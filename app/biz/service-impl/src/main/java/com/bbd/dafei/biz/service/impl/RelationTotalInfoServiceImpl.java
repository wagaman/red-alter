package com.bbd.dafei.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bbd.dafei.biz.service.sys.SystemThreadPool;
import com.bbd.dafei.biz.shared.*;
import com.bbd.dafei.common.dal.po.RaCompanyPO;
import com.bbd.dafei.common.modal.dto.BaseDataDTO;
import com.bbd.dafei.common.modal.dto.JbxxDTO;
import com.bbd.dafei.common.modal.dto.RelationInfoDTO;
import com.bbd.dafei.common.modal.util.BaseDataUtil;
import com.bbd.dafei.common.modal.util.RaTwoComparator;
import com.bbd.dafei.common.modal.util.RelationUtil;
import com.bbd.dafei.common.modal.vo.*;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.Constants;
import com.components.service.ApiExecuteEngineService;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 企业详情页面关联方相关信息
 *
 * @author anhong.Tu
 * @version $Id: RelationTotalInfoServiceImpl.java, v 0.1 2017/7/25 9:30 anhong.Tu Exp $
 */
@Service
public class RelationTotalInfoServiceImpl implements RelationTotalInfoService {

    private final Logger logger = LoggerFactory.getLogger(RelationTotalInfoServiceImpl.class);

    @Autowired
    private RelationService relationService;

    @Autowired
    private ApiExecuteEngineService defaultApiExecEngine;

    @Autowired
    private BaseDataService baseDataService;

    @Autowired
    private RaCompanyService raCompanyService;

    @Autowired
    private RaBlackListService raBlackListService;

    @Value("${api.components.financial.apiId}")
    private String financialApiId;

    @Value("${api.components.jbxxBatch.apiId}")
    private String jbxxBatchApiId;

    @Value("${api.components.financialRelateInfo.apiId}")
    private String financialRelationApiId;

    @Value("${api.components.qyxxBatch.apiId}")
    private String qyxxBatchApiId;

