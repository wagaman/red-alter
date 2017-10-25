package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 行业实时监测统计数据
 * @author anhong.Tu
 * @version $Id: IndustryRealTimeMonitoringDTO.java, v 0.1 2017/7/5 18:33 anhong.Tu Exp $
 */
@ApiModel(value = "行业实时监测统计数据")
public class IndustryRealTimeMonitoringDTO {

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("地区")
    private String region;

    @ApiModelProperty("监测地区")
    private int monitorRegion;

    @ApiModelProperty("高危企业数")
    private int highCompany;

    @ApiModelProperty("高危企业变动数")
    private int changeHighCompany;

    @ApiModelProperty("增加高危企业数")
    private Integer addHighRisk;

    @ApiModelProperty("减少高危企业数")
    private Integer lessenHighRisk;

    @ApiModelProperty("网络借贷高危变动数")
    private int netChangeHighCompany;

    @ApiModelProperty("增加网络借贷高危企业数")
    private int netAddHighRisk;

    @ApiModelProperty("减少网络借贷高危企业数")
    private int netLessenHighRisk;

    @ApiModelProperty("私募基金高危变动数")
    private int privateFundChangeHighCompany;

    @ApiModelProperty("增加私募基金高危企业数")
    private int privateFundAddHighRisk;

    @ApiModelProperty("减少私募基金高危企业数")
    private int privateFundLessenHighRisk;

    @ApiModelProperty("交易场所高危变动数")
    private int tradePlaceChangeHighCompany;

    @ApiModelProperty("增加交易场所高危企业数")
    private int tradePlaceAddHighRisk;

    @ApiModelProperty("减少交易场所高危企业数")
    private int tradePlaceLessenHighRisk;

    @ApiModelProperty("融资担保高危变动数")
    private int financingGuaranteeChangeHighCompany;

    @ApiModelProperty("增加融资担保高危企业数")
    private int financingGuaranteeAddHighRisk;

    @ApiModelProperty("减少融资担保高危企业数")
    private int financingGuaranteeLessenHighRisk;

    @ApiModelProperty("小额贷款高危变动数")
    private int pettyLoanChangeHighCompany;

    @ApiModelProperty("增加小额贷款高危企业数")
    private int pettyLoanAddHighRisk;

    @ApiModelProperty("减少小额贷款高危企业数")
    private int pettyLoanLessenHighRisk;

    @ApiModelProperty("其他新兴金融高危变动数")
    private int otherChangeHighCompany;

    @ApiModelProperty("增加其他新兴金融高危企业数")
    private int otherAddHighRisk;

    @ApiModelProperty("减少其他新兴金融高危企业数")
    private int otherLessenHighRisk;

    @ApiModelProperty("监控企业数")
    private int monitorCompany;

    @ApiModelProperty("监控企业变动数")
    private int changeMonitorCompany;

    @ApiModelProperty("增加监控企业数")
    private int addMonitor;

    @ApiModelProperty("减少监控企业数")
    private int lessenMonitor;

    @ApiModelProperty("新兴金融监控企业数")
    private int risingFinancial;

    @ApiModelProperty("网络借贷监控企业数")
    private int netLoan;

    @ApiModelProperty("私募基金监控企业数")
    private int privateFund;

    @ApiModelProperty("交易场所监控企业数")
    private int tradePlace;

    @ApiModelProperty("融资担保监控企业数")
    private int financingGuarantee;

    @ApiModelProperty("小额贷款监控企业数")
    private int pettyLoan;


    @ApiModelProperty("网络借贷监控企业变动数")
    private int netChangeMonitorCompany;

    @ApiModelProperty("增加网络借贷监控企业数")
    private int netAddMonitor;

    @ApiModelProperty("减少网络借贷监控企业数")
    private int netLessenmonitor;

    @ApiModelProperty("私募基金监控企业变动数")
    private int privateFundChangeMonitorCompany;

    @ApiModelProperty("增加私募基金监控企业数")
    private int privateFundAddMonitor;

    @ApiModelProperty("减少私募基金监控企业数")
    private int privateFundLessenmonitor;

    @ApiModelProperty("交易场所监控企业变动数")
    private int tradePlaceChangeMonitorCompany;

    @ApiModelProperty("增加交易场所监控企业数")
    private int tradePlaceAddMonitor;

    @ApiModelProperty("减少交易场所监控企业数")
    private int tradePlaceLessenmonitor;

