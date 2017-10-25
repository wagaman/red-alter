package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "法院公告")
public class FyggDTO {
    @ApiModelProperty(value = "公告人")
    @SerializedName("notice_people")
    private String noticePeople;
    @ApiModelProperty(value = "公告类型")
    @SerializedName("notice_type")
    private String noticeType;
    @ApiModelProperty(value = "公告内容")
    @SerializedName("notice_content")
    private String noticeContent;
    @ApiModelProperty(value = "数据源")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "当事人")
    @SerializedName("litigant")
    private String litigant;
    @ApiModelProperty(value = "公告时间")
    @SerializedName("notice_time")
    private String noticeTime;
    @ApiModelProperty(value = "附件")
    @SerializedName("attachment")
    private String attachment;

    public String getNoticePeople() {
        return noticePeople;
    }

    public void setNoticePeople(String noticePeople) {
        this.noticePeople = noticePeople;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
