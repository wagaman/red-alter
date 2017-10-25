package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wish on 2017/4/19.
 */
public class YearReportDTO {
    @SerializedName("qyxx_nb_jbxx")
    private List<Jbxx> qyxxNbJbxx;
    @SerializedName("qyxx_nb_xgxx")
    private List<Xgxx> qyxxNbXgxx;
    @SerializedName("qyxx_nb_tzxx")
    private List<Tzxx> qyxxNbTzxx;
    @SerializedName("qyxx_nb_bgxx")
    private List<Bgxx> qyxxNbBgxx;
    @SerializedName("qyxx_nb_dbxx")
    private List<Dbxx> qyxxNbDbxx;
    @SerializedName("qyxx_nb_fzjg")
    private List<Fzjg> qyxxNbFzjg;
    @SerializedName("qyxx_nb_xzxk")
    private List<Xzxk> qyxxNbXzxk;
    @SerializedName("qyxx_nb_gzsm")
    private List<Gzsm> qyxxNbGzsm;
    @SerializedName("qyxx_nb_czxx")
    private List<Czxx> qyxxNbCzxx;
    @SerializedName("qyxx_nb_wzxx")
    private List<Wzxx> qyxxNbWzxx;
    @SerializedName("qyxx_nb_zcxx")
    private List<Zcxx> qyxxNbZcxx;

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

    public static class Jbxx {
        @SerializedName("year")
        private String year;
        @SerializedName("phone")
        private String phone;
        @SerializedName("staff_num")
        private String staffNum;
        @SerializedName("name")
        private String name;
        @SerializedName("postalcode")
        private String postalcode;
        @SerializedName("address")
        private String address;
        @SerializedName("enterprise_status")
        private String enterpriseStatus;
        @SerializedName("stock_transfer_flag")
        private String stockTransferFlag;
        @SerializedName("regno_creditcode")
        private String regnoCreditcode;
        @SerializedName("stock_buy_flag")
        private String stockBuyFlag;
        @SerializedName("website_flag")
        private String websiteFlag;
        @SerializedName("email")
        private String email;
        @SerializedName("external_security_flag")
        private String externalSecurityFlag;
        @SerializedName("subordinate_relations")
        private String subordinateRelations;
        @SerializedName("money_num")
        private String moneyNum;
        @SerializedName("subordinate_name")
        private String subordinateName;
        @SerializedName("company_type")
        private String companyType;
        @SerializedName("admin_license_flag")
        private String adminLicenseFlag;
        @SerializedName("nbbz")
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

    public static class Xgxx{
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("amend_items")
        private String amendItems;
        @SerializedName("amend_date")
        private String amendDate;
        @SerializedName("content_after_amend")
        private String contentAfterAmend;
        @SerializedName("content_before_amend")
        private String contentBeforeAmend;
        @SerializedName("name")
        private String name;
        @SerializedName("regno_creditcode")
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

    public static class Tzxx {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("name")
        private String name;
        @SerializedName("regno_creditcode")
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

    public static class Bgxx {
        @SerializedName("field_name")
        private String fieldName;
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("change_date")
        private String changeDate;
        @SerializedName("content_after_change")
        private String contentAfterChange;
        @SerializedName("content_before_change")
        private String contentBeforeChange;
        @SerializedName("shareholder_name")
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

    public static class Dbxx {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("creditor")
        private String creditor;
        @SerializedName("debtor")
        private String debtor;
        @SerializedName("creditor_type")
        private String creditorType;
        @SerializedName("creditor_num")
        private String creditorNum;
        @SerializedName("debt_deadline")
        private String debtDeadline;
        @SerializedName("guarantee_period")
        private String guaranteePeriod;
        @SerializedName("guarantee_type")
        private String guaranteeType;
        @SerializedName("guarantee_scope")
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

    public static class Fzjg {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("name")
        private String name;
        @SerializedName("regno_creditcode")
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

    public static class Xzxk {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("license_file_name")
        private String licenseFileName;
        @SerializedName("valid_date")
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

    public static class Gzsm {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("gzsm.content")
        private String gzsmContent;
        @SerializedName("gzsm.reason")
        private String gzsmReason;
        @SerializedName("gzsm.date")
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

    public static class Czxx {
        @SerializedName("subscribed_date")
        private String subscribedDate;
        @SerializedName("year")
        private String year;
        @SerializedName("subscribed_type")
        private String subscribedType;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("paidin_date")
        private String paidinDate;
        @SerializedName("subscribed_capital")
        private String subscribedCapital;
        @SerializedName("paidin_type")
        private String paidinType;
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("paidin_capital")
        private String paidinCapital;
        @SerializedName("shareholder_name")
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

    public static class Wzxx {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("type")
        private String type;
        @SerializedName("name")
        private String name;
        @SerializedName("website")
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

    public static class Zcxx {
        @SerializedName("company_name")
        private String companyName;
        @SerializedName("regno_or_creditcode")
        private String regnoOrCreditcode;
        @SerializedName("year")
        private String year;
        @SerializedName("assets_total")
        private String assetsTotal;
        @SerializedName("equity_total")
        private String equityTotal;
        @SerializedName("profit_total")
        private String profitTotal;
        @SerializedName("profit_net")
        private String profitNet;
        @SerializedName("liabilities_total")
        private String liabilitiesTotal;
        @SerializedName("tax_total")
        private String taxTotal;
        @SerializedName("main_business_income")
        private String mainBusinessIncome;
        @SerializedName("total_business_income")
        private String totalBusinessIncome;
        @SerializedName("should_disabilities_num")
        private String shouldDisabilitiesNum;
        @SerializedName("total_disabilities_num")
        private String totalDisabilitiesNum;
        @SerializedName("actual_disabilities_num")
        private String actualDisabilitiesNum;
        @SerializedName("prig_2015_flag")
        private String prig2015Flag;
        @SerializedName("prig_2014_flag")
        private String prig2014Flag;
        @SerializedName("prig_2013_flag")
        private String prig2013Flag;
        @SerializedName("prig_flag")
        private String prigFlag;
        @SerializedName("financial_loans")
        private String financialLoans;
        @SerializedName("surplus_total")
        private String surplusTotal;
        @SerializedName("access_government_info")
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
