package com.bbd.dafei.biz.service.components;

import com.bbd.dafei.common.exception.AccessApiException;
import com.bbd.dafei.common.util.AbstractReturnBean;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by wish on 2017/5/22.
 */
public class ApiExceptionUtils {
    /**
     * 生成异常
     *
     * @param url
     * @param returnBean
     * @param nvps
     * @return
     */
    public static AccessApiException getAccessApiException(String url, AbstractReturnBean returnBean, List<NameValuePair> nvps) {
        StringBuilder msg = new StringBuilder();
        msg.append("调用http接口失败，");
        msg.append(returnBean.errorDescribe());
        msg.append("，url：");
        msg.append(url);
        if (CollectionUtils.isNotEmpty(nvps)) {
            msg.append("，参数：");
            nvps.forEach((NameValuePair nameValuePair) -> {
                if ("appkey".equals(nameValuePair.getName())) {
                    return;
                }
                msg.append(nameValuePair.getName());
                msg.append("=");
                msg.append(nameValuePair.getValue());
                msg.append(";");
            });
        }
        return new AccessApiException(msg.toString());
    }
}
