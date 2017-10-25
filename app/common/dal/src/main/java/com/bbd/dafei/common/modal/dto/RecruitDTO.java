package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "招聘数据信息")
public class RecruitDTO {
    @ApiModelProperty(value = "公司名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "job_title")
    @SerializedName("job_title")
    private String jobTitle;
    @ApiModelProperty(value = "工作地点")
    @SerializedName("location")
    private String location;
    @ApiModelProperty(value = "招聘人数")
    @SerializedName("recruit_numbers")
    private String recruitNumbers;
    @ApiModelProperty(value = "发布时间")
    @SerializedName("pubdate")
    private String pubdate;
    @ApiModelProperty(value = "数据表")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "职位描述")
    @SerializedName("job_descriptions")
    private String jobDescriptions;
    @ApiModelProperty(value = "福利待遇")
    @SerializedName("benefits")
    private String benefits;
    @ApiModelProperty(value = "职位薪资")
    @SerializedName("salary")
    private String salary;
    @ApiModelProperty(value = "工作年限")
    @SerializedName("service_year")
    private String serviceYear;
    @ApiModelProperty(value = "公司网址")
    @SerializedName("website_address")
    private String websiteAddress;
    @ApiModelProperty(value = "招聘会地点")
    @SerializedName("jobfair_location")
    private String jobfairLocation;
    @ApiModelProperty(value = "招聘会时间")
    @SerializedName("jobfair_time")
    private String jobfairTime;
    @ApiModelProperty(value = "语言要求")
    @SerializedName("language_required")
    private String languageRequired;
    @ApiModelProperty(value = "工作性质")
    @SerializedName("job_nature")
    private String jobNature;
    @ApiModelProperty(value = "职位职能")
    @SerializedName("job_functions")
    private String jobFunctions;
    @ApiModelProperty(value = "学历要求")
    @SerializedName("education_required")
    private String educationRequired;
    @ApiModelProperty(value = "企业规模")
    @SerializedName("enscale")
    private String enscale;
    @ApiModelProperty(value = "年龄要求")
    @SerializedName("agerequired")
    private String agerequired;
    @ApiModelProperty(value = "邮编")
    @SerializedName("postcode")
    private String postcode;
    @ApiModelProperty(value = "邮箱")
    @SerializedName("e_mail")
    private String eMail;
    @ApiModelProperty(value = "联系人及联系方式")
    @SerializedName("contact_information")
    private String contactInformation;
    @ApiModelProperty(value = "公司简介")
    @SerializedName("company_introduction")
    private String companyIntroduction;
    @ApiModelProperty(value = "所属行业")
    @SerializedName("industry")
    private String industry;
    @ApiModelProperty(value = "企业性质")
    @SerializedName("company_nature")
    private String companyNature;
    @ApiModelProperty(value = "专业要求")
    @SerializedName("majors_required")
    private String majorsRequired;
    @ApiModelProperty(value = "所属部门")
    @SerializedName("department")
    private String department;
    @ApiModelProperty(value = "下属人数")
    @SerializedName("underling_numbers")
    private String underlingNumbers;
    @ApiModelProperty(value = "查看率")
    @SerializedName("view_rate")
    private String viewRate;
    @ApiModelProperty(value = "性别要求")
    @SerializedName("sex_required")
    private String sexRequired;
    @ApiModelProperty(value = "bbd招聘人数")
    @SerializedName("bbd_recruit_num")
    private Integer bbdRecruitNum;
    @ApiModelProperty(value = "bbd行业划分")
    @SerializedName("bbd_industry")
    private String bbdIndustry;
    @ApiModelProperty(value = "反馈率")
    @SerializedName("responserate")
    private String responserate;
    @ApiModelProperty(value = "bbd职位薪资")
    @SerializedName("bbd_salary")
    private String bbdSalary;
    @ApiModelProperty(value = "薪资体系")
    @SerializedName("salary_system")
    private String salarySystem;
    @ApiModelProperty(value = "汇报对象")
    @SerializedName("reportto")
    private String reportto;
    @ApiModelProperty(value = "有效日期")
    @SerializedName("validdate")
    private String validdate;
    @ApiModelProperty(value = "简历投递时间")
    @SerializedName("delivery_time")
    private String deliveryTime;
    @ApiModelProperty(value = "招聘页面内容")
    @SerializedName("page_content")
    private String pageContent;
    @ApiModelProperty(value = "source")
    @SerializedName("source")
    private String source;
    @ApiModelProperty(value = "发布时间(排重)")
    @SerializedName("pubdate_doublet")
    private String pubdateDoublet;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRecruitNumbers() {
        return recruitNumbers;
    }

