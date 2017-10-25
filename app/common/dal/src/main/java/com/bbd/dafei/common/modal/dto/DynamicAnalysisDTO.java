package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wish on 2017/5/14.
 */
public class DynamicAnalysisDTO {
    @SerializedName("平均预期收益率")
    private String avgReturn;
    @SerializedName("预期投资期限")
    private String expectInvestTerm;
    @SerializedName("借款人数")
    private String numOfBorrower;
    @SerializedName("日待还余额（万元）")
    private String lastDailyPending;
    @SerializedName("成交量（万元）")
    private String dealVolume;
    @SerializedName("投资人数")
    private String numOfLender;
    @SerializedName("日资金净流入（万元）")
    private String lastFundNetInflow;

    public String getAvgReturn() {
        return avgReturn;
    }

    public void setAvgReturn(String avgReturn) {
        this.avgReturn = avgReturn;
    }

    public String getExpectInvestTerm() {
        return expectInvestTerm;
    }

    public void setExpectInvestTerm(String expectInvestTerm) {
        this.expectInvestTerm = expectInvestTerm;
    }

    public String getNumOfBorrower() {
        return numOfBorrower;
    }

    public void setNumOfBorrower(String numOfBorrower) {
        this.numOfBorrower = numOfBorrower;
    }

    public String getLastDailyPending() {
        return lastDailyPending;
    }

    public void setLastDailyPending(String lastDailyPending) {
        this.lastDailyPending = lastDailyPending;
    }

    public String getDealVolume() {
        return dealVolume;
    }

    public void setDealVolume(String dealVolume) {
        this.dealVolume = dealVolume;
    }

    public String getNumOfLender() {
        return numOfLender;
    }

    public void setNumOfLender(String numOfLender) {
        this.numOfLender = numOfLender;
    }

    public String getLastFundNetInflow() {
        return lastFundNetInflow;
    }

    public void setLastFundNetInflow(String lastFundNetInflow) {
        this.lastFundNetInflow = lastFundNetInflow;
    }
}