    @ApiModelProperty("小额贷款监控企业变动数")
    private int pettyLoanChangeMonitorCompany;

    @ApiModelProperty("增加小额贷款监控企业数")
    private int pettyLoanAddMonitor;

    @ApiModelProperty("减少小额贷款监控企业数")
    private int pettyLoanLessenmonitor;

    @ApiModelProperty("融资担保监控企业变动数")
    private int financingGuaranteeChangeMonitorCompany;

    @ApiModelProperty("增加融资担保监控企业数")
    private int financingGuaranteeAddMonitor;

    @ApiModelProperty("减少融资担保监控企业数")
    private int financingGuaranteeLessenmonitor;

    @ApiModelProperty("其他新兴金融监控企业变动数")
    private int otherChangeMonitorCompany;

    @ApiModelProperty("增加其他新兴金融监控企业数")
    private int otherAddMonitor;

    @ApiModelProperty("减少其他新兴金融监控企业数")
    private int otherLessenmonitor;

    @ApiModelProperty("占比,如5%,则本字段的值为0.05")
    private BigDecimal proportion;

    public int getRisingFinancial() {
        return risingFinancial;
    }

    public void setRisingFinancial(int risingFinancial) {
        this.risingFinancial = risingFinancial;
    }

    public int getNetLoan() {
        return netLoan;
    }

    public void setNetLoan(int netLoan) {
        this.netLoan = netLoan;
    }

    public int getPrivateFund() {
        return privateFund;
    }

    public void setPrivateFund(int privateFund) {
        this.privateFund = privateFund;
    }

    public int getTradePlace() {
        return tradePlace;
    }

    public void setTradePlace(int tradePlace) {
        this.tradePlace = tradePlace;
    }

    public int getFinancingGuarantee() {
        return financingGuarantee;
    }

    public void setFinancingGuarantee(int financingGuarantee) {
        this.financingGuarantee = financingGuarantee;
    }

    public int getPettyLoan() {
        return pettyLoan;
    }

