package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bbd.dafei.biz.shared.YuqingService;
import com.bbd.dafei.common.exception.AccessApiException;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.modal.commonenum.YuqingSortTypeEnum;
import com.bbd.dafei.common.modal.dto.YuqingContentDTO;
import com.bbd.dafei.common.modal.dto.YuqingPictureDTO;
import com.bbd.dafei.common.modal.dto.YuqingRelateContentDTO;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.YuqingPageInfo;
import com.components.service.ApiExecuteEngineService;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wish on 2017/8/20.
 */
@Service
@Transactional
public class YuqingServiceImpl implements YuqingService {

    private final Logger logger = LoggerFactory.getLogger(YuqingServiceImpl.class);

    @Autowired
    private ApiExecuteEngineService defaultApiExecEngine;

    @Value("${api.components.yuqingContent.apiId}")
    private String qyContentApiId;

    @Value("${api.components.yuqingPicture.apiId}")
    private String qyPictureApiId;

    @Value("${api.components.cpList.apiId}")
    private String cplistApiId;

    //图片key前缀
    private final String pictureKeyPrefix = "pic_rowkey";

    /**
     * 查询舆情排序描述对应值
     */
    private final Map yuqingSortCodeMap = new HashMap<String, Integer>() {{
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_PUBDATE_DESC.getName(), 1);
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_PUBDATE_ASC.getName(), 2);
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_VALUE_DESC.getName(), 3);
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_VALUE_ASC.getName(), 4);
    }};

    /**
     * 根据相关公司相关人物查询舆情排序描述对应值
     */
    private final Map relateSortCodeMap = new HashMap<String, Integer>() {{
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_VALUE_ASC.getName(), 1);
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_VALUE_DESC.getName(), 2);
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_PUBDATE_ASC.getName(), 3);
        put(YuqingSortTypeEnum.YUQING_SORT_TYPE_PUBDATE_DESC.getName(), 4);
    }};


    @Override
    public PageInfo<YuqingContentDTO> getYuqingContentByCompanyId(String companyId, String sort, Integer page, Integer pageSize) throws Exception {
        Map externalParam = new HashedMap();
        externalParam.put("qyxx_id", companyId);
        externalParam.put("sort", yuqingSortCodeMap.get(sort));
        externalParam.put("page", page);
        externalParam.put("pageSize", pageSize);
        JSONObject data = (JSONObject) defaultApiExecEngine.execute(qyContentApiId, externalParam);
        Gson gson = new Gson();
        ApiReturnBean<YuqingContentDTO> r = gson.fromJson(data.toJSONString(), new TypeToken<ApiReturnBean<YuqingContentDTO>>() {
        }.getType());
        if (!r.accessApiSuccess()) {
            logger.error("调用数据平台失败");
            throw new AccessApiException("调用数据平台失败");
        }
        if (CollectionUtils.isEmpty(r.getResults())) {
            return null;
        }
        for (YuqingContentDTO yuqingContentDTO : r.getResults()) {
            yuqingContentDTO.setPubdate(yuqingContentDTO.getPubdate().substring(0, 10));
            handYuqingAbstract(yuqingContentDTO);
        }
        PageInfo<YuqingContentDTO> pageInfo = new PageInfo<YuqingContentDTO>(r, page);
        handleYuqingResults(pageInfo.getItems());
        return pageInfo;
    }

    @Override
    public PageInfo<YuqingContentDTO> getYuqingContentByCompanyIdAndRelate(String companyId, String qc, String type, String sort, int page, int pageSize) throws Exception {

        Map externalParam = new HashedMap();
        externalParam.put("qyId", companyId);
        externalParam.put("q_c", qc);
        externalParam.put("q_type", type);
        externalParam.put("s_type", relateSortCodeMap.get(sort));
        externalParam.put("pn", page);
        externalParam.put("p_size", pageSize);
        JSONObject jsonObject = (JSONObject) defaultApiExecEngine.execute(cplistApiId, externalParam);
        Gson gson = new Gson();
        YuqingPageInfo<YuqingRelateContentDTO> yuqingPageInfo = gson.fromJson(jsonObject.toString(), new TypeToken<YuqingPageInfo<YuqingRelateContentDTO>>() {
        }.getType());

        List<YuqingContentDTO> results = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (YuqingRelateContentDTO yuqingRelateContentDTO : yuqingPageInfo.getDataList()) {
            YuqingContentDTO yuqingContentDTO = new YuqingContentDTO();
            yuqingContentDTO.setNewsSite(yuqingRelateContentDTO.getBbdSource());
            yuqingContentDTO.setCmp(yuqingRelateContentDTO.getCompanyName());
            yuqingContentDTO.setNewsTitle(yuqingRelateContentDTO.getNewsTitle());
            yuqingContentDTO.setAbstract_(yuqingRelateContentDTO.getNewsRoundup());
            yuqingContentDTO.setMain(gson.fromJson(yuqingRelateContentDTO.getMain(), new TypeToken<String>() {
            }.getType()));
            if (StringUtils.isEmpty(yuqingRelateContentDTO.getPubdate())) {
                continue;
            }
            yuqingContentDTO.setPubdate(DateFormatUtils.format(sdf.parse(yuqingRelateContentDTO.getPubdate()), "yyyy-MM-dd"));
            results.add(yuqingContentDTO);
        }
        handleYuqingResults(results);
        PageInfo<YuqingContentDTO> pageInfo = new PageInfo<>();
        pageInfo.setPage(yuqingPageInfo.getCurrentPage());
        pageInfo.setPageSize(yuqingPageInfo.getPageSize());
        pageInfo.setTotalCount(yuqingPageInfo.getTotalCount());
        pageInfo.setTotalPage(yuqingPageInfo.getTotalPage());
        pageInfo.setItems(results);
        return pageInfo;
    }

    /**
     * 处理舆情摘要，如果abstract_字段没有值，取summary字段的值为摘要
     *
     * @param yuqingContentDTO
     */
    private void handYuqingAbstract(YuqingContentDTO yuqingContentDTO) {
        if (yuqingContentDTO == null) {
            return;
        }
        if (StringUtils.isBlank(yuqingContentDTO.getAbstract_()) || "null".equals(StringUtils.lowerCase(yuqingContentDTO.getAbstract_()))) {
            yuqingContentDTO.setAbstract_(yuqingContentDTO.getSummary());
        }
    }

    /**
     * 处理舆情结果
     *
     * @param yuqingContentDTOList
     */
    private void handleYuqingResults(List<YuqingContentDTO> yuqingContentDTOList) {
        if (CollectionUtils.isEmpty(yuqingContentDTOList)) {
            return;
        }
        List<String> pictureKeys = getAllPictureKeys(yuqingContentDTOList);
        Map<String, YuqingPictureDTO> imageMap = getPictureUrlsByKeys(pictureKeys);
        for (YuqingContentDTO yuqingContentDTO : yuqingContentDTOList) {
            String html = getHtmlFromMain(yuqingContentDTO.getMain(), imageMap);
            //替换main
            yuqingContentDTO.setMain(html);
        }
    }

    /**
     * 获取所有图片key
     *
     * @param yuqingContentDTOS
     * @return
     */
    private List<String> getAllPictureKeys(List<YuqingContentDTO> yuqingContentDTOS) {
        List<String> pictureKeys = new ArrayList<>();
        if (CollectionUtils.isEmpty(yuqingContentDTOS)) {
            return pictureKeys;
        }
        Gson gson = new Gson();
        for (YuqingContentDTO yuqingContentDTO : yuqingContentDTOS) {
            if (yuqingContentDTO == null || StringUtils.isEmpty(yuqingContentDTO.getMain())) {
                continue;
            }
            List<String> contents = gson.fromJson(yuqingContentDTO.getMain(), new TypeToken<List<String>>() {
            }.getType());
            //批量查询图片url
            for (String content : contents) {
                if (content.startsWith(pictureKeyPrefix)) {
                    pictureKeys.add(content);
                }
            }
        }
        return pictureKeys;
    }

    /**
     * 处理舆情正文，返回html
     *
     * @param mainString
     * @param imageMap
     * @return
     */
    private String getHtmlFromMain(String mainString, Map<String, YuqingPictureDTO> imageMap) {
        StringBuilder htmlMain = new StringBuilder();
        if (StringUtils.isBlank(mainString)) {
            return "";
        }
        Gson gson = new Gson();
        List<String> contents = gson.fromJson(mainString, new TypeToken<List<String>>() {
        }.getType());

        for (String content : contents) {
            //图片
            if (content.startsWith(pictureKeyPrefix)) {
                YuqingPictureDTO yuqingPictureDTO = imageMap.get(content);
                //根据yuqingPictureDTO生成img标签
                htmlMain.append(getImgTagByYuqingPictureDTO(yuqingPictureDTO));
            } else {
                htmlMain.append(getPTag(content));
            }
        }
        return htmlMain.toString();
    }

    /**
     * 生成img标签
     *
     * @param yuqingPictureDTO
     * @return
     */
    private String getImgTagByYuqingPictureDTO(YuqingPictureDTO yuqingPictureDTO) {
        if (yuqingPictureDTO == null || StringUtils.isEmpty(yuqingPictureDTO.getImgUrl())) {
            return "";
        }
        StringBuilder imgTag = new StringBuilder();
        imgTag.append("<img src=\"");
        imgTag.append(yuqingPictureDTO.getImgUrl());
        imgTag.append("\"</>");
        return imgTag.toString();
    }

    /**
     * 生成p标签
     *
     * @param text
     * @return
     */
    private String getPTag(String text) {
        StringBuilder pTag = new StringBuilder();
        pTag.append("<p>&nbsp;&nbsp;&nbsp;&nbsp;");
        pTag.append(text);
        pTag.append("</p>");
        return pTag.toString();
    }

    /**
     * 多线程批量通过key查询图片
     *
     * @param pictureKeys
     * @return
     */
    private Map<String, YuqingPictureDTO> getPictureUrlsByKeys(List<String> pictureKeys) {
        Map<String, YuqingPictureDTO> result = new ConcurrentHashMap();
        if (CollectionUtils.isEmpty(pictureKeys)) {
            return result;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (String pictureKey : pictureKeys) {
            executorService.execute(() -> {
                try {
                    YuqingPictureDTO yuqingPictureDTO = getPictureUrlByKey(pictureKey);
                    if (yuqingPictureDTO != null) {
                        result.put(pictureKey, yuqingPictureDTO);
                    }
                } catch (Exception e) {
                    logger.error("获取图片失败,key:{}", pictureKey);
                    e.printStackTrace();
                }
            });
        }
        //关闭线程池
        executorService.shutdown();
        try {
            //等待子线程完成后在继续执行
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("查询图片失败");
            throw new CommonException("查询图片失败");
        }

        return result;

    }

    /**
     * 通过key查询图片
     *
     * @param pictureKey
     * @return
     * @throws Exception
     */
    private YuqingPictureDTO getPictureUrlByKey(String pictureKey) throws Exception {
        Map externalParam = new HashedMap();
        externalParam.put("key", pictureKey);
        JSONObject data = (JSONObject) defaultApiExecEngine.execute(qyPictureApiId, externalParam);
        Gson gson = new Gson();
        ApiReturnBean<YuqingPictureDTO> r = gson.fromJson(data.toJSONString(), new TypeToken<ApiReturnBean<YuqingPictureDTO>>() {
        }.getType());
        if (!r.accessApiSuccess()) {
            throw new AccessApiException("调用数据平台失败");
        }
        if (CollectionUtils.isEmpty(r.getResults())) {
            return null;
        }
        return r.getResults().get(0);
    }
}