    public void setRecruitNumbers(String recruitNumbers) {
        this.recruitNumbers = recruitNumbers;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getJobDescriptions() {
        return jobDescriptions;
    }

    public void setJobDescriptions(String jobDescriptions) {
        this.jobDescriptions = jobDescriptions;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(String serviceYear) {
        this.serviceYear = serviceYear;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    public String getJobfairLocation() {
        return jobfairLocation;
    }

    public void setJobfairLocation(String jobfairLocation) {
        this.jobfairLocation = jobfairLocation;
    }

    public String getJobfairTime() {
        return jobfairTime;
    }

    public void setJobfairTime(String jobfairTime) {
        this.jobfairTime = jobfairTime;
    }

    public String getLanguageRequired() {
        return languageRequired;
    }

    public void setLanguageRequired(String languageRequired) {
        this.languageRequired = languageRequired;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    public String getJobFunctions() {
        return jobFunctions;
    }

    public void setJobFunctions(String jobFunctions) {
        this.jobFunctions = jobFunctions;
    }

    public String getEducationRequired() {
        return educationRequired;
    }

    public void setEducationRequired(String educationRequired) {
        this.educationRequired = educationRequired;
    }

    public String getEnscale() {
        return enscale;
    }

    public void setEnscale(String enscale) {
        this.enscale = enscale;
    }

    public String getAgerequired() {
        return agerequired;
    }

    public void setAgerequired(String agerequired) {
        this.agerequired = agerequired;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getCompanyIntroduction() {
        return companyIntroduction;
    }

    public void setCompanyIntroduction(String companyIntroduction) {
        this.companyIntroduction = companyIntroduction;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getMajorsRequired() {
        return majorsRequired;
    }

    public void setMajorsRequired(String majorsRequired) {
        this.majorsRequired = majorsRequired;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUnderlingNumbers() {
        return underlingNumbers;
    }

    public void setUnderlingNumbers(String underlingNumbers) {
        this.underlingNumbers = underlingNumbers;
    }

    public String getViewRate() {
        return viewRate;
    }

    public void setViewRate(String viewRate) {
        this.viewRate = viewRate;
    }

    public String getSexRequired() {
        return sexRequired;
    }

    public void setSexRequired(String sexRequired) {
        this.sexRequired = sexRequired;
    }

    public Integer getBbdRecruitNum() {
        return bbdRecruitNum;
    }

    public void setBbdRecruitNum(Integer bbdRecruitNum) {
        this.bbdRecruitNum = bbdRecruitNum;
    }

    public String getBbdIndustry() {
        return bbdIndustry;
    }

    public void setBbdIndustry(String bbdIndustry) {
        this.bbdIndustry = bbdIndustry;
    }

    public String getResponserate() {
        return responserate;
    }

    public void setResponserate(String responserate) {
        this.responserate = responserate;
    }

    public String getBbdSalary() {
        return bbdSalary;
    }

    public void setBbdSalary(String bbdSalary) {
        this.bbdSalary = bbdSalary;
    }

    public String getSalarySystem() {
        return salarySystem;
    }

    public void setSalarySystem(String salarySystem) {
        this.salarySystem = salarySystem;
    }

    public String getReportto() {
        return reportto;
    }

    public void setReportto(String reportto) {
        this.reportto = reportto;
    }

    public String getValiddate() {
        return validdate;
    }

    public void setValiddate(String validdate) {
        this.validdate = validdate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPubdateDoublet() {
        return pubdateDoublet;
    }

    public void setPubdateDoublet(String pubdateDoublet) {
        this.pubdateDoublet = pubdateDoublet;
    }
}
