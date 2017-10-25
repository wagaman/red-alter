package com.bbd.dafei.common.modal.vo;

/**
 * Created by Administrator on 2017-07-28.
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业详情页面关联方信息
 * @author anhong.Tu
 * @version $Id: RelationListInfoVO.java, v 0.1 2017/7/28 9:30 anhong.Tu Exp $
 */
@ApiModel(value = "企业详情页面关联方列表信息")
public class RelationListInfoVO {
    @ApiModelProperty(value = "序号")
    private String numIndex;

    @ApiModelProperty(value = "唯一ID")
    private String dataId;

    @ApiModelProperty(value = "企业名/人名")
    private String name;

    @ApiModelProperty(value = "出资比例")
    private String investRatio;

    @ApiModelProperty(value = "关联度")
    private int category;

    @ApiModelProperty(value = "关联关系")
    private String relationDescribe;

    @ApiModelProperty(value ="注册资本")
    private  String regcap;

    @ApiModelProperty(value ="注册日期")
    private String esdate;

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

    @ApiModelProperty("是否黑名单")
    private boolean black;

    public String getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(String numIndex) {
        this.numIndex = numIndex;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvestRatio() {
        return investRatio;
    }

    public void setInvestRatio(String investRatio) {
        this.investRatio = investRatio;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getRelationDescribe() {
        return relationDescribe;
    }

    public void setRelationDescribe(String relationDescribe) {
        this.relationDescribe = relationDescribe;
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
