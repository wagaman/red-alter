package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/5/4.
 */
@ApiModel(value = "零壹数据")
public class PlatformDataDTO {
    @ApiModelProperty(value = "人均投资金额（万）")
    @SerializedName("per_lending_amount")
    private String perLendingAmount;
    @ApiModelProperty(value = "注册资本")
    @SerializedName("regcap")
    private String regcap;
    @ApiModelProperty(value = "平台状态")
    @SerializedName("platform_state")
    private String platformState;
    @ApiModelProperty(value = "平均满标时间（小时）")
    @SerializedName("avg_soldout_time")
    private String avgSoldoutTime;
    @ApiModelProperty(value = "总投资人数（人）")
    @SerializedName("total_num_of_lender")
    private String totalNumOfLender;
    @ApiModelProperty(value = "注册地点")
    @SerializedName("city")
    private String city;
    @ApiModelProperty(value = "总成交额（万）")
    @SerializedName("total_turnover")
    private String totalTurnover;
    @ApiModelProperty(value = "总成交量（笔）")
    @SerializedName("total_deal_volume")
    private String totalDealVolume;
    @ApiModelProperty(value = "所属公司")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "平均借款期限（天）")
    @SerializedName("avg_lend_time")
    private String avgLendTime;
    @ApiModelProperty(value = "人均借款金额（万）")
    @SerializedName("per_borrowing_amount")
    private String perBorrowingAmount;
    @ApiModelProperty(value = "上线时间")
    @SerializedName("onlinetime")
    private String onlinetime;
    @ApiModelProperty(value = "人均借款次数（次）")
    @SerializedName("per_borrowing_num")
    private String perBorrowingNum;
    @ApiModelProperty(value = "月成交数据")
    @SerializedName("monthly_deal_data")
    private String monthlyDealData;
    @ApiModelProperty(value = "名义利率")
    @SerializedName("nominal_interest_rate")
    private String nominalInterestRate;
    @ApiModelProperty(value = "借款人数")
    @SerializedName("num_of_borrower")
    private String numOfBorrower;
    @ApiModelProperty(value = "投资人数")
    @SerializedName("num_of_lender")
    private String numOfLender;
    @ApiModelProperty(value = "成交量")
    @SerializedName("deal_volume")
    private String dealVolume;
    @ApiModelProperty(value = "成交额")
    @SerializedName("turnover")
    private String turnover;
    @ApiModelProperty(value = "贷款余额（万）")
    @SerializedName("loan_balance")
    private String loanBalance;
    @ApiModelProperty(value = "公司地址")
    @SerializedName("address")
    private String address;
    @ApiModelProperty(value = "投资分散度")
    @SerializedName("lending_dispersion")
    private String lendingDispersion;
    @ApiModelProperty(value = "法人代表")
    @SerializedName("frname")
    private String frname;
    @ApiModelProperty(value = "总借款人数（人）")
    @SerializedName("total_num_of_borrower")
    private String totalNumOfBorrower;
    @ApiModelProperty(value = "平台名称")
    @SerializedName("platform_name")
    private String platformName;
    @ApiModelProperty(value = "人均投资次数（次）")
    @SerializedName("per_lending_num")
    private String perLendingNum;
    @ApiModelProperty(value = "借款分散度")
    @SerializedName("borrowing_dispersion")
    private String borrowingDispersion;

    public String getPerLendingAmount() {
        return perLendingAmount;
    }

    public void setPerLendingAmount(String perLendingAmount) {
        this.perLendingAmount = perLendingAmount;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getPlatformState() {
        return platformState;
    }

    public void setPlatformState(String platformState) {
        this.platformState = platformState;
    }

    public String getAvgSoldoutTime() {
        return avgSoldoutTime;
    }

    public void setAvgSoldoutTime(String avgSoldoutTime) {
        this.avgSoldoutTime = avgSoldoutTime;
    }

    public String getTotalNumOfLender() {
        return totalNumOfLender;
    }

    public void setTotalNumOfLender(String totalNumOfLender) {
        this.totalNumOfLender = totalNumOfLender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTotalTurnover() {
        return totalTurnover;
    }

    public void setTotalTurnover(String totalTurnover) {
        this.totalTurnover = totalTurnover;
    }

    public String getTotalDealVolume() {
        return totalDealVolume;
    }

    public void setTotalDealVolume(String totalDealVolume) {
        this.totalDealVolume = totalDealVolume;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAvgLendTime() {
        return avgLendTime;
    }

    public void setAvgLendTime(String avgLendTime) {
        this.avgLendTime = avgLendTime;
    }

    public String getPerBorrowingAmount() {
        return perBorrowingAmount;
    }

    public void setPerBorrowingAmount(String perBorrowingAmount) {
        this.perBorrowingAmount = perBorrowingAmount;
    }

    public String getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(String onlinetime) {
        this.onlinetime = onlinetime;
    }

    public String getPerBorrowingNum() {
        return perBorrowingNum;
    }

    public void setPerBorrowingNum(String perBorrowingNum) {
        this.perBorrowingNum = perBorrowingNum;
    }

    public String getMonthlyDealData() {
        return monthlyDealData;
    }

    public void setMonthlyDealData(String monthlyDealData) {
        this.monthlyDealData = monthlyDealData;
    }

    public String getNominalInterestRate() {
        return nominalInterestRate;
    }

    public void setNominalInterestRate(String nominalInterestRate) {
        this.nominalInterestRate = nominalInterestRate;
    }

    public String getNumOfBorrower() {
        return numOfBorrower;
    }

    public void setNumOfBorrower(String numOfBorrower) {
        this.numOfBorrower = numOfBorrower;
    }

    public String getNumOfLender() {
        return numOfLender;
    }

    public void setNumOfLender(String numOfLender) {
        this.numOfLender = numOfLender;
    }

    public String getDealVolume() {
        return dealVolume;
    }

    public void setDealVolume(String dealVolume) {
        this.dealVolume = dealVolume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(String loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLendingDispersion() {
        return lendingDispersion;
    }

    public void setLendingDispersion(String lendingDispersion) {
        this.lendingDispersion = lendingDispersion;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getTotalNumOfBorrower() {
        return totalNumOfBorrower;
    }

    public void setTotalNumOfBorrower(String totalNumOfBorrower) {
        this.totalNumOfBorrower = totalNumOfBorrower;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPerLendingNum() {
        return perLendingNum;
    }

    public void setPerLendingNum(String perLendingNum) {
        this.perLendingNum = perLendingNum;
    }

    public String getBorrowingDispersion() {
        return borrowingDispersion;
    }

    public void setBorrowingDispersion(String borrowingDispersion) {
        this.borrowingDispersion = borrowingDispersion;
    }
}
