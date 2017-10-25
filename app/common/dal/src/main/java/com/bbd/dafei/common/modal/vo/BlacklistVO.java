package com.bbd.dafei.common.modal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author Ian.Su
 * @version $Id: BlacklistVO.java, v 0.1 2017/6/8 16:03 Ian.Su Exp $
 */
@ApiModel(value = "黑名单信息")
public class BlacklistVO {


    @ApiModelProperty(value = "黑名单id")
    private Integer id;

    @ApiModelProperty(value = "企业id")
    private String companyId;

    @ApiModelProperty(value = "企业名称")
    private String company;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "加入原因")
    private String joinReason;

    @ApiModelProperty(value = "加入来源")
    private String joinSrouce;

    @ApiModelProperty(value = "加入时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date joinDate;

    @ApiModelProperty(value = "移除原因")
    private String cancelReason;

    @ApiModelProperty(value = "移除时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date cancelDate;

    @ApiModelProperty(value = "入库时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtCreate;

    @ApiModelProperty(value = "黑名单状态:0:正常黑名单企业,1:已取消黑名单")
    private short status;

    @ApiModelProperty(value = "加入黑名单方式:0用户加入,1网络爬取,2后台导入,3后台用户加入")
    private short joinType;

    public short getJoinType() {
        return joinType;
    }

    public void setJoinType(short joinType) {
        this.joinType = joinType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getJoinReason() {
        return joinReason;
    }

    public void setJoinReason(String joinReason) {
        this.joinReason = joinReason;
    }

    public String getJoinSrouce() {
        return joinSrouce;
    }

    public void setJoinSrouce(String joinSrouce) {
        this.joinSrouce = joinSrouce;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
