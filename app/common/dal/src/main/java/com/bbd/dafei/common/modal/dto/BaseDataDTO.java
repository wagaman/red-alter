package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 企业工商数据
 * @author anhong.Tu
 * @version $Id: BaseDataDTO.java, v 0.1 2017/08/04 9:30 anhong.Tu Exp $
 */
public class BaseDataDTO {

    /** 基本信息 */
    @SerializedName("jbxx")
    private Jbxx jbxx;
    /** 分支机构 */
    @SerializedName("fzjg")
    private List<Fzjg> fzjg;
    /** 股东信息 */
    @SerializedName("gdxx")
    private List<Gdxx> gdxx;
    /** 备案信息 */
    @SerializedName("baxx")
    private List<Baxx> baxx;
    /** 行政处罚 */
    @SerializedName("xzcf")
    private List<Xzcf> xzcf;

    public Jbxx getJbxx() {
        return jbxx;
    }

    public void setJbxx(Jbxx jbxx) {
        this.jbxx = jbxx;
    }


    public List<Fzjg> getFzjg() {
        return fzjg;
    }

    public void setFzjg(List<Fzjg> fzjg) {
        this.fzjg = fzjg;
    }

    public List<Gdxx> getGdxx() {
        return gdxx;
    }

    public void setGdxx(List<Gdxx> gdxx) {
        this.gdxx = gdxx;
    }

    public List<Baxx> getBaxx() {
        return baxx;
    }

    public void setBaxx(List<Baxx> baxx) {
        this.baxx = baxx;
    }

    public List<Xzcf> getXzcf() {
        return xzcf;
    }

    public void setXzcf(List<Xzcf> xzcf) {
        this.xzcf = xzcf;
    }

    /**
     * 基本信息
     */
    public static class Jbxx {
        /** 统一社会信用代码 */
        @SerializedName("credit_code")
        private String creditCode;
        /** 注册号 */
        @SerializedName("regno")
        private String regno;
        /** 名称 */
        @SerializedName("company_name")
        private String companyName;
        /** 企业类型 */
        @SerializedName("company_type")
        private String companyType;
        /** 法定代表人 */
        @SerializedName("frname")
        private String frname;
        /** 注册资金 */
        @SerializedName("regcap")
        private String regcap;
        /** 实收资本 */
        @SerializedName("realcap")
        private String realcap;
        /** 成立日期 */
        @SerializedName("esdate")
        private String esdate;
        /** 核准日期 */
        @SerializedName("approval_date")
        private String approvalDate;
        /** 营业期限自 */
        @SerializedName("openfrom")
        private String openfrom;
        /** 营业期限至 */
        @SerializedName("opento")
        private String opento;
        /** 地址 */
        @SerializedName("address")
        private String address;
        /** 经营范围 */
        @SerializedName("operate_scope")
        private String operateScope;
        /** 登记机关 */
        @SerializedName("regorg")
        private String regorg;
        /** 登记状态 */
        @SerializedName("enterprise_status")
        private String enterpriseStatus;
        /** 吊销日期 */
        @SerializedName("revoke_date")
        private String revokeDate;
        /** 派出企业名称 */
        @SerializedName("parent_firm")
        private String parentFirm;
        /** 出资额 */
        @SerializedName("invest_cap")
        private String investCap;
        /** 注册币种 */
        @SerializedName("regcapcur")
        private String regcapcur;
        /** 注销日期 */
        @SerializedName("cancel_date")
        private String cancelDate;
        /** 经营期限 */
        @SerializedName("operating_period")
        private String operatingPeriod;
        /** 组成形式 */
        @SerializedName("form")
        private String form;
        /** 企业唯一ID */
        @SerializedName("bbd_qyxx_id")
        private String bbdQyxxId;
        /** 法定代表人唯一ID */
        @SerializedName("frname_id")
        private String frnameId;
        /** 历名名称 */
        @SerializedName("bbd_history_name")
        private String bbdHistoryName;
        /** 行业分类 */
        @SerializedName("company_industry")
        private String companyIndustry;
        /** 注册资本_金额 */
        @SerializedName("regcap_amount")
        private String regcapAmount;
        /** 注册资本_币种 */
        @SerializedName("regcap_currency")
        private String regcapCurrency;
        /** 实收资本_金额 */
        @SerializedName("realcap_amount")
        private String realcapAmount;
        /** 实收资本_币种 */
        @SerializedName("realcap_currency")
        private String realcapCurrency;
        /** 投资总额_金额 */
        @SerializedName("investcap_amount")
        private String investcapAmount;
        /** 投资总额_币种 */
        @SerializedName("investcap_currency")
        private String investcapCurrency;
        /** 注册币种_映射结果 */
        @SerializedName("company_currency")
        private String companyCurrency;
        /** 省份_映射结果 */
        @SerializedName("company_province")
        private String companyProvince;
        /** 登记状态_映射结果 */
        @SerializedName("company_enterprise_status")
        private String companyEnterpriseStatus;
        /** 企业类型_映射结果 */
        @SerializedName("company_companytype")
        private String companyCompanytype;
        /** 登记机关_映射结果 */
        @SerializedName("company_regorg")
        private String companyRegorg;
        /** 上市公司标识 */
        @SerializedName("ipo_company")
        private String ipoCompany;
        /** GIS数据_经度 */
        @SerializedName("company_gis_lon")
        private String companyGisLon;
        /** GIS数据_纬度 */
        @SerializedName("company_gis_lat")
        private String companyGisLat;
        /** 企业区县 */
        @SerializedName("company_county")
        private String companyCounty;
        /** 股东 */
        @SerializedName("shareholder_name")
        private String shareholderName;
        /** 股东类型 */
        @SerializedName("shareholder_type")
        private String shareholderType;
        /** 证照类型 */
        @SerializedName("idtype")
        private String idtype;
        /** 证照号码 */
        @SerializedName("idno")
        private String idno;
        /** 出资比例 */
        @SerializedName("invest_ratio")
        private String investRatio;
        /** 出资额 */
        @SerializedName("invest_amount")
        private String investAmount;
        /** 股东详情 */
        @SerializedName("shareholder_detail")
        private String shareholderDetail;
        /** 出资方式 */
        @SerializedName("invest_name")
        private String investName;
        /** 认缴出资额 */
        @SerializedName("subscribed_capital")
        private String subscribedCapital;
        /** 实缴出资额 */
        @SerializedName("paid_contribution")
        private String paidContribution;
        /** 股东唯一ID */
        @SerializedName("shareholder_id")
        private String shareholderId;
        /** 股东的类别判断 */
        @SerializedName("name_compid")
        private String nameCompid;

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

