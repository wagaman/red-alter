package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.ManageDataService;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.TransferResponseBean;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wish on 2017/4/19.
 */
@Service
public class ManageDataServiceImpl implements ManageDataService {
    @Autowired
    private ApiUtils api;

    //工商变更信息url
    @Value("${api.qygsbgxx}")
    private String qygsBgxxUrl;

    //企业舆情信息url
    @Value("${api.qyyqxx}")
    private String qyyqxxUrl;

    //域名备案url
    @Value("${api.qyymbaxx}")
    private String qyymbaxxUrl;

    //年报url
    @Value("${api.gsnbxx}")
    private String gsnbxxUrl;

    //企业招聘数据信息数据查询API接口url
    @Value("${api.qyzpsjxx}")
    private String qyzpsjxxUrl;

    //transfer 查询招聘KPI url
    @Value("${api.transfer.recruitKPI}")
    private String recruitKPIUrl;

    private final String bazc = "章程备案";
    private final String jyfwbg = "经营范围变更";
    private final String fzrbg = "负责人变更";
    private final String jyfwbgyw = "经营范围变更（含业务范围变更）变更";

    @Override
    public PageInfo<BgxxDTO> getBgxxByCompanyId(String companyId, Integer page, Integer pageSize, boolean highLight) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<BgxxDTO> r = api.cacheThenGet(qygsBgxxUrl, new TypeToken<ApiReturnBean<BgxxDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qygsBgxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            //处理变更信息高亮
            if (highLight) {
                handlerChangeHighLight(r.getResults());
            }
            return new PageInfo<BgxxDTO>(r, page);
        }
        return null;
    }

    /**
     * 处理变更信息高亮
     * 变更的内容高亮
     *
     * @param bgxxDTOList
     */
    private void handlerChangeHighLight(List<BgxxDTO> bgxxDTOList) {
        if (CollectionUtils.isEmpty(bgxxDTOList)) {
            return;
        }
        for (BgxxDTO bgxxDTO : bgxxDTOList) {
            String separator = ";";
            if (bazc.equals(bgxxDTO.getChangeItems())) {
                separator = ",";
            } else if (jyfwbg.equals(bgxxDTO.getChangeItems()) || jyfwbgyw.equals(bgxxDTO.getChangeItems())) {
                separator = "；";
            } else if (fzrbg.equals(bgxxDTO.getChangeItems())) {
                separator = "`";
            }

            List<String> beforeContents = new ArrayList<>();
            List<String> afterContents = new ArrayList<>();
            if (bgxxDTO.getContentBeforeChange() != null) {
                beforeContents = Splitter.on(separator).omitEmptyStrings().splitToList(bgxxDTO.getContentBeforeChange());
            }
            if ("null".equals(bgxxDTO.getContentAfterChange())) {
                bgxxDTO.setContentAfterChange("--");
            }
            if (bgxxDTO.getContentAfterChange() != null) {
                afterContents = Splitter.on(separator).omitEmptyStrings().splitToList(bgxxDTO.getContentAfterChange());
            }


            List<String> hightLightBeforeContents = new ArrayList<>();
            List<String> hightLightAfterContents = new ArrayList<>();

            for (String beforeContent : beforeContents) {
                if (!afterContents.contains(beforeContent)) {
                    beforeContent = "<em>" + beforeContent + "</em>";
                }
                hightLightBeforeContents.add(beforeContent);
            }
            for (String afterContent : afterContents) {
                if (!beforeContents.contains(afterContent)) {
                    afterContent = "<em>" + afterContent + "</em>";
                }
                hightLightAfterContents.add(afterContent);
            }
            bgxxDTO.setContentBeforeChange(Joiner.on(separator).join(hightLightBeforeContents));
            bgxxDTO.setContentAfterChange(Joiner.on(separator).join(hightLightAfterContents));
        }
    }

    @Override
    public PageInfo<YuqingDTO> getYuqingByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<YuqingDTO> r = api.cacheThenGet(qyyqxxUrl, new TypeToken<ApiReturnBean<YuqingDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qyyqxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<YuqingDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<YmbaDTO> getYmbaBycompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<YmbaDTO> r = api.cacheThenGet(qyymbaxxUrl, new TypeToken<ApiReturnBean<YmbaDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qyymbaxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<YmbaDTO>(r, page);
        }
        return null;
    }

    @Override
    public YearReportDTO getYearReportByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("detail", "true"));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<YearReportDTO> r = api.cacheThenGet(gsnbxxUrl, new TypeToken<ApiReturnBean<YearReportDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gsnbxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return r.getResults().get(0);
        }
        return null;
    }

    @Override
    public PageInfo<RecruitDTO> getRecruitBycompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<RecruitDTO> r = api.cacheThenGet(qyzpsjxxUrl, new TypeToken<ApiReturnBean<RecruitDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qyzpsjxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<RecruitDTO>(r, page);
        }
        return null;
    }

    @Override
    public RecruitKPIDTO getRecruitKPIByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("companyId", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        TransferResponseBean<RecruitKPIDTO> transferResponseBean = api.cacheThenGet(recruitKPIUrl,
                new TypeToken<TransferResponseBean<RecruitKPIDTO>>() {
                }, validDate, nvps);
        if (!transferResponseBean.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(recruitKPIUrl, transferResponseBean, nvps);
        }
        return transferResponseBean.getContent();
    }

}
