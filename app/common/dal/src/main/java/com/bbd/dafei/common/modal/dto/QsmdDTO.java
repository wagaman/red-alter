package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "企业欠税")
public class QsmdDTO {
    @ApiModelProperty(value = "欠税人名称")
    @SerializedName("defaulteroftax_name")
    private String defaulteroftaxName;
    @ApiModelProperty(value = "纳税人识别号")
    @SerializedName("taxpayer_id")
    private String taxpayerId;
    @ApiModelProperty(value = "法定代表人")
    @SerializedName("frname")
    private String frname;
    @ApiModelProperty(value = "法人代表证件号码")
    @SerializedName("frname_idno")
    private String frnameIdno;
    @ApiModelProperty(value = "生产经营地址")
    @SerializedName("line_operation_address")
    private String lineOperationAddress;
    @ApiModelProperty(value = "主管税务机关")
    @SerializedName("tax_authorities")
    private String taxAuthorities;
    @ApiModelProperty(value = "当前状态")
    @SerializedName("current_state")
    private String currentState;
    @ApiModelProperty(value = "欠税税种")
    @SerializedName("taxes_category")
    private String taxesCategory;
    @ApiModelProperty(value = "欠税金额（元）")
    @SerializedName("taxes_amount")
    private String taxesAmount;
    @ApiModelProperty(value = "欠税余额")
    @SerializedName("taxes_residual")
    private String taxesResidual;
    @ApiModelProperty(value = "当前新时间发生的欠税金额（元）")
    @SerializedName("newtime_taxes_amount")
    private String newtimeTaxesAmount;
    @ApiModelProperty(value = "欠税时间起")
    @SerializedName("taxes_time_start")
    private String taxesTimeStart;
    @ApiModelProperty(value = "欠税时间止")
    @SerializedName("taxes_time_end")
    private String taxesTimeEnd;
    @ApiModelProperty(value = "欠税时间")
    @SerializedName("taxes_time")
    private String taxesTime;
    @ApiModelProperty(value = "省份")
    @SerializedName("type")
    private String type;
    @ApiModelProperty(value = "抓取时间")
    @SerializedName("bbd_dotime")
    private String bbdDotime;

    public String getDefaulteroftaxName() {
        return defaulteroftaxName;
    }

    public void setDefaulteroftaxName(String defaulteroftaxName) {
        this.defaulteroftaxName = defaulteroftaxName;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getFrnameIdno() {
        return frnameIdno;
    }

    public void setFrnameIdno(String frnameIdno) {
        this.frnameIdno = frnameIdno;
    }

    public String getLineOperationAddress() {
        return lineOperationAddress;
    }

    public void setLineOperationAddress(String lineOperationAddress) {
        this.lineOperationAddress = lineOperationAddress;
    }

    public String getTaxAuthorities() {
        return taxAuthorities;
    }

    public void setTaxAuthorities(String taxAuthorities) {
        this.taxAuthorities = taxAuthorities;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getTaxesCategory() {
        return taxesCategory;
    }

    public void setTaxesCategory(String taxesCategory) {
        this.taxesCategory = taxesCategory;
    }

    public String getTaxesAmount() {
        return taxesAmount;
    }

    public void setTaxesAmount(String taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    public String getTaxesResidual() {
        return taxesResidual;
    }

    public void setTaxesResidual(String taxesResidual) {
        this.taxesResidual = taxesResidual;
    }

    public String getNewtimeTaxesAmount() {
        return newtimeTaxesAmount;
    }

    public void setNewtimeTaxesAmount(String newtimeTaxesAmount) {
        this.newtimeTaxesAmount = newtimeTaxesAmount;
    }

    public String getTaxesTimeStart() {
        return taxesTimeStart;
    }

    public void setTaxesTimeStart(String taxesTimeStart) {
        this.taxesTimeStart = taxesTimeStart;
    }

    public String getTaxesTimeEnd() {
        return taxesTimeEnd;
    }

    public void setTaxesTimeEnd(String taxesTimeEnd) {
        this.taxesTimeEnd = taxesTimeEnd;
    }

    public String getTaxesTime() {
        return taxesTime;
    }

    public void setTaxesTime(String taxesTime) {
        this.taxesTime = taxesTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBbdDotime() {
        return bbdDotime;
    }

    public void setBbdDotime(String bbdDotime) {
        this.bbdDotime = bbdDotime;
    }
}
