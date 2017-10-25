package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 变更信息DTO
 * Created by wish on 2017/4/19.
 */
@ApiModel(value = "变更信息")
public class BgxxDTO {
    @ApiModelProperty(value = "公司名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "变更事项")
    @SerializedName("change_items")
    private String changeItems;
    @ApiModelProperty(value = "变更前内容")
    @SerializedName("content_before_change")
    private String contentBeforeChange;
    @ApiModelProperty(value = "变更后内容")
    @SerializedName("content_after_change")
    private String contentAfterChange;
    @ApiModelProperty(value = "变更日期")
    @SerializedName("change_date")
    private String changeDate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getChangeItems() {
        return changeItems;
    }

    public void setChangeItems(String changeItems) {
        this.changeItems = changeItems;
    }

    public String getContentBeforeChange() {
        return contentBeforeChange;
    }

    public void setContentBeforeChange(String contentBeforeChange) {
        this.contentBeforeChange = contentBeforeChange;
    }

    public String getContentAfterChange() {
        return contentAfterChange;
    }

    public void setContentAfterChange(String contentAfterChange) {
        this.contentAfterChange = contentAfterChange;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
}
