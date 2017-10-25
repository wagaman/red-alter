package com.bbd.dafei.common.modal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by wish on 2017/4/26.
 */
@ApiModel(value = "拉黑、关注、备注信息")
public class RaBlackListFocusDTO {
    @ApiModelProperty(value = "id ")
    private Integer id;
    @ApiModelProperty(value = "操作用户")
    private String userName;
    @ApiModelProperty(value = "企业id")
    private String companyId;
    @ApiModelProperty(value = "公司名")
    private String companyName;
    @ApiModelProperty(value = "类型；1:黑名单，2：关注，3：备注")
    private Integer type;
    @ApiModelProperty(value = "事由；如：“已立案/已查处")
    private String reasons;
    @ApiModelProperty(value = "备注；保存备注等信息")
    private String mark;
    @ApiModelProperty(value = "是否已查看风险变动;0:否，1：是，默认0")
    private Integer lookOver;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getLookOver() {
        return lookOver;
    }

    public void setLookOver(Integer lookOver) {
        this.lookOver = lookOver;
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
}
