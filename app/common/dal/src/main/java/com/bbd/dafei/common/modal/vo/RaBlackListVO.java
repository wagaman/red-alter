package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tuanhong on 2017-04-20.
 */
@ApiModel("黑名单")
public class RaBlackListVO {

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("序号")
    private String numIndex;

    @ApiModelProperty("企业ID")
    private String companyId;

    @ApiModelProperty("企业名称")
    private String company;

    @ApiModelProperty("易燃指数")
    private double riskIndex;

    @ApiModelProperty("风险等级")
    private String riskLevel;

    @ApiModelProperty("易燃指数是否上升；1:上升，0：持平，-1：下降")
    private int rise = 0;

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("注册地区（市+区县）")
    private String registerArea;

    @ApiModelProperty("加入日期")
    private String joinDate;

    @ApiModelProperty("加入原因")
    private String joinReason;

    @ApiModelProperty("取消原因")
    private String cancelReason;

    @ApiModelProperty("加入/取消原因")
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @ApiModelProperty("状态[ 0:正常黑名单,1:已被取消黑名单 ]")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getJoinReason() {
        return joinReason;
    }

    public void setJoinReason(String joinReason) {
        this.joinReason = joinReason;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public int getRise() {
        return rise;
    }

    public void setRise(int rise) {
        this.rise = rise;
    }

    public String getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(String numIndex) {
        this.numIndex = numIndex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(double riskIndex) {
        this.riskIndex = riskIndex;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRegisterArea() {
        return registerArea;
    }

    public void setRegisterArea(String registerArea) {
        this.registerArea = registerArea;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
