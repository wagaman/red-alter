package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "经营异常信息")
public class JyycDTO {
    @ApiModelProperty(value = "移出经营异常名录原因")
    @SerializedName("remove_busexcep_list")
    private String removeBusexcepList;
    @ApiModelProperty(value = "年报年度")
    @SerializedName("annual_report")
    private String annualReport;
    @ApiModelProperty(value = "公告类型")
    @SerializedName("notice_type")
    private String noticeType;
    @ApiModelProperty(value = "作出决定机关")
    @SerializedName("decision_org")
    private String decisionOrg;
    @ApiModelProperty(value = "注册号/统一社会信用代码")
    @SerializedName("regno_or_creditcode")
    private String regnoOrCreditcode;
    @ApiModelProperty(value = "列入经营异常名录原因")
    @SerializedName("busexcep_list")
    private String busexcepList;
    @ApiModelProperty(value = "标题")
    @SerializedName("title")
    private String title;
    @ApiModelProperty(value = "移出日期")
    @SerializedName("remove_date")
    private String removeDate;
    @ApiModelProperty(value = "列入日期")
    @SerializedName("rank_date")
    private String rankDate;
    @ApiModelProperty(value = "企业名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "数据源")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "状态")
    @SerializedName("status")
    private String status;
    @ApiModelProperty(value = "被列入经营异常名录日期")
    @SerializedName("rank_busexcep_date")
    private String rankBusexcepDate;
    @ApiModelProperty(value = "作出决定机关（移出）")
    @SerializedName("punish_orgout")
    private String punishOrgout;
    @ApiModelProperty(value = "作出决定机关（列入）")
    @SerializedName("punish_org")
    private String punishOrg;
    @ApiModelProperty(value = "决定文书号")
    @SerializedName("decide_docno")
    private String decideDocno;

    public String getRemoveBusexcepList() {
        return removeBusexcepList;
    }

    public void setRemoveBusexcepList(String removeBusexcepList) {
        this.removeBusexcepList = removeBusexcepList;
    }

    public String getAnnualReport() {
        return annualReport;
    }

    public void setAnnualReport(String annualReport) {
        this.annualReport = annualReport;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getDecisionOrg() {
        return decisionOrg;
    }

    public void setDecisionOrg(String decisionOrg) {
        this.decisionOrg = decisionOrg;
    }

    public String getRegnoOrCreditcode() {
        return regnoOrCreditcode;
    }

    public void setRegnoOrCreditcode(String regnoOrCreditcode) {
        this.regnoOrCreditcode = regnoOrCreditcode;
    }

    public String getBusexcepList() {
        return busexcepList;
    }

    public void setBusexcepList(String busexcepList) {
        this.busexcepList = busexcepList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRankBusexcepDate() {
        return rankBusexcepDate;
    }

    public void setRankBusexcepDate(String rankBusexcepDate) {
        this.rankBusexcepDate = rankBusexcepDate;
    }

    public String getPunishOrgout() {
        return punishOrgout;
    }

    public void setPunishOrgout(String punishOrgout) {
        this.punishOrgout = punishOrgout;
    }

    public String getPunishOrg() {
        return punishOrg;
    }

    public void setPunishOrg(String punishOrg) {
        this.punishOrg = punishOrg;
    }

    public String getDecideDocno() {
        return decideDocno;
    }

    public void setDecideDocno(String decideDocno) {
        this.decideDocno = decideDocno;
    }
}
