package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/5/4.
 */
@ApiModel(value = "网贷之家数据")
public class WdzjDTO {
    @ApiModelProperty(value = "注册资本")
    @SerializedName("regcap")
    private String regcap;
    @ApiModelProperty(value = "平台状态")
    @SerializedName("platform_state")
    private String platformState;
    @ApiModelProperty(value = "注册地点")
    @SerializedName("city")
    private String city;
    @ApiModelProperty(value = "所属公司")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "上线时间")
    @SerializedName("onlinetime")
    private String onlinetime;
    @ApiModelProperty(value = "公司地址")
    @SerializedName("address")
    private String address;
    @ApiModelProperty(value = "法人代表")
    @SerializedName("frname")
    private String frname;
    @ApiModelProperty(value = "平台名称")
    @SerializedName("platform_name")
    private String platformName;
    @ApiModelProperty(value = "借款人数历史所有")
    @SerializedName("num_of_borrower_all")
    private String numOfBorrowerAll;
    @ApiModelProperty(value = "投资人数历史所有")
    @SerializedName("num_of_lender_all")
    private String numOfLenderAll;
    @ApiModelProperty(value = "成交量历史所有")
    @SerializedName("deal_volume_all")
    private String dealVolumeAll;
    @ApiModelProperty(value = "人均投资金额（万）历史所有")
    @SerializedName("per_lending_amount_all")
    private String perLendingAmountAll;
    @ApiModelProperty(value = "综合指数")
    @SerializedName("composite_index")
    private String compositeIndex;
    @ApiModelProperty(value = "网友点评")
    @SerializedName("user_comments")
    private String userComments;
    @ApiModelProperty(value = "平均收益")
    @SerializedName("avg_return")
    private String avgReturn;
    @ApiModelProperty(value = "投资期限")
    @SerializedName("invest_term")
    private String investTerm;
    @ApiModelProperty(value = "平台背景")
    @SerializedName("platform_background")
    private String platformBackground;
    @ApiModelProperty(value = "平台官网")
    @SerializedName("official_website")
    private String officialWebsite;
    @ApiModelProperty(value = "近30天动态分析")
    @SerializedName("dynamic_analysis")
    private String dynamicAnalysis;
    @ApiModelProperty(value = "股权上市")
    @SerializedName("equity_listing")
    private String equityListing;
    @ApiModelProperty(value = "银行存管")
    @SerializedName("bank_custody")
    private String bankCustody;
    @ApiModelProperty(value = "融资记录")
    @SerializedName("financing_record")
    private String financingRecord;
    @ApiModelProperty(value = "监管协会")
    @SerializedName("supervise_association")
    private String superviseAssociation;
    @ApiModelProperty(value = "ICP号")
    @SerializedName("icp_no")
    private String icpNo;
    @ApiModelProperty(value = "自动投标")
    @SerializedName("automatic_bidding")
    private String automaticBidding;
    @ApiModelProperty(value = "债权转让")
    @SerializedName("claim_transfer")
    private String claimTransfer;
    @ApiModelProperty(value = "投标保障")
    @SerializedName("bid_guarantee")
    private String bidGuarantee;
    @ApiModelProperty(value = "保障模式")
    @SerializedName("guarantee_mode")
    private String guaranteeMode;
    @ApiModelProperty(value = "担保机构")
    @SerializedName("guarantee_institution")
    private String guaranteeInstitution;
    @ApiModelProperty(value = "风险准备金存管")
    @SerializedName("risk_reserve")
    private String riskReserve;
    @ApiModelProperty(value = "公司简介")
    @SerializedName("company_profile")
    private String companyProfile;
    @ApiModelProperty(value = "公司类型")
    @SerializedName("company_type")
    private String companyType;
    @ApiModelProperty(value = "股东结构")
    @SerializedName("sharehouder_structure")
    private String sharehouderStructure;
    @ApiModelProperty(value = "实缴资本")
    @SerializedName("paid_capital")
    private String paidCapital;
    @ApiModelProperty(value = "开业日期")
    @SerializedName("open_date")
    private String openDate;
    @ApiModelProperty(value = "核准日期")
    @SerializedName("approval_date")
    private String approvalDate;
    @ApiModelProperty(value = "登记机关")
    @SerializedName("reg_authority")
    private String regAuthority;
    @ApiModelProperty(value = "营业执照注册号")
    @SerializedName("regno")
    private String regno;
    @ApiModelProperty(value = "组织机构代码")
    @SerializedName("organization_code")
    private String organizationCode;
    @ApiModelProperty(value = "税务登记号")
    @SerializedName("tax_regd_no")
    private String taxRegdNo;
    @ApiModelProperty(value = "经营范围")
    @SerializedName("business_scope")
    private String businessScope;
    @ApiModelProperty(value = "高管信息")
    @SerializedName("executive_message")
    private String executiveMessage;
    @ApiModelProperty(value = "网站备案信息")
    @SerializedName("web_record")
    private String webRecord;
    @ApiModelProperty(value = "平台费用")
    @SerializedName("platform_cost")
    private String platformCost;
    @ApiModelProperty(value = "联系方式")
    @SerializedName("contact_way")
    private String contactWay;
    @ApiModelProperty(value = "平台研报信息")
    @SerializedName("research_report")
    private String researchReport;
    @ApiModelProperty(value = "发展指数")
    @SerializedName("develop_index")
    private String developIndex;
    @ApiModelProperty(value = "发展指数排名")
    @SerializedName("develop_index_rank")
    private String developIndexRank;
    @ApiModelProperty(value = "预期收益率")
    @SerializedName("expected_yield")
    private String expectedYield;
    @ApiModelProperty(value = "投资人数分级")
    @SerializedName("investor_no_grade")
    private String investorNoGrade;
    @ApiModelProperty(value = "借款人数分级")
    @SerializedName("borrower_no_grade")
    private String borrowerNoGrade;
    @ApiModelProperty(value = "不同期限标的预期收益率")
    @SerializedName("diffterm_expected_yield")
    private String difftermExpectedYield;
    @ApiModelProperty(value = "不同期限标的满标用时")
    @SerializedName("diffterm_full_time")
    private String difftermFullTime;
    @ApiModelProperty(value = "人均借款金额（万）历史所有")
    @SerializedName("per_borrowing_amount_all")
    private String perBorrowingAmountAll;
    @ApiModelProperty(value = "新投资人数")
    @SerializedName("new_investor_no")
    private String newInvestorNo;
    @ApiModelProperty(value = "老投资人数")
    @SerializedName("old_investor_no")
    private String oldInvestorNo;
    @ApiModelProperty(value = "新投资人总额")
    @SerializedName("new_total_invest")
    private String newTotalInvest;
    @ApiModelProperty(value = "老投资人总额")
    @SerializedName("old_total_invest")
    private String oldTotalInvest;
    @ApiModelProperty(value = "平均借款期限（月）历史所有")
    @SerializedName("avg_loan_term_all")
    private String avgLoanTermAll;
    @ApiModelProperty(value = "行业平均期限")
    @SerializedName("industry_avg_term")
    private String industryAvgTerm;
    @ApiModelProperty(value = "待收投资人排行")
    @SerializedName("pend_invest_rank")
    private String pendInvestRank;
    @ApiModelProperty(value = "待还借款人排行")
    @SerializedName("pend_loan_rank")
    private String pendLoanRank;
    @ApiModelProperty(value = "近90日标的类型")
    @SerializedName("item_type")
    private String itemType;
    @ApiModelProperty(value = "近90日标的期限")
    @SerializedName("item_term")
    private String itemTerm;
    @ApiModelProperty(value = "近90日标的金额")
    @SerializedName("item_amount")
    private String itemAmount;
    @ApiModelProperty(value = "当日待还金额")
    @SerializedName("daily_pending")
    private String dailyPending;
    @ApiModelProperty(value = "当日待还金额（30日平均）")
    @SerializedName("daily_pending_avg")
    private String dailyPendingAvg;
    @ApiModelProperty(value = "资金净流入")
    @SerializedName("fund_net_inflow")
    private String fundNetInflow;
    @ApiModelProperty(value = "综合评分")
    @SerializedName("overall_score")
    private String overallScore;
    @ApiModelProperty(value = "网友印象")
    @SerializedName("user_impression")
    private String userImpression;
    @ApiModelProperty(value = "整体评价")
    @SerializedName("overall_evaluation")
    private String overallEvaluation;
    @ApiModelProperty(value = "评论内容")
    @SerializedName("comment")
    private String comment;

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getPlatformState() {
        return platformState;
    }

    public void setPlatformState(String platformState) {
        this.platformState = platformState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(String onlinetime) {
        this.onlinetime = onlinetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getNumOfBorrowerAll() {
        return numOfBorrowerAll;
    }

    public void setNumOfBorrowerAll(String numOfBorrowerAll) {
        this.numOfBorrowerAll = numOfBorrowerAll;
    }

    public String getNumOfLenderAll() {
        return numOfLenderAll;
    }

    public void setNumOfLenderAll(String numOfLenderAll) {
        this.numOfLenderAll = numOfLenderAll;
    }

    public String getDealVolumeAll() {
        return dealVolumeAll;
    }

    public void setDealVolumeAll(String dealVolumeAll) {
        this.dealVolumeAll = dealVolumeAll;
    }

    public String getPerLendingAmountAll() {
        return perLendingAmountAll;
    }

    public void setPerLendingAmountAll(String perLendingAmountAll) {
        this.perLendingAmountAll = perLendingAmountAll;
    }

    public String getCompositeIndex() {
        return compositeIndex;
    }

    public void setCompositeIndex(String compositeIndex) {
        this.compositeIndex = compositeIndex;
    }

    public String getUserComments() {
        return userComments;
    }

    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }

    public String getAvgReturn() {
        return avgReturn;
    }

    public void setAvgReturn(String avgReturn) {
        this.avgReturn = avgReturn;
    }

    public String getInvestTerm() {
        return investTerm;
    }

    public void setInvestTerm(String investTerm) {
        this.investTerm = investTerm;
    }

    public String getPlatformBackground() {
        return platformBackground;
    }

    public void setPlatformBackground(String platformBackground) {
        this.platformBackground = platformBackground;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public void setOfficialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }

    public String getDynamicAnalysis() {
        return dynamicAnalysis;
    }

    public void setDynamicAnalysis(String dynamicAnalysis) {
        this.dynamicAnalysis = dynamicAnalysis;
    }

    public String getEquityListing() {
        return equityListing;
    }

    public void setEquityListing(String equityListing) {
        this.equityListing = equityListing;
    }

    public String getBankCustody() {
        return bankCustody;
    }

    public void setBankCustody(String bankCustody) {
        this.bankCustody = bankCustody;
    }

    public String getFinancingRecord() {
        return financingRecord;
    }

    public void setFinancingRecord(String financingRecord) {
        this.financingRecord = financingRecord;
    }

    public String getSuperviseAssociation() {
        return superviseAssociation;
    }

    public void setSuperviseAssociation(String superviseAssociation) {
        this.superviseAssociation = superviseAssociation;
    }

    public String getIcpNo() {
        return icpNo;
    }

    public void setIcpNo(String icpNo) {
        this.icpNo = icpNo;
    }

    public String getAutomaticBidding() {
        return automaticBidding;
    }

    public void setAutomaticBidding(String automaticBidding) {
        this.automaticBidding = automaticBidding;
    }

    public String getClaimTransfer() {
        return claimTransfer;
    }

    public void setClaimTransfer(String claimTransfer) {
        this.claimTransfer = claimTransfer;
    }

    public String getBidGuarantee() {
        return bidGuarantee;
    }

    public void setBidGuarantee(String bidGuarantee) {
        this.bidGuarantee = bidGuarantee;
    }

    public String getGuaranteeMode() {
        return guaranteeMode;
    }

    public void setGuaranteeMode(String guaranteeMode) {
        this.guaranteeMode = guaranteeMode;
    }

    public String getGuaranteeInstitution() {
        return guaranteeInstitution;
    }

    public void setGuaranteeInstitution(String guaranteeInstitution) {
        this.guaranteeInstitution = guaranteeInstitution;
    }

    public String getRiskReserve() {
        return riskReserve;
    }

    public void setRiskReserve(String riskReserve) {
        this.riskReserve = riskReserve;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getSharehouderStructure() {
        return sharehouderStructure;
    }

    public void setSharehouderStructure(String sharehouderStructure) {
        this.sharehouderStructure = sharehouderStructure;
    }

    public String getPaidCapital() {
        return paidCapital;
    }

    public void setPaidCapital(String paidCapital) {
        this.paidCapital = paidCapital;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getRegAuthority() {
        return regAuthority;
    }

    public void setRegAuthority(String regAuthority) {
        this.regAuthority = regAuthority;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getTaxRegdNo() {
        return taxRegdNo;
    }

    public void setTaxRegdNo(String taxRegdNo) {
        this.taxRegdNo = taxRegdNo;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getExecutiveMessage() {
        return executiveMessage;
    }

    public void setExecutiveMessage(String executiveMessage) {
        this.executiveMessage = executiveMessage;
    }

    public String getWebRecord() {
        return webRecord;
    }

    public void setWebRecord(String webRecord) {
        this.webRecord = webRecord;
    }

    public String getPlatformCost() {
        return platformCost;
    }

    public void setPlatformCost(String platformCost) {
        this.platformCost = platformCost;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getResearchReport() {
        return researchReport;
    }

    public void setResearchReport(String researchReport) {
        this.researchReport = researchReport;
    }

    public String getDevelopIndex() {
        return developIndex;
    }

    public void setDevelopIndex(String developIndex) {
        this.developIndex = developIndex;
    }

    public String getDevelopIndexRank() {
        return developIndexRank;
    }

    public void setDevelopIndexRank(String developIndexRank) {
        this.developIndexRank = developIndexRank;
    }

    public String getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(String expectedYield) {
        this.expectedYield = expectedYield;
    }

    public String getInvestorNoGrade() {
        return investorNoGrade;
    }

    public void setInvestorNoGrade(String investorNoGrade) {
        this.investorNoGrade = investorNoGrade;
    }

    public String getBorrowerNoGrade() {
        return borrowerNoGrade;
    }

    public void setBorrowerNoGrade(String borrowerNoGrade) {
        this.borrowerNoGrade = borrowerNoGrade;
    }

    public String getDifftermExpectedYield() {
        return difftermExpectedYield;
    }

    public void setDifftermExpectedYield(String difftermExpectedYield) {
        this.difftermExpectedYield = difftermExpectedYield;
    }

    public String getDifftermFullTime() {
        return difftermFullTime;
    }

    public void setDifftermFullTime(String difftermFullTime) {
        this.difftermFullTime = difftermFullTime;
    }

    public String getPerBorrowingAmountAll() {
        return perBorrowingAmountAll;
    }

    public void setPerBorrowingAmountAll(String perBorrowingAmountAll) {
        this.perBorrowingAmountAll = perBorrowingAmountAll;
    }

    public String getNewInvestorNo() {
        return newInvestorNo;
    }

    public void setNewInvestorNo(String newInvestorNo) {
        this.newInvestorNo = newInvestorNo;
    }

    public String getOldInvestorNo() {
        return oldInvestorNo;
    }

    public void setOldInvestorNo(String oldInvestorNo) {
        this.oldInvestorNo = oldInvestorNo;
    }

    public String getNewTotalInvest() {
        return newTotalInvest;
    }

    public void setNewTotalInvest(String newTotalInvest) {
        this.newTotalInvest = newTotalInvest;
    }

    public String getOldTotalInvest() {
        return oldTotalInvest;
    }

    public void setOldTotalInvest(String oldTotalInvest) {
        this.oldTotalInvest = oldTotalInvest;
    }

    public String getAvgLoanTermAll() {
        return avgLoanTermAll;
    }

    public void setAvgLoanTermAll(String avgLoanTermAll) {
        this.avgLoanTermAll = avgLoanTermAll;
    }

    public String getIndustryAvgTerm() {
        return industryAvgTerm;
    }

    public void setIndustryAvgTerm(String industryAvgTerm) {
        this.industryAvgTerm = industryAvgTerm;
    }

    public String getPendInvestRank() {
        return pendInvestRank;
    }

    public void setPendInvestRank(String pendInvestRank) {
        this.pendInvestRank = pendInvestRank;
    }

    public String getPendLoanRank() {
        return pendLoanRank;
    }

    public void setPendLoanRank(String pendLoanRank) {
        this.pendLoanRank = pendLoanRank;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemTerm() {
        return itemTerm;
    }

    public void setItemTerm(String itemTerm) {
        this.itemTerm = itemTerm;
    }

    public String getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getDailyPending() {
        return dailyPending;
    }

    public void setDailyPending(String dailyPending) {
        this.dailyPending = dailyPending;
    }

    public String getDailyPendingAvg() {
        return dailyPendingAvg;
    }

    public void setDailyPendingAvg(String dailyPendingAvg) {
        this.dailyPendingAvg = dailyPendingAvg;
    }

    public String getFundNetInflow() {
        return fundNetInflow;
    }

    public void setFundNetInflow(String fundNetInflow) {
        this.fundNetInflow = fundNetInflow;
    }

    public String getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(String overallScore) {
        this.overallScore = overallScore;
    }

    public String getUserImpression() {
        return userImpression;
    }

    public void setUserImpression(String userImpression) {
        this.userImpression = userImpression;
    }

    public String getOverallEvaluation() {
        return overallEvaluation;
    }

    public void setOverallEvaluation(String overallEvaluation) {
        this.overallEvaluation = overallEvaluation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
