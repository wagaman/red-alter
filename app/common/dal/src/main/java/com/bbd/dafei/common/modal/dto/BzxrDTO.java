package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "被执行人")
public class BzxrDTO {
    @ApiModelProperty(value = "被执行人姓名/名称")
    @SerializedName("pname")
    private String pname;
    @ApiModelProperty(value = "案件状态")
    @SerializedName("case_state")
    private String caseState;
    @ApiModelProperty(value = "数据源")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "身份证号码/组织机构代码")
    @SerializedName("pname_id")
    private String pnameId;
    @ApiModelProperty(value = "执行法院")
    @SerializedName("exec_court_name")
    private String execCourtName;
    @ApiModelProperty(value = "立案时间")
    @SerializedName("case_create_time")
    private String caseCreateTime;
    @ApiModelProperty(value = "案号")
    @SerializedName("case_code")
    private String caseCode;
    @ApiModelProperty(value = "执行标的")
    @SerializedName("exec_subject")
    private Float execSubject;
    @ApiModelProperty(value = "证照类型")
    @SerializedName("idtype")
    private String idtype;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCaseState() {
        return caseState;
    }

    public void setCaseState(String caseState) {
        this.caseState = caseState;
    }

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getPnameId() {
        return pnameId;
    }

    public void setPnameId(String pnameId) {
        this.pnameId = pnameId;
    }

    public String getExecCourtName() {
        return execCourtName;
    }

    public void setExecCourtName(String execCourtName) {
        this.execCourtName = execCourtName;
    }

    public String getCaseCreateTime() {
        return caseCreateTime;
    }

    public void setCaseCreateTime(String caseCreateTime) {
        this.caseCreateTime = caseCreateTime;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public Float getExecSubject() {
        return execSubject;
    }

    public void setExecSubject(Float execSubject) {
        this.execSubject = execSubject;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }
}
