package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.FeatureService;
import com.bbd.dafei.common.modal.dto.ExchangeDTO;
import com.bbd.dafei.common.modal.dto.PlatformDTO;
import com.bbd.dafei.common.modal.dto.PrivateFundDTO;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.TransferResponseBean;
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
 * Created by wish on 2017/4/25.
 */
@Service
public class FeatureServiceImpl implements FeatureService {
    @Autowired
    private ApiUtils api;

    //交易中国url
    @Value("${api.jyzg}")
    private String jyzgUrl;

    //私募基金特征信息url
    @Value("${api.transfer.privateFundFeature}")
    private String privateFundFeatureUrl;

    //网络借贷特征信息url
    @Value("${api.wljd}")
    private String wljdUrl;


    @Override
    public ExchangeDTO getExchangeByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<ExchangeDTO> r = api.cacheThenGet(jyzgUrl, new TypeToken<ApiReturnBean<ExchangeDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(jyzgUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return r.getResults().get(0);
        }
        return null;
    }

    @Override
    public PrivateFundDTO getPrivateFundBycompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("companyId", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        TransferResponseBean<PrivateFundDTO> transferResponseBean = api.cacheThenGet(privateFundFeatureUrl,
                new TypeToken<TransferResponseBean<PrivateFundDTO>>() {
                }, validDate, nvps);
        if (!transferResponseBean.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(privateFundFeatureUrl, transferResponseBean, nvps);
        }
        return transferResponseBean.getContent();
    }

    @Override
    public PlatformDTO getP2PPlatformByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());

        ApiReturnBean<PlatformDTO> r = api.cacheThenGet(wljdUrl,
                new TypeToken<ApiReturnBean<PlatformDTO>>() {
                }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(wljdUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return r.getResults().get(0);
        }
        return null;
    }
}
