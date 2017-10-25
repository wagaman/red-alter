package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/4/21.
 */
@ApiModel("工商数据")
public class BaseDataVO {

    @ApiModelProperty(value = "基本信息")
    private Jbxx jbxx;
    @ApiModelProperty(value = "股东信息")
    private List<Gdxx> gdxx;
    @ApiModelProperty(value = "高管")
    private List<Baxx> executives;
    @ApiModelProperty(value = "董事")
    private List<Baxx> directors;
    @ApiModelProperty(value = "监事")
    private List<Baxx> supervisors;
    @ApiModelProperty(value = "行政处罚")
    private List<Xzcf> xzcf;

    public Jbxx getJbxx() {
        return jbxx;
    }

    public void setJbxx(Jbxx jbxx) {
        this.jbxx = jbxx;
    }

    public List<Gdxx> getGdxx() {
        return gdxx;
    }

    public void setGdxx(List<Gdxx> gdxx) {
        this.gdxx = gdxx;
    }

    public List<Baxx> getExecutives() {
        return executives;
    }

    public void setExecutives(List<Baxx> executives) {
        this.executives = executives;
    }

    public List<Baxx> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Baxx> directors) {
        this.directors = directors;
    }

    public List<Baxx> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Baxx> supervisors) {
        this.supervisors = supervisors;
    }

    public List<Xzcf> getXzcf() {
        return xzcf;
    }

    public void setXzcf(List<Xzcf> xzcf) {
        this.xzcf = xzcf;
    }

    @ApiModel(value = "基本信息")
    public static class Jbxx {
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
        private String regcapAmount;
        @ApiModelProperty(value = "注册资本_币种")
        private String regcapCurrency;
        @ApiModelProperty(value = "实收资本_金额")
        private String realcapAmount;
        @ApiModelProperty(value = "实收资本_币种")
        private String realcapCurrency;
        @ApiModelProperty(value = "投资总额_金额")
        private String investcapAmount;
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
        private String companyGisLon;
        @ApiModelProperty(value = "GIS数据_纬度")
        private String companyGisLat;
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
        private String nameCompid;
        @ApiModelProperty(value = "组织机构代码")
        private String jgdm;

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

        public String getJgdm() {
            return jgdm;
        }

        public void setJgdm(String jgdm) {
            this.jgdm = jgdm;
        }
    }

    @ApiModel(value = "股东信息")
    public static class Gdxx {
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

    @ApiModel(value = "备案信息")
    public static class Baxx {

        public static final String TYPE_EXECUTIVE = "executive";//高管
        public static final String TYPE_DIRECTOR = "director";//董事
        public static final String TYPE_SUPERVISOR = "supervisor";//监事

        @ApiModelProperty(value = "姓名")
        private String name;
        @ApiModelProperty(value = "职务")
        private String position;
        @ApiModelProperty(value = "证照类型")
        private String idtype;
        @ApiModelProperty(value = "证照号码")
        private String idno;
        @ApiModelProperty(value = "职务类型")
        private String type;
        @ApiModelProperty(value = "性别")
        private String sex;
        @ApiModelProperty(value = "任职起始（上市公司）")
        private String asstarting;
        @ApiModelProperty(value = "薪酬（上市公司）")
        private String salary;
        @ApiModelProperty(value = "简历（上市公司）")
        private String resume;
        @ApiModelProperty(value = "自然人唯一ID")
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

    @ApiModel("行政处罚")
    public static class Xzcf {
        @ApiModelProperty(value = "序号")
        private String no;
        @ApiModelProperty(value = "作出行政处罚决定机关名称")
        private String punishOrg;
        @ApiModelProperty(value = "行政处罚决定书文号")
        private String punishCode;
        @ApiModelProperty(value = "作出行政处罚决定日期")
        private String punishDate;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "行政处罚内容")
        private String punishContent;
        @ApiModelProperty(value = "违法行为类型")
        private String punishType;
        @ApiModelProperty(value = "企业唯一ID")
        private String bbdQyxxId;
        @ApiModelProperty(value = "注册号")
        private String companyName;
        @ApiModelProperty(value = "名称")
        private String name;
        @ApiModelProperty(value = "作出行政处罚决定日期")
        private String publicDate;
        @ApiModelProperty(value = "法定代表人")
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