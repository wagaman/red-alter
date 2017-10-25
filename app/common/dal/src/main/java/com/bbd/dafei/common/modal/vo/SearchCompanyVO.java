package com.bbd.dafei.common.modal.vo;

import com.bbd.dafei.common.modal.dto.HighLightDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/4/25.
 */
@ApiModel(value = "搜索企业信息")
public class SearchCompanyVO {
    @ApiModelProperty(value = "成立日期")
    private String esdate;
    @ApiModelProperty(value = "企业类型")
    private String companyType;
    @ApiModelProperty(value = "经营范围")
    private String operateScope;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区县")
    private String district;
    @ApiModelProperty(value = "上市与否")
    private String ipoCompany;
    @ApiModelProperty(value = "存续状态")
    private String companyEnterpriseStatus;
    @ApiModelProperty(value = "董监高")
    private List<String> baxx;
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;
    @ApiModelProperty(value = "法人代表")
    private String frname;
    @ApiModelProperty(value = "注册号")
    private String regno;
    @ApiModelProperty(value = "企业地址")
    private String address;
    @ApiModelProperty(value = "股东信息")
    private String gdxx;
    @ApiModelProperty(value = "历史名称")
    private List<String> bbdHistoryName;
    @ApiModelProperty(value = "行业")
    private String companyIndustry;
    @ApiModelProperty(value = "注册资本金")
    private String regcap;
    @ApiModelProperty(value = "组织机构代码")
    private String jgdm;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "注册机构")
    private String regOrg;
    private String bbdQyxxId;
    @ApiModelProperty(value = "高亮")
    private HighLightDTO hightLight;
    @ApiModelProperty(value = "标签")
    private List<String> redalertTags;
    @ApiModelProperty(value = "平台")
    private List<String> p2pPlatform;
    @ApiModelProperty(value = "拼音")
    private String pinyin;
    @ApiModelProperty(value = "行业")
    private String industry;
    @ApiModelProperty(value = "易燃指数")
    private Float riskIndex;
    @ApiModelProperty(value = "风险等级")
    private String riskLevel;
    @ApiModelProperty(value = "易燃指数是否上升；1:上升，0：持平，-1：下降")
    private Integer rise;
    @ApiModelProperty(value = "是否被拉黑")
    private boolean black;
    @ApiModelProperty(value = "公司名称(未高亮)")
    private String unHighLightCompanyName;
    @ApiModelProperty(value = "登录用户是否有权限查看详情")
    private boolean hasPermission;

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

    public String getGdxx() {
        return gdxx;
    }

    public void setGdxx(String gdxx) {
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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Float getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(Float riskIndex) {
        this.riskIndex = riskIndex;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Integer getRise() {
        return rise;
    }

    public void setRise(Integer rise) {
        this.rise = rise;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public String getUnHighLightCompanyName() {
        return unHighLightCompanyName;
    }

    public void setUnHighLightCompanyName(String unHighLightCompanyName) {
        this.unHighLightCompanyName = unHighLightCompanyName;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }
}
