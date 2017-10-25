package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/4/19.
 */
@ApiModel(value = "年报")
public class YearReportVO {
    @ApiModelProperty(value = "年报年度")
    private String year;
    @ApiModelProperty(value = "年报基本信息")
    private List<Jbxx> qyxxNbJbxx;
    @ApiModelProperty(value = "年报修改信息")
    private List<Xgxx> qyxxNbXgxx;
    @ApiModelProperty(value = "年报对外投资")
    private List<Tzxx> qyxxNbTzxx;
    @ApiModelProperty(value = "年报股权变更信息")
    private List<Bgxx> qyxxNbBgxx;
    @ApiModelProperty(value = "年报对外提供担保信息")
    private List<Dbxx> qyxxNbDbxx;
    @ApiModelProperty(value = "年报分支机构")
    private List<Fzjg> qyxxNbFzjg;
    @ApiModelProperty(value = "年报行政许可")
    private List<Xzxk> qyxxNbXzxk;
    @ApiModelProperty(value = "年报更正声明")
    private List<Gzsm> qyxxNbGzsm;
    @ApiModelProperty(value = "年报股东及出资")
    private List<Czxx> qyxxNbCzxx;
    @ApiModelProperty(value = "年报网站或者网店")
    private List<Wzxx> qyxxNbWzxx;
    @ApiModelProperty(value = "年报资产状况")
    private List<Zcxx> qyxxNbZcxx;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Jbxx> getQyxxNbJbxx() {
        return qyxxNbJbxx;
    }

    public void setQyxxNbJbxx(List<Jbxx> qyxxNbJbxx) {
        this.qyxxNbJbxx = qyxxNbJbxx;
    }

    public List<Xgxx> getQyxxNbXgxx() {
        return qyxxNbXgxx;
    }

    public void setQyxxNbXgxx(List<Xgxx> qyxxNbXgxx) {
        this.qyxxNbXgxx = qyxxNbXgxx;
    }

    public List<Tzxx> getQyxxNbTzxx() {
        return qyxxNbTzxx;
    }

    public void setQyxxNbTzxx(List<Tzxx> qyxxNbTzxx) {
        this.qyxxNbTzxx = qyxxNbTzxx;
    }

    public List<Bgxx> getQyxxNbBgxx() {
        return qyxxNbBgxx;
    }

    public void setQyxxNbBgxx(List<Bgxx> qyxxNbBgxx) {
        this.qyxxNbBgxx = qyxxNbBgxx;
    }

    public List<Dbxx> getQyxxNbDbxx() {
        return qyxxNbDbxx;
    }

    public void setQyxxNbDbxx(List<Dbxx> qyxxNbDbxx) {
        this.qyxxNbDbxx = qyxxNbDbxx;
    }

    public List<Fzjg> getQyxxNbFzjg() {
        return qyxxNbFzjg;
    }

    public void setQyxxNbFzjg(List<Fzjg> qyxxNbFzjg) {
        this.qyxxNbFzjg = qyxxNbFzjg;
    }

    public List<Xzxk> getQyxxNbXzxk() {
        return qyxxNbXzxk;
    }

    public void setQyxxNbXzxk(List<Xzxk> qyxxNbXzxk) {
        this.qyxxNbXzxk = qyxxNbXzxk;
    }

    public List<Gzsm> getQyxxNbGzsm() {
        return qyxxNbGzsm;
    }

    public void setQyxxNbGzsm(List<Gzsm> qyxxNbGzsm) {
        this.qyxxNbGzsm = qyxxNbGzsm;
    }

    public List<Czxx> getQyxxNbCzxx() {
        return qyxxNbCzxx;
    }

    public void setQyxxNbCzxx(List<Czxx> qyxxNbCzxx) {
        this.qyxxNbCzxx = qyxxNbCzxx;
    }

    public List<Wzxx> getQyxxNbWzxx() {
        return qyxxNbWzxx;
    }

    public void setQyxxNbWzxx(List<Wzxx> qyxxNbWzxx) {
        this.qyxxNbWzxx = qyxxNbWzxx;
    }

    public List<Zcxx> getQyxxNbZcxx() {
        return qyxxNbZcxx;
    }

    public void setQyxxNbZcxx(List<Zcxx> qyxxNbZcxx) {
        this.qyxxNbZcxx = qyxxNbZcxx;
    }

