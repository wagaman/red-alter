package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/5/4.
 */
@ApiModel(value = "高亮信息")
public class HighLightDTO {
    @ApiModelProperty(value = "公司名高亮")
    @SerializedName("company_name")
    private List<String> companyName;
    @ApiModelProperty(value = "董监高高亮")
    @SerializedName("baxx")
    private List<String> baxx;
    @ApiModelProperty(value = "股东公司高亮")
    @SerializedName("gdxx_company")
    private List<String> gdxxCompany;
    @ApiModelProperty(value = "股东个人高亮")
    @SerializedName("gdxx")
    private List<String> gdxx;
    @ApiModelProperty(value = "法人高亮")
    @SerializedName("frname")
    private List<String> frname;
    @ApiModelProperty(value = "平台高亮")
    @SerializedName("p2p_platform")
    private List<String> p2pPlatform;
    @ApiModelProperty(value = "地址高亮")
    @SerializedName("address")
    private List<String> address;
    @ApiModelProperty(value = "软件著作权")
    @SerializedName("rjzzq")
    private List<String> rjzzq;
    @ApiModelProperty(value = "注册号")
    @SerializedName("regno")
    private List<String> regno;
    @ApiModelProperty(value = "商标")
    @SerializedName("trademark")
    private List<String> tradeMark;
    @ApiModelProperty(value = "统一社会信用代码")
    @SerializedName("credit_code")
    private List<String> creditCode;
    @ApiModelProperty(value = "专利")
    @SerializedName("patent")
    private List<String> patent;


    public List<String> getCompanyName() {
        return companyName;
    }

    public void setCompanyName(List<String> companyName) {
        this.companyName = companyName;
    }

    public List<String> getBaxx() {
        return baxx;
    }

    public void setBaxx(List<String> baxx) {
        this.baxx = baxx;
    }

    public List<String> getGdxxCompany() {
        return gdxxCompany;
    }

    public void setGdxxCompany(List<String> gdxxCompany) {
        this.gdxxCompany = gdxxCompany;
    }

    public List<String> getGdxx() {
        return gdxx;
    }

    public void setGdxx(List<String> gdxx) {
        this.gdxx = gdxx;
    }

    public List<String> getFrname() {
        return frname;
    }

    public void setFrname(List<String> frname) {
        this.frname = frname;
    }

    public List<String> getP2pPlatform() {
        return p2pPlatform;
    }

    public void setP2pPlatform(List<String> p2pPlatform) {
        this.p2pPlatform = p2pPlatform;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<String> getRjzzq() {
        return rjzzq;
    }

    public void setRjzzq(List<String> rjzzq) {
        this.rjzzq = rjzzq;
    }

    public List<String> getRegno() {
        return regno;
    }

    public void setRegno(List<String> regno) {
        this.regno = regno;
    }

    public List<String> getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(List<String> tradeMark) {
        this.tradeMark = tradeMark;
    }

    public List<String> getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(List<String> creditCode) {
        this.creditCode = creditCode;
    }

    public List<String> getPatent() {
        return patent;
    }

    public void setPatent(List<String> patent) {
        this.patent = patent;
    }
}
