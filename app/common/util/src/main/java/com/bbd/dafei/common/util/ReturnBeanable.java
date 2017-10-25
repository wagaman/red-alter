package com.bbd.dafei.common.util;

/**
 * http调用返回bean接口
 * Created by wish on 2017/5/15.
 */
public interface ReturnBeanable {
    /**
     * 调用Api是否成功
     *
     * @return
     */
    boolean accessApiSuccess();

    /**
     * 错误描述
     *
     * @return
     */
    String errorDescribe();

}
