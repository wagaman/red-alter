package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 企业关联信息
 * Created by wish on 2017/4/24.
 */
public class RelationInfoDTO {
    //目标公司自然人股东数
    @SerializedName("individual_shareholders")
    private String individualShareholders;
    //目标公司非自然人股东数
    @SerializedName("non_individual_shareholders")
    private String nonIndividualShareholders;
    //目标公司股东数
    @SerializedName("shareholders")
    private String shareholders;
    //目标公司子公司数
    @SerializedName("subsidiaries")
    private String subsidiaries;
    //目标公司自然人股东比例
    @SerializedName("indi_share_proportion")
    private String indiShareProportion;
    //一度关联自然人数
    @SerializedName("natural_persons_1d")
    private String naturalPersons1d;
    //一度关联非自然人数
    @SerializedName("non_natural_persons_1d")
    private String nonNaturalPersons1d;
    //一度关联方数
    @SerializedName("related_parties_1d")
    private String relatedParties1d;
    //一度关联自然人比例
    @SerializedName("natural_persons_proportion_1d")
    private String naturalPersonsProportion1d;
    //二度关联自然人数
    @SerializedName("natural_persons_2d")
    private String naturalPersons2d;
    //二度关联非自然人数
    @SerializedName("non_natural_persons_2d")
    private String nonNaturalPersons2d;
    //二度关联方数
    @SerializedName("related_parties_2d")
    private String relatedParties2d;
    //二度关联自然人比例
    @SerializedName("natural_persons_proportion_2d")
    private String naturalPersonsProportion2d;
    //三度关联自然人数
    @SerializedName("natural_persons_3d")
    private String naturalPersons3d;
    //三度关联非自然人数
    @SerializedName("non_natural_persons_3d")
    private String nonNaturalPersons3d;
    //三度关联方数
    @SerializedName("related_parties_3d")
    private String relatedParties3d;
    //三度关联自然人比例
    @SerializedName("natural_persons_proportion_3d")
    private String naturalPersonsProportion3d;
    //一度关联非自然人行业跨度
    @SerializedName("Industry_span_1d")
    private String IndustrySpan1d;
    //一度关联非自然人最集中行业
    @SerializedName("concentrated_Industry_1d")
    private String concentratedIndustry1d;
    //二度关联非自然人行业跨度
    @SerializedName("Industry_span_2d")
    private String IndustrySpan2d;
    //二度关联非自然人最集中行业
    @SerializedName("concentrated_Industry_2d")
    private String concentratedIndustry2d;
    //三度关联非自然人行业跨度
    @SerializedName("Industry_span_3d")
    private String IndustrySpan3d;
    //三度关联非自然人最集中行业
    @SerializedName("concentrated_Industry_3d")
    private String concentratedIndustry3d;
    //一度关联关键自然人（与3.5KPI定义不同）
    @SerializedName("pivotal_natural_persons_top_1d")
    private String pivotalNaturalPersonsTop1d;
    //二度关联关键自然人（与3.5KPI定义不同）
    @SerializedName("pivotal_natural_persons_top_2d")
    private String pivotalNaturalPersonsTop2d;
    //三度关联关键自然人（与3.5KPI定义不同）
    @SerializedName("pivotal_natural_persons_top_3d")
    private String pivotalNaturalPersonsTop3d;
    //一度关联关键非自然人（新增）
    @SerializedName("pivotal_non_natural_persons_top_1d")
    private String pivotalNonNaturalPersonsTop1d;
    //二度关联关键非自然人（新增）
    @SerializedName("pivotal_non_natural_persons_top_2d")
    private String pivotalNonNaturalPersonsTop2d;
    //三度关联关键非自然人（新增）
    @SerializedName("pivotal_non_natural_persons_top_3d")
    private String pivotalNonNaturalPersonsTop3d;
    //投资链关联方数
    @SerializedName("investchain_counter")
    private String investchainCounter;
    //一度关联方行业分布
    @SerializedName("industry_span_ratio_1d")
    private List<List<String>> industrySpanRatio1d;
    //二度关联方行业分布
    @SerializedName("industry_span_ratio_2d")
    private List<List<String>> industrySpanRatio2d;
    //三度关联方行业分布
    @SerializedName("industry_span_ratio_3d")
    private List<List<String>> industrySpanRatio3d;
    //目标公司董事数
    @SerializedName("directors")
    private String directors;
    //目标公司监事数
    @SerializedName("supervisors")
    private String supervisors;
    //目标公司高管数
    @SerializedName("executives")
    private String executives;
    //一度关联公司董事数
    @SerializedName("company_directors_1d")
    private String companyDirectors1d;
    //一度关联公司监事数
    @SerializedName("company_supervisors_1d")
    private String companySupervisors1d;
    //一度关联公司高管数
    @SerializedName("company_executives_1d")
    private String companyExecutives1d;
    //二度关联公司董事数
    @SerializedName("company_directors_2d")
    private String companyDirectors2d;
    //二度关联公司监事数
    @SerializedName("company_supervisors_2d")
    private String companySupervisors2d;
    //二度关联公司高管数
    @SerializedName("company_executives_2d")
    private String companyExecutives2d;
    //三度关联公司董事数
    @SerializedName("company_directors_3d")
    private String companyDirectors3d;
    //三度关联公司监事数
    @SerializedName("company_supervisors_3d")
    private String companySupervisors3d;
    //三度关联公司高管数
    @SerializedName("company_executives_3d")
    private String companyExecutives3d;
    //管理层总人数
    @SerializedName("managers")
    private String managers;
    //管理层兼职人数
    @SerializedName("managers_slashcareer")
    private String managersSlashcareer;
    //管理层兼职比例
    @SerializedName("managers_slashcareer_ratio")
    private String managersSlashcareerRatio;
    //管理层兼职公司数
    @SerializedName("managers_slashcareer_companycounter")
    private String managersSlashcareerCompanycounter;
    //目标公司诉讼数
    @SerializedName("non_natural_persons_litigation")
    private String nonNaturalPersonsLitigation;
    //一度关联非自然人诉讼数
    @SerializedName("non_natural_persons_litigation_1d")
    private String nonNaturalPersonsLitigation1d;
    //二度关联非自然人诉讼数
    @SerializedName("non_natural_persons_litigation_2d")
    private String nonNaturalPersonsLitigation2d;
    //三度关联非自然人诉讼数
    @SerializedName("non_natural_persons_litigation_3d")
    private String nonNaturalPersonsLitigation3d;
    //目标公司涉案最集中领域
    @SerializedName("litigation_concentrated_area")
    private String litigationConcentratedArea;
    //一度关联非自然人涉案最集中领域
    @SerializedName("litigation_concentrated_area_1d")
    private String litigationConcentratedArea1d;
    //二度关联非自然人涉案最集中领域
    @SerializedName("litigation_concentrated_area_2d")
    private String litigationConcentratedArea2d;
    //三度关联非自然人涉案最集中领域
    @SerializedName("litigation_concentrated_area_3d")
    private String litigationConcentratedArea3d;
    //目标公司失信次数
    @SerializedName("dishonesty_times")
    private String dishonestyTimes;
    //一度关联非自然人失信次数
    @SerializedName("dishonesty_times_1d")
    private String dishonestyTimes1d;
    //二度关联非自然人失信次数
    @SerializedName("dishonesty_times_2d")
    private String dishonestyTimes2d;
    //三度关联非自然人失信次数
    @SerializedName("dishonesty_times_3d")
    private String dishonestyTimes3d;
    //目标公司商标数
    @SerializedName("trademarks")
    private String trademarks;
    //一度关联非自然人商标数
    @SerializedName("trademarks_1d")
    private String trademarks1d;
    //二度关联非自然人商标数
    @SerializedName("trademarks_2d")
    private String trademarks2d;
    //三度关联非自然人商标数
    @SerializedName("trademarks_3d")
    private String trademarks3d;
    //目标公司专利数
    @SerializedName("patents")
    private String patents;
    //一度关联非自然人专利数
    @SerializedName("patents_1d")
    private String patents1d;
    //二度关联非自然人专利数
    @SerializedName("patents_2d")
    private String patents2d;
    //三度关联非自然人专利数
    @SerializedName("patents_3d")
    private String patents3d;

