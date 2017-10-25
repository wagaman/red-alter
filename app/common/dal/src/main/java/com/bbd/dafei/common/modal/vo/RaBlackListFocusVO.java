package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tuanhong on 2017-04-20.
 */

@ApiModel(value = "列表数据",description = "用于黑名单或者关注企业")
public class RaBlackListFocusVO {

    @ApiModelProperty("ID")
    private Integer id;

    //序号
    private String numIndex;
    //企业名称
    @ApiModelProperty("企业名称")
    private String company;
    //易燃指数
    @ApiModelProperty("易燃指数")
    private double riskIndex;
    //风险等级
    @ApiModelProperty("风险等级")
    private String riskLevel;
    //所属行业
    @ApiModelProperty("所属行业")
    private String industry;
    //加入日期
    @ApiModelProperty("加入日期")
    private String joinDate;
    //加入原因
    @ApiModelProperty("加入原因")
    private String reasons;

    @ApiModelProperty("风险变化情况:1:上升,0:持平,-1:下降")
    private Integer rise;

    @ApiModelProperty("企业详细信息,数据变化情况")
    private String companyDetail;

    @ApiModelProperty("企业ID")
    private String companyId;

    @ApiModelProperty("状态:1已移除关注(或黑名单),0:正常关注(或黑名单)")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRise() {
        return rise;
    }

    public void setRise(Integer rise) {
        this.rise = rise;
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
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

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

}