    @ApiModel(value = "年报基本信息")
    public static class Jbxx {
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "联系电话")
        private String phone;
        @ApiModelProperty(value = "从业人数")
        private String staffNum;
        @ApiModelProperty(value = "企业名称")
        private String name;
        @ApiModelProperty(value = "邮政编码")
        private String postalcode;
        @ApiModelProperty(value = "通信地址")
        private String address;
        @ApiModelProperty(value = "经营状态")
        private String enterpriseStatus;
        @ApiModelProperty(value = "有限责任公司本年度是否发生股东股权转让")
        private String stockTransferFlag;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoCreditcode;
        @ApiModelProperty(value = "企业是否有投资信息或购买其他公司股权")
        private String stockBuyFlag;
        @ApiModelProperty(value = "是否有网站或网店")
        private String websiteFlag;
        @ApiModelProperty(value = "电子邮箱")
        private String email;
        @ApiModelProperty(value = "是否对外担保")
        private String externalSecurityFlag;
        @ApiModelProperty(value = "隶属关系")
        private String subordinateRelations;
        @ApiModelProperty(value = "资金数额")
        private String moneyNum;
        @ApiModelProperty(value = "隶属名称")
        private String subordinateName;
        @ApiModelProperty(value = "主体类型")
        private String companyType;
        @ApiModelProperty(value = "是否有行政许可信息")
        private String adminLicenseFlag;
        @ApiModelProperty(value = "年报备注")
        private String nbbz;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStaffNum() {
            return staffNum;
        }

        public void setStaffNum(String staffNum) {
            this.staffNum = staffNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPostalcode() {
            return postalcode;
        }

        public void setPostalcode(String postalcode) {
            this.postalcode = postalcode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEnterpriseStatus() {
            return enterpriseStatus;
        }

        public void setEnterpriseStatus(String enterpriseStatus) {
            this.enterpriseStatus = enterpriseStatus;
        }

        public String getStockTransferFlag() {
            return stockTransferFlag;
        }

        public void setStockTransferFlag(String stockTransferFlag) {
            this.stockTransferFlag = stockTransferFlag;
        }

        public String getRegnoCreditcode() {
            return regnoCreditcode;
        }

        public void setRegnoCreditcode(String regnoCreditcode) {
            this.regnoCreditcode = regnoCreditcode;
        }

        public String getStockBuyFlag() {
            return stockBuyFlag;
        }

        public void setStockBuyFlag(String stockBuyFlag) {
            this.stockBuyFlag = stockBuyFlag;
        }

        public String getWebsiteFlag() {
            return websiteFlag;
        }

        public void setWebsiteFlag(String websiteFlag) {
            this.websiteFlag = websiteFlag;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getExternalSecurityFlag() {
            return externalSecurityFlag;
        }

        public void setExternalSecurityFlag(String externalSecurityFlag) {
            this.externalSecurityFlag = externalSecurityFlag;
        }

        public String getSubordinateRelations() {
            return subordinateRelations;
        }

        public void setSubordinateRelations(String subordinateRelations) {
            this.subordinateRelations = subordinateRelations;
        }

        public String getMoneyNum() {
            return moneyNum;
        }

        public void setMoneyNum(String moneyNum) {
            this.moneyNum = moneyNum;
        }

        public String getSubordinateName() {
            return subordinateName;
        }

        public void setSubordinateName(String subordinateName) {
            this.subordinateName = subordinateName;
        }

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        public String getAdminLicenseFlag() {
            return adminLicenseFlag;
        }

        public void setAdminLicenseFlag(String adminLicenseFlag) {
            this.adminLicenseFlag = adminLicenseFlag;
        }

        public String getNbbz() {
            return nbbz;
        }

        public void setNbbz(String nbbz) {
            this.nbbz = nbbz;
        }
    }

    @ApiModel(value = "年报修改信息")
    public static class Xgxx {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "修改事项")
        private String amendItems;
        @ApiModelProperty(value = "修改日期")
        private String amendDate;
        @ApiModelProperty(value = "修改后")
        private String contentAfterAmend;
        @ApiModelProperty(value = "修改前")
        private String contentBeforeAmend;
        @ApiModelProperty(value = "投资设立企业或购买股权企业名称")
        private String name;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoCreditcode;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getAmendItems() {
            return amendItems;
        }

        public void setAmendItems(String amendItems) {
            this.amendItems = amendItems;
        }

        public String getAmendDate() {
            return amendDate;
        }

        public void setAmendDate(String amendDate) {
            this.amendDate = amendDate;
        }

        public String getContentAfterAmend() {
            return contentAfterAmend;
        }

        public void setContentAfterAmend(String contentAfterAmend) {
            this.contentAfterAmend = contentAfterAmend;
        }

        public String getContentBeforeAmend() {
            return contentBeforeAmend;
        }

        public void setContentBeforeAmend(String contentBeforeAmend) {
            this.contentBeforeAmend = contentBeforeAmend;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegnoCreditcode() {
            return regnoCreditcode;
        }

        public void setRegnoCreditcode(String regnoCreditcode) {
            this.regnoCreditcode = regnoCreditcode;
        }
    }

    @ApiModel(value = "年报对外投资")
    public static class Tzxx {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "投资设立企业或购买股权企业名称")
        private String name;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoCreditcode;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegnoCreditcode() {
            return regnoCreditcode;
        }

        public void setRegnoCreditcode(String regnoCreditcode) {
            this.regnoCreditcode = regnoCreditcode;
        }
    }

    @ApiModel(value = "年报股权变更信息")
    public static class Bgxx {
        @ApiModelProperty(value = "comments")
        private String fieldName;
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "股权变更日期")
        private String changeDate;
        @ApiModelProperty(value = "变更后股权比例")
        private String contentAfterChange;
        @ApiModelProperty(value = "变更前股权比例")
        private String contentBeforeChange;
        @ApiModelProperty(value = "股东")
        private String shareholderName;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getChangeDate() {
            return changeDate;
        }

        public void setChangeDate(String changeDate) {
            this.changeDate = changeDate;
        }

        public String getContentAfterChange() {
            return contentAfterChange;
        }

        public void setContentAfterChange(String contentAfterChange) {
            this.contentAfterChange = contentAfterChange;
        }

        public String getContentBeforeChange() {
            return contentBeforeChange;
        }

        public void setContentBeforeChange(String contentBeforeChange) {
            this.contentBeforeChange = contentBeforeChange;
        }

        public String getShareholderName() {
            return shareholderName;
        }

        public void setShareholderName(String shareholderName) {
            this.shareholderName = shareholderName;
        }
    }

