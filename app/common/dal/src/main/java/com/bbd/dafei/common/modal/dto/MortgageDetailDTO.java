package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "动产抵押信息")
public class MortgageDetailDTO {
    @ApiModelProperty(value = "公司名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "抵押 ID")
    @SerializedName("morreg_id")
    private String morregId;
    @ApiModelProperty(value = "抵押人")
    @SerializedName("mortgagor")
    private String mortgagor;
    @ApiModelProperty(value = "抵押权人")
    @SerializedName("more")
    private String more;
    @ApiModelProperty(value = "登记机关")
    @SerializedName("regorg")
    private String regorg;
    @ApiModelProperty(value = "登记日期")
    @SerializedName("regidate")
    private String regidate;
    @ApiModelProperty(value = "状态标识")
    @SerializedName("mortype")
    private String mortype;
    @ApiModelProperty(value = "登记证号")
    @SerializedName("morregcno")
    private String morregcno;
    @ApiModelProperty(value = "申请抵押原因")
    @SerializedName("appregrea")
    private String appregrea;
    @ApiModelProperty(value = "被担保主债权种类")
    @SerializedName("priclaseckind")
    private String priclaseckind;
    @ApiModelProperty(value = "被担保主债权数额(万元)")
    @SerializedName("priclasecam")
    private String priclasecam;
    @ApiModelProperty(value = "履约起始日期")
    @SerializedName("pefperform")
    private String pefperform;
    @ApiModelProperty(value = "履约截止日期")
    @SerializedName("pefperto")
    private String pefperto;
    @ApiModelProperty(value = "注销日期")
    @SerializedName("candate")
    private String candate;
    @ApiModelProperty(value = "抵押物名称")
    @SerializedName("guaname")
    private String guaname;
    @ApiModelProperty(value = "抵押物信息")
    @SerializedName("guadetali")
    private String guadetali;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMorregId() {
        return morregId;
    }

    public void setMorregId(String morregId) {
        this.morregId = morregId;
    }

    public String getMortgagor() {
        return mortgagor;
    }

    public void setMortgagor(String mortgagor) {
        this.mortgagor = mortgagor;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getRegorg() {
        return regorg;
    }

    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    public String getRegidate() {
        return regidate;
    }

    public void setRegidate(String regidate) {
        this.regidate = regidate;
    }

    public String getMortype() {
        return mortype;
    }

    public void setMortype(String mortype) {
        this.mortype = mortype;
    }

    public String getMorregcno() {
        return morregcno;
    }

    public void setMorregcno(String morregcno) {
        this.morregcno = morregcno;
    }

    public String getAppregrea() {
        return appregrea;
    }

    public void setAppregrea(String appregrea) {
        this.appregrea = appregrea;
    }

    public String getPriclaseckind() {
        return priclaseckind;
    }

    public void setPriclaseckind(String priclaseckind) {
        this.priclaseckind = priclaseckind;
    }

    public String getPriclasecam() {
        return priclasecam;
    }

    public void setPriclasecam(String priclasecam) {
        this.priclasecam = priclasecam;
    }

    public String getPefperform() {
        return pefperform;
    }

    public void setPefperform(String pefperform) {
        this.pefperform = pefperform;
    }

    public String getPefperto() {
        return pefperto;
    }

    public void setPefperto(String pefperto) {
        this.pefperto = pefperto;
    }

    public String getCandate() {
        return candate;
    }

    public void setCandate(String candate) {
        this.candate = candate;
    }

    public String getGuaname() {
        return guaname;
    }

    public void setGuaname(String guaname) {
        this.guaname = guaname;
    }

    public String getGuadetali() {
        return guadetali;
    }

    public void setGuadetali(String guadetali) {
        this.guadetali = guadetali;
    }
}
