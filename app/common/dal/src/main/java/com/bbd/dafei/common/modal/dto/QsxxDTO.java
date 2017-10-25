package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "清算信息")
public class QsxxDTO {
    @ApiModelProperty(value = "公司名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "清算责任人")
    @SerializedName("ligentity")
    private String ligentity;
    @ApiModelProperty(value = "清算负责人")
    @SerializedName("ligprincipal")
    private String ligprincipal;
    @ApiModelProperty(value = "清算组成员")
    @SerializedName("liqmen")
    private String liqmen;
    @ApiModelProperty(value = "清算完结情况")
    @SerializedName("ligst")
    private String ligst;
    @ApiModelProperty(value = "清算完结日期")
    @SerializedName("ligenddate")
    private String ligenddate;
    @ApiModelProperty(value = "债务承接人")
    @SerializedName("debttranee")
    private String debttranee;
    @ApiModelProperty(value = "债权承接人")
    @SerializedName("claimtranee")
    private String claimtranee;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLigentity() {
        return ligentity;
    }

    public void setLigentity(String ligentity) {
        this.ligentity = ligentity;
    }

    public String getLigprincipal() {
        return ligprincipal;
    }

    public void setLigprincipal(String ligprincipal) {
        this.ligprincipal = ligprincipal;
    }

    public String getLiqmen() {
        return liqmen;
    }

    public void setLiqmen(String liqmen) {
        this.liqmen = liqmen;
    }

    public String getLigst() {
        return ligst;
    }

    public void setLigst(String ligst) {
        this.ligst = ligst;
    }

    public String getLigenddate() {
        return ligenddate;
    }

    public void setLigenddate(String ligenddate) {
        this.ligenddate = ligenddate;
    }

    public String getDebttranee() {
        return debttranee;
    }

    public void setDebttranee(String debttranee) {
        this.debttranee = debttranee;
    }

    public String getClaimtranee() {
        return claimtranee;
    }

    public void setClaimtranee(String claimtranee) {
        this.claimtranee = claimtranee;
    }
}
