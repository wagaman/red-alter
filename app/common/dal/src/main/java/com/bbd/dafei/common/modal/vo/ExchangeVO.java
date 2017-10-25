package com.bbd.dafei.common.modal.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/4/25.
 */
@ApiModel(value = "交易场所特征信息")
public class ExchangeVO {
    @ApiModelProperty(value = "交易所名称")
    private String exchangeName;
    @ApiModelProperty(value = "注册日期")
    private String esdate;
    @ApiModelProperty(value = "政府批文")
    private String govDoc;
    @ApiModelProperty(value = "法人代表")
    private String frname;
    @ApiModelProperty(value = "交易所简称")
    private String exchangeShort;
    @ApiModelProperty(value = "交易所全称")
    private String companyName;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "注册资本（万元）")
    private String regcap;
    @ApiModelProperty(value = "注册地区")
    private String regCity;
    @ApiModelProperty(value = "简介")
    private String exchangeBrief;
    @ApiModelProperty(value = "交易品种")
    private String tradingVariety;
    @ApiModelProperty(value = "资料文件")
    private String materialFiles;
    @ApiModelProperty(value = "开业日期")
    private String openDate;
    @ApiModelProperty(value = "地区")
    private String region;
    @ApiModelProperty(value = "交易所类型")
    private String exchangeType;
    @ApiModelProperty(value = "交易品种信息")
    private List<TradingVarietyInfo> tradingVarietyInfos;

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getGovDoc() {
        return govDoc;
    }

    public void setGovDoc(String govDoc) {
        this.govDoc = govDoc;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getExchangeShort() {
        return exchangeShort;
    }

    public void setExchangeShort(String exchangeShort) {
        this.exchangeShort = exchangeShort;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getRegCity() {
        return regCity;
    }

    public void setRegCity(String regCity) {
        this.regCity = regCity;
    }

    public String getExchangeBrief() {
        return exchangeBrief;
    }

    public void setExchangeBrief(String exchangeBrief) {
        this.exchangeBrief = exchangeBrief;
    }

    public String getTradingVariety() {
        return tradingVariety;
    }

    public void setTradingVariety(String tradingVariety) {
        this.tradingVariety = tradingVariety;
    }

    public String getMaterialFiles() {
        return materialFiles;
    }

    public void setMaterialFiles(String materialFiles) {
        this.materialFiles = materialFiles;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public List<TradingVarietyInfo> getTradingVarietyInfos() {
        return tradingVarietyInfos;
    }

    public void setTradingVarietyInfos(List<TradingVarietyInfo> tradingVarietyInfos) {
        this.tradingVarietyInfos = tradingVarietyInfos;
    }

    @ApiModel(value = "交易品种信息")
    public static class TradingVarietyInfo {

        @ApiModelProperty(value = "最小变动价位")
        @SerializedName(value = "最小变动价位")
        private String minChangePrice;
        @ApiModelProperty(value = "每日波动价格限制")
        @SerializedName(value = "每日波动价格限制")
        private String priceChangeLimitDaily;
        @ApiModelProperty(value = "交易时间")
        @SerializedName(value = "交易时间")
        private String tradeDate;
        @ApiModelProperty(value = "最少交易量")
        @SerializedName(value = "最少交易量")
        private String minTradeNum;
        @ApiModelProperty(value = "最小交收量")
        @SerializedName(value = "最小交收量")
        private String minDeliveryNum;
        @ApiModelProperty(value = "最大单边持仓量")
        @SerializedName(value = "最大单边持仓量")
        private String maxInventory;
        @ApiModelProperty(value = "交易单位")
        @SerializedName(value = "交易单位")
        private String tradeUnit;
        @ApiModelProperty(value = "最大单边交易量")
        @SerializedName(value = "最大单边交易量")
        private String maxTradeNum;
        @ApiModelProperty(value = "报价单位")
        @SerializedName(value = "报价单位")
        private String offerUnit;
        @ApiModelProperty(value = "交收时间")
        @SerializedName(value = "交收时间")
        private String deliveryDate;
        @ApiModelProperty(value = "最低保证金")
        @SerializedName(value = "最低保证金")
        private String minCashDeposit;
        @ApiModelProperty(value = "交易品种")
        @SerializedName(value = "交易品种")
        private String tradeType;
        @ApiModelProperty(value = "手续费")
        @SerializedName(value = "手续费")
        private String handlingCharge;
        @ApiModelProperty(value = "最大交收量")
        @SerializedName(value = "最大交收量")
        private String maxDeliveryNum;

        public String getMinChangePrice() {
            return minChangePrice;
        }

        public void setMinChangePrice(String minChangePrice) {
            this.minChangePrice = minChangePrice;
        }

        public String getPriceChangeLimitDaily() {
            return priceChangeLimitDaily;
        }

        public void setPriceChangeLimitDaily(String priceChangeLimitDaily) {
            this.priceChangeLimitDaily = priceChangeLimitDaily;
        }

        public String getTradeDate() {
            return tradeDate;
        }

        public void setTradeDate(String tradeDate) {
            this.tradeDate = tradeDate;
        }

        public String getMinTradeNum() {
            return minTradeNum;
        }

        public void setMinTradeNum(String minTradeNum) {
            this.minTradeNum = minTradeNum;
        }

        public String getMinDeliveryNum() {
            return minDeliveryNum;
        }

        public void setMinDeliveryNum(String minDeliveryNum) {
            this.minDeliveryNum = minDeliveryNum;
        }

        public String getMaxInventory() {
            return maxInventory;
        }

        public void setMaxInventory(String maxInventory) {
            this.maxInventory = maxInventory;
        }

        public String getTradeUnit() {
            return tradeUnit;
        }

        public void setTradeUnit(String tradeUnit) {
            this.tradeUnit = tradeUnit;
        }

        public String getMaxTradeNum() {
            return maxTradeNum;
        }

        public void setMaxTradeNum(String maxTradeNum) {
            this.maxTradeNum = maxTradeNum;
        }

        public String getOfferUnit() {
            return offerUnit;
        }

        public void setOfferUnit(String offerUnit) {
            this.offerUnit = offerUnit;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public String getMinCashDeposit() {
            return minCashDeposit;
        }

        public void setMinCashDeposit(String minCashDeposit) {
            this.minCashDeposit = minCashDeposit;
        }

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getHandlingCharge() {
            return handlingCharge;
        }

        public void setHandlingCharge(String handlingCharge) {
            this.handlingCharge = handlingCharge;
        }

        public String getMaxDeliveryNum() {
            return maxDeliveryNum;
        }

        public void setMaxDeliveryNum(String maxDeliveryNum) {
            this.maxDeliveryNum = maxDeliveryNum;
        }
    }
}
