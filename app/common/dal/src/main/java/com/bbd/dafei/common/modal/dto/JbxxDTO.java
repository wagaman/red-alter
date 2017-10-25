package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业基本信息
 * Created by wish on 2017/4/23.
 */
@ApiModel(value = "企业基本信息")
public class JbxxDTO {
    @ApiModelProperty(value = "统一社会信用代码")
    @SerializedName("credit_code")
    private String creditCode;
    @ApiModelProperty(value = "注册号")
    @SerializedName("regno")
    private String regno;
    @ApiModelProperty(value = "名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "企业类型")
    @SerializedName("company_type")
    private String companyType;
    @ApiModelProperty(value = "法定代表人")
    @SerializedName("frname")
    private String frname;
    @ApiModelProperty(value = "注册资金")
    @SerializedName("regcap")
    private String regcap;
    @ApiModelProperty(value = "实收资本")
    @SerializedName("realcap")
    private String realcap;
    @ApiModelProperty(value = "成立日期")
    @SerializedName("esdate")
    private String esdate;
    @ApiModelProperty(value = "核准日期")
    @SerializedName("approval_date")
    private String approvalDate;
    @ApiModelProperty(value = "营业期限自")
    @SerializedName("openfrom")
    private String openfrom;
    @ApiModelProperty(value = "营业期限至")
    @SerializedName("opento")
    private String opento;
    @ApiModelProperty(value = "地址")
    @SerializedName("address")
    private String address;
    @ApiModelProperty(value = "经营范围")
    @SerializedName("operate_scope")
    private String operateScope;
    @ApiModelProperty(value = "登记机关")
    @SerializedName("regorg")
    private String regorg;
    @ApiModelProperty(value = "登记状态")
    @SerializedName("enterprise_status")
    private String enterpriseStatus;
    @ApiModelProperty(value = "吊销日期")
    @SerializedName("revoke_date")
    private String revokeDate;
    @ApiModelProperty(value = "派出企业名称")
    @SerializedName("parent_firm")
    private String parentFirm;
    @ApiModelProperty(value = "出资额")
    @SerializedName("invest_cap")
    private String investCap;
    @ApiModelProperty(value = "注册币种")
    @SerializedName("regcapcur")
    private String regcapcur;
    @ApiModelProperty(value = "注销日期")
    @SerializedName("cancel_date")
    private String cancelDate;
    @ApiModelProperty(value = "组成形式")
    @SerializedName("form")
    private String form;
    @ApiModelProperty(value = "经营期限")
    @SerializedName("operating_period")
    private String operatingPeriod;
    @ApiModelProperty(value = "行业")
    @SerializedName("company_industry")
    private String companyIndustry;

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getRealcap() {
        return realcap;
    }

    public void setRealcap(String realcap) {
        this.realcap = realcap;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getOpenfrom() {
        return openfrom;
    }

    public void setOpenfrom(String openfrom) {
        this.openfrom = openfrom;
    }

    public String getOpento() {
        return opento;
    }

    public void setOpento(String opento) {
        this.opento = opento;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(String operateScope) {
        this.operateScope = operateScope;
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(String revokeDate) {
        this.revokeDate = revokeDate;
    }

    public String getParentFirm() {
        return parentFirm;
    }

    public void setParentFirm(String parentFirm) {
        this.parentFirm = parentFirm;
    }

    public String getInvestCap() {
        return investCap;
    }

    public void setInvestCap(String investCap) {
        this.investCap = investCap;
    }

    public String getRegcapcur() {
        return regcapcur;
    }

    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getOperatingPeriod() {
        return operatingPeriod;
    }

    public void setOperatingPeriod(String operatingPeriod) {
        this.operatingPeriod = operatingPeriod;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }
}
