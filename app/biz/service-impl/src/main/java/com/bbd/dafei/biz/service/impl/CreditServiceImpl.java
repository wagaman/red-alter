package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.CreditService;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.PageInfo;
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
 * Created by wish on 2017/4/20.
 */
@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    private ApiUtils api;

    //企业开庭公告信息url
    @Value("${api.qyktggxx}")
    private String qyktggxxUrl;

    //企业裁判文书信息url
    @Value("${api.qycpwsxx}")
    private String qycpwsxxUrl;

    //企业法院公告信息url
    @Value("${api.qyfyggxx}")
    private String qyfyggxxUrl;

    //企业被执行人信息url
    @Value("${api.qybzxrxx}")
    private String qybzxrxxUrl;

    //企业失信被执行人信息url
    @Value("${api.qysxbzxrxx}")
    private String qysxbzxrxxUrl;

    //企业司法拍卖信息url
    @Value("${api.qysfpmxx}")
    private String qysfpmxxUrl;

    //工商经营异常信息url
    @Value("${api.gsjyycxx}")
    private String gsjyycxxUrl;

    //欠税名单url
    @Value("${api.qsmd}")
    private String qsmdUrl;

    //工商数据清算信息url
    @Value("${api.gssjqsxx}")
    private String gssjqsxxUrl;

    //工商数据股权出质信息url
    @Value("${api.gsjjgqczxx}")
    private String gsjjgqczxxUrl;

    //工商数据动产抵押信息url
    @Value("${api.gsjjdcdyxx}")
    private String gsjjdcdyxxUrl;


    @Override
    public PageInfo<KtggDTO> getKtggByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<KtggDTO> r = api.cacheThenGet(qyktggxxUrl, new TypeToken<ApiReturnBean<KtggDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qyktggxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<KtggDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<CpwsDTO> getCpwsByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<CpwsDTO> r = api.cacheThenGet(qycpwsxxUrl, new TypeToken<ApiReturnBean<CpwsDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qycpwsxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<CpwsDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<FyggDTO> getFyggByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<FyggDTO> r = api.cacheThenGet(qyfyggxxUrl, new TypeToken<ApiReturnBean<FyggDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qyfyggxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<FyggDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<BzxrDTO> getBzxrByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<BzxrDTO> r = api.cacheThenGet(qybzxrxxUrl, new TypeToken<ApiReturnBean<BzxrDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qybzxrxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<BzxrDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<SxbzxrDTO> getSxbzxrByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<SxbzxrDTO> r = api.cacheThenGet(qysxbzxrxxUrl, new TypeToken<ApiReturnBean<SxbzxrDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qysxbzxrxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<SxbzxrDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<SfpmDto> getSfpmByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<SfpmDto> r = api.cacheThenGet(qysfpmxxUrl, new TypeToken<ApiReturnBean<SfpmDto>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qysfpmxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<SfpmDto>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<JyycDTO> getJyycByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<JyycDTO> r = api.cacheThenGet(gsjyycxxUrl, new TypeToken<ApiReturnBean<JyycDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gsjyycxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<JyycDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<QsmdDTO> getQsmdByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<QsmdDTO> r = api.cacheThenGet(qsmdUrl, new TypeToken<ApiReturnBean<QsmdDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qsmdUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<QsmdDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<QsxxDTO> getQsxxByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<QsxxDTO> r = api.cacheThenGet(gssjqsxxUrl, new TypeToken<ApiReturnBean<QsxxDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gssjqsxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<QsxxDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<SharesPawnDTO> getSharesPawn(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<SharesPawnDTO> r = api.cacheThenGet(gsjjgqczxxUrl, new TypeToken<ApiReturnBean<SharesPawnDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gsjjgqczxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<SharesPawnDTO>(r, page);
        }
        return null;
    }

    @Override
    public PageInfo<MortgageDetailDTO> getMortgageDetail(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<MortgageDetailDTO> r = api.cacheThenGet(gsjjdcdyxxUrl, new TypeToken<ApiReturnBean<MortgageDetailDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gsjjdcdyxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<MortgageDetailDTO>(r, page);
        }
        return null;
    }
}
