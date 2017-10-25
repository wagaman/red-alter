package com.bbd.dafei.common.modal.dto;

import com.bbd.dafei.common.util.AbstractReturnBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wish on 2017/4/25.
 */
public class SearchCompanyPageDTO extends AbstractReturnBean {
    /**
     * 访问成功code
     */
    public static final String SUCCESS_CODE = "0";

    private String msg;//消息
    private int total;//页总数
    private int sum;//总数
    @SerializedName("err_code")
    private String errCode;//错误号
    @SerializedName("rdata")
    private List<SearchCompanyDTO> searchCompanyDTOList;//搜索公司结果

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public List<SearchCompanyDTO> getSearchCompanyDTOList() {
        return searchCompanyDTOList;
    }

    public void setSearchCompanyDTOList(List<SearchCompanyDTO> searchCompanyDTOList) {
        this.searchCompanyDTOList = searchCompanyDTOList;
    }

    @Override
    public boolean accessApiSuccess() {
        return SUCCESS_CODE.equals(errCode);
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
