package com.bbd.dafei.common.modal.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-08-10.
 */
public class ApiFinancialRelateVO {
    @SerializedName("black")
    @ApiModelProperty("黑名单")
    private Map<String,ApiFinancialRelateDetailVO> black;
    @SerializedName("common_address")
    @ApiModelProperty("地址相同")
    private Map<String,ApiFinancialRelateDetailVO>  commonAddress;
    @SerializedName("common_interests")
    @ApiModelProperty("利益一致")
    private Map<String,ApiFinancialRelateDetailVO>  commonInterests;
    @SerializedName("estate")
    @ApiModelProperty("注吊销")
    private Map<String,ApiFinancialRelateDetailVO> estate;
    @SerializedName("high_risk")
    @ApiModelProperty("高风险")
    private Map<String,ApiFinancialRelateDetailVO> highRisk;
    @SerializedName("new_finance")
    @ApiModelProperty("新金融")
    private Map<String,ApiFinancialRelateDetailVO> newFinance;
    @SerializedName("total")
    @ApiModelProperty("全部")
    private Map<String,ApiFinancialRelateDetailVO> total;

    public Map<String, ApiFinancialRelateDetailVO> getBlack() {
        return black;
    }

    public void setBlack(Map<String, ApiFinancialRelateDetailVO> black) {
        this.black = black;
    }

    public Map<String, ApiFinancialRelateDetailVO> getCommonAddress() {
        return commonAddress;
    }

    public void setCommonAddress(Map<String, ApiFinancialRelateDetailVO> commonAddress) {
        this.commonAddress = commonAddress;
    }

    public Map<String, ApiFinancialRelateDetailVO> getCommonInterests() {
        return commonInterests;
    }

    public void setCommonInterests(Map<String, ApiFinancialRelateDetailVO> commonInterests) {
        this.commonInterests = commonInterests;
    }

    public Map<String, ApiFinancialRelateDetailVO> getEstate() {
        return estate;
    }

    public void setEstate(Map<String, ApiFinancialRelateDetailVO> estate) {
        this.estate = estate;
    }

    public Map<String, ApiFinancialRelateDetailVO> getHighRisk() {
        return highRisk;
    }

    public void setHighRisk(Map<String, ApiFinancialRelateDetailVO> highRisk) {
        this.highRisk = highRisk;
    }

    public Map<String, ApiFinancialRelateDetailVO> getNewFinance() {
        return newFinance;
    }

    public void setNewFinance(Map<String, ApiFinancialRelateDetailVO> newFinance) {
        this.newFinance = newFinance;
    }

    public Map<String, ApiFinancialRelateDetailVO> getTotal() {
        return total;
    }

    public void setTotal(Map<String, ApiFinancialRelateDetailVO> total) {
        this.total = total;
    }
}
