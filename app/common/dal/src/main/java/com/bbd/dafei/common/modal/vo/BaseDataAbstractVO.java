package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/24.
 */
@ApiModel(value = "企业摘要信息")
public class BaseDataAbstractVO {
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;
    @ApiModelProperty(value = "注册号")
    private String regno;
    @ApiModelProperty(value = "名称")
    private String companyName;
    @ApiModelProperty(value = "企业类型")
    private String companyType;
    @ApiModelProperty(value = "法定代表人")
    private String frname;
    @ApiModelProperty(value = "注册资金")
    private String regcap;
    @ApiModelProperty(value = "实收资本")
    private String realcap;
    @ApiModelProperty(value = "成立日期")
    private String esdate;
    @ApiModelProperty(value = "核准日期")
    private String approvalDate;
    @ApiModelProperty(value = "营业期限自")
    private String openfrom;
    @ApiModelProperty(value = "营业期限至")
    private String opento;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "经营范围")
    private String operateScope;
    @ApiModelProperty(value = "登记机关")
    private String regorg;
    @ApiModelProperty(value = "登记状态")
    private String enterpriseStatus;
    @ApiModelProperty(value = "吊销日期")
    private String revokeDate;
    @ApiModelProperty(value = "派出企业名称")
    private String parentFirm;
    @ApiModelProperty(value = "出资额")
    private String investCap;
    @ApiModelProperty(value = "注册币种")
    private String regcapcur;
    @ApiModelProperty(value = "注销日期")
    private String cancelDate;
    @ApiModelProperty(value = "经营期限")
    private String operatingPeriod;
    @ApiModelProperty(value = "组成形式")
    private String form;
    @ApiModelProperty(value = "企业唯一ID")
    private String bbdQyxxId;
    @ApiModelProperty(value = "法定代表人唯一ID")
    private String frnameId;
    @ApiModelProperty(value = "历名名称")
    private String bbdHistoryName;
    @ApiModelProperty(value = "行业分类")
    private String companyIndustry;
    @ApiModelProperty(value = "注册资本_金额")
    private Float regcapAmount;
    @ApiModelProperty(value = "注册资本_币种")
    private String regcapCurrency;
    @ApiModelProperty(value = "实收资本_金额")
    private Float realcapAmount;
    @ApiModelProperty(value = "实收资本_币种")
    private String realcapCurrency;
    @ApiModelProperty(value = "投资总额_金额")
    private Float investcapAmount;
    @ApiModelProperty(value = "投资总额_币种")
    private String investcapCurrency;
    @ApiModelProperty(value = "注册币种_映射结果")
    private String companyCurrency;
    @ApiModelProperty(value = "省份_映射结果")
    private String companyProvince;
    @ApiModelProperty(value = "登记状态_映射结果")
    private String companyEnterpriseStatus;
    @ApiModelProperty(value = "企业类型_映射结果")
    private String companyCompanytype;
    @ApiModelProperty(value = "登记机关_映射结果")
    private String companyRegorg;
    @ApiModelProperty(value = "上市公司标识")
    private String ipoCompany;
    @ApiModelProperty(value = "GIS数据_经度")
    private Float companyGisLon;
    @ApiModelProperty(value = "GIS数据_纬度")
    private Float companyGisLat;
    @ApiModelProperty(value = "企业区县")
    private String companyCounty;
    @ApiModelProperty(value = "股东")
    private String shareholderName;
    @ApiModelProperty(value = "股东类型")
    private String shareholderType;
    @ApiModelProperty(value = "证照类型")
    private String idtype;
    @ApiModelProperty(value = "证照号码")
    private String idno;
    @ApiModelProperty(value = "出资比例")
    private String investRatio;
    @ApiModelProperty(value = "出资额")
    private String investAmount;
    @ApiModelProperty(value = "股东详情")
    private String shareholderDetail;
    @ApiModelProperty(value = "出资方式")
    private String investName;
    @ApiModelProperty(value = "认缴出资额")
    private String subscribedCapital;
    @ApiModelProperty(value = "实缴出资额")
    private String paidContribution;
    @ApiModelProperty(value = "股东唯一ID")
    private String shareholderId;
    @ApiModelProperty(value = "股东的类别判断")
    private Integer nameCompid;
    @ApiModelProperty(value = "所属行业")
    private String industry;
    @ApiModelProperty(value = "易燃指数")
    private Float riskIndex;
    @ApiModelProperty(value = "风险等级")
    private String riskLevel;
    @ApiModelProperty(value = "是否拉黑")
    private boolean black;

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getRealcap() {
        return realcap;
    }

    public void setRealcap(String realcap) {
        this.realcap = realcap;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getOpenfrom() {
        return openfrom;
    }

    public void setOpenfrom(String openfrom) {
        this.openfrom = openfrom;
    }

    public String getOpento() {
        return opento;
    }

    public void setOpento(String opento) {
        this.opento = opento;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperateScope() {
        return operateScope;
    }

    public void setOperateScope(String operateScope) {
        this.operateScope = operateScope;
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(String revokeDate) {
        this.revokeDate = revokeDate;
    }

    public String getParentFirm() {
        return parentFirm;
    }

    public void setParentFirm(String parentFirm) {
        this.parentFirm = parentFirm;
    }

    public String getInvestCap() {
        return investCap;
    }

    public void setInvestCap(String investCap) {
        this.investCap = investCap;
    }

    public String getRegcapcur() {
        return regcapcur;
    }

    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getOperatingPeriod() {
        return operatingPeriod;
    }

    public void setOperatingPeriod(String operatingPeriod) {
        this.operatingPeriod = operatingPeriod;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getBbdQyxxId() {
        return bbdQyxxId;
    }

    public void setBbdQyxxId(String bbdQyxxId) {
        this.bbdQyxxId = bbdQyxxId;
    }

    public String getFrnameId() {
        return frnameId;
    }

    public void setFrnameId(String frnameId) {
        this.frnameId = frnameId;
    }

    public String getBbdHistoryName() {
        return bbdHistoryName;
    }

    public void setBbdHistoryName(String bbdHistoryName) {
        this.bbdHistoryName = bbdHistoryName;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public Float getRegcapAmount() {
        return regcapAmount;
    }

    public void setRegcapAmount(Float regcapAmount) {
        this.regcapAmount = regcapAmount;
    }

    public String getRegcapCurrency() {
        return regcapCurrency;
    }

    public void setRegcapCurrency(String regcapCurrency) {
        this.regcapCurrency = regcapCurrency;
    }

    public Float getRealcapAmount() {
        return realcapAmount;
    }

    public void setRealcapAmount(Float realcapAmount) {
        this.realcapAmount = realcapAmount;
    }

    public String getRealcapCurrency() {
        return realcapCurrency;
    }

    public void setRealcapCurrency(String realcapCurrency) {
        this.realcapCurrency = realcapCurrency;
    }

    public Float getInvestcapAmount() {
        return investcapAmount;
    }

    public void setInvestcapAmount(Float investcapAmount) {
        this.investcapAmount = investcapAmount;
    }

    public String getInvestcapCurrency() {
        return investcapCurrency;
    }

    public void setInvestcapCurrency(String investcapCurrency) {
        this.investcapCurrency = investcapCurrency;
    }

    public String getCompanyCurrency() {
        return companyCurrency;
    }

    public void setCompanyCurrency(String companyCurrency) {
        this.companyCurrency = companyCurrency;
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }

    public String getCompanyEnterpriseStatus() {
        return companyEnterpriseStatus;
    }

    public void setCompanyEnterpriseStatus(String companyEnterpriseStatus) {
        this.companyEnterpriseStatus = companyEnterpriseStatus;
    }

    public String getCompanyCompanytype() {
        return companyCompanytype;
    }

    public void setCompanyCompanytype(String companyCompanytype) {
        this.companyCompanytype = companyCompanytype;
    }

    public String getCompanyRegorg() {
        return companyRegorg;
    }

    public void setCompanyRegorg(String companyRegorg) {
        this.companyRegorg = companyRegorg;
    }

    public String getIpoCompany() {
        return ipoCompany;
    }

    public void setIpoCompany(String ipoCompany) {
        this.ipoCompany = ipoCompany;
    }

    public Float getCompanyGisLon() {
        return companyGisLon;
    }

    public void setCompanyGisLon(Float companyGisLon) {
        this.companyGisLon = companyGisLon;
    }

    public Float getCompanyGisLat() {
        return companyGisLat;
    }

    public void setCompanyGisLat(Float companyGisLat) {
        this.companyGisLat = companyGisLat;
    }

    public String getCompanyCounty() {
        return companyCounty;
    }

    public void setCompanyCounty(String companyCounty) {
        this.companyCounty = companyCounty;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public String getShareholderType() {
        return shareholderType;
    }

    public void setShareholderType(String shareholderType) {
        this.shareholderType = shareholderType;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getInvestRatio() {
        return investRatio;
    }

    public void setInvestRatio(String investRatio) {
        this.investRatio = investRatio;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getShareholderDetail() {
        return shareholderDetail;
    }

    public void setShareholderDetail(String shareholderDetail) {
        this.shareholderDetail = shareholderDetail;
    }

    public String getInvestName() {
        return investName;
    }

    public void setInvestName(String investName) {
        this.investName = investName;
    }

    public String getSubscribedCapital() {
        return subscribedCapital;
    }

    public void setSubscribedCapital(String subscribedCapital) {
        this.subscribedCapital = subscribedCapital;
    }

    public String getPaidContribution() {
        return paidContribution;
    }

    public void setPaidContribution(String paidContribution) {
        this.paidContribution = paidContribution;
    }

    public String getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(String shareholderId) {
        this.shareholderId = shareholderId;
    }

    public Integer getNameCompid() {
        return nameCompid;
    }

    public void setNameCompid(Integer nameCompid) {
        this.nameCompid = nameCompid;
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

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }
}