    public String getIndividualShareholders() {
        return individualShareholders;
    }

    public void setIndividualShareholders(String individualShareholders) {
        this.individualShareholders = individualShareholders;
    }

    public String getNonIndividualShareholders() {
        return nonIndividualShareholders;
    }

    public void setNonIndividualShareholders(String nonIndividualShareholders) {
        this.nonIndividualShareholders = nonIndividualShareholders;
    }

    public String getShareholders() {
        return shareholders;
    }

    public void setShareholders(String shareholders) {
        this.shareholders = shareholders;
    }

    public String getSubsidiaries() {
        return subsidiaries;
    }

    public void setSubsidiaries(String subsidiaries) {
        this.subsidiaries = subsidiaries;
    }

    public String getIndiShareProportion() {
        return indiShareProportion;
    }

    public void setIndiShareProportion(String indiShareProportion) {
        this.indiShareProportion = indiShareProportion;
    }

    public String getNaturalPersons1d() {
        return naturalPersons1d;
    }

    public void setNaturalPersons1d(String naturalPersons1d) {
        this.naturalPersons1d = naturalPersons1d;
    }

    public String getNonNaturalPersons1d() {
        return nonNaturalPersons1d;
    }

    public void setNonNaturalPersons1d(String nonNaturalPersons1d) {
        this.nonNaturalPersons1d = nonNaturalPersons1d;
    }

