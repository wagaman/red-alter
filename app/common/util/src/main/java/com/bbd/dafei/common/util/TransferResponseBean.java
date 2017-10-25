package com.bbd.dafei.common.util;

/**
 * Created by wish on 2017/5/2.
 */
public class TransferResponseBean<T> extends AbstractReturnBean {
    private boolean success;

    private T content;

    /**
     * 响应状态:200:成功;203:失败(如修改某数据时,此数据已经被删除);332:未登录;400:错误请求(缺少参数等);403:无权限;500:服务内部错误;)
     */
    private int code = 200;

    private Object msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public boolean accessApiSuccess() {
        return success;
    }

    @Override
    public String returnCode() {
        return String.valueOf(code);
    }

    @Override
    public String returnMessage() {
        return msg.toString();
    }
}
