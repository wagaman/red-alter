package com.bbd.dafei.common.modal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by wish on 2017/7/7.
 */
@ApiModel("黑名单核实")
public class BlacklistVerifyVO {
    @ApiModelProperty("企业id")
    private String companyId;
    @ApiModelProperty("企业名")
    private String companyName;
    @ApiModelProperty("行业")
    private String industry;
    @ApiModelProperty("省")
    private String province;
    @ApiModelProperty("计算版本")
    private String dataVersion;
    @ApiModelProperty("类型：1新增黑名单，2已移除->本次为黑，3已加入->本次为灰")
    private String type;
    @ApiModelProperty("类型名称")
    private String typeName;
    @ApiModelProperty("黑名单Id")
    private Integer blackId;
    @ApiModelProperty("入库时间")
    private String blackCreateDate;
    @ApiModelProperty("加入来源")
    private String addSource;
    @ApiModelProperty("加入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinDate;
    @ApiModelProperty("加入原因")
    private String joinReason;
    @ApiModelProperty("移出时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cancelDate;
    @ApiModelProperty("移出原因")
    private String cancelReason;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getBlackId() {
        return blackId;
    }

    public void setBlackId(Integer blackId) {
        this.blackId = blackId;
    }

    public String getBlackCreateDate() {
        return blackCreateDate;
    }

    public void setBlackCreateDate(String blackCreateDate) {
        this.blackCreateDate = blackCreateDate;
    }

    public String getAddSource() {
        return addSource;
    }

    public void setAddSource(String addSource) {
        this.addSource = addSource;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getJoinReason() {
        return joinReason;
    }

    public void setJoinReason(String joinReason) {
        this.joinReason = joinReason;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
