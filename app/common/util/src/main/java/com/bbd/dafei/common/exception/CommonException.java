package com.bbd.dafei.common.exception;

/**
 * 公共异常,所有的自定义异常请继承自此类,也可以直接使用此类
 * @author Ian.Su
 * @version $Id: CommonException.java, v 0.1 2017/4/21 16:54 Ian.Su Exp $
 */
public class CommonException extends RuntimeException {


    private Integer errCode = 500;

    public CommonException(String message, Throwable cause){
        super(message, cause);
    }

    public CommonException(String message){
        super(message);
    }

    public CommonException(Integer errCode,String message){

        this(message);

        this.errCode = errCode;

    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
