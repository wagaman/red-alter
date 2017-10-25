package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/21.
 */
@ApiModel(value = "海外投资机构")
public class OverseasInvestDTO {
    @ApiModelProperty(value = "经营范围")
    @SerializedName("operate_scope")
    private String operateScope;
    @ApiModelProperty(value = "境外投资企业（机构）")
    @SerializedName("foreign_invest_enterprises")
    private String foreignInvestEnterprises;
    @ApiModelProperty(value = "核准日期")
    @SerializedName("approval_date")
    private String approvalDate;
    @ApiModelProperty(value = "省市")
    @SerializedName("province")
    private String province;
    @ApiModelProperty(value = "境内投资主体")
    @SerializedName("domestic_invest_subject")
    private String domesticInvestSubject;
    @ApiModelProperty(value = "数据表")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "证书号")
    @SerializedName("certificate_no")
    private String certificateNo;
    @ApiModelProperty(value = "国家/地区")
    @SerializedName("country_region")
    private String countryRegion;

    public String getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(String operateScope) {
        this.operateScope = operateScope;
    }

    public String getForeignInvestEnterprises() {
        return foreignInvestEnterprises;
    }

    public void setForeignInvestEnterprises(String foreignInvestEnterprises) {
        this.foreignInvestEnterprises = foreignInvestEnterprises;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDomesticInvestSubject() {
        return domesticInvestSubject;
    }

    public void setDomesticInvestSubject(String domesticInvestSubject) {
        this.domesticInvestSubject = domesticInvestSubject;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }
}
