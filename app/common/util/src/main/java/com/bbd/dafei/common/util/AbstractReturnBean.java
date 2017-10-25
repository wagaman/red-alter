package com.bbd.dafei.common.util;

/**
 * Created by wish on 2017/5/18.
 */
public abstract class AbstractReturnBean implements ReturnBeanable {
    /**
     * 错误描述
     *
     * @return
     */
    @Override
    public String errorDescribe() {
        StringBuilder errorDescribe = new StringBuilder();
        errorDescribe.append("错误码：");
        errorDescribe.append(returnCode());
        errorDescribe.append(",");
        errorDescribe.append(returnMessage());
        return errorDescribe.toString();
    }


    /**
     * 错误编号
     *
     * @return
     */
    public abstract String returnCode();

    /**
     * 错误信息
     *
     * @return
     */
    public abstract String returnMessage();
}
