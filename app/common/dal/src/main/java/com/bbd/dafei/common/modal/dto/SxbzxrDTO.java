package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "失信被执行人")
public class SxbzxrDTO {
    @ApiModelProperty(value = "被执行人姓名或名称")
    @SerializedName("pname")
    private String pname;
    @ApiModelProperty(value = "身份证号码或组织机构代码")
    @SerializedName("pname_id")
    private String pnameId;
    @ApiModelProperty(value = "法定代表人或者负责人姓名")
    @SerializedName("frname")
    private String frname;
    @ApiModelProperty(value = "执行法院")
    @SerializedName("exec_court_name")
    private String execCourtName;
    @ApiModelProperty(value = "省份")
    @SerializedName("province")
    private String province;
    @ApiModelProperty(value = "案号")
    @SerializedName("case_code")
    private String caseCode;
    @ApiModelProperty(value = "执行依据文号")
    @SerializedName("exe_code")
    private String exeCode;
    @ApiModelProperty(value = "立案时间")
    @SerializedName("case_create_time")
    private String caseCreateTime;
    @ApiModelProperty(value = "被执行人的履行情况")
    @SerializedName("perform_degree")
    private String performDegree;
    @ApiModelProperty(value = "失信被执行人行为具体情形")
    @SerializedName("concrete_situation")
    private String concreteSituation;
    @ApiModelProperty(value = "做出执行依据单位")
    @SerializedName("exec_basunit")
    private String execBasunit;
    @ApiModelProperty(value = "生效法律文书确定义务")
    @SerializedName("definiteo_bligation")
    private String definiteoBligation;
    @ApiModelProperty(value = "发布时间")
    @SerializedName("pubdate")
    private String pubdate;
    @ApiModelProperty(value = "证照类型")
    @SerializedName("idtype")
    private String idtype;
    @ApiModelProperty(value = "数据源")
    @SerializedName("bbd_type")
    private String bbdType;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPnameId() {
        return pnameId;
    }

    public void setPnameId(String pnameId) {
        this.pnameId = pnameId;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getExecCourtName() {
        return execCourtName;
    }

    public void setExecCourtName(String execCourtName) {
        this.execCourtName = execCourtName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getExeCode() {
        return exeCode;
    }

    public void setExeCode(String exeCode) {
        this.exeCode = exeCode;
    }

    public String getCaseCreateTime() {
        return caseCreateTime;
    }

    public void setCaseCreateTime(String caseCreateTime) {
        this.caseCreateTime = caseCreateTime;
    }

    public String getPerformDegree() {
        return performDegree;
    }

    public void setPerformDegree(String performDegree) {
        this.performDegree = performDegree;
    }

    public String getConcreteSituation() {
        return concreteSituation;
    }

    public void setConcreteSituation(String concreteSituation) {
        this.concreteSituation = concreteSituation;
    }

    public String getExecBasunit() {
        return execBasunit;
    }

    public void setExecBasunit(String execBasunit) {
        this.execBasunit = execBasunit;
    }

    public String getDefiniteoBligation() {
        return definiteoBligation;
    }

    public void setDefiniteoBligation(String definiteoBligation) {
        this.definiteoBligation = definiteoBligation;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }
}
