package com.bbd.dafei.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "响应")
public class ResponseBean<T> {
    @ApiModelProperty(value = "响应状态:200:成功;203:失败(如修改某数据时,此数据已经被删除);332:未登录;400:错误请求(缺少参数等);403:无权限;500:服务内部错误;)")
    private int code=200;
    @ApiModelProperty(value = "返回内容")
    private T content;
    @ApiModelProperty(value = "消息")
    private Object   msg;
    /**
     * 记录各方法执行时间
     * */
    @ApiModelProperty(value = "后台方法执行时间")
    private Object exeTimes;



    /**
     * @param content 成功的内容
     * @return ResponseBean
     * @author Ian.Su
     */
    public static <T> ResponseBean successResponse(T content) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = 200;
        responseBean.msg = "成功";
        responseBean.content = content;
        return responseBean;
    }

    /**
     * @param content 成功的内容
     * @return
     * @author
     */
    public static <T> ResponseBean successResponse(T content, Object msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = 200;
        responseBean.content = content;
        responseBean.msg = msg;
        return responseBean;
    }

    /**
     * 默认500错误
     * @param msg 失败的内容，比如提示语句
     * @return ResponseBean
     * @author Ian.Su
     */
    public static ResponseBean errorResponse(Object msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = 500;
        responseBean.msg = msg;
        return responseBean;
    }

    /**
     * 自定义错误码的返回
     * @param msg 失败的内容，比如提示语句
     * @return ResponseBean
     * @author Ian.Su
     */
    public static ResponseBean errorResponse(int code,Object msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = code;
        responseBean.msg = msg;
        return responseBean;
    }

    /**
     * 自定义错误码的返回
     * @param msg 失败的内容，比如提示语句
     * @return ResponseBean
     * @author Ian.Su
     */
    public static ResponseBean errorResponse(int code,Object msg,Object content) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = code;
        responseBean.msg = msg;
        responseBean.content = content;
        return responseBean;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getExeTimes() {
        return exeTimes;
    }

    public void setExeTimes(Object exeTimes) {
        this.exeTimes = exeTimes;
    }
}