    @ApiModel(value = "年报对外提供担保信息")
    public static class Dbxx {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "债权人")
        private String creditor;
        @ApiModelProperty(value = "债务人")
        private String debtor;
        @ApiModelProperty(value = "主债权种类")
        private String creditorType;
        @ApiModelProperty(value = "主债权数额")
        private String creditorNum;
        @ApiModelProperty(value = "履行债务的期限")
        private String debtDeadline;
        @ApiModelProperty(value = "保证的期间")
        private String guaranteePeriod;
        @ApiModelProperty(value = "保证的方式")
        private String guaranteeType;
        @ApiModelProperty(value = "保证担保的范围")
        private String guaranteeScope;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getCreditor() {
            return creditor;
        }

        public void setCreditor(String creditor) {
            this.creditor = creditor;
        }

        public String getDebtor() {
            return debtor;
        }

        public void setDebtor(String debtor) {
            this.debtor = debtor;
        }

        public String getCreditorType() {
            return creditorType;
        }

        public void setCreditorType(String creditorType) {
            this.creditorType = creditorType;
        }

        public String getCreditorNum() {
            return creditorNum;
        }

        public void setCreditorNum(String creditorNum) {
            this.creditorNum = creditorNum;
        }

        public String getDebtDeadline() {
            return debtDeadline;
        }

        public void setDebtDeadline(String debtDeadline) {
            this.debtDeadline = debtDeadline;
        }

        public String getGuaranteePeriod() {
            return guaranteePeriod;
        }

        public void setGuaranteePeriod(String guaranteePeriod) {
            this.guaranteePeriod = guaranteePeriod;
        }

        public String getGuaranteeType() {
            return guaranteeType;
        }

        public void setGuaranteeType(String guaranteeType) {
            this.guaranteeType = guaranteeType;
        }

        public String getGuaranteeScope() {
            return guaranteeScope;
        }

