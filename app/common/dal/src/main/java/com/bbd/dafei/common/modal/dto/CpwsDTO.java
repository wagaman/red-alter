package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "裁判文书")
public class CpwsDTO {
    @ApiModelProperty(value = "案件标题")
    @SerializedName("title")
    private String title;
    @ApiModelProperty(value = "文书内容")
    @SerializedName("main")
    private String main;
    @ApiModelProperty(value = "案号")
    @SerializedName("casecode")
    private String casecode;
    @ApiModelProperty(value = "案由")
    @SerializedName("action_cause")
    private String actionCause;
    @ApiModelProperty(value = "案件类型")
    @SerializedName("case_type")
    private String caseType;
    @ApiModelProperty(value = "案件结果")
    @SerializedName("caseout_come")
    private String caseoutCome;
    @ApiModelProperty(value = "裁判日期")
    @SerializedName("sentence_date")
    private String sentenceDate;
    @ApiModelProperty(value = "审理法院")
    @SerializedName("trial_court")
    private String trialCourt;
    @ApiModelProperty(value = "法院当事人")
    @SerializedName("court_litigant")
    private String courtLitigant;
    @ApiModelProperty(value = "起诉方当事人")
    @SerializedName("pro_litigant")
    private String proLitigant;
    @ApiModelProperty(value = "被诉方当事人")
    @SerializedName("def_litigant")
    private String defLitigant;
    @ApiModelProperty(value = "起诉方其他相关人")
    @SerializedName("pro_other_related")
    private String proOtherRelated;
    @ApiModelProperty(value = "被诉方其他相关人")
    @SerializedName("def_other_related")
    private String defOtherRelated;
    @ApiModelProperty(value = "当事人类型")
    @SerializedName("litigant_type")
    private String litigantType;
    @ApiModelProperty(value = "历审案例")
    @SerializedName("historycase")
    private String historycase;
    @ApiModelProperty(value = "当事人")
    @SerializedName("litigant")
    private String litigant;
    @ApiModelProperty(value = "关联文书")
    @SerializedName("rel_doc")
    private String relDoc;
    @ApiModelProperty(value = "关联文书URL")
    @SerializedName("rel_doc_url")
    private String relDocUrl;
    @ApiModelProperty(value = "文书类型")
    @SerializedName("doc_type")
    private String docType;
    @ApiModelProperty(value = "审理程序")
    @SerializedName("ju_proc")
    private String juProc;
    @ApiModelProperty(value = "适用法条")
    @SerializedName("applicable_law")
    private String applicableLaw;
    @ApiModelProperty(value = "受理费")
    @SerializedName("court_acceptance_fee")
    private String courtAcceptanceFee;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getActionCause() {
        return actionCause;
    }

    public void setActionCause(String actionCause) {
        this.actionCause = actionCause;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseoutCome() {
        return caseoutCome;
    }

    public void setCaseoutCome(String caseoutCome) {
        this.caseoutCome = caseoutCome;
    }

    public String getSentenceDate() {
        return sentenceDate;
    }

    public void setSentenceDate(String sentenceDate) {
        this.sentenceDate = sentenceDate;
    }

    public String getTrialCourt() {
        return trialCourt;
    }

    public void setTrialCourt(String trialCourt) {
        this.trialCourt = trialCourt;
    }

    public String getCourtLitigant() {
        return courtLitigant;
    }

    public void setCourtLitigant(String courtLitigant) {
        this.courtLitigant = courtLitigant;
    }

    public String getProLitigant() {
        return proLitigant;
    }

    public void setProLitigant(String proLitigant) {
        this.proLitigant = proLitigant;
    }

    public String getDefLitigant() {
        return defLitigant;
    }

    public void setDefLitigant(String defLitigant) {
        this.defLitigant = defLitigant;
    }

    public String getProOtherRelated() {
        return proOtherRelated;
    }

    public void setProOtherRelated(String proOtherRelated) {
        this.proOtherRelated = proOtherRelated;
    }

    public String getDefOtherRelated() {
        return defOtherRelated;
    }

    public void setDefOtherRelated(String defOtherRelated) {
        this.defOtherRelated = defOtherRelated;
    }

    public String getLitigantType() {
        return litigantType;
    }

    public void setLitigantType(String litigantType) {
        this.litigantType = litigantType;
    }

    public String getHistorycase() {
        return historycase;
    }

    public void setHistorycase(String historycase) {
        this.historycase = historycase;
    }

    public String getLitigant() {
        return litigant;
    }

    public void setLitigant(String litigant) {
        this.litigant = litigant;
    }

    public String getRelDoc() {
        return relDoc;
    }

    public void setRelDoc(String relDoc) {
        this.relDoc = relDoc;
    }

    public String getRelDocUrl() {
        return relDocUrl;
    }

    public void setRelDocUrl(String relDocUrl) {
        this.relDocUrl = relDocUrl;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getJuProc() {
        return juProc;
    }

    public void setJuProc(String juProc) {
        this.juProc = juProc;
    }

    public String getApplicableLaw() {
        return applicableLaw;
    }

    public void setApplicableLaw(String applicableLaw) {
        this.applicableLaw = applicableLaw;
    }

    public String getCourtAcceptanceFee() {
        return courtAcceptanceFee;
    }

    public void setCourtAcceptanceFee(String courtAcceptanceFee) {
        this.courtAcceptanceFee = courtAcceptanceFee;
    }
}
