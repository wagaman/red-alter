package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/5/4.
 */
@ApiModel(value = "分支机构")
public class FzjgDTO {
    @ApiModelProperty(value = "公司名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "分支机构名称")
    @SerializedName("name")
    private String name;
    @ApiModelProperty(value = "注册号")
    @SerializedName("regno")
    private String regno;
    @ApiModelProperty(value = "注册号/统一社会信用代码")
    @SerializedName("regno_or_creditcode")
    private String regnoOrCreditcode;
    @ApiModelProperty(value = "法定代表人/负责人")
    @SerializedName("frname")
    private String frname;
    @ApiModelProperty(value = "成立日期")
    @SerializedName("esdate")
    private String esdate;
    @ApiModelProperty(value = "登记状态")
    @SerializedName("enterprise_status")
    private String enterpriseStatus;
    @ApiModelProperty(value = "登记机关")
    @SerializedName("regorg")
    private String regorg;
    @ApiModelProperty(value = "住所")
    @SerializedName("address")
    private String address;

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

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getRegnoOrCreditcode() {
        return regnoOrCreditcode;
    }

    public void setRegnoOrCreditcode(String regnoOrCreditcode) {
        this.regnoOrCreditcode = regnoOrCreditcode;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