    @Override
    public RelationTotalInfoVO getRightRelation(String companyId) throws Exception {

        RelationTotalInfoVO relationTotalInfoVO = new RelationTotalInfoVO();
        RelationTotalInfoDetail1dVO relationTotalInfoDetail1dVO = new RelationTotalInfoDetail1dVO();
        RelationTotalInfoDetail2dVO relationTotalInfoDetail2dVO = new RelationTotalInfoDetail2dVO();
        RelationTotalInfoDetail3dVO relationTotalInfoDetail3dVO = new RelationTotalInfoDetail3dVO();

        Map externalParam = new HashedMap();
        externalParam.put("qyId", companyId);
        JSONObject rawData = (JSONObject) defaultApiExecEngine.execute(financialApiId, externalParam);

//        ApiReturnBean<ApiFinancialVO> data = new Gson().fromJson(rawData.toString(),new TypeToken<ApiReturnBean<ApiFinancialVO>>() {}.getType());
//        ApiFinancialVO apiFinancialVO = (ApiFinancialVO) data.getResults();

        List<Object> listData = (List<Object>) rawData.get("data");

        if (CollectionUtils.isNotEmpty(listData)) {
            Gson gson = new Gson();
            ApiFinancialVO apiFinancialVO = gson.fromJson(listData.get(0).toString(), ApiFinancialVO.class);

            //1度新兴金融企业数
            relationTotalInfoDetail1dVO.setNewFinanceNum(integerNullDataChange(apiFinancialVO.getNewFinanceNum1d()));
            //1度利益一致行动法人数
            relationTotalInfoDetail1dVO.setCommonInterestsNum(integerNullDataChange(apiFinancialVO.getCommonInterestsNum1d()));
            //1度地址相同企业数
            relationTotalInfoDetail1dVO.setSameAddressNum(integerNullDataChange(apiFinancialVO.getSameAddressNum1d()));
            //1度注吊销企业数
            relationTotalInfoDetail1dVO.setCancelNum(integerNullDataChange(apiFinancialVO.getEstatusNum1d()));

            //2度新兴金融企业数
            relationTotalInfoDetail2dVO.setNewFinanceNum(integerNullDataChange(apiFinancialVO.getNewFinanceNum2d()));
            //2度利益一致行动法人数
            relationTotalInfoDetail2dVO.setCommonInterestsNum(integerNullDataChange(apiFinancialVO.getCommonInterestsNum2d()));
            //2度地址相同企业数
            relationTotalInfoDetail2dVO.setSameAddressNum(integerNullDataChange(apiFinancialVO.getSameAddressNum2d()));
            //2度注吊销企业数
            relationTotalInfoDetail2dVO.setCancelNum(integerNullDataChange(apiFinancialVO.getEstatusNum2d()));

            //3度新兴金融企业数
            relationTotalInfoDetail3dVO.setNewFinanceNum(integerNullDataChange(apiFinancialVO.getNewFinanceNum3d()));
            //3度利益一致行动法人数
            relationTotalInfoDetail3dVO.setCommonInterestsNum(integerNullDataChange(apiFinancialVO.getCommonInterestsNum3d()));
            //3度地址相同企业数
            relationTotalInfoDetail3dVO.setSameAddressNum(integerNullDataChange(apiFinancialVO.getSameAddressNum3d()));
            //3度注吊销企业数
            relationTotalInfoDetail3dVO.setCancelNum(integerNullDataChange(apiFinancialVO.getEstatusNum3d()));
            //1度关联聚集地
            relationTotalInfoDetail1dVO.setRelationPlace(getGatherPlaceFromJson(apiFinancialVO.getGatherPlace1d()));
            //2度关联聚集地
            relationTotalInfoDetail2dVO.setRelationPlace(getGatherPlaceFromJson(apiFinancialVO.getGatherPlace2d()));
            //3度关联聚集地
            relationTotalInfoDetail3dVO.setRelationPlace(getGatherPlaceFromJson(apiFinancialVO.getGatherPlace3d()));

            //查询关联信息
            RelationInfoDTO relationInfoDTO = null;
            try {
                relationInfoDTO = relationService.getRelationInfoByCompanyId(companyId);

                RelationInfoVO relationInfoVO = RelationUtil.transRelationInfoDTOToRelationInfoVO(relationInfoDTO);

                //1度关键自然人
                List<String> pivotalNaturalPersonsTop1d = relationInfoVO.getPivotalNaturalPersonsTop1d();
                relationTotalInfoDetail1dVO.setKeyNature(getData(pivotalNaturalPersonsTop1d));
                //2度关键自然人
                List<String> pivotalNaturalPersonsTop2d = relationInfoVO.getPivotalNaturalPersonsTop1d();
                relationTotalInfoDetail2dVO.setKeyNature(getData(pivotalNaturalPersonsTop2d));
                //3度关键自然人
                List<String> pivotalNaturalPersonsTop3d = relationInfoVO.getPivotalNaturalPersonsTop1d();
                relationTotalInfoDetail3dVO.setKeyNature(getData(pivotalNaturalPersonsTop3d));

                //1度关键非自然人
                List<String> pivotalNonNaturalPersonsTop1d = relationInfoVO.getPivotalNonNaturalPersonsTop1d();
                relationTotalInfoDetail1dVO.setUnKeyNature(getData(pivotalNonNaturalPersonsTop1d));
                //2度关键非自然人
                List<String> pivotalNonNaturalPersonsTop2d = relationInfoVO.getPivotalNonNaturalPersonsTop2d();
                relationTotalInfoDetail2dVO.setUnKeyNature(getData(pivotalNonNaturalPersonsTop2d));
                //3度关键非自然人
                List<String> pivotalNonNaturalPersonsTop3d = relationInfoVO.getPivotalNonNaturalPersonsTop3d();
                relationTotalInfoDetail3dVO.setUnKeyNature(getData(pivotalNonNaturalPersonsTop3d));

                //1度关联聚集行业
                List<String> industrySpanTop1d = relationInfoVO.getIndustrySpanTop1d();
                relationTotalInfoDetail1dVO.setRelationIndustry(getData(industrySpanTop1d));
                //2度关联聚集行业
                List<String> industrySpanTop2d = relationInfoVO.getIndustrySpanTop2d();
                relationTotalInfoDetail2dVO.setRelationIndustry(getData(industrySpanTop2d));
                //3度关联聚集行业
                List<String> industrySpanTop3d = relationInfoVO.getIndustrySpanTop3d();
                relationTotalInfoDetail3dVO.setRelationIndustry(getData(industrySpanTop3d));

            } catch (Exception e) {
                e.printStackTrace();
            }

            //关联方关联度
            try {
                getRelationData(relationTotalInfoDetail1dVO, relationTotalInfoDetail2dVO, relationTotalInfoDetail3dVO, companyId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            relationTotalInfoVO.setRelationTotalInfoDetail1dVO(relationTotalInfoDetail1dVO);
            relationTotalInfoVO.setRelationTotalInfoDetail2dVO(relationTotalInfoDetail2dVO);
            relationTotalInfoVO.setRelationTotalInfoDetail3dVO(relationTotalInfoDetail3dVO);
        }
        return relationTotalInfoVO;
    }

    /**
     * 解析关联方聚集地json
     *
     * @param json
     * @return
     */
    private String getGatherPlaceFromJson(String json) {
        try {
            Gson gson = new Gson();
            List<String> gatherPlaceTop1d = gson.fromJson(json, new TypeToken<List<String>>() {
            }.getType());
            return getData(gatherPlaceTop1d);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            logger.error("解析关联方聚集地json失败");
            return "";
        }
    }

    /**
     * Interger类型为NULL时设定为0
     *
     * @param value
     * @return
     */
    private int integerNullDataChange(Integer value) {
        if (null == value) {
            return 0;
        } else {
            return value;
        }
    }

    /**
     * 多线程取得企业1,2,3度的关联方信息
     *
     * @param relationTotalInfoDetail1dVO
     * @param relationTotalInfoDetail2dVO
     * @param relationTotalInfoDetail3dVO
     * @param companyId
     */
    private void getRelationData(RelationTotalInfoDetail1dVO relationTotalInfoDetail1dVO, RelationTotalInfoDetail2dVO relationTotalInfoDetail2dVO, RelationTotalInfoDetail3dVO relationTotalInfoDetail3dVO, String companyId) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        //1
        pool.execute(() -> {
            try {
                RelationDataVO relationDataVO1 = relationService.getRelationNodesAndLinks(companyId, 1);

                //1度黑名单数量
                relationTotalInfoDetail1dVO.setBlackNum(relationDataVO1.getBlackCompanyList().size());
                //1度高危企业数量
                relationTotalInfoDetail1dVO.setHighRiskNum(relationDataVO1.getHighCompanyList().size());
                //1度关联方所有企业ID
                List<RelationNodeVO> relationNodeVOS = relationDataVO1.getNodes();
                List<String> companyIdList = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(relationNodeVOS)) {
                    for (RelationNodeVO relationNodeVO : relationNodeVOS) {
                        companyIdList.add(relationNodeVO.getName());
                    }
                }
                relationTotalInfoDetail1dVO.setNodeCompanyIdList(companyIdList);
                //1度关联方总数量
                relationTotalInfoDetail1dVO.setRelationTotalNum(relationDataVO1.getNodes().size());
                //1度黑名单企业列表
                relationTotalInfoDetail1dVO.setBlackList(relationDataVO1.getBlackCompanyList());
                //1度高危企业列表
                relationTotalInfoDetail1dVO.setHighList(relationDataVO1.getHighCompanyList());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            try {
                RelationDataVO relationDataVO2 = relationService.getRelationNodesAndLinks(companyId, 2);

                //2度黑名单数量
                relationTotalInfoDetail2dVO.setBlackNum(relationDataVO2.getBlackCompanyList().size());
                //2度高危企业数量
                relationTotalInfoDetail2dVO.setHighRiskNum(relationDataVO2.getHighCompanyList().size());
                //2度关联方企业列表
                List<RelationNodeVO> relationNodeVOS = relationDataVO2.getNodes();
                List<String> companyIdList = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(relationNodeVOS)) {
                    for (RelationNodeVO relationNodeVO : relationNodeVOS) {
                        companyIdList.add(relationNodeVO.getName());
                    }
                }
                relationTotalInfoDetail2dVO.setNodeCompanyIdList(companyIdList);
                //2度关联方总数量
                relationTotalInfoDetail2dVO.setRelationTotalNum(relationDataVO2.getNodes().size());
                //2度黑名单企业列表
                relationTotalInfoDetail2dVO.setBlackList(relationDataVO2.getBlackCompanyList());
                //2度高危企业列表
                relationTotalInfoDetail2dVO.setHighList(relationDataVO2.getHighCompanyList());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            try {
                RelationDataVO relationDataVO3 = relationService.getRelationNodesAndLinks(companyId, 3);

                //3度黑名单数量
                relationTotalInfoDetail3dVO.setBlackNum(relationDataVO3.getBlackCompanyList().size());
                //3度高危企业数量
                relationTotalInfoDetail3dVO.setHighRiskNum(relationDataVO3.getHighCompanyList().size());
                //3度关联方企业列表
                List<RelationNodeVO> relationNodeVOS = relationDataVO3.getNodes();
                List<String> companyIdList = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(relationNodeVOS)) {
                    for (RelationNodeVO relationNodeVO : relationNodeVOS) {
                        companyIdList.add(relationNodeVO.getName());
                    }
                }
                relationTotalInfoDetail3dVO.setNodeCompanyIdList(companyIdList);
                //3度关联方总数量
                relationTotalInfoDetail3dVO.setRelationTotalNum(relationDataVO3.getNodes().size());
                //3度黑名单企业列表
                relationTotalInfoDetail3dVO.setBlackList(relationDataVO3.getBlackCompanyList());
                //3度高危企业列表
                relationTotalInfoDetail3dVO.setHighList(relationDataVO3.getHighCompanyList());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            // 关闭启动线程
            pool.shutdown();
            // 等待子线程结束，再继续执行下面的代码
            while (!pool.awaitTermination(1, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RelationListInfoVO> queryBottomRelationInfo(String companyId, int degree, String type, String companyIdList, String sortColumn, String sortType, int isSort) throws Exception {

        /**
         * 参数合法性问题
         * 1、当isSort=1 时，表示需要排序，那么 排序栏位 与排序条件 必须有值。
         * 2、黑名单查询，高分风险查询，2,3度全部查询，搜索的查询，companyIdList 必须有值
         * 3、搜素查询（非1度），2,3度全部查询，isSort需要为0，因为这几种查询不提供排序功能
         */

        /*
         * 判断是否需要 自己手动取资料
         * 所谓手动取资料就是需要自己传一个企业列表进行资料抓取
         * 手动取资料的情况包括：黑名单 与高风险（这两个值是通过关联方接口自己计算的），2度，3度的全部查询时
         * 搜素功能时，需要手动取得资料
         */
        boolean autoData = true;
        if (type.equals(Constants.QUERY_TYPE_BLACK) ||
                type.equals(Constants.QUERY_TYPE_HIGH) ||
                type.equals(Constants.QUERY_TYPE_SEARCH) ||
                ((degree == 2 || degree == 3) && type.equals(Constants.QUERY_TPYE_ALL))
                ) {
            autoData = false;
        }

        //取得目标公司关联方信息
        RelationDataVO relationDataVO = relationService.getRelationNodesAndLinks(companyId, degree);
        List<RelationNodeVO> nodes = relationDataVO.getNodes();
        HashMap<String, RelationNodeVO> mapData = new HashMap<>();
        for (RelationNodeVO data : nodes) {
            String name = data.getName();
            mapData.put(name, data);
        }

        //取得目标公司的股东信息
        BaseDataVO baseDataVO = baseDataService.getBaseDataByCompanyId(companyId);
        List<BaseDataVO.Gdxx> gdxxList = baseDataVO.getGdxx();
        HashMap<String, String> gdxxMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(gdxxList)) {
            for (BaseDataVO.Gdxx data : gdxxList) {
                gdxxMap.put(data.getShareholderName(), data.getInvestRatio());
            }
        }

        //取得数仓资料
        List<ApiFinancialVO> shuCangDataList = new ArrayList<>();

        if (autoData) {
            Map externalParam = new HashedMap();
            externalParam.put("qyId", companyId);
            externalParam.put("relate", degree);
            try {
                JSONObject rawData = (JSONObject) defaultApiExecEngine.execute(financialRelationApiId, externalParam);

                Gson gson = new Gson();
                ApiFinancialRelateVO apiFinancialRelateVO = gson.fromJson(rawData.get("data").toString(), ApiFinancialRelateVO.class);

                voDataToShuCangDataList(shuCangDataList, apiFinancialRelateVO, type);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {//手动取数据接口
            if (null == companyIdList) {

            } else {
                //一次取25 个
                int pageSize = 25;
                shuCangDataList = getApiFinancialData(companyIdList, pageSize);
            }
        }

        //批量取得基本信息
        StringBuffer keys = new StringBuffer();
        Map<String, ApiFinancialVO> shuCangMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(shuCangDataList)) {
            for (ApiFinancialVO data : shuCangDataList) {
                keys.append(keys.length() == 0 ? data.getCompanyId() : "," + data.getCompanyId());
                shuCangMap.put(data.getCompanyId(), data);
            }
        }

        //选择 1
//        List<JbxxDTO> baseDataList = getBaseInfoDataByJbxxBatch(keys.toString());
//        HashMap<String,JbxxDTO> baseMap = new HashMap<>();
//        if(CollectionUtils.isNotEmpty(baseDataList)){
//            for(JbxxDTO data: baseDataList){
//                baseMap.put(data.getCompanyName(),data);
//            }
//        }

        //选择 2
        List<BaseDataDTO> baseDataList = getBaseInfoDataByQyxxBatch(keys.toString());
        HashMap<String, BaseDataDTO.Jbxx> baseMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(baseDataList)) {
            for (BaseDataDTO data : baseDataList) {
                BaseDataDTO.Jbxx jbxx = data.getJbxx();
                if (jbxx != null) {

                    //放入map方便取值
                    baseMap.put(jbxx.getBbdQyxxId(), jbxx);
                }
            }
        }
        List<RelationListInfoVO> relationListInfoVOS = makesReturnData(baseMap, shuCangDataList, mapData, gdxxMap, companyIdList, autoData, shuCangMap, degree);

        //处理黑名单
        handleBlack(relationListInfoVOS);

        if (isSort == 0) {
            return relationListInfoVOS;
        } else {
            return sortObjects(relationListInfoVOS, sortColumn, sortType);
        }
    }

    /**
     * 转换VO 资料
     *
     * @param shuCangDataList
     * @param apiFinancialRelateVO
     * @param type
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void voDataToShuCangDataList(List<ApiFinancialVO> shuCangDataList, ApiFinancialRelateVO apiFinancialRelateVO, String type) throws InvocationTargetException, IllegalAccessException {

        if (apiFinancialRelateVO != null) {
            Map<String, ApiFinancialRelateDetailVO> map = new HashMap<>();

            switch (type) {
                case Constants.QUERY_TPYE_ALL:
                    map = apiFinancialRelateVO.getTotal();
                    break;
                case Constants.QUERY_TYPE_SAME_ADRESS:
                    map = apiFinancialRelateVO.getCommonAddress();
                    break;
                case Constants.QUERY_TYPE_ESTATE:
                    map = apiFinancialRelateVO.getEstate();
                    break;
                case Constants.QUERY_TYPE_COMMON_INTERESTS:
                    map = apiFinancialRelateVO.getCommonInterests();
                    break;
                case Constants.QUERY_TYPE_NEW_FINANCIAL:
                    map = apiFinancialRelateVO.getNewFinance();
                    break;
                default:
                    break;
            }
            if (map != null && map.size() != 0) {
                Set<Map.Entry<String, ApiFinancialRelateDetailVO>> entrySet = map.entrySet();
                for (Map.Entry<String, ApiFinancialRelateDetailVO> entry : entrySet) {
                    ApiFinancialVO apiFinancialVO = new ApiFinancialVO();
                    ApiFinancialRelateDetailVO apiFinancialRelateDetailVO = entry.getValue();
                    if (apiFinancialRelateDetailVO != null) {
                        //企业ID
                        apiFinancialVO.setCompanyId(entry.getKey());

                        BeanUtils.copyProperties(apiFinancialVO, apiFinancialRelateDetailVO);

                        shuCangDataList.add(apiFinancialVO);
                    }
                }
            }

        }
    }

    @Override
    public List<RelationListInfoVO> getDataForExcel(String companyId, int degree, String type) throws Exception {
        /*
         * 判断是否需要 自己手动取资料
         * 所谓手动取资料就是需要自己传一个企业列表进行资料抓取
         * 手动取资料的情况包括：黑名单 与高风险（这两个值是通过关联方接口自己计算的），2度，3度的全部查询时
         * 搜素功能时，需要手动取得资料
         */
        boolean autoData = true;
        if (type.equals(Constants.QUERY_TYPE_BLACK) || type.equals(Constants.QUERY_TYPE_HIGH) || type.equals(Constants.QUERY_TPYE_ALL)) {
            autoData = false;
        }

        //取得目标公司关联方信息
        RelationDataVO relationDataVO = relationService.getRelationNodesAndLinks(companyId, degree);
        List<RelationNodeVO> nodes = relationDataVO.getNodes();
        //全部企业id
        StringBuffer companyIdlist = new StringBuffer();

        HashMap<String, RelationNodeVO> mapData = new HashMap<>();
        for (RelationNodeVO data : nodes) {
            String name = data.getName();
            mapData.put(name, data);
            companyIdlist.append(companyIdlist.length() == 0 ? name : "," + name);
        }

        //黑名单企业
        List<String> blackList = relationDataVO.getBlackCompanyList();
        StringBuffer blackCompanyIdList = new StringBuffer();
        if (CollectionUtils.isNotEmpty(blackList)) {
            for (int i = 0; i < blackList.size(); i++) {
                blackCompanyIdList.append(blackCompanyIdList.length() == 0 ? blackList.get(i) : "," + blackList.get(i));
            }
        }
        //高风险企业
        List<String> highList = relationDataVO.getHighCompanyList();
        StringBuffer highCompanyIdList = new StringBuffer();
        if (CollectionUtils.isNotEmpty(highList)) {
            for (int i = 0; i < highList.size(); i++) {
                highCompanyIdList.append(highCompanyIdList.length() == 0 ? highList.get(i) : "," + highList.get(i));
            }
        }

        //取得目标公司的股东信息
        BaseDataVO baseDataVO = baseDataService.getBaseDataByCompanyId(companyId);
        List<BaseDataVO.Gdxx> gdxxList = baseDataVO.getGdxx();
        HashMap<String, String> gdxxMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(gdxxList)) {
            for (BaseDataVO.Gdxx data : gdxxList) {
                gdxxMap.put(data.getShareholderName(), data.getInvestRatio());
            }
        }

        String keys = null;
        if (autoData) {
            //取得数仓资料
            List<ApiFinancialVO> shuCangDataList = new ArrayList<>();

            Map externalParam = new HashedMap();
            externalParam.put("qyId", companyId);
            externalParam.put("relate", degree);
            try {
                JSONObject rawData = (JSONObject) defaultApiExecEngine.execute(financialRelationApiId, externalParam);

                Gson gson = new Gson();
                ApiFinancialRelateVO apiFinancialRelateVO = gson.fromJson(rawData.get("data").toString(), ApiFinancialRelateVO.class);

                voDataToShuCangDataList(shuCangDataList, apiFinancialRelateVO, type);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //shuCangDataList = 自动取数据接口
            /*
            * 自动取得的资料需要排除 关联方 没有，但是数仓返回有的资料
            * */
//            shuCangDataList = changeData(shuCangDataList, mapData);
            //批量取得基本信息
            StringBuffer keyStringBuilder = new StringBuffer();
            Map<String, ApiFinancialVO> shuCangMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(shuCangDataList)) {
                for (ApiFinancialVO data : shuCangDataList) {
                    keyStringBuilder.append(keyStringBuilder.length() == 0 ? data.getCompanyId() : "," + data.getCompanyId());
                    shuCangMap.put(data.getCompanyId(), data);
                }
            }
            keys = keyStringBuilder.toString();
        } else {

            if (type.equals(Constants.QUERY_TPYE_ALL)) {
                keys = companyIdlist.toString();
            } else if (type.equals(Constants.QUERY_TYPE_HIGH)) {
                keys = highCompanyIdList.toString();
            } else if (type.equals(Constants.QUERY_TYPE_BLACK)) {
                keys = blackCompanyIdList.toString();
            }
        }

        List<BaseDataDTO> baseDataList = null;

        if (StringUtils.isNotEmpty(keys)) {
            baseDataList = getBaseInfoDataByQyxxBatch(keys.toString());
        }

        HashMap<String, BaseDataDTO.Jbxx> baseMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(baseDataList)) {
            for (BaseDataDTO data : baseDataList) {
                BaseDataDTO.Jbxx jbxx = data.getJbxx();
                if (jbxx != null) {
                    //放入map方便取值
                    baseMap.put(jbxx.getBbdQyxxId(), jbxx);
                }
            }
        }

        //组装返回的资料
        List<RelationListInfoVO> relationListInfoVOS = makesReturnDataForExcel(baseMap, mapData, gdxxMap, keys, degree);

        relationListInfoVOS = sortObjects(relationListInfoVOS, Constants.SORT_COLUMN_CATEGORY, Constants.SORT_TYPE_ASC);

        int numIndex = 1;
        for (RelationListInfoVO data : relationListInfoVOS) {
            data.setNumIndex(String.valueOf(numIndex));
            numIndex++;
        }
        handleBlack(relationListInfoVOS);
        return relationListInfoVOS;
    }

    /**
     * 组装返回资料（导出EXCEL使用）
     *
     * @param baseMap
     * @param mapData
     * @param gdxxMap
     * @param keys
     * @param degree
     * @return
     */
    private List<RelationListInfoVO> makesReturnDataForExcel(HashMap<String, BaseDataDTO.Jbxx> baseMap, HashMap<String, RelationNodeVO> mapData, HashMap<String, String> gdxxMap, String keys, int degree) {
        List<RelationListInfoVO> relationListInfoVOS = new ArrayList<>();

        String[] keyValue = StringUtils.split(keys, ",");

        if (keyValue == null) {
            return relationListInfoVOS;
        }

        for (int i = 0; i < keyValue.length; i++) {

            RelationListInfoVO relationListInfoVO = new RelationListInfoVO();
            String companyId = keyValue[i];

            RelationNodeVO relationNodeVO = mapData.get(companyId);

            BaseDataDTO.Jbxx jbxx = null;

            if (relationNodeVO == null) {//关联方VO 为空表示 这个资料 数仓有 但是 关联没有
                RaCompanyPO raCompanyPO = raCompanyService.findCompanyById(companyId);
                if (raCompanyPO != null) {

                    //用ID取资料
                    jbxx = baseMap.get(raCompanyPO.getId());

                    //企业名称/人名
                    relationListInfoVO.setName(stringNullChange(raCompanyPO.getCompany()));
                    //关联度
                    relationListInfoVO.setCategory(degree);
                    //关联关系
                    relationListInfoVO.setRelationDescribe("--");
                    //风险等级
                    relationListInfoVO.setRiskLevel(stringNullChange(raCompanyPO.getRiskLevel()));
                    //易燃指数
                    relationListInfoVO.setRiskIndex(raCompanyPO.getRiskIndex());
                    //行业
                    relationListInfoVO.setIndustry(stringNullChange(raCompanyPO.getIndustry()));
                } else {//等昆仑接口修改好以后直接从 这边取
                    jbxx = baseMap.get(companyId);

                    if (jbxx != null) {
                        //企业名称/人名
                        relationListInfoVO.setName(stringNullChange(jbxx.getCompanyName()));
                        //关联度
                        relationListInfoVO.setCategory(degree);
                        //关联关系
                        relationListInfoVO.setRelationDescribe("--");
                        //风险等级
                        relationListInfoVO.setRiskLevel("--");
                        //易燃指数
                        relationListInfoVO.setRiskIndex(null);
                        //行业
                        relationListInfoVO.setIndustry(stringNullChange(Constants.INDUSTRY_DESCRIBE_MAP.get(jbxx.getCompanyIndustry())));
                    }
                }
            } else {
                String id = relationNodeVO.getName();

                //用ID取资料
                jbxx = baseMap.get(id);

                //企业名称/人名
                relationListInfoVO.setName(stringNullChange(relationNodeVO.getCname()));
                //关联度
                relationListInfoVO.setCategory(integerNullDataChange(relationNodeVO.getCategory()));
                //关联关系
                relationListInfoVO.setRelationDescribe(stringNullChange(relationNodeVO.getRelationDescribe()));
                //风险等级
                relationListInfoVO.setRiskLevel(stringNullChange(relationNodeVO.getRiskLevel()));
                //易燃指数
                relationListInfoVO.setRiskIndex(relationNodeVO.getRiskIndex());
                //行业
                relationListInfoVO.setIndustry(stringNullChange(relationNodeVO.getIndustry()));

                //出资比例  investRatio
                if (relationNodeVO.getRelationDescribe().contains("股东")) {
                    if (gdxxMap.containsKey(relationNodeVO.getCname())) {
                        relationListInfoVO.setInvestRatio(gdxxMap.get(stringNullChange(relationNodeVO.getCname())));
                    }
                }
            }

            if (jbxx == null) {
                //注册日期  esdate
                relationListInfoVO.setEsdate("--");
                //法定代表人 frname
                relationListInfoVO.setFrname("--");
                //登记状态 enterpriseStatus
                relationListInfoVO.setEnterpriseStatus("--");
                //注册资本  regcap
                relationListInfoVO.setRegcap("--");
            } else {
                //注册日期  esdate
                relationListInfoVO.setEsdate(stringNullChange(jbxx.getEsdate()));
                //法定代表人 frname
                relationListInfoVO.setFrname(stringNullChange(jbxx.getFrname()));
                //登记状态 enterpriseStatus
                relationListInfoVO.setEnterpriseStatus(stringNullChange(jbxx.getEnterpriseStatus()));
                //注册资本  regcap
                relationListInfoVO.setRegcap(stringNullChange(BaseDataUtil.getRegcap(jbxx.getRegcapAmount(), jbxx.getRegcapCurrency())));
                if ("--".equals(relationListInfoVO.getIndustry())) {
                    relationListInfoVO.setIndustry(stringNullChange(Constants.INDUSTRY_DESCRIBE_MAP.get(jbxx.getCompanyIndustry())));
                }
            }
            relationListInfoVOS.add(relationListInfoVO);
        }

        return relationListInfoVOS;
    }

    /**
     * 将对象进行排序处理
     *
     * @param relationListInfoVOS
     * @param sortColumn
     * @param sortType
     * @return
     */
    private List<RelationListInfoVO> sortObjects(List<RelationListInfoVO> relationListInfoVOS, String sortColumn, String sortType) {
        //排序
        Collections.sort(relationListInfoVOS, new RaTwoComparator(sortColumn));

        if (sortType.equals(Constants.SORT_TYPE_DESC)) {
            Collections.reverse(relationListInfoVOS);
        }
        return relationListInfoVOS;
    }

    /**
     * 批量数仓数据
     *
     * @param companyIdList
     * @param pageSize
     * @return
     * @throws InterruptedException
     */
    private List<ApiFinancialVO> getApiFinancialData(String companyIdList, int pageSize) throws InterruptedException {
        Vector<ApiFinancialVO> dataList = new Vector<>();
        String[] keysValue = StringUtils.split(companyIdList, ",");
        List<String> keys = getKeys(keysValue, pageSize);
        if (CollectionUtils.isEmpty(keys)) {
            return dataList;
        }
        CountDownLatch latch = new CountDownLatch(keys.size());

        for (int m = 0; m < keys.size(); m++) {
            String companyId = keys.get(m);
            SystemThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Map externalParam = new HashedMap();
                    externalParam.put("qyId", companyId);
                    try {
                        JSONObject rawData = (JSONObject) defaultApiExecEngine.execute(financialApiId, externalParam);

                        List<Object> objectsData = (List<Object>) rawData.get("data");
                        Gson gson = new Gson();
                        for (Object o : objectsData) {
                            JSONObject value = (JSONObject) o;
                            ApiFinancialVO apiFinancialVO = gson.fromJson(value.toString(), ApiFinancialVO.class);
                            dataList.add(apiFinancialVO);
                        }
                        latch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        latch.await();
        return dataList;
    }

    /**
     * 将传入的数据根据pageSize转换成对应的list
     *
     * @param keysValue
     * @param pageSize
     * @return
     */
    private List<String> getKeys(String[] keysValue, int pageSize) {
        List<String> keys = new ArrayList<String>();
        int keysLength = keysValue.length;
        int num = 0;
        for (int i = keysLength; i > 0; i -= pageSize) {
            StringBuffer value = new StringBuffer();
            if (i <= pageSize) {
                for (int j = 0; j < i; j++) {
                    value.append(value.length() == 0 ? keysValue[j + num * pageSize] : "," + keysValue[j + num * pageSize]);
                }
            } else {
                for (int j = 0; j < pageSize; j++) {
                    value.append(value.length() == 0 ? keysValue[j + num * pageSize] : "," + keysValue[j + num * pageSize]);
                }
            }
            keys.add(value.toString());
            num++;
        }
        return keys;
    }

    /**
     * 组装返回资料
     *
     * @param baseMap
     * @param forRelationList
     * @param mapData
     * @param companyIdList
     * @param autoData        @return
     * @param shuCangMap
     * @param degree
     */
    private List<RelationListInfoVO> makesReturnData(HashMap<String, BaseDataDTO.Jbxx> baseMap, List<ApiFinancialVO> forRelationList, HashMap<String, RelationNodeVO> mapData, HashMap<String, String> gdxxMap, String companyIdList, boolean autoData, Map<String, ApiFinancialVO> shuCangMap, int degree) {
        List<RelationListInfoVO> relationListInfoVOS = new ArrayList<>();

        String[] listCompany = null;

        /**
         * 如果自动取资料，资料的多少有数仓接口决定，所以循环数仓返回的数量
         * 如果是手动取资料，那么数量的多少由我们传入参数companyList决定所以循环传入参数的数量
         */
        int whileTime = 0;
        if (autoData) {
            whileTime = shuCangMap.size();
        } else {
            listCompany = StringUtils.split(companyIdList, ",");
            whileTime = listCompany.length;
        }

        for (int j = 0; j < whileTime; j++) {
            RelationListInfoVO relationListInfoVO = new RelationListInfoVO();
            String companyId = null;
            if (autoData) {
                companyId = forRelationList.get(j).getCompanyId();
            } else {
                companyId = listCompany[j];
            }


            ApiFinancialVO apiFinancialVO = shuCangMap.get(companyId);

            /**
             * 如果是自动取得资料，那么数仓返回来的信息当中有可能存在这边关联方没有的资料
             * 这种资料经与产品确认还是要显示，但是就从关联放里面取不到相关信息，就从我们本地库里面取，能取到多少信息算多少
             */
            RelationNodeVO relationNodeVO = mapData.get(companyId);

            relationListInfoVO.setDataId(companyId);

//            JbxxDTO jbxx = null;
            BaseDataDTO.Jbxx jbxx = null;

            if (relationNodeVO == null) {//关联方VO 为空表示 这个资料 数仓有 但是 关联没有
                RaCompanyPO raCompanyPO = raCompanyService.findCompanyById(companyId);
                if (raCompanyPO != null) {

                    //用ID取资料
                    jbxx = baseMap.get(raCompanyPO.getId());

                    //企业名称/人名
                    relationListInfoVO.setName(stringNullChange(raCompanyPO.getCompany()));
                    //关联度
                    relationListInfoVO.setCategory(degree);
                    //关联关系
                    relationListInfoVO.setRelationDescribe("--");
                    //风险等级
                    relationListInfoVO.setRiskLevel(stringNullChange(raCompanyPO.getRiskLevel()));
                    //易燃指数
                    relationListInfoVO.setRiskIndex(raCompanyPO.getRiskIndex());
                    //行业
                    relationListInfoVO.setIndustry(stringNullChange(raCompanyPO.getIndustry()));
                } else {//等昆仑接口修改好以后直接从 这边取
                    jbxx = baseMap.get(companyId);

                    if (jbxx != null) {
                        //企业名称/人名
                        relationListInfoVO.setName(stringNullChange(jbxx.getCompanyName()));
                        //关联度
                        relationListInfoVO.setCategory(degree);
                        //关联关系
                        relationListInfoVO.setRelationDescribe("--");
                        //风险等级
                        relationListInfoVO.setRiskLevel("--");
                        //易燃指数
                        relationListInfoVO.setRiskIndex(null);
                        //行业
                        relationListInfoVO.setIndustry(stringNullChange(Constants.INDUSTRY_DESCRIBE_MAP.get(jbxx.getCompanyIndustry())));
                    }
                }
            } else {
                String id = relationNodeVO.getName();

                //用ID取资料
                jbxx = baseMap.get(id);

                //企业名称/人名
                relationListInfoVO.setName(stringNullChange(relationNodeVO.getCname()));
                //关联度
                relationListInfoVO.setCategory(integerNullDataChange(relationNodeVO.getCategory()));
                //关联关系
                relationListInfoVO.setRelationDescribe(stringNullChange(relationNodeVO.getRelationDescribe()));
                //风险等级
                relationListInfoVO.setRiskLevel(stringNullChange(relationNodeVO.getRiskLevel()));
                //易燃指数
                relationListInfoVO.setRiskIndex(relationNodeVO.getRiskIndex());
                //行业
                relationListInfoVO.setIndustry(stringNullChange(relationNodeVO.getIndustry()));

                //出资比例  investRatio
                if (relationNodeVO.getRelationDescribe().contains("股东")) {
                    if (gdxxMap.containsKey(relationNodeVO.getCname())) {
                        relationListInfoVO.setInvestRatio(gdxxMap.get(stringNullChange(relationNodeVO.getCname())));
                    }
                }
            }

            if (jbxx == null) {
                //注册日期  esdate
                relationListInfoVO.setEsdate("--");
                //法定代表人 frname
                relationListInfoVO.setFrname("--");
                //登记状态 enterpriseStatus
                relationListInfoVO.setEnterpriseStatus("--");
                //注册资本  regcap
                relationListInfoVO.setRegcap("--");
            } else {
                //注册日期  esdate
                relationListInfoVO.setEsdate(stringNullChange(jbxx.getEsdate()));
                //法定代表人 frname
                relationListInfoVO.setFrname(stringNullChange(jbxx.getFrname()));
                //登记状态 enterpriseStatus
                relationListInfoVO.setEnterpriseStatus(stringNullChange(jbxx.getEnterpriseStatus()));
                //注册资本  regcap
                String regcap = stringNullChange(BaseDataUtil.getRegcap(jbxx.getRegcapAmount(), jbxx.getRegcapCurrency()));
                if ("--".equals(relationListInfoVO.getIndustry())) {
                    relationListInfoVO.setIndustry(stringNullChange(Constants.INDUSTRY_DESCRIBE_MAP.get(jbxx.getCompanyIndustry())));
                }
                relationListInfoVO.setRegcap(regcap);
            }


            if (apiFinancialVO != null) {
                setApiFinancialInfo(relationListInfoVO, apiFinancialVO);
            }
            relationListInfoVOS.add(relationListInfoVO);
        }

        return relationListInfoVOS;
    }

    /**
     * 查询数据库黑名单
     *
     * @param relationListInfoVOS
     */
    private void handleBlack(List<RelationListInfoVO> relationListInfoVOS) {
        Set<String> companyIds = new HashSet<>();
        Map<String, RelationListInfoVO> map = new HashMap<>();
        for (RelationListInfoVO relationListInfoVO : relationListInfoVOS) {
            companyIds.add(relationListInfoVO.getDataId());
            map.put(relationListInfoVO.getDataId(), relationListInfoVO);
        }

        List<String> blackCompanyIds = raBlackListService.findBlackListByCompanyIds(companyIds);
        for (String blackCompanyId : blackCompanyIds) {
            RelationListInfoVO relationListInfoVO = map.get(blackCompanyId);
            if (relationListInfoVO == null) {
                continue;
            }
            relationListInfoVO.setBlack(true);
        }
    }


    /**
     * 剔除关联方没有但是数仓返回有的资料
     */
    private List<ApiFinancialVO> changeData(List<ApiFinancialVO> shuCangDataList, HashMap<String, RelationNodeVO> mapData) {
        List<ApiFinancialVO> data = new ArrayList<>();
        for (ApiFinancialVO voData : shuCangDataList) {
            String keyValue = voData.getCompanyId();
            if (mapData.containsKey(keyValue)) {
                data.add(voData);
            }
        }
        return data;
    }

    /**
     * 批量取得基本信息(调用基本信息批量API接口)
     *
     * @param keys
     * @return
     * @throws Exception
     */
    private List<JbxxDTO> getBaseInfoDataByJbxxBatch(String keys) throws Exception {
        Vector<JbxxDTO> data = new Vector<JbxxDTO>();
        int pageSize = 200;
        String[] keysValue = keys.split(",");
        List<String> keysList = getKeys(keysValue, pageSize);
        CountDownLatch latch = new CountDownLatch(keysList.size());
        int num = keysList.size();


        for (int i = 0; i < keysList.size(); i++) {

            String keysData = keysList.get(i);

            SystemThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Map externalParam = new HashedMap();
                    externalParam.put("keys", keysData);
                    JSONObject rawData = null;
                    try {
                        rawData = (JSONObject) defaultApiExecEngine.execute(jbxxBatchApiId, externalParam);

                        TypeToken token = new TypeToken<ApiReturnBean<JbxxDTO>>() {
                        };
                        Gson gson = new Gson();
                        ApiReturnBean<JbxxDTO> baseDataVOApiReturnBean = gson.fromJson(rawData.toString(), token.getType());

                        List<JbxxDTO> baseDataVOS = baseDataVOApiReturnBean.getResults();

                        data.addAll(baseDataVOS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        return data;
    }

    /**
     * 批量取得基本信息(工商数据批量API接口)
     *
     * @param keys
     * @return
     * @throws Exception
     */
    private List<BaseDataDTO> getBaseInfoDataByQyxxBatch(String keys) throws Exception {
        Vector<BaseDataDTO> data = new Vector<BaseDataDTO>();
        int pageSize = 50;
        String[] keysValue = keys.split(",");
        List<String> keysList = getKeys(keysValue, pageSize);
        CountDownLatch latch = new CountDownLatch(keysList.size());

        ExecutorService pool = Executors.newFixedThreadPool(15);

        for (int i = 0; i < keysList.size(); i++) {
            String keysData = keysList.get(i);
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    Map externalParam = new HashedMap();
                    externalParam.put("keys", keysData);
                    JSONObject rawData = null;
                    try {
                        rawData = (JSONObject) defaultApiExecEngine.execute(qyxxBatchApiId, externalParam);
                        TypeToken token = new TypeToken<ApiReturnBean<BaseDataDTO>>() {
                        };
                        Gson gson = new Gson();
                        ApiReturnBean<BaseDataDTO> baseDataVOApiReturnBean = gson.fromJson(rawData.toString(), token.getType());
                        List<BaseDataDTO> baseDataDTOS = baseDataVOApiReturnBean.getResults();
                        data.addAll(baseDataDTOS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        return data;
    }

    /**
     * 设置数仓相关信息
     *
     * @param relationListInfoVO
     * @param apiFinancialVO
     */
    private void setApiFinancialInfo(RelationListInfoVO relationListInfoVO, ApiFinancialVO apiFinancialVO) {
        //民间借贷法律文书
        relationListInfoVO.setTotalPrivateLendingNum(integerNullDataChange(apiFinancialVO.getTotalPrivateLendingNum()));
        //失信被执行人
        relationListInfoVO.setTotalDishonestyNum(integerNullDataChange(apiFinancialVO.getTotalDishonestyNum()));
        //被执行人
        relationListInfoVO.setTotalZhixingNum(integerNullDataChange(apiFinancialVO.getTotalZhixingNum()));
        //行政处罚
        relationListInfoVO.setTotalXzcfNum(integerNullDataChange(apiFinancialVO.getTotalXzcfNum()));
        //经营异常
        relationListInfoVO.setTotalQyycNum(integerNullDataChange(apiFinancialVO.getTotalQyycNum()));
        //诉讼
        relationListInfoVO.setTotalDocumentNum(integerNullDataChange(apiFinancialVO.getTotalDocumentNum()));
        //工商变更
        relationListInfoVO.setTotalBgxxNum(integerNullDataChange(apiFinancialVO.getTotalBgxxNum()));
        //对外投资
        relationListInfoVO.setTotalOutDegreeNum(integerNullDataChange(apiFinancialVO.getTotalOutDegreeNum()));
        //黑名单
        relationListInfoVO.setTotalBlackNum(integerNullDataChange(apiFinancialVO.getBlackNum3d()));
        //高风险
        relationListInfoVO.setTotalHighNum(integerNullDataChange(apiFinancialVO.getHighRiskNum3d()));
    }

    /**
     * 将LIST中的数据用“、”连接
     *
     * @param value
     * @return
     */
    private String getData(List<String> value) {
        StringBuffer data = new StringBuffer();
        if (!CollectionUtils.isEmpty(value)) {
            for (int i = 0; i < value.size(); i++) {
                if (i == 0) {
                    data.append(value.get(i));
                } else {
                    data.append("、");
                    data.append(value.get(i));
                }
            }
        }
        return data.toString();
    }

    /**
     * 当值为空时返回“--”
     *
     * @param value
     * @return
     */
    private String stringNullChange(String value) {
        if (null == value || value.equals("")) {
            return "--";
        } else {
            return value;
        }
    }
}
