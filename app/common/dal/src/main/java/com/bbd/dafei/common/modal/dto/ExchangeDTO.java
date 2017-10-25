package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

/**
 * 交易信息DTO
 * Created by wish on 2017/4/25.
 */
public class ExchangeDTO {
    //交易所名称
    @SerializedName("exchange_name")
    private String exchangeName;
    //注册日期
    @SerializedName("esdate")
    private String esdate;
    //政府批文
    @SerializedName("gov_doc")
    private String govDoc;
    //法人代表
    @SerializedName("frname")
    private String frname;
    //交易品种信息
    @SerializedName("trading_variety_info")
    private String tradingVarietyInfo;
    //交易所简称
    @SerializedName("exchange_short")
    private String exchangeShort;
    //交易所全称
    @SerializedName("company_name")
    private String companyName;
    //网址
    @SerializedName("website")
    private String website;
    //注册资本（万元）
    @SerializedName("regcap")
    private String regcap;
    //注册地区
    @SerializedName("reg_city")
    private String regCity;
    //简介
    @SerializedName("exchange_brief")
    private String exchangeBrief;
    //交易品种
    @SerializedName("trading_variety")
    private String tradingVariety;
    //资料文件
    @SerializedName("material_files")
    private String materialFiles;
    //开业日期
    @SerializedName("open_date")
    private String openDate;
    //地区
    @SerializedName("region")
    private String region;
    //交易所类型
    @SerializedName("exchange_type")
    private String exchangeType;

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

    public String getTradingVarietyInfo() {
        return tradingVarietyInfo;
    }

    public void setTradingVarietyInfo(String tradingVarietyInfo) {
        this.tradingVarietyInfo = tradingVarietyInfo;
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
}