    public String getRelatedParties1d() {
        return relatedParties1d;
    }

    public void setRelatedParties1d(String relatedParties1d) {
        this.relatedParties1d = relatedParties1d;
    }

    public String getNaturalPersonsProportion1d() {
        return naturalPersonsProportion1d;
    }

    public void setNaturalPersonsProportion1d(String naturalPersonsProportion1d) {
        this.naturalPersonsProportion1d = naturalPersonsProportion1d;
    }

    public String getNaturalPersons2d() {
        return naturalPersons2d;
    }

    public void setNaturalPersons2d(String naturalPersons2d) {
        this.naturalPersons2d = naturalPersons2d;
    }

    public String getNonNaturalPersons2d() {
        return nonNaturalPersons2d;
    }

    public void setNonNaturalPersons2d(String nonNaturalPersons2d) {
        this.nonNaturalPersons2d = nonNaturalPersons2d;
    }

    public String getRelatedParties2d() {
        return relatedParties2d;
    }

    public void setRelatedParties2d(String relatedParties2d) {
        this.relatedParties2d = relatedParties2d;
    }

    public String getNaturalPersonsProportion2d() {
        return naturalPersonsProportion2d;
    }

    public void setNaturalPersonsProportion2d(String naturalPersonsProportion2d) {
        this.naturalPersonsProportion2d = naturalPersonsProportion2d;
    }

    public String getNaturalPersons3d() {
        return naturalPersons3d;
    }

    public void setNaturalPersons3d(String naturalPersons3d) {
        this.naturalPersons3d = naturalPersons3d;
    }

    public String getNonNaturalPersons3d() {
        return nonNaturalPersons3d;
    }

    public void setNonNaturalPersons3d(String nonNaturalPersons3d) {
        this.nonNaturalPersons3d = nonNaturalPersons3d;
    }

    public String getRelatedParties3d() {
        return relatedParties3d;
    }

    public void setRelatedParties3d(String relatedParties3d) {
        this.relatedParties3d = relatedParties3d;
    }

    public String getNaturalPersonsProportion3d() {
        return naturalPersonsProportion3d;
    }

