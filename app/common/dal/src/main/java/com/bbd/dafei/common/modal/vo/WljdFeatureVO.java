package com.bbd.dafei.common.modal.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/5/4.
 */
@ApiModel(value = "特征信息")
public class WljdFeatureVO {
    @ApiModelProperty(value = "平台名称")
    private String platformName;

    @ApiModelProperty(value = "是否异常")
    private boolean problem;

    @ApiModelProperty(value = "异常时间")
    private String problemTime;

    @ApiModelProperty(value = "异常原因")
    private String problemReason;

    @ApiModelProperty(value = "上线时间")
    private String onlinetime;

    @ApiModelProperty(value = "平均收益")
    @SerializedName("avg_return")
    private String avgReturn;

    @ApiModelProperty(value = "总成交额（万）")
    private String totalTurnover;

    @ApiModelProperty(value = "银行存管")
    private String bankCustody;

    @ApiModelProperty(value = "投资期限")
    private String investTerm;

    @ApiModelProperty(value = "平均借款期限（天）")
    private String avgLendTime;

    @ApiModelProperty(value = "自动投标")
    private String automaticBidding;

    @ApiModelProperty(value = "成交量")
    private String dealVolume;

    @ApiModelProperty(value = "平均满标时间（小时）")
    private String avgSoldoutTime;

    @ApiModelProperty(value = "债权转让")
    private String claimTransfer;

    @ApiModelProperty(value = "投资人数")
    private String numOfLender;

    @ApiModelProperty(value = "人均借款金额（万）")
    private String perBorrowingAmount;

    @ApiModelProperty(value = "投标保障")
    private String bidGuarantee;

    @ApiModelProperty(value = "借款人数")
    private String numOfBorrower;

    @ApiModelProperty(value = "人均投资金额（万）")
    private String perLendingAmount;

    @ApiModelProperty(value = "保障模式")
    private String guaranteeMode;

    @ApiModelProperty(value = "最新日资金净流入")
    private String lastFundNetInflow;

    @ApiModelProperty(value = "人均借款次数（次）")
    private String perBorrowingNum;

    @ApiModelProperty(value = "风险准备金存管")
    private String riskReserve;

    @ApiModelProperty(value = "最新日待还金额")
    private String lastDailyPending;

    @ApiModelProperty(value = "人均投资次数（次）")
    private String perLendingNum;

    @ApiModelProperty(value = "融资记录")
    private String financingRecord;

    @ApiModelProperty(value = "监管协会")
    private String superviseAssociation;

    @ApiModelProperty(value = "担保机构")
    private String guaranteeInstitution;

    @ApiModelProperty(value = "是否严重问题平台")
    private boolean serious;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public boolean isProblem() {
        return problem;
    }

    public void setProblem(boolean problem) {
        this.problem = problem;
    }

    public String getProblemTime() {
        return problemTime;
    }

    public void setProblemTime(String problemTime) {
        this.problemTime = problemTime;
    }

    public String getProblemReason() {
        return problemReason;
    }

    public void setProblemReason(String problemReason) {
        this.problemReason = problemReason;
    }

    public String getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(String onlinetime) {
        this.onlinetime = onlinetime;
    }

    public String getAvgReturn() {
        return avgReturn;
    }

    public void setAvgReturn(String avgReturn) {
        this.avgReturn = avgReturn;
    }

    public String getTotalTurnover() {
        return totalTurnover;
    }

    public void setTotalTurnover(String totalTurnover) {
        this.totalTurnover = totalTurnover;
    }

    public String getBankCustody() {
        return bankCustody;
    }

    public void setBankCustody(String bankCustody) {
        this.bankCustody = bankCustody;
    }

    public String getInvestTerm() {
        return investTerm;
    }

    public void setInvestTerm(String investTerm) {
        this.investTerm = investTerm;
    }

    public String getAvgLendTime() {
        return avgLendTime;
    }

    public void setAvgLendTime(String avgLendTime) {
        this.avgLendTime = avgLendTime;
    }

    public String getAutomaticBidding() {
        return automaticBidding;
    }

    public void setAutomaticBidding(String automaticBidding) {
        this.automaticBidding = automaticBidding;
    }

    public String getDealVolume() {
        return dealVolume;
    }

    public void setDealVolume(String dealVolume) {
        this.dealVolume = dealVolume;
    }

    public String getAvgSoldoutTime() {
        return avgSoldoutTime;
    }

    public void setAvgSoldoutTime(String avgSoldoutTime) {
        this.avgSoldoutTime = avgSoldoutTime;
    }

    public String getClaimTransfer() {
        return claimTransfer;
    }

    public void setClaimTransfer(String claimTransfer) {
        this.claimTransfer = claimTransfer;
    }

    public String getNumOfLender() {
        return numOfLender;
    }

    public void setNumOfLender(String numOfLender) {
        this.numOfLender = numOfLender;
    }

    public String getPerBorrowingAmount() {
        return perBorrowingAmount;
    }

    public void setPerBorrowingAmount(String perBorrowingAmount) {
        this.perBorrowingAmount = perBorrowingAmount;
    }

    public String getBidGuarantee() {
        return bidGuarantee;
    }

    public void setBidGuarantee(String bidGuarantee) {
        this.bidGuarantee = bidGuarantee;
    }

    public String getNumOfBorrower() {
        return numOfBorrower;
    }

    public void setNumOfBorrower(String numOfBorrower) {
        this.numOfBorrower = numOfBorrower;
    }

    public String getPerLendingAmount() {
        return perLendingAmount;
    }

    public void setPerLendingAmount(String perLendingAmount) {
        this.perLendingAmount = perLendingAmount;
    }

    public String getGuaranteeMode() {
        return guaranteeMode;
    }

    public void setGuaranteeMode(String guaranteeMode) {
        this.guaranteeMode = guaranteeMode;
    }

    public String getLastFundNetInflow() {
        return lastFundNetInflow;
    }

    public void setLastFundNetInflow(String lastFundNetInflow) {
        this.lastFundNetInflow = lastFundNetInflow;
    }

    public String getPerBorrowingNum() {
        return perBorrowingNum;
    }

    public void setPerBorrowingNum(String perBorrowingNum) {
        this.perBorrowingNum = perBorrowingNum;
    }

    public String getRiskReserve() {
        return riskReserve;
    }

    public void setRiskReserve(String riskReserve) {
        this.riskReserve = riskReserve;
    }

    public String getLastDailyPending() {
        return lastDailyPending;
    }

    public void setLastDailyPending(String lastDailyPending) {
        this.lastDailyPending = lastDailyPending;
    }

    public String getPerLendingNum() {
        return perLendingNum;
    }

    public void setPerLendingNum(String perLendingNum) {
        this.perLendingNum = perLendingNum;
    }

    public String getFinancingRecord() {
        return financingRecord;
    }

    public void setFinancingRecord(String financingRecord) {
        this.financingRecord = financingRecord;
    }

    public String getSuperviseAssociation() {
        return superviseAssociation;
    }

    public void setSuperviseAssociation(String superviseAssociation) {
        this.superviseAssociation = superviseAssociation;
    }

    public String getGuaranteeInstitution() {
        return guaranteeInstitution;
    }

    public void setGuaranteeInstitution(String guaranteeInstitution) {
        this.guaranteeInstitution = guaranteeInstitution;
    }

    public boolean isSerious() {
        return serious;
    }

    public void setSerious(boolean serious) {
        this.serious = serious;
    }
}
