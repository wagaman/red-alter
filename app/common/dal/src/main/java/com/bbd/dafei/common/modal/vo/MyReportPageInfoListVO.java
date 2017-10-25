package com.bbd.dafei.common.modal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * Created by tuanhong on 2017-04-24.
 */
@ApiModel("个人中心--我的报告")
public class MyReportPageInfoListVO {
    @ApiModelProperty("用户Id")
    private  int userId;
    @ApiModelProperty("企业ID")
    private String companyId;
    @ApiModelProperty("企业名称")
    private String company;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("区县")
    private String area;
    @ApiModelProperty("易燃指数")
    private String riskIndex;
    @ApiModelProperty("风险等级")
    private String riskLevel;
    @ApiModelProperty("易燃指数是否上升  1:上升，0：持平，-1：下降")
    private int rise=0;
    @ApiModelProperty("所属行业")
    private String industry;
    @ApiModelProperty("简报下载日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String downloadTime;
    @ApiModelProperty("研报申请日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String applyTime;
    @ApiModelProperty("研报申请状态")
    private String reportStatus;
    @ApiModelProperty("研报申请ID")
    private int reportId;

    @ApiModelProperty("是否黑名单")
    private boolean backList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(String riskIndex) {
        this.riskIndex = riskIndex;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getRise() {
        return rise;
    }

    public void setRise(int rise) {
        this.rise = rise;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(String downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public boolean isBackList() {
        return backList;
    }

    public void setBackList(boolean backList) {
        this.backList = backList;
    }
}