    public void setNaturalPersonsProportion3d(String naturalPersonsProportion3d) {
        this.naturalPersonsProportion3d = naturalPersonsProportion3d;
    }

    public String getIndustrySpan1d() {
        return IndustrySpan1d;
    }

    public void setIndustrySpan1d(String industrySpan1d) {
        IndustrySpan1d = industrySpan1d;
    }

    public String getConcentratedIndustry1d() {
        return concentratedIndustry1d;
    }

    public void setConcentratedIndustry1d(String concentratedIndustry1d) {
        this.concentratedIndustry1d = concentratedIndustry1d;
    }

    public String getIndustrySpan2d() {
        return IndustrySpan2d;
    }

    public void setIndustrySpan2d(String industrySpan2d) {
        IndustrySpan2d = industrySpan2d;
    }

    public String getConcentratedIndustry2d() {
        return concentratedIndustry2d;
    }

    public void setConcentratedIndustry2d(String concentratedIndustry2d) {
        this.concentratedIndustry2d = concentratedIndustry2d;
    }

    public String getIndustrySpan3d() {
        return IndustrySpan3d;
    }

    public void setIndustrySpan3d(String industrySpan3d) {
        IndustrySpan3d = industrySpan3d;
    }

    public String getConcentratedIndustry3d() {
        return concentratedIndustry3d;
    }

    public void setConcentratedIndustry3d(String concentratedIndustry3d) {
        this.concentratedIndustry3d = concentratedIndustry3d;
    }

    public String getPivotalNaturalPersonsTop1d() {
        return pivotalNaturalPersonsTop1d;
    }

    public void setPivotalNaturalPersonsTop1d(String pivotalNaturalPersonsTop1d) {
        this.pivotalNaturalPersonsTop1d = pivotalNaturalPersonsTop1d;
    }

    public String getPivotalNaturalPersonsTop2d() {
        return pivotalNaturalPersonsTop2d;
    }

    public void setPivotalNaturalPersonsTop2d(String pivotalNaturalPersonsTop2d) {
        this.pivotalNaturalPersonsTop2d = pivotalNaturalPersonsTop2d;
    }

    public String getPivotalNaturalPersonsTop3d() {
        return pivotalNaturalPersonsTop3d;
    }

    public void setPivotalNaturalPersonsTop3d(String pivotalNaturalPersonsTop3d) {
        this.pivotalNaturalPersonsTop3d = pivotalNaturalPersonsTop3d;
    }

    public String getPivotalNonNaturalPersonsTop1d() {
        return pivotalNonNaturalPersonsTop1d;
    }

    public void setPivotalNonNaturalPersonsTop1d(String pivotalNonNaturalPersonsTop1d) {
        this.pivotalNonNaturalPersonsTop1d = pivotalNonNaturalPersonsTop1d;
    }

    public String getPivotalNonNaturalPersonsTop2d() {
        return pivotalNonNaturalPersonsTop2d;
    }

    public void setPivotalNonNaturalPersonsTop2d(String pivotalNonNaturalPersonsTop2d) {
        this.pivotalNonNaturalPersonsTop2d = pivotalNonNaturalPersonsTop2d;
    }

    public String getPivotalNonNaturalPersonsTop3d() {
        return pivotalNonNaturalPersonsTop3d;
    }

    public void setPivotalNonNaturalPersonsTop3d(String pivotalNonNaturalPersonsTop3d) {
        this.pivotalNonNaturalPersonsTop3d = pivotalNonNaturalPersonsTop3d;
    }

    public String getInvestchainCounter() {
        return investchainCounter;
    }

    public void setInvestchainCounter(String investchainCounter) {
        this.investchainCounter = investchainCounter;
    }

    public List<List<String>> getIndustrySpanRatio1d() {
        return industrySpanRatio1d;
    }

    public void setIndustrySpanRatio1d(List<List<String>> industrySpanRatio1d) {
        this.industrySpanRatio1d = industrySpanRatio1d;
    }

