package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017-04-19.
 */
@ApiModel("企业VO")
public class RaIndexCompanyVO {
    //序号
    private String numIndex;



    @ApiModelProperty("企业ID")
    private String id;

    @ApiModelProperty("企业名称")
    private String company;

    @ApiModelProperty("易燃指数")
    private double riskIndex;

    @ApiModelProperty("风险级别")
    private String riskLevel;

    @ApiModelProperty("进入日期")
    private String joinDate;

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("是否为新加入：0 否，1 是")
    private Short isNew;


    @ApiModelProperty("易燃指数是否上升；1:上升，0：持平，-1：下降")
    private Short rise;

    @ApiModelProperty("注册地区（市+区县）")
    private String registerArea;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getRise() {
        return rise;
    }

    public void setRise(Short rise) {
        this.rise = rise;
    }

    public Short getIsNew() {
        return isNew;
    }

    public void setIsNew(Short isNew) {
        this.isNew = isNew;
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

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
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
}
