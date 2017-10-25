package com.bbd.dafei.common.modal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 反馈信息
 *
 * @author Ian.Su
 * @version $Id: FeedbackVO.java, v 0.1 2017/5/27 9:30 Ian.Su Exp $
 */
@ApiModel(value = "反馈信息")
public class FeedbackVO {

    @ApiModelProperty(value = "企业名")
    private String company;

    @ApiModelProperty(value = "类别")
    private String type;

    @ApiModelProperty(value = "加入/信息反馈日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "GMT+8")
    private Date gmtCreate;

    @ApiModelProperty(value = "加入原因/填入内容")
    private String joinContent;

    @ApiModelProperty(value = "取消日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "GMT+8")
    private Date cancelDate;

    @ApiModelProperty(value = "取消原因")
    private String cancelReason;

    @ApiModelProperty(value = "操作用户")
    private String user;

    @JsonIgnore
    private Date otime;

    @JsonIgnore
    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getJoinContent() {
        return joinContent;
    }

    public void setJoinContent(String joinContent) {
        this.joinContent = joinContent;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