        public String getRealcapAmount() {
            return realcapAmount;
        }

        public void setRealcapAmount(String realcapAmount) {
            this.realcapAmount = realcapAmount;
        }

        public String getRealcapCurrency() {
            return realcapCurrency;
        }

        public void setRealcapCurrency(String realcapCurrency) {
            this.realcapCurrency = realcapCurrency;
        }

        public String getInvestcapAmount() {
            return investcapAmount;
        }

        public void setInvestcapAmount(String investcapAmount) {
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

        public String getCompanyGisLon() {
            return companyGisLon;
        }

        public void setCompanyGisLon(String companyGisLon) {
            this.companyGisLon = companyGisLon;
        }

        public String getCompanyGisLat() {
            return companyGisLat;
        }

        public void setCompanyGisLat(String companyGisLat) {
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

        public String getNameCompid() {
            return nameCompid;
        }

        public void setNameCompid(String nameCompid) {
            this.nameCompid = nameCompid;
        }
    }

    /**
     * 分支机构
     */
    public static class Fzjg {
        /** 注册号 */
        @SerializedName("regno")
        private String regno;
        /** 序号 */
        @SerializedName("no")
        private String no;
        /** 企业唯一ID */
        @SerializedName("bbd_qyxx_id")
        private String bbdQyxxId;
        /** 名称 */
        @SerializedName("company_name")
        private String companyName;
        /** 分支机构名称 */
        @SerializedName("name")
        private String name;
        /** 注册号/统一社会信用代码 */
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;

        public String getRegno() {
            return regno;
        }

        public void setRegno(String regno) {
            this.regno = regno;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getBbdQyxxId() {
            return bbdQyxxId;
        }

        public void setBbdQyxxId(String bbdQyxxId) {
            this.bbdQyxxId = bbdQyxxId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }
    }

    /**
     * 股东信息
     */
    public static class Gdxx {
        /** 股东 */
        @SerializedName("shareholder_name")
        private String shareholderName;
        /** 股东类型 */
        @SerializedName("shareholder_type")
        private String shareholderType;
        /** 证照类型 */
        @SerializedName("idtype")
        private String idtype;
        /** 证照号码 */
        @SerializedName("idno")
        private String idno;
        /** 出资比例 */
        @SerializedName("invest_ratio")
        private String investRatio;
        /** 出资额 */
        @SerializedName("invest_amount")
        private String investAmount;
        /** 股东详情 */
        @SerializedName("shareholder_detail")
        private String shareholderDetail;
        /** 出资方式 */
        @SerializedName("invest_name")
        private String investName;
        /** 认缴出资额 */
        @SerializedName("subscribed_capital")
        private String subscribedCapital;
        /** 实缴出资额 */
        @SerializedName("paid_contribution")
        private String paidContribution;
        /** 股东唯一ID */
        @SerializedName("shareholder_id")
        private String shareholderId;
        /** 股东的类别判断 */
        @SerializedName("name_compid")
        private String nameCompid;

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

        public String getNameCompid() {
            return nameCompid;
        }

        public void setNameCompid(String nameCompid) {
            this.nameCompid = nameCompid;
        }
    }

    /**
     * 备案信息
     */
    public static class Baxx {
        public static final String TYPE_EXECUTIVE = "executive";//高管
        public static final String TYPE_DIRECTOR = "director";//董事
        public static final String TYPE_SUPERVISOR = "supervisor";//监事

        /** 姓名 */
        @SerializedName("name")
        private String name;
        /** 职务 */
        @SerializedName("position")
        private String position;
        /** 证照类型 */
        @SerializedName("idtype")
        private String idtype;
        /** 证照号码 */
        @SerializedName("idno")
        private String idno;
        /** 职务类型 */
        @SerializedName("type")
        private String type;
        /** 性别 */
        @SerializedName("sex")
        private String sex;
        /** 任职起始（上市公司） */
        @SerializedName("asstarting")
        private String asstarting;
        /** 薪酬（上市公司） */
        @SerializedName("salary")
        private String salary;
        /** 简历（上市公司） */
        @SerializedName("resume")
        private String resume;
        /** 自然人唯一ID */
        @SerializedName("name_id")
        private String nameId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAsstarting() {
            return asstarting;
        }

        public void setAsstarting(String asstarting) {
            this.asstarting = asstarting;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public String getNameId() {
            return nameId;
        }

        public void setNameId(String nameId) {
            this.nameId = nameId;
        }
    }

    /**
     * 行政处罚
     */
    public static class Xzcf{
        /** 序号 */
        @SerializedName("no")
        private String no;
        /** 作出行政处罚决定机关名称 */
        @SerializedName("punish_org")
        private String punishOrg;
        /** 行政处罚决定书文号 */
        @SerializedName("punish_code")
        private String punishCode;
        /** 作出行政处罚决定日期 */
        @SerializedName("punish_date")
        private String punishDate;
        /** 注册号/统一社会信用代码 */
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        /** 行政处罚内容 */
        @SerializedName("punish_content")
        private String punishContent;
        /** 违法行为类型 */
        @SerializedName("punish_type")
        private String punishType;
        /** 企业唯一ID */
        @SerializedName("bbd_qyxx_id")
        private String bbdQyxxId;
        /** 注册号 */
        @SerializedName("company_name")
        private String companyName;
        /** 名称 */
        @SerializedName("name")
        private String name;
        /** 作出行政处罚决定日期 */
        @SerializedName("public_date")
        private String publicDate;
        /** 法定代表人 */
        @SerializedName("frname")
        private String frname;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getPunishOrg() {
            return punishOrg;
        }

        public void setPunishOrg(String punishOrg) {
            this.punishOrg = punishOrg;
        }

        public String getPunishCode() {
            return punishCode;
        }

        public void setPunishCode(String punishCode) {
            this.punishCode = punishCode;
        }

        public String getPunishDate() {
            return punishDate;
        }

        public void setPunishDate(String punishDate) {
            this.punishDate = punishDate;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getPunishContent() {
            return punishContent;
        }

        public void setPunishContent(String punishContent) {
            this.punishContent = punishContent;
        }

        public String getPunishType() {
            return punishType;
        }

        public void setPunishType(String punishType) {
            this.punishType = punishType;
        }

        public String getBbdQyxxId() {
            return bbdQyxxId;
        }

        public void setBbdQyxxId(String bbdQyxxId) {
            this.bbdQyxxId = bbdQyxxId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPublicDate() {
            return publicDate;
        }

        public void setPublicDate(String publicDate) {
            this.publicDate = publicDate;
        }

        public String getFrname() {
            return frname;
        }

        public void setFrname(String frname) {
            this.frname = frname;
        }
    }
}