    public void setPettyLoan(int pettyLoan) {
        this.pettyLoan = pettyLoan;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMonitorRegion() {
        return monitorRegion;
    }

    public void setMonitorRegion(int monitorRegion) {
        this.monitorRegion = monitorRegion;
    }

    public int getHighCompany() {
        return highCompany;
    }

    public void setHighCompany(int highCompany) {
        this.highCompany = highCompany;
    }

    public int getChangeHighCompany() {
        return changeHighCompany;
    }

    public void setChangeHighCompany(int changeHighCompany) {
        this.changeHighCompany = changeHighCompany;
    }

    public Integer getAddHighRisk() {
        return addHighRisk;
    }

    public void setAddHighRisk(Integer addHighRisk) {
        this.addHighRisk = addHighRisk;
    }

    public Integer getLessenHighRisk() {
        return lessenHighRisk;
    }

    public void setLessenHighRisk(Integer lessenHighRisk) {
        this.lessenHighRisk = lessenHighRisk;
    }

    public int getNetChangeHighCompany() {
        return netChangeHighCompany;
    }

    public void setNetChangeHighCompany(int netChangeHighCompany) {
        this.netChangeHighCompany = netChangeHighCompany;
    }

    public int getNetAddHighRisk() {
        return netAddHighRisk;
    }

    public void setNetAddHighRisk(int netAddHighRisk) {
        this.netAddHighRisk = netAddHighRisk;
    }

    public int getNetLessenHighRisk() {
        return netLessenHighRisk;
    }

    public void setNetLessenHighRisk(int netLessenHighRisk) {
        this.netLessenHighRisk = netLessenHighRisk;
    }

    public int getPrivateFundChangeHighCompany() {
        return privateFundChangeHighCompany;
    }

    public void setPrivateFundChangeHighCompany(int privateFundChangeHighCompany) {
        this.privateFundChangeHighCompany = privateFundChangeHighCompany;
    }

    public int getPrivateFundAddHighRisk() {
        return privateFundAddHighRisk;
    }

    public void setPrivateFundAddHighRisk(int privateFundAddHighRisk) {
        this.privateFundAddHighRisk = privateFundAddHighRisk;
    }

    public int getPrivateFundLessenHighRisk() {
        return privateFundLessenHighRisk;
    }

    public void setPrivateFundLessenHighRisk(int privateFundLessenHighRisk) {
        this.privateFundLessenHighRisk = privateFundLessenHighRisk;
    }

    public int getTradePlaceChangeHighCompany() {
        return tradePlaceChangeHighCompany;
    }

    public void setTradePlaceChangeHighCompany(int tradePlaceChangeHighCompany) {
        this.tradePlaceChangeHighCompany = tradePlaceChangeHighCompany;
    }

    public int getTradePlaceAddHighRisk() {
        return tradePlaceAddHighRisk;
    }

    public void setTradePlaceAddHighRisk(int tradePlaceAddHighRisk) {
        this.tradePlaceAddHighRisk = tradePlaceAddHighRisk;
    }

    public int getTradePlaceLessenHighRisk() {
        return tradePlaceLessenHighRisk;
    }

    public void setTradePlaceLessenHighRisk(int tradePlaceLessenHighRisk) {
        this.tradePlaceLessenHighRisk = tradePlaceLessenHighRisk;
    }

    public int getFinancingGuaranteeChangeHighCompany() {
        return financingGuaranteeChangeHighCompany;
    }

    public void setFinancingGuaranteeChangeHighCompany(int financingGuaranteeChangeHighCompany) {
        this.financingGuaranteeChangeHighCompany = financingGuaranteeChangeHighCompany;
    }

    public int getFinancingGuaranteeAddHighRisk() {
        return financingGuaranteeAddHighRisk;
    }

    public void setFinancingGuaranteeAddHighRisk(int financingGuaranteeAddHighRisk) {
        this.financingGuaranteeAddHighRisk = financingGuaranteeAddHighRisk;
    }

    public int getFinancingGuaranteeLessenHighRisk() {
        return financingGuaranteeLessenHighRisk;
    }

    public void setFinancingGuaranteeLessenHighRisk(int financingGuaranteeLessenHighRisk) {
        this.financingGuaranteeLessenHighRisk = financingGuaranteeLessenHighRisk;
    }

    public int getPettyLoanChangeHighCompany() {
        return pettyLoanChangeHighCompany;
    }

    public void setPettyLoanChangeHighCompany(int pettyLoanChangeHighCompany) {
        this.pettyLoanChangeHighCompany = pettyLoanChangeHighCompany;
    }

    public int getPettyLoanAddHighRisk() {
        return pettyLoanAddHighRisk;
    }

    public void setPettyLoanAddHighRisk(int pettyLoanAddHighRisk) {
        this.pettyLoanAddHighRisk = pettyLoanAddHighRisk;
    }

    public int getPettyLoanLessenHighRisk() {
        return pettyLoanLessenHighRisk;
    }

    public void setPettyLoanLessenHighRisk(int pettyLoanLessenHighRisk) {
        this.pettyLoanLessenHighRisk = pettyLoanLessenHighRisk;
    }

    public int getOtherChangeHighCompany() {
        return otherChangeHighCompany;
    }

    public void setOtherChangeHighCompany(int otherChangeHighCompany) {
        this.otherChangeHighCompany = otherChangeHighCompany;
    }

    public int getOtherAddHighRisk() {
        return otherAddHighRisk;
    }

    public void setOtherAddHighRisk(int otherAddHighRisk) {
        this.otherAddHighRisk = otherAddHighRisk;
    }

    public int getOtherLessenHighRisk() {
        return otherLessenHighRisk;
    }

    public void setOtherLessenHighRisk(int otherLessenHighRisk) {
        this.otherLessenHighRisk = otherLessenHighRisk;
    }

    public int getMonitorCompany() {
        return monitorCompany;
    }

    public void setMonitorCompany(int monitorCompany) {
        this.monitorCompany = monitorCompany;
    }

    public int getChangeMonitorCompany() {
        return changeMonitorCompany;
    }

    public void setChangeMonitorCompany(int changeMonitorCompany) {
        this.changeMonitorCompany = changeMonitorCompany;
    }

    public int getAddMonitor() {
        return addMonitor;
    }

    public void setAddMonitor(int addMonitor) {
        this.addMonitor = addMonitor;
    }

    public int getLessenMonitor() {
        return lessenMonitor;
    }

    public void setLessenMonitor(int lessenMonitor) {
        this.lessenMonitor = lessenMonitor;
    }

    public int getNetChangeMonitorCompany() {
        return netChangeMonitorCompany;
    }

    public void setNetChangeMonitorCompany(int netChangeMonitorCompany) {
        this.netChangeMonitorCompany = netChangeMonitorCompany;
    }

    public int getNetAddMonitor() {
        return netAddMonitor;
    }

    public void setNetAddMonitor(int netAddMonitor) {
        this.netAddMonitor = netAddMonitor;
    }

    public int getNetLessenmonitor() {
        return netLessenmonitor;
    }

    public void setNetLessenmonitor(int netLessenmonitor) {
        this.netLessenmonitor = netLessenmonitor;
    }

    public int getPrivateFundChangeMonitorCompany() {
        return privateFundChangeMonitorCompany;
    }

    public void setPrivateFundChangeMonitorCompany(int privateFundChangeMonitorCompany) {
        this.privateFundChangeMonitorCompany = privateFundChangeMonitorCompany;
    }

    public int getPrivateFundAddMonitor() {
        return privateFundAddMonitor;
    }

    public void setPrivateFundAddMonitor(int privateFundAddMonitor) {
        this.privateFundAddMonitor = privateFundAddMonitor;
    }

    public int getPrivateFundLessenmonitor() {
        return privateFundLessenmonitor;
    }

    public void setPrivateFundLessenmonitor(int privateFundLessenmonitor) {
        this.privateFundLessenmonitor = privateFundLessenmonitor;
    }

    public int getTradePlaceChangeMonitorCompany() {
        return tradePlaceChangeMonitorCompany;
    }

    public void setTradePlaceChangeMonitorCompany(int tradePlaceChangeMonitorCompany) {
        this.tradePlaceChangeMonitorCompany = tradePlaceChangeMonitorCompany;
    }

    public int getTradePlaceAddMonitor() {
        return tradePlaceAddMonitor;
    }

    public void setTradePlaceAddMonitor(int tradePlaceAddMonitor) {
        this.tradePlaceAddMonitor = tradePlaceAddMonitor;
    }

    public int getTradePlaceLessenmonitor() {
        return tradePlaceLessenmonitor;
    }

    public void setTradePlaceLessenmonitor(int tradePlaceLessenmonitor) {
        this.tradePlaceLessenmonitor = tradePlaceLessenmonitor;
    }

    public int getPettyLoanChangeMonitorCompany() {
        return pettyLoanChangeMonitorCompany;
    }

    public void setPettyLoanChangeMonitorCompany(int pettyLoanChangeMonitorCompany) {
        this.pettyLoanChangeMonitorCompany = pettyLoanChangeMonitorCompany;
    }

    public int getPettyLoanAddMonitor() {
        return pettyLoanAddMonitor;
    }

    public void setPettyLoanAddMonitor(int pettyLoanAddMonitor) {
        this.pettyLoanAddMonitor = pettyLoanAddMonitor;
    }

    public int getPettyLoanLessenmonitor() {
        return pettyLoanLessenmonitor;
    }

    public void setPettyLoanLessenmonitor(int pettyLoanLessenmonitor) {
        this.pettyLoanLessenmonitor = pettyLoanLessenmonitor;
    }

    public int getFinancingGuaranteeChangeMonitorCompany() {
        return financingGuaranteeChangeMonitorCompany;
    }

    public void setFinancingGuaranteeChangeMonitorCompany(int financingGuaranteeChangeMonitorCompany) {
        this.financingGuaranteeChangeMonitorCompany = financingGuaranteeChangeMonitorCompany;
    }

    public int getFinancingGuaranteeAddMonitor() {
        return financingGuaranteeAddMonitor;
    }

    public void setFinancingGuaranteeAddMonitor(int financingGuaranteeAddMonitor) {
        this.financingGuaranteeAddMonitor = financingGuaranteeAddMonitor;
    }

    public int getFinancingGuaranteeLessenmonitor() {
        return financingGuaranteeLessenmonitor;
    }

    public void setFinancingGuaranteeLessenmonitor(int financingGuaranteeLessenmonitor) {
        this.financingGuaranteeLessenmonitor = financingGuaranteeLessenmonitor;
    }

    public int getOtherChangeMonitorCompany() {
        return otherChangeMonitorCompany;
    }

    public void setOtherChangeMonitorCompany(int otherChangeMonitorCompany) {
        this.otherChangeMonitorCompany = otherChangeMonitorCompany;
    }

    public int getOtherAddMonitor() {
        return otherAddMonitor;
    }

    public void setOtherAddMonitor(int otherAddMonitor) {
        this.otherAddMonitor = otherAddMonitor;
    }

    public int getOtherLessenmonitor() {
        return otherLessenmonitor;
    }

    public void setOtherLessenmonitor(int otherLessenmonitor) {
        this.otherLessenmonitor = otherLessenmonitor;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

}