        public void setGuaranteeScope(String guaranteeScope) {
            this.guaranteeScope = guaranteeScope;
        }
    }

    @ApiModel(value = "年报分支机构")
    public static class Fzjg {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "分支机构名称")
        private String name;
        @ApiModelProperty(value = "分支机构注册号/统一社会信用代码")
        private String regnoCreditcode;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegnoCreditcode() {
            return regnoCreditcode;
        }

        public void setRegnoCreditcode(String regnoCreditcode) {
            this.regnoCreditcode = regnoCreditcode;
        }
    }

    @ApiModel(value = "年报行政许可")
    public static class Xzxk {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "许可文件名称")
        private String licenseFileName;
        @ApiModelProperty(value = "有效期至")
        private String validDate;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getLicenseFileName() {
            return licenseFileName;
        }

        public void setLicenseFileName(String licenseFileName) {
            this.licenseFileName = licenseFileName;
        }

        public String getValidDate() {
            return validDate;
        }

        public void setValidDate(String validDate) {
            this.validDate = validDate;
        }
    }

    @ApiModel(value = "年报更正声明")
    public static class Gzsm {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "更正事项")
        private String gzsmContent;
        @ApiModelProperty(value = "更正理由")
        private String gzsmReason;
        @ApiModelProperty(value = "更正时间")
        private String gzsmDate;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getGzsmContent() {
            return gzsmContent;
        }

        public void setGzsmContent(String gzsmContent) {
            this.gzsmContent = gzsmContent;
        }

        public String getGzsmReason() {
            return gzsmReason;
        }

        public void setGzsmReason(String gzsmReason) {
            this.gzsmReason = gzsmReason;
        }

        public String getGzsmDate() {
            return gzsmDate;
        }

        public void setGzsmDate(String gzsmDate) {
            this.gzsmDate = gzsmDate;
        }
    }

    @ApiModel(value = "年报股东及出资")
    public static class Czxx {
        @ApiModelProperty(value = "认缴出资时间")
        private String subscribedDate;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "认缴出资方式")
        private String subscribedType;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "实缴出资时间")
        private String paidinDate;
        @ApiModelProperty(value = "认缴出资额(万元)")
        private String subscribedCapital;
        @ApiModelProperty(value = "实缴出资方式")
        private String paidinType;
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "实缴出资额(万元)")
        private String paidinCapital;
        @ApiModelProperty(value = "股东")
        private String shareholderName;

        public String getSubscribedDate() {
            return subscribedDate;
        }

        public void setSubscribedDate(String subscribedDate) {
            this.subscribedDate = subscribedDate;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getSubscribedType() {
            return subscribedType;
        }

        public void setSubscribedType(String subscribedType) {
            this.subscribedType = subscribedType;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getPaidinDate() {
            return paidinDate;
        }

        public void setPaidinDate(String paidinDate) {
            this.paidinDate = paidinDate;
        }

        public String getSubscribedCapital() {
            return subscribedCapital;
        }

        public void setSubscribedCapital(String subscribedCapital) {
            this.subscribedCapital = subscribedCapital;
        }

        public String getPaidinType() {
            return paidinType;
        }

        public void setPaidinType(String paidinType) {
            this.paidinType = paidinType;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getPaidinCapital() {
            return paidinCapital;
        }

        public void setPaidinCapital(String paidinCapital) {
            this.paidinCapital = paidinCapital;
        }

        public String getShareholderName() {
            return shareholderName;
        }

        public void setShareholderName(String shareholderName) {
            this.shareholderName = shareholderName;
        }
    }

    @ApiModel(value = "年报网站或者网店")
    public static class Wzxx {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "类型")
        private String type;
        @ApiModelProperty(value = "名称")
        private String name;
        @ApiModelProperty(value = "网址")
        private String website;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }
    }

    @ApiModel(value = "年报资产状况")
    public static class Zcxx {
        @ApiModelProperty(value = "公司名称")
        private String companyName;
        @ApiModelProperty(value = "注册号/统一社会信用代码")
        private String regnoOrCreditcode;
        @ApiModelProperty(value = "年报年度")
        private String year;
        @ApiModelProperty(value = "资产总额")
        private String assetsTotal;
        @ApiModelProperty(value = "所有者权益合计")
        private String equityTotal;
        @ApiModelProperty(value = "利润总额")
        private String profitTotal;
        @ApiModelProperty(value = "净利润")
        private String profitNet;
        @ApiModelProperty(value = "负债总额")
        private String liabilitiesTotal;
        @ApiModelProperty(value = "纳税总额")
        private String taxTotal;
        @ApiModelProperty(value = "主营业务收入")
        private String mainBusinessIncome;
        @ApiModelProperty(value = "营业总收入")
        private String totalBusinessIncome;
        @ApiModelProperty(value = "企业应安置残疾人员数")
        private String shouldDisabilitiesNum;
        @ApiModelProperty(value = "从业人员中属于残疾人")
        private String totalDisabilitiesNum;
        @ApiModelProperty(value = "企业已安置残疾人员数")
        private String actualDisabilitiesNum;
        @ApiModelProperty(value = "2015年是否依法交纳残保金")
        private String prig2015Flag;
        @ApiModelProperty(value = "2014年是否依法交纳残保金")
        private String prig2014Flag;
        @ApiModelProperty(value = "2013年是否依法交纳残保金")
        private String prig2013Flag;
        @ApiModelProperty(value = "年是否依法交纳残保金")
        private String prigFlag;
        @ApiModelProperty(value = "金融贷款")
        private String financialLoans;
        @ApiModelProperty(value = "盈余总额")
        private String surplusTotal;
        @ApiModelProperty(value = "获得政府扶持资金、补助")
        private String accessGovernmentInfo;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRegnoOrCreditcode() {
            return regnoOrCreditcode;
        }

        public void setRegnoOrCreditcode(String regnoOrCreditcode) {
            this.regnoOrCreditcode = regnoOrCreditcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getAssetsTotal() {
            return assetsTotal;
        }

        public void setAssetsTotal(String assetsTotal) {
            this.assetsTotal = assetsTotal;
        }

        public String getEquityTotal() {
            return equityTotal;
        }

        public void setEquityTotal(String equityTotal) {
            this.equityTotal = equityTotal;
        }

        public String getProfitTotal() {
            return profitTotal;
        }

        public void setProfitTotal(String profitTotal) {
            this.profitTotal = profitTotal;
        }

        public String getProfitNet() {
            return profitNet;
        }

        public void setProfitNet(String profitNet) {
            this.profitNet = profitNet;
        }

        public String getLiabilitiesTotal() {
            return liabilitiesTotal;
        }

        public void setLiabilitiesTotal(String liabilitiesTotal) {
            this.liabilitiesTotal = liabilitiesTotal;
        }

        public String getTaxTotal() {
            return taxTotal;
        }

        public void setTaxTotal(String taxTotal) {
            this.taxTotal = taxTotal;
        }

        public String getMainBusinessIncome() {
            return mainBusinessIncome;
        }

        public void setMainBusinessIncome(String mainBusinessIncome) {
            this.mainBusinessIncome = mainBusinessIncome;
        }

        public String getTotalBusinessIncome() {
            return totalBusinessIncome;
        }

        public void setTotalBusinessIncome(String totalBusinessIncome) {
            this.totalBusinessIncome = totalBusinessIncome;
        }

        public String getShouldDisabilitiesNum() {
            return shouldDisabilitiesNum;
        }

        public void setShouldDisabilitiesNum(String shouldDisabilitiesNum) {
            this.shouldDisabilitiesNum = shouldDisabilitiesNum;
        }

        public String getTotalDisabilitiesNum() {
            return totalDisabilitiesNum;
        }

        public void setTotalDisabilitiesNum(String totalDisabilitiesNum) {
            this.totalDisabilitiesNum = totalDisabilitiesNum;
        }

        public String getActualDisabilitiesNum() {
            return actualDisabilitiesNum;
        }

        public void setActualDisabilitiesNum(String actualDisabilitiesNum) {
            this.actualDisabilitiesNum = actualDisabilitiesNum;
        }

        public String getPrig2015Flag() {
            return prig2015Flag;
        }

        public void setPrig2015Flag(String prig2015Flag) {
            this.prig2015Flag = prig2015Flag;
        }

        public String getPrig2014Flag() {
            return prig2014Flag;
        }

        public void setPrig2014Flag(String prig2014Flag) {
            this.prig2014Flag = prig2014Flag;
        }

        public String getPrig2013Flag() {
            return prig2013Flag;
        }

        public void setPrig2013Flag(String prig2013Flag) {
            this.prig2013Flag = prig2013Flag;
        }

        public String getPrigFlag() {
            return prigFlag;
        }

        public void setPrigFlag(String prigFlag) {
            this.prigFlag = prigFlag;
        }

        public String getFinancialLoans() {
            return financialLoans;
        }

        public void setFinancialLoans(String financialLoans) {
            this.financialLoans = financialLoans;
        }

        public String getSurplusTotal() {
            return surplusTotal;
        }

        public void setSurplusTotal(String surplusTotal) {
            this.surplusTotal = surplusTotal;
        }

        public String getAccessGovernmentInfo() {
            return accessGovernmentInfo;
        }

        public void setAccessGovernmentInfo(String accessGovernmentInfo) {
            this.accessGovernmentInfo = accessGovernmentInfo;
        }
    }

}
