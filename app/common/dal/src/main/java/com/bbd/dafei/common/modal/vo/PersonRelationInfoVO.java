package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人关联方数据
 * @author anhong.Tu
 * @version $Id: PersonRelationInfoVO.java, v 0.1 2017/7/28 9:30 anhong.Tu Exp $
 */
@ApiModel(value = "个人关联方数据",description = "个人关联方数据")
public class PersonRelationInfoVO {
    @ApiModelProperty("关联企业ID")
    private String relationCompanyId;
    @ApiModelProperty("关联企业名称")
    private String relationCompanyName;
    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("省份地区")
    private String province;
    @ApiModelProperty(value ="注册资本")
    private  String regcap;
    @ApiModelProperty(value ="注册日期")
    private String esdate;
    @ApiModelProperty(value = "出资比例")
    private String investRatio;
    @ApiModelProperty(value = "法定代表人")
    private String frname;
    @ApiModelProperty(value = "登记状态")
    private String enterpriseStatus;
    @ApiModelProperty(value ="行业")
    private String industry;
    @ApiModelProperty(value = "风险等级")
    private String riskLevel;
    @ApiModelProperty(value = "易燃指数")
    private Float riskIndex;
    @ApiModelProperty(value ="民间借贷法律文书")
    private int totalPrivateLendingNum;
    @ApiModelProperty(value ="失信被执行人")
    private int totalDishonestyNum;
    @ApiModelProperty(value ="被执行人")
    private int totalZhixingNum;
    @ApiModelProperty(value ="行政处罚")
    private int totalXzcfNum;
    @ApiModelProperty(value ="经营异常")
    private int totalQyycNum;
    @ApiModelProperty(value ="诉讼")
    private int totalDocumentNum;
    @ApiModelProperty(value ="工商变更")
    private int totalBgxxNum;
    @ApiModelProperty(value ="对外投资")
    private int totalOutDegreeNum;
    @ApiModelProperty(value ="黑名单")
    private int totalBlackNum;
    @ApiModelProperty(value ="高风险")
    private int totalHighNum;
    @ApiModelProperty(value ="是否黑名单")
    private boolean black;

    public String getRelationCompanyId() {
        return relationCompanyId;
    }

    public void setRelationCompanyId(String relationCompanyId) {
        this.relationCompanyId = relationCompanyId;
    }

    public String getRelationCompanyName() {
        return relationCompanyName;
    }

    public void setRelationCompanyName(String relationCompanyName) {
        this.relationCompanyName = relationCompanyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegcap() {
        return regcap;
    }

    public void setRegcap(String regcap) {
        this.regcap = regcap;
    }

    public String getEsdate() {
        return esdate;
    }

    public void setEsdate(String esdate) {
        this.esdate = esdate;
    }

    public String getInvestRatio() {
        return investRatio;
    }

    public void setInvestRatio(String investRatio) {
        this.investRatio = investRatio;
    }

    public String getFrname() {
        return frname;
    }

    public void setFrname(String frname) {
        this.frname = frname;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Float getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(Float riskIndex) {
        this.riskIndex = riskIndex;
    }

    public int getTotalPrivateLendingNum() {
        return totalPrivateLendingNum;
    }

    public void setTotalPrivateLendingNum(int totalPrivateLendingNum) {
        this.totalPrivateLendingNum = totalPrivateLendingNum;
    }

    public int getTotalDishonestyNum() {
        return totalDishonestyNum;
    }

    public void setTotalDishonestyNum(int totalDishonestyNum) {
        this.totalDishonestyNum = totalDishonestyNum;
    }

    public int getTotalZhixingNum() {
        return totalZhixingNum;
    }

    public void setTotalZhixingNum(int totalZhixingNum) {
        this.totalZhixingNum = totalZhixingNum;
    }

    public int getTotalXzcfNum() {
        return totalXzcfNum;
    }

    public void setTotalXzcfNum(int totalXzcfNum) {
        this.totalXzcfNum = totalXzcfNum;
    }

    public int getTotalQyycNum() {
        return totalQyycNum;
    }

    public void setTotalQyycNum(int totalQyycNum) {
        this.totalQyycNum = totalQyycNum;
    }

    public int getTotalDocumentNum() {
        return totalDocumentNum;
    }

    public void setTotalDocumentNum(int totalDocumentNum) {
        this.totalDocumentNum = totalDocumentNum;
    }

    public int getTotalBgxxNum() {
        return totalBgxxNum;
    }

    public void setTotalBgxxNum(int totalBgxxNum) {
        this.totalBgxxNum = totalBgxxNum;
    }

    public int getTotalOutDegreeNum() {
        return totalOutDegreeNum;
    }

    public void setTotalOutDegreeNum(int totalOutDegreeNum) {
        this.totalOutDegreeNum = totalOutDegreeNum;
    }

    public int getTotalBlackNum() {
        return totalBlackNum;
    }

    public void setTotalBlackNum(int totalBlackNum) {
        this.totalBlackNum = totalBlackNum;
    }

    public int getTotalHighNum() {
        return totalHighNum;
    }

    public void setTotalHighNum(int totalHighNum) {
        this.totalHighNum = totalHighNum;
    }

    public boolean getBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }
}
