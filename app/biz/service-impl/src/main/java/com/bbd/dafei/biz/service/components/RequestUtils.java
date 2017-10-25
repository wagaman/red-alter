package com.bbd.dafei.biz.service.components;

import com.bbd.dafei.common.exception.CommonException;
import com.bbd.dafei.common.util.ReturnBeanable;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 请求远程接口
 * @author Ian.Su
 * @version $Id: RequestUtils.java, v 0.1 2017/5/24 11:16 Ian.Su Exp $
 */
@Component
public class RequestUtils {


    private static final Logger LOGGER = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * http获取数据并转为目标对象
     *
     * @param url   请求地址
     * @param token 需要转换的对象
     * @param nvps  参数
     * @return T 目标对象
     */
    public <T extends ReturnBeanable> T post(String url, TypeToken<T> token, List<NameValuePair> nvps) throws Exception {

        Request request = Request.Post(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .bodyForm(nvps, Charset.forName("utf-8"));

        try {
            String s = request.execute().returnContent().asString();
            Gson gson = new Gson();
            T t = gson.fromJson(s, token.getType());
            return t;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            StringBuilder msg = new StringBuilder();
            for (NameValuePair nvp : nvps) {
                msg.append(nvp.getName()).append("=").append(nvp.getValue()).append("&");
            }
            msg.insert(0, "请求远程接口错误:" + url + "?");
            throw new CommonException(msg.toString().substring(0, msg.length() - 1), e);
        }

    }


    public <T extends ReturnBeanable> T get(String url, TypeToken<T> token, List<NameValuePair> nvps) throws Exception {


        StringBuilder params = new StringBuilder();

        for (NameValuePair nvp : nvps) {

            params.append(params.length() == 0 ? "?" : "&")
                    .append(nvp.getName()).append("=")
                    .append(URLEncoder.encode(nvp.getValue(), "utf8"));
        }

        url += params.toString();

        Request request = Request.Get(url).
                addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        try {
            String s = request.execute().returnContent().asString();
            Gson gson = new Gson();
            T t = gson.fromJson(s, token.getType());
            return t;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            String message = "请求远程接口错误:" + url;
            throw new CommonException(message, e);
        }

    }
}
