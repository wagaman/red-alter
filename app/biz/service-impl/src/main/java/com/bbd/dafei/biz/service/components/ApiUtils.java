package com.bbd.dafei.biz.service.components;

import com.bbd.dafei.biz.service.sys.SystemThreadPool;
import com.bbd.dafei.common.dal.mapper.RaCacheMapper;
import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.MD5Util;
import com.bbd.dafei.common.util.ReturnBeanable;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

/**
 * 请求数据接口组件
 *
 * @author Ian.Su
 * @version $Id: HttpRequest.java, v 0.1 2017/4/14 14:51 Ian.Su Exp $
 */
@Component
public class ApiUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiUtils.class);


    @Autowired
    private RaCacheMapper raCacheMapper;

    @Autowired
    private RequestUtils requestUtils;


    //数据平台appkey
    @Value("${dataapi.appkey}")
    private String appkey;

    public String getAppkey() {
        return appkey;
    }



    /**
     * 优先从缓存中获取数据,如果缓存中没有,则用get方式从远程接口处获取,获取后将数据存入缓存中
     *
     * @param url       请求地址
     * @param token     需要转换的对象
     * @param validDate 缓存最终有效期
     * @param nvps      参数
     * @return T 目标对象
     */
    public <T extends ReturnBeanable> T cacheThenGet(String url, TypeToken<T> token, Date validDate, List<NameValuePair> nvps) throws Exception {

        T t = getFormCache(url, token, nvps);

        if (t == null) {
            t = requestUtils.get(url, token, nvps);
            cache(url, validDate, nvps, t);
        }

        return t;

    }


    /**
     * 优先从缓存中获取数据,如果缓存中没有,则用post从远程接口处获取,获取后将数据存入缓存中
     *
     * @param url       请求地址
     * @param token     需要转换的对象
     * @param validDate 缓存最终有效期
     * @param nvps      参数
     * @return T 目标对象
     */
    public <T extends ReturnBeanable> T cacheThenPost(String url, TypeToken<T> token, Date validDate, List<NameValuePair> nvps) throws Exception {

        T t = getFormCache(url, token, nvps);

        if (t == null) {
            t = requestUtils.post(url, token, nvps);
            cache(url, validDate, nvps, t);
        }

        return t;

    }

    /**
     * 从缓存获取数据,不会调用远程接口
     *
     * @param url   请求地址
     * @param token 需要转换的对象
     * @param nvps  参数
     * @return T 目标对象
     */
    public <T extends ReturnBeanable> T getFormCache(String url, TypeToken<T> token, List<NameValuePair> nvps) {
        try {
            String id = getKey(url, nvps);
            String val = raCacheMapper.get(id);
            Gson gson = new Gson();
            return gson.fromJson(val, token.getType());
        } catch (Exception e) {
            LOGGER.error("获取缓存出现错误", e);
        }
        return null;
    }


    private String getKey(String url, List<NameValuePair> nvps) throws Exception {

        String id = url + "?" + nvps.toString();

        id = MD5Util.MD5(id);

        return id;
    }


    /**
     * 用异步线程保存数据到缓存中
     */
    private <T extends ReturnBeanable> void cache(String url, Date validDate, List<NameValuePair> nvps, T val) {
        //请求失败，不做缓存
        if (!val.accessApiSuccess()) {
            return;
        }
        Runnable run = new Runnable() {
            @Override
            public void run() {

                try {
                    String id = getKey(url, nvps);
                    Gson gson = new Gson();
                    String valStr = gson.toJson(val);
                    raCacheMapper.save(id, valStr, validDate);
                } catch (Exception e) {
                    LOGGER.error("保存缓存出现错误", e);
                }

            }
        };

        SystemThreadPool.execute(run);

    }


}
