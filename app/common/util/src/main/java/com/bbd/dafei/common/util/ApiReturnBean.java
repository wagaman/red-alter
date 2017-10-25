package com.bbd.dafei.common.util;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: ApiReturnBean.java, v 0.1 2017/4/17 11:32 Ian.Su Exp $
 */
public class ApiReturnBean<T> extends AbstractReturnBean {

    /**
     * 成功返回码
     **/
    public static final String CODE_SUCCESS = "0";

    /**
     * 错误码
     **/
    @SerializedName("err_code")
    private String errCode;
    /**
     * 错误码对应的提示信息
     **/
    private String msg;
    /**
     * 结果数据
     **/
    private List<T> results;
    /**
     * 当前返回的数据条数
     **/
    private int rsize;
    /**
     * 符合查询条件的数据总量
     **/
    private int total;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getRsize() {
        return rsize;
    }

    public void setRsize(int rsize) {
        this.rsize = rsize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean accessApiSuccess() {
        return ApiReturnBean.CODE_SUCCESS.equals(errCode);
    }

    @Override
    public String returnCode() {
        return errCode;
    }

    @Override
    public String returnMessage() {
        return msg;
    }


}
