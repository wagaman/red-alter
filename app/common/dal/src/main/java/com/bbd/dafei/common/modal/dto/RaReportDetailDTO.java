package com.bbd.dafei.common.modal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by tuanhong on 2017-04-21.
 */
@ApiModel(value = "用户研报下载详细情况")
public class RaReportDetailDTO {

    @ApiModelProperty(value = "详情ID")
    private Integer id;

    @ApiModelProperty(value = "用户")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "企业名称")
    private String company;

    @ApiModelProperty(value = "企业Id")
    private String companyId;

    @ApiModelProperty(value = "研报地址")
    private String reportUrl;

    @ApiModelProperty(value = "研报下载日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportDownloadTime;

    @ApiModelProperty(value = "研报生成日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportMakeTime;

    @ApiModelProperty(value = "研报状态")
    private String reportStatus;

    @ApiModelProperty(value = "上传文件类型")
    private String uploadFileType;

    @ApiModelProperty(value = "申请研报时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtUpdate;

    @ApiModelProperty(value = "研报剩余下载次数")
    private int remainingNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public Date getReportDownloadTime() {
        return reportDownloadTime;
    }

    public void setReportDownloadTime(Date reportDownloadTime) {
        this.reportDownloadTime = reportDownloadTime;
    }

    public Date getReportMakeTime() {
        return reportMakeTime;
    }

    public void setReportMakeTime(Date reportMakeTime) {
        this.reportMakeTime = reportMakeTime;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getUploadFileType() {
        return uploadFileType;
    }

    public void setUploadFileType(String uploadFileType) {
        this.uploadFileType = uploadFileType;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public int getRemainingNumber() {
        return remainingNumber;
    }

    public void setRemainingNumber(int remainingNumber) {
        this.remainingNumber = remainingNumber;
    }

}
