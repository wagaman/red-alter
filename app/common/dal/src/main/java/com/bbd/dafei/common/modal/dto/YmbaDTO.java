package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * 域名备案DTO
 * Created by wish on 2017/4/19.
 */
public class YmbaDTO {
    @ApiModelProperty(value = "数据源")
    @SerializedName("bbd_source")
    private String bbdSource;
    @ApiModelProperty(value = "区分表类型")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "网站备案/许可证号")
    @SerializedName("site_certificate_no")
    private String siteCertificateNo;
    @ApiModelProperty(value = "网站域名")
    @SerializedName("domain_name")
    private String domainName;
    @ApiModelProperty(value = "主办单位名称")
    @SerializedName("organizer_name")
    private String organizerName;
    @ApiModelProperty(value = "网站首页网址")
    @SerializedName("homepage_url")
    private String homepageUrl;
    @ApiModelProperty(value = "网站名称")
    @SerializedName("website_name")
    private String websiteName;
    @ApiModelProperty(value = "网站负责人姓名")
    @SerializedName("chief_website_name")
    private String chiefWebsiteName;
    @ApiModelProperty(value = "审核通过时间")
    @SerializedName("approval_time")
    private String approvalTime;
    @ApiModelProperty(value = "备案/许可证号")
    @SerializedName("record_license")
    private String recordLicense;
    @ApiModelProperty(value = "网站前置审批项")
    @SerializedName("website_exam_item")
    private String websiteExamItem;
    @ApiModelProperty(value = "主办单位性质")
    @SerializedName("organizer_nature")
    private String organizerNature;

    public String getBbdSource() {
        return bbdSource;
    }

    public void setBbdSource(String bbdSource) {
        this.bbdSource = bbdSource;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getSiteCertificateNo() {
        return siteCertificateNo;
    }

    public void setSiteCertificateNo(String siteCertificateNo) {
        this.siteCertificateNo = siteCertificateNo;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getChiefWebsiteName() {
        return chiefWebsiteName;
    }

    public void setChiefWebsiteName(String chiefWebsiteName) {
        this.chiefWebsiteName = chiefWebsiteName;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getRecordLicense() {
        return recordLicense;
    }

    public void setRecordLicense(String recordLicense) {
        this.recordLicense = recordLicense;
    }

    public String getWebsiteExamItem() {
        return websiteExamItem;
    }

    public void setWebsiteExamItem(String websiteExamItem) {
        this.websiteExamItem = websiteExamItem;
    }

    public String getOrganizerNature() {
        return organizerNature;
    }

    public void setOrganizerNature(String organizerNature) {
        this.organizerNature = organizerNature;
    }
}
