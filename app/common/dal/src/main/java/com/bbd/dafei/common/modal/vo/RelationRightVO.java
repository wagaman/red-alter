package com.bbd.dafei.common.modal.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

/**
 * Created by shi.jun on 2017/9/20.
 */
@ApiModel("企业详情右侧的关联方数据")
public class RelationRightVO {

    @ApiModelProperty("企业ID")
    private String companyId;
    @ApiModelProperty("企业名称")
    private String companyName;
    @ApiModelProperty("关键自然人")
    private String keyNature;
    @ApiModelProperty("关键非自然人")
    private String keyNoNature;
    @ApiModelProperty("关键集聚行业")
    private String keyIndustry;
    @ApiModelProperty("关键集聚行业")
    private String keyLocation;
    @ApiModelProperty("黑名单数")
    private Integer blacklistNum;
    @ApiModelProperty("高风险企业数")
    private Integer highDangerCompanyNum;
    @ApiModelProperty("新金融企业数")
    private Integer newFinanceCompanyNum;
    @ApiModelProperty("利益一致行动法人数")
    private Integer benefitConsNum;
    @ApiModelProperty("地址相同企业数")
    private Integer sameLocationCompanyNum;
    @ApiModelProperty("注吊销企业数")
    private Integer revokeCompanyNum;
    @ApiModelProperty("维度数(1,2,3)")
    private Integer dimension;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getKeyNature() {
        return keyNature;
    }

    public void setKeyNature(String keyNature) {
        this.keyNature = keyNature;
    }

    public String getKeyNoNature() {
        return keyNoNature;
    }

    public void setKeyNoNature(String keyNoNature) {
        this.keyNoNature = keyNoNature;
    }

    public String getKey_industry() {
        return keyIndustry;
    }

    public void setKey_industry(String key_industry) {
        this.keyIndustry = key_industry;
    }

    public String getKeyLocation() {
        return keyLocation;
    }

    public void setKeyLocation(String keyLocation) {
        this.keyLocation = keyLocation;
    }

    public Integer getBlacklistNum() {
        return blacklistNum;
    }

    public void setBlacklistNum(Integer blacklistNum) {
        this.blacklistNum = blacklistNum;
    }

    public Integer getHighDangerCompanyNum() {
        return highDangerCompanyNum;
    }

    public void setHighDangerCompanyNum(Integer highDangerCompanyNum) {
        this.highDangerCompanyNum = highDangerCompanyNum;
    }

    public Integer getNewFinanceCompanyNum() {
        return newFinanceCompanyNum;
    }

    public void setNewFinanceCompanyNum(Integer newFinanceCompanyNum) {
        this.newFinanceCompanyNum = newFinanceCompanyNum;
    }

    public Integer getBenefitCons_num() {
        return benefitConsNum;
    }

    public void setBenefitCons_num(Integer benefitCons_num) {
        this.benefitConsNum = benefitCons_num;
    }

    public Integer getSameLocationCompanyNum() {
        return sameLocationCompanyNum;
    }

    public void setSameLocationCompanyNum(Integer sameLocationCompanyNum) {
        this.sameLocationCompanyNum = sameLocationCompanyNum;
    }

    public Integer getRevokeCompanyNum() {
        return revokeCompanyNum;
    }

    public void setRevokeCompanyNum(Integer revokeCompanyNum) {
        this.revokeCompanyNum = revokeCompanyNum;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    }
