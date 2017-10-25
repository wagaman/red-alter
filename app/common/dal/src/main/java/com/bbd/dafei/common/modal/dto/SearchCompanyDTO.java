package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 搜索企业信息DTO
 * Created by wish on 2017/4/25.
 */
public class SearchCompanyDTO {
    //成立日期
    @SerializedName("esdate")
    private String esdate;
    //企业类型
    @SerializedName("company_type")
    private String companyType;
    //经营范围
    @SerializedName("OperateScope")
    private String operateScope;
    //省
    @SerializedName("province")
    private String province;
    //市
    @SerializedName("city")
    private String city;
    //区县
    @SerializedName("district")
    private String district;
    //上市与否
    @SerializedName("ipo_Company")
    private String ipoCompany;
    //存续状态
    @SerializedName("company_enterprise_status")
    private String companyEnterpriseStatus;
    //董监高
    @SerializedName("baxx")
    private List<String> baxx;
    //统一社会信用代码
    @SerializedName("credit_code")
    private String creditCode;
    //法人代表
    @SerializedName("frname")
    private String frname;
    //注册号
    @SerializedName("regno")
    private String regno;
    //企业地址
    @SerializedName("address")
    private String address;
    //股东信息
    @SerializedName("gdxx")
    private List<String> gdxx;
    //历史名称
    @SerializedName("bbd_history_name")
    private List<String> bbdHistoryName;
    //行业
    @SerializedName("company_industry")
    private String companyIndustry;
    //注册资本金
    @SerializedName("regcap")
    private String regcap;
    //注册资本数量
    @SerializedName("regcap_amount")
    private String regcapAmount;
    //注册资本单位
    @SerializedName("regcap_currency")
    private String regcapCurrency;
    //组织机构代码
    @SerializedName("jgdm")
    private String jgdm;
    //企业名称
    @SerializedName("company_name")
    private String companyName;
    //注册机构
    @SerializedName("regOrg")
    private String regOrg;
    @SerializedName("bbd_qyxx_id")
    private String bbdQyxxId;
    //高亮
    @SerializedName("highlight")
    private HighLightDTO hightLight;
    //拼音
    @SerializedName("pinyin")
    private String pinyin;
    //标签
    @SerializedName("redalert_tags")
    private List<String> redalertTags;
    //平台
    @SerializedName("p2p_platform")
    private List<String> p2pPlatform;
    //公司名称(未高亮)
    private String unHighLightCompanyName;

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(String operateScope) {
        this.operateScope = operateScope;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIpoCompany() {
        return ipoCompany;
    }

    public void setIpoCompany(String ipoCompany) {
        this.ipoCompany = ipoCompany;
    }

    public String getCompanyEnterpriseStatus() {
        return companyEnterpriseStatus;
    }

    public void setCompanyEnterpriseStatus(String companyEnterpriseStatus) {
        this.companyEnterpriseStatus = companyEnterpriseStatus;
    }

    public List<String> getBaxx() {
        return baxx;
    }

    public void setBaxx(List<String> baxx) {
        this.baxx = baxx;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getGdxx() {
        return gdxx;
    }

    public void setGdxx(List<String> gdxx) {
        this.gdxx = gdxx;
    }

    public List<String> getBbdHistoryName() {
        return bbdHistoryName;
    }

    public void setBbdHistoryName(List<String> bbdHistoryName) {
        this.bbdHistoryName = bbdHistoryName;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getRegcapAmount() {
        return regcapAmount;
    }

    public void setRegcapAmount(String regcapAmount) {
        this.regcapAmount = regcapAmount;
    }

    public String getRegcapCurrency() {
        return regcapCurrency;
    }

    public void setRegcapCurrency(String regcapCurrency) {
        this.regcapCurrency = regcapCurrency;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegOrg() {
        return regOrg;
    }

    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    public String getBbdQyxxId() {
        return bbdQyxxId;
    }

    public void setBbdQyxxId(String bbdQyxxId) {
        this.bbdQyxxId = bbdQyxxId;
    }

    public HighLightDTO getHightLight() {
        return hightLight;
    }

    public void setHightLight(HighLightDTO hightLight) {
        this.hightLight = hightLight;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public List<String> getRedalertTags() {
        return redalertTags;
    }

    public void setRedalertTags(List<String> redalertTags) {
        this.redalertTags = redalertTags;
    }

    public List<String> getP2pPlatform() {
        return p2pPlatform;
    }

    public void setP2pPlatform(List<String> p2pPlatform) {
        this.p2pPlatform = p2pPlatform;
    }

    public String getUnHighLightCompanyName() {
        return unHighLightCompanyName;
    }

    public void setUnHighLightCompanyName(String unHighLightCompanyName) {
        this.unHighLightCompanyName = unHighLightCompanyName;
    }
}
