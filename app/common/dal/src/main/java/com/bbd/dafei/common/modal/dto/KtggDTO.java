package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 开庭公告
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "开庭公告")
public class KtggDTO {
    @ApiModelProperty(value = "main")
    @SerializedName("main")
    private String main;
    @ApiModelProperty(value = "city")
    @SerializedName("city")
    private String city;
    @ApiModelProperty(value = "案由")
    @SerializedName("action_cause")
    private String actionCause;
    @ApiModelProperty(value = "当事人")
    @SerializedName("litigant")
    private String litigant;
    @ApiModelProperty(value = "案号")
    @SerializedName("case_code")
    private String caseCode;
    @ApiModelProperty(value = "开庭日期")
    @SerializedName("trial_date")
    private String trialDate;
    @ApiModelProperty(value = "title")
    @SerializedName("title")
    private String title;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getTrialDate() {
        return trialDate;
    }

    public void setTrialDate(String trialDate) {
        this.trialDate = trialDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