    public List<List<String>> getIndustrySpanRatio2d() {
        return industrySpanRatio2d;
    }

    public void setIndustrySpanRatio2d(List<List<String>> industrySpanRatio2d) {
        this.industrySpanRatio2d = industrySpanRatio2d;
    }

    public List<List<String>> getIndustrySpanRatio3d() {
        return industrySpanRatio3d;
    }

    public void setIndustrySpanRatio3d(List<List<String>> industrySpanRatio3d) {
        this.industrySpanRatio3d = industrySpanRatio3d;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors;
    }

    public String getExecutives() {
        return executives;
    }

    public void setExecutives(String executives) {
        this.executives = executives;
    }

    public String getCompanyDirectors1d() {
        return companyDirectors1d;
    }

    public void setCompanyDirectors1d(String companyDirectors1d) {
        this.companyDirectors1d = companyDirectors1d;
    }

    public String getCompanySupervisors1d() {
        return companySupervisors1d;
    }

    public void setCompanySupervisors1d(String companySupervisors1d) {
        this.companySupervisors1d = companySupervisors1d;
    }

    public String getCompanyExecutives1d() {
        return companyExecutives1d;
    }

    public void setCompanyExecutives1d(String companyExecutives1d) {
        this.companyExecutives1d = companyExecutives1d;
    }

    public String getCompanyDirectors2d() {
        return companyDirectors2d;
    }

    public void setCompanyDirectors2d(String companyDirectors2d) {
        this.companyDirectors2d = companyDirectors2d;
    }

    public String getCompanySupervisors2d() {
        return companySupervisors2d;
    }

    public void setCompanySupervisors2d(String companySupervisors2d) {
        this.companySupervisors2d = companySupervisors2d;
    }

    public String getCompanyExecutives2d() {
        return companyExecutives2d;
    }

    public void setCompanyExecutives2d(String companyExecutives2d) {
        this.companyExecutives2d = companyExecutives2d;
    }

    public String getCompanyDirectors3d() {
        return companyDirectors3d;
    }

    public void setCompanyDirectors3d(String companyDirectors3d) {
        this.companyDirectors3d = companyDirectors3d;
    }

    public String getCompanySupervisors3d() {
        return companySupervisors3d;
    }

    public void setCompanySupervisors3d(String companySupervisors3d) {
        this.companySupervisors3d = companySupervisors3d;
    }

    public String getCompanyExecutives3d() {
        return companyExecutives3d;
    }

    public void setCompanyExecutives3d(String companyExecutives3d) {
        this.companyExecutives3d = companyExecutives3d;
    }

    public String getManagers() {
        return managers;
    }

    public void setManagers(String managers) {
        this.managers = managers;
    }

    public String getManagersSlashcareer() {
        return managersSlashcareer;
    }

    public void setManagersSlashcareer(String managersSlashcareer) {
        this.managersSlashcareer = managersSlashcareer;
    }

    public String getManagersSlashcareerRatio() {
        return managersSlashcareerRatio;
    }

    public void setManagersSlashcareerRatio(String managersSlashcareerRatio) {
        this.managersSlashcareerRatio = managersSlashcareerRatio;
    }

    public String getManagersSlashcareerCompanycounter() {
        return managersSlashcareerCompanycounter;
    }

    public void setManagersSlashcareerCompanycounter(String managersSlashcareerCompanycounter) {
        this.managersSlashcareerCompanycounter = managersSlashcareerCompanycounter;
    }

    public String getNonNaturalPersonsLitigation() {
        return nonNaturalPersonsLitigation;
    }

    public void setNonNaturalPersonsLitigation(String nonNaturalPersonsLitigation) {
        this.nonNaturalPersonsLitigation = nonNaturalPersonsLitigation;
    }

    public String getNonNaturalPersonsLitigation1d() {
        return nonNaturalPersonsLitigation1d;
    }

