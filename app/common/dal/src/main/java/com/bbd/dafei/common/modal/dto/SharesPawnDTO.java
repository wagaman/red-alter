package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "股权出质")
public class SharesPawnDTO {
    @ApiModelProperty(value = "公司名称")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "出质人姓名")
    @SerializedName("imporg")
    private String imporg;
    @ApiModelProperty(value = "出质人类别")
    @SerializedName("imporgtype")
    private String imporgtype;
    @ApiModelProperty(value = "出质金额")
    @SerializedName("impam")
    private String impam;
    @ApiModelProperty(value = "出质备案日期")
    @SerializedName("imponrecdate")
    private String imponrecdate;
    @ApiModelProperty(value = "出质审批部门")
    @SerializedName("impexaeep")
    private String impexaeep;
    @ApiModelProperty(value = "出质批准日期")
    @SerializedName("impsandate")
    private String impsandate;
    @ApiModelProperty(value = "出质截至日期")
    @SerializedName("impto")
    private String impto;
    @ApiModelProperty(value = "登记编号")
    @SerializedName("morregcno")
    private String morregcno;
    @ApiModelProperty(value = "证照/证件号码")
    @SerializedName("imporg_idno")
    private String imporgIdno;
    @ApiModelProperty(value = "质权人姓名")
    @SerializedName("pledgee")
    private String pledgee;
    @ApiModelProperty(value = "证照/证件号码")
    @SerializedName("pledgee_idno")
    private String pledgeeIdno;
    @ApiModelProperty(value = "状态")
    @SerializedName("impstate")
    private String impstate;
    @ApiModelProperty(value = "变化情况")
    @SerializedName("impsituation")
    private String impsituation;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImporg() {
        return imporg;
    }

    public void setImporg(String imporg) {
        this.imporg = imporg;
    }

    public String getImporgtype() {
        return imporgtype;
    }

    public void setImporgtype(String imporgtype) {
        this.imporgtype = imporgtype;
    }

    public String getImpam() {
        return impam;
    }

    public void setImpam(String impam) {
        this.impam = impam;
    }

    public String getImponrecdate() {
        return imponrecdate;
    }

    public void setImponrecdate(String imponrecdate) {
        this.imponrecdate = imponrecdate;
    }

    public String getImpexaeep() {
        return impexaeep;
    }

    public void setImpexaeep(String impexaeep) {
        this.impexaeep = impexaeep;
    }

    public String getImpsandate() {
        return impsandate;
    }

    public void setImpsandate(String impsandate) {
        this.impsandate = impsandate;
    }

    public String getImpto() {
        return impto;
    }

    public void setImpto(String impto) {
        this.impto = impto;
    }

    public String getMorregcno() {
        return morregcno;
    }

    public void setMorregcno(String morregcno) {
        this.morregcno = morregcno;
    }

    public String getImporgIdno() {
        return imporgIdno;
    }

    public void setImporgIdno(String imporgIdno) {
        this.imporgIdno = imporgIdno;
    }

    public String getPledgee() {
        return pledgee;
    }

    public void setPledgee(String pledgee) {
        this.pledgee = pledgee;
    }

    public String getPledgeeIdno() {
        return pledgeeIdno;
    }

    public void setPledgeeIdno(String pledgeeIdno) {
        this.pledgeeIdno = pledgeeIdno;
    }

    public String getImpstate() {
        return impstate;
    }

    public void setImpstate(String impstate) {
        this.impstate = impstate;
    }

    public String getImpsituation() {
        return impsituation;
    }

    public void setImpsituation(String impsituation) {
        this.impsituation = impsituation;
    }
}
