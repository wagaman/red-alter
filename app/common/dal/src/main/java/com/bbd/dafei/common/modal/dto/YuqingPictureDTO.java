package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 舆情图片
 * Created by wish on 2017/8/20.
 */
@ApiModel("舆情图片")
public class YuqingPictureDTO {
    @ApiModelProperty(value = "正文图片rowkey")
    @SerializedName("pic_rowkey")
    private String picRowkey;
    @ApiModelProperty(value = "正文图片")
    @SerializedName("picture")
    private String picture;
    @ApiModelProperty(value = "图片链接地址")
    @SerializedName("img_url")
    private String imgUrl;

    public String getPicRowkey() {
        return picRowkey;
    }

    public void setPicRowkey(String picRowkey) {
        this.picRowkey = picRowkey;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
