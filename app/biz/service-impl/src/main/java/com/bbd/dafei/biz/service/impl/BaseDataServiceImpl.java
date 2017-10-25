package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiExceptionUtils;
import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.BaseDataService;
import com.bbd.dafei.common.modal.dto.*;
import com.bbd.dafei.common.modal.util.BaseDataUtil;
import com.bbd.dafei.common.modal.vo.BaseDataVO;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.bbd.dafei.common.util.CommonUtil;
import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.TransferResponseBean;
import com.google.common.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wish on 2017/4/17.
 */
@Service
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    private ApiUtils api;

    //工商数据API接口url
    @Value("${api.transfer.gssj}")
    private String gssjUrl;

    //企业境外投资信息API接口url
    @Value("${api.qyjwtzxx}")
    private String qyjwtzxxUrl;

    //工商数据基本信息API接口
    @Value("${api.gssjjbxx}")
    private String gssjjbxxUrl;

    //查询基本信息概览url
    @Value("${api.transfer.baseDataOverview}")
    private String baseDataOverviewUrl;

    //查询基本信息摘要
    @Value("${api.transfer.companyAbstract}")
    private String companyAbstractUrl;

    //工商分支机构信息API接口
    @Value("${api.gsfzjgxx}")
    private String gsfzjgxxUrl;


    public BaseDataVO getBaseDataByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("companyId", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        TransferResponseBean<BaseDataVO> transferResponseBean = api.cacheThenGet(gssjUrl, new TypeToken<TransferResponseBean<BaseDataVO>>() {
        }, validDate, nvps);
        if (!transferResponseBean.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gssjUrl, transferResponseBean, nvps);
        }
        BaseDataVO baseDataVO = transferResponseBean.getContent();
        List<BaseDataVO.Gdxx> gdxx = baseDataVO.getGdxx();

        for (BaseDataVO.Gdxx g : gdxx) {
            Field[] field = g.getClass().getDeclaredFields();
            String str =null;
            for (int j = 0; j < field.length; j++) { // 遍历所有属性
                String name = field[j].getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                Method m = g.getClass().getMethod("get" + name);
                String value = (String) m.invoke(g); // 调用getter方法获取属性
                if (value !=null && "null".equals(value)) {
                    m = g.getClass().getMethod("set"+name,String.class);
                    m.invoke(g, str);
                }
            }
        }
        if (baseDataVO != null && baseDataVO.getJbxx() != null) {
            baseDataVO.getJbxx().setRegcap(BaseDataUtil.getRegcap(baseDataVO.getJbxx().getRegcapAmount(), baseDataVO.getJbxx().getRegcapCurrency()));
        }
        return transferResponseBean.getContent();
    }

    @Override
    public PageInfo<OverseasInvestDTO> getOverseasInvestByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<OverseasInvestDTO> r = api.cacheThenGet(qyjwtzxxUrl, new TypeToken<ApiReturnBean<OverseasInvestDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(qyjwtzxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<OverseasInvestDTO>(r, page);
        }
        return null;
    }

    @Override
    public JbxxDTO getJbxxByCompanyName(String companyName) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("company", companyName));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<JbxxDTO> r = api.cacheThenGet(gssjjbxxUrl, new TypeToken<ApiReturnBean<JbxxDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gssjjbxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return r.getResults().get(0);
        }
        return null;
    }

    @Override
    public BaseDataOverviewDTO getBaseDataOverviewByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("companyId", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        TransferResponseBean<BaseDataOverviewDTO> transferResponseBean = api.cacheThenGet(baseDataOverviewUrl,
                new TypeToken<TransferResponseBean<BaseDataOverviewDTO>>() {
                }, validDate, nvps);
        if (!transferResponseBean.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(baseDataOverviewUrl, transferResponseBean, nvps);
        }
        return transferResponseBean.getContent();
    }

    @Override
    public BaseDataAbstractDTO getBaseDataAbstractByCompanyId(String companyId) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("companyId", companyId));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        TransferResponseBean<BaseDataAbstractDTO> transferResponseBean = api.cacheThenGet(companyAbstractUrl,
                new TypeToken<TransferResponseBean<BaseDataAbstractDTO>>() {
                }, validDate, nvps);
        if (!transferResponseBean.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(companyAbstractUrl, transferResponseBean, nvps);
        }
        BaseDataAbstractDTO baseDataAbstractDTO = transferResponseBean.getContent();
        if (baseDataAbstractDTO != null) {
            baseDataAbstractDTO.setRegcap(BaseDataUtil.getRegcap(baseDataAbstractDTO.getRegcapAmount(), baseDataAbstractDTO.getRegcapCurrency()));
        }
        return transferResponseBean.getContent();
    }

    @Override
    public PageInfo<FzjgDTO> getFzjgByCompanyId(String companyId, Integer page, Integer pageSize) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("qyxx_id", companyId));
        nvps.add(new BasicNameValuePair("page", String.valueOf(page)));
        nvps.add(new BasicNameValuePair("pageSize", String.valueOf(pageSize)));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));
        //缓存过期时间设置为第二天凌晨
        Date validDate = CommonUtil.getNextDayWithoutHour(new Date());
        ApiReturnBean<FzjgDTO> r = api.cacheThenGet(gsfzjgxxUrl, new TypeToken<ApiReturnBean<FzjgDTO>>() {
        }, validDate, nvps);
        if (!r.accessApiSuccess()) {
            throw ApiExceptionUtils.getAccessApiException(gsfzjgxxUrl, r, nvps);
        }
        if (CollectionUtils.isNotEmpty(r.getResults())) {
            return new PageInfo<FzjgDTO>(r, page);
        }
        return null;
    }

}
