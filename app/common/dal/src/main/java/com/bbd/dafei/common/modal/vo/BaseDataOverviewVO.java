package com.bbd.dafei.common.modal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by wish on 2017/4/23.
 */
@ApiModel(value = "基本信息概览")
public class BaseDataOverviewVO {
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;
    @ApiModelProperty(value = "注册号")
    private String regno;
    @ApiModelProperty(value = "名称")
    private String companyName;
    @ApiModelProperty(value = "企业类型")
    private String companyType;
    @ApiModelProperty(value = "企业唯一ID")
    private String bbdQyxxId;
    @ApiModelProperty(value = "法定代表人")
    private String frname;
    @ApiModelProperty(value = "注册资金")
    private String regcap;
    @ApiModelProperty(value = "实收资本")
    private String realcap;
    @ApiModelProperty(value = "成立日期")
    private String esdate;
    @ApiModelProperty(value = "核准日期")
    private String approvalDate;
    @ApiModelProperty(value = "营业期限自")
    private String openfrom;
    @ApiModelProperty(value = "营业期限至")
    private String opento;
    @ApiModelProperty(value = "省份_映射结果")
    private String companyProvince;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "经营范围")
    private String operateScope;
    @ApiModelProperty(value = "登记机关")
    private String regorg;
    @ApiModelProperty(value = "登记状态_映射结果")
    private String companyEnterpriseStatus;
    @ApiModelProperty(value = "吊销日期")
    private String revokeDate;
    @ApiModelProperty(value = "派出企业名称")
    private String parentFirm;
    @ApiModelProperty(value = "出资额")
    private String investCap;
    @ApiModelProperty(value = "注册币种")
    private String regcapcur;
    @ApiModelProperty(value = "注册资本_金额")
    private String regcapAmount;
    @ApiModelProperty(value = "注册资本_币种")
    private String regcapCurrency;
    @ApiModelProperty(value = "注销日期")
    private String cancelDate;
    @ApiModelProperty(value = "组成形式")
    private String form;
    @ApiModelProperty(value = "经营期限")
    private String operatingPeriod;
    @ApiModelProperty(value = "行业")
    private String companyIndustry;
    @ApiModelProperty(value = "所属行业")
    private String industry;
    @ApiModelProperty(value = "易燃指数")
    private Float riskIndex;
    @ApiModelProperty(value = "风险等级")
    private String riskLevel;
    @ApiModelProperty(value = "企业关注数量")
    private int focusNum;
    @ApiModelProperty(value = "易燃指数是否上升；1:上升，0：持平，-1：下降")
    private Integer rise;
    @ApiModelProperty(value = "是否拉黑")
    private boolean black;
    @ApiModelProperty(value = "拉黑id")
    private Integer blackId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "拉黑时间")
    private Date addBlackDate;
    @ApiModelProperty(value = "拉黑原因")
    private List<String> blackReasons;
    @ApiModelProperty(value = "用户是否关注")
    private boolean userFocus;
    @ApiModelProperty(value = "用户对该公司的关注id")
    private Integer focusId;
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "电话")
    private String tel;
    @ApiModelProperty(value = "研报状态(未申请，生成中，未下载，已下载)")
    private String reportStatus;

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

    public String getBbdQyxxId() {
        return bbdQyxxId;
    }

    public void setBbdQyxxId(String bbdQyxxId) {
        this.bbdQyxxId = bbdQyxxId;
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

    public String getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
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

    public String getCompanyEnterpriseStatus() {
        return companyEnterpriseStatus;
    }

    public void setCompanyEnterpriseStatus(String companyEnterpriseStatus) {
        this.companyEnterpriseStatus = companyEnterpriseStatus;
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

    public String getRegcapAmount() {
        return regcapAmount;
    }

    public void setRegcapAmount(String regcapAmount) {
        this.regcapAmount = regcapAmount;
    }

    public String getRegcapCurrency() {
        return regcapCurrency;
    }

    public void setRegcapCurrency(String regcapCurrency) {
        this.regcapCurrency = regcapCurrency;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Float getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(Float riskIndex) {
        this.riskIndex = riskIndex;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(int focusNum) {
        this.focusNum = focusNum;
    }

    public Integer getRise() {
        return rise;
    }

    public void setRise(Integer rise) {
        this.rise = rise;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public Integer getBlackId() {
        return blackId;
    }

    public void setBlackId(Integer blackId) {
        this.blackId = blackId;
    }

    public Date getAddBlackDate() {
        return addBlackDate;
    }

    public void setAddBlackDate(Date addBlackDate) {
        this.addBlackDate = addBlackDate;
    }

    public List<String> getBlackReasons() {
        return blackReasons;
    }

    public void setBlackReasons(List<String> blackReasons) {
        this.blackReasons = blackReasons;
    }

    public boolean isUserFocus() {
        return userFocus;
    }

    public void setUserFocus(boolean userFocus) {
        this.userFocus = userFocus;
    }

    public Integer getFocusId() {
        return focusId;
    }

    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
}
