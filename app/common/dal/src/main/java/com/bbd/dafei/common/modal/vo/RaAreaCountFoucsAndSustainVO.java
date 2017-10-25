package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 取得不同行业的重点关注企业数与持续监控企业数
 * @author anhong.Tu
 * @version $Id: RaAreaCountFoucsAndSustainVO.java, v 0.1 2017/7/21 9:30 anhong.Tu Exp $
 */
@ApiModel("地区企业数统计")
public class RaAreaCountFoucsAndSustainVO {

    @ApiModelProperty("网络借贷重点关注企业数")
    private int netFocusOn;

    @ApiModelProperty("网络借贷持续监控企业数")
    private int netSustainMonitor;

    @ApiModelProperty("私募基金重点关注企业数")
    private int privateFundFocusOn;

    @ApiModelProperty("私募基金持续监控企业数")
    private int privateFundSustainMonitor;

    @ApiModelProperty("交易场所重点关注企业数")
    private int tradePlaceFocusOn;

    @ApiModelProperty("交易场所持续监控企业数")
    private int tradePlaceSustainMonitor;

    @ApiModelProperty("融资担保重点关注企业数")
    private int financingGuaranteeFocusOn;

    @ApiModelProperty("融资担保持续监控企业数")
    private int financingGuaranteeSustainMonitor;

    @ApiModelProperty("小额贷款重点关注企业数")
    private int pettyLoanFocusOn;

    @ApiModelProperty("小额贷款持续监控企业数")
    private int pettyLoanSustainMonitor;

    @ApiModelProperty("其他新兴金融重点关注企业数")
    private int otherFocusOn;

    @ApiModelProperty("其他新兴金融持续监控企业数")
    private int otherSustainMonitor;

    public int getNetFocusOn() {
        return netFocusOn;
    }

    public void setNetFocusOn(int netFocusOn) {
        this.netFocusOn = netFocusOn;
    }

    public int getNetSustainMonitor() {
        return netSustainMonitor;
    }

    public void setNetSustainMonitor(int netSustainMonitor) {
        this.netSustainMonitor = netSustainMonitor;
    }

    public int getPrivateFundFocusOn() {
        return privateFundFocusOn;
    }

    public void setPrivateFundFocusOn(int privateFundFocusOn) {
        this.privateFundFocusOn = privateFundFocusOn;
    }

    public int getPrivateFundSustainMonitor() {
        return privateFundSustainMonitor;
    }

    public void setPrivateFundSustainMonitor(int privateFundSustainMonitor) {
        this.privateFundSustainMonitor = privateFundSustainMonitor;
    }

    public int getTradePlaceFocusOn() {
        return tradePlaceFocusOn;
    }

    public void setTradePlaceFocusOn(int tradePlaceFocusOn) {
        this.tradePlaceFocusOn = tradePlaceFocusOn;
    }

    public int getTradePlaceSustainMonitor() {
        return tradePlaceSustainMonitor;
    }

    public void setTradePlaceSustainMonitor(int tradePlaceSustainMonitor) {
        this.tradePlaceSustainMonitor = tradePlaceSustainMonitor;
    }

    public int getFinancingGuaranteeFocusOn() {
        return financingGuaranteeFocusOn;
    }

    public void setFinancingGuaranteeFocusOn(int financingGuaranteeFocusOn) {
        this.financingGuaranteeFocusOn = financingGuaranteeFocusOn;
    }

    public int getFinancingGuaranteeSustainMonitor() {
        return financingGuaranteeSustainMonitor;
    }

    public void setFinancingGuaranteeSustainMonitor(int financingGuaranteeSustainMonitor) {
        this.financingGuaranteeSustainMonitor = financingGuaranteeSustainMonitor;
    }

    public int getPettyLoanFocusOn() {
        return pettyLoanFocusOn;
    }

    public void setPettyLoanFocusOn(int pettyLoanFocusOn) {
        this.pettyLoanFocusOn = pettyLoanFocusOn;
    }

    public int getPettyLoanSustainMonitor() {
        return pettyLoanSustainMonitor;
    }

    public void setPettyLoanSustainMonitor(int pettyLoanSustainMonitor) {
        this.pettyLoanSustainMonitor = pettyLoanSustainMonitor;
    }

    public int getOtherFocusOn() {
        return otherFocusOn;
    }

    public void setOtherFocusOn(int otherFocusOn) {
        this.otherFocusOn = otherFocusOn;
    }

    public int getOtherSustainMonitor() {
        return otherSustainMonitor;
    }

    public void setOtherSustainMonitor(int otherSustainMonitor) {
        this.otherSustainMonitor = otherSustainMonitor;
    }
}