    public void setNonNaturalPersonsLitigation1d(String nonNaturalPersonsLitigation1d) {
        this.nonNaturalPersonsLitigation1d = nonNaturalPersonsLitigation1d;
    }

    public String getNonNaturalPersonsLitigation2d() {
        return nonNaturalPersonsLitigation2d;
    }

    public void setNonNaturalPersonsLitigation2d(String nonNaturalPersonsLitigation2d) {
        this.nonNaturalPersonsLitigation2d = nonNaturalPersonsLitigation2d;
    }

    public String getNonNaturalPersonsLitigation3d() {
        return nonNaturalPersonsLitigation3d;
    }

    public void setNonNaturalPersonsLitigation3d(String nonNaturalPersonsLitigation3d) {
        this.nonNaturalPersonsLitigation3d = nonNaturalPersonsLitigation3d;
    }

    public String getLitigationConcentratedArea() {
        return litigationConcentratedArea;
    }

    public void setLitigationConcentratedArea(String litigationConcentratedArea) {
        this.litigationConcentratedArea = litigationConcentratedArea;
    }

    public String getLitigationConcentratedArea1d() {
        return litigationConcentratedArea1d;
    }

    public void setLitigationConcentratedArea1d(String litigationConcentratedArea1d) {
        this.litigationConcentratedArea1d = litigationConcentratedArea1d;
    }

    public String getLitigationConcentratedArea2d() {
        return litigationConcentratedArea2d;
    }

    public void setLitigationConcentratedArea2d(String litigationConcentratedArea2d) {
        this.litigationConcentratedArea2d = litigationConcentratedArea2d;
    }

    public String getLitigationConcentratedArea3d() {
        return litigationConcentratedArea3d;
    }

    public void setLitigationConcentratedArea3d(String litigationConcentratedArea3d) {
        this.litigationConcentratedArea3d = litigationConcentratedArea3d;
    }

    public String getDishonestyTimes() {
        return dishonestyTimes;
    }

    public void setDishonestyTimes(String dishonestyTimes) {
        this.dishonestyTimes = dishonestyTimes;
    }

    public String getDishonestyTimes1d() {
        return dishonestyTimes1d;
    }

    public void setDishonestyTimes1d(String dishonestyTimes1d) {
        this.dishonestyTimes1d = dishonestyTimes1d;
    }

    public String getDishonestyTimes2d() {
        return dishonestyTimes2d;
    }

    public void setDishonestyTimes2d(String dishonestyTimes2d) {
        this.dishonestyTimes2d = dishonestyTimes2d;
    }

    public String getDishonestyTimes3d() {
        return dishonestyTimes3d;
    }

    public void setDishonestyTimes3d(String dishonestyTimes3d) {
        this.dishonestyTimes3d = dishonestyTimes3d;
    }

    public String getTrademarks() {
        return trademarks;
    }

    public void setTrademarks(String trademarks) {
        this.trademarks = trademarks;
    }

    public String getTrademarks1d() {
        return trademarks1d;
    }

    public void setTrademarks1d(String trademarks1d) {
        this.trademarks1d = trademarks1d;
    }

    public String getTrademarks2d() {
        return trademarks2d;
    }

    public void setTrademarks2d(String trademarks2d) {
        this.trademarks2d = trademarks2d;
    }

    public String getTrademarks3d() {
        return trademarks3d;
    }

    public void setTrademarks3d(String trademarks3d) {
        this.trademarks3d = trademarks3d;
    }

    public String getPatents() {
        return patents;
    }

    public void setPatents(String patents) {
        this.patents = patents;
    }

    public String getPatents1d() {
        return patents1d;
    }

    public void setPatents1d(String patents1d) {
        this.patents1d = patents1d;
    }

    public String getPatents2d() {
        return patents2d;
    }

    public void setPatents2d(String patents2d) {
        this.patents2d = patents2d;
    }

    public String getPatents3d() {
        return patents3d;
    }

    public void setPatents3d(String patents3d) {
        this.patents3d = patents3d;
    }

}
