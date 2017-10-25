package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.service.components.ApiUtils;
import com.bbd.dafei.biz.shared.TestService;
import com.bbd.dafei.common.exception.AccessApiException;
import com.bbd.dafei.common.util.ApiReturnBean;
import com.google.common.reflect.TypeToken;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: TestServiceImpl.java, v 0.1 2017/4/13 19:08 Ian.Su Exp $
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private ApiUtils api;

    public String say() throws Exception {

        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("company", "成都数联铭品科技有限公司"));
        nvps.add(new BasicNameValuePair("appkey", api.getAppkey()));

        // postCache(String url, TypeToken<T> token, Date validDate, List< NameValuePair > nvps)
        ApiReturnBean r = api.cacheThenGet("http://dataapi.bbdservice.com/api/bbd_ent_logo/", new TypeToken<ApiReturnBean>() {
        }, new Date(), nvps);
        if (!r.accessApiSuccess()) {
            throw new AccessApiException("请求远程接口失败");
        }

        return r.toString();
    }

}
