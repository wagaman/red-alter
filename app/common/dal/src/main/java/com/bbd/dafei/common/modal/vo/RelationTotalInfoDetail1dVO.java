package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * 企业详情页面右侧关联方信息1度
 * @author anhong.Tu
 * @version $Id: RelationTotalInfoVO.java, v 0.1 2017/7/25 9:30 anhong.Tu Exp $
 */
@ApiModel(value = "企业详情页面右侧关联方信息")
public class RelationTotalInfoDetail1dVO {
    @ApiModelProperty(value = "1度关键自然人")
    private String keyNature;
    @ApiModelProperty(value = "1度非关键自然人")
    private String unKeyNature;
    @ApiModelProperty(value = "1度关联集聚行业")
    private String relationIndustry;
    @ApiModelProperty(value = "1度关联聚集地")
    private String relationPlace;
    @ApiModelProperty(value = "1度黑名单数量")
    private int blackNum;
    @ApiModelProperty(value = "1度高风险企业数")
    private int highRiskNum;
    @ApiModelProperty(value = "1度新兴金融企业数")
    private int newFinanceNum;
    @ApiModelProperty(value = "1度利益一致行动法人数")
    private int commonInterestsNum;
    @ApiModelProperty(value = "1度地址相同企业数")
    private int sameAddressNum;
    @ApiModelProperty(value = "1度注吊销企业数")
    private int cancelNum;
    @ApiModelProperty(value = "1度关联方总数")
    private int relationTotalNum;
    @ApiModelProperty(value = "1度关联方ID列表")
    private List<String> nodeCompanyIdList;
    @ApiModelProperty(value = "1度黑名单企业列表")
    private List<String> blackList;
    @ApiModelProperty(value = "1度高危企业列表")
    private List<String> highList;
    public String getKeyNature() {
        return keyNature;
    }

    public void setKeyNature(String keyNature) {
        this.keyNature = keyNature;
    }

    public String getUnKeyNature() {
        return unKeyNature;
    }

    public void setUnKeyNature(String unKeyNature) {
        this.unKeyNature = unKeyNature;
    }

    public String getRelationIndustry() {
        return relationIndustry;
    }

    public void setRelationIndustry(String relationIndustry) {
        this.relationIndustry = relationIndustry;
    }

    public String getRelationPlace() {
        return relationPlace;
    }

    public void setRelationPlace(String relationPlace) {
        this.relationPlace = relationPlace;
    }

    public int getBlackNum() {
        return blackNum;
    }

    public void setBlackNum(int blackNum) {
        this.blackNum = blackNum;
    }

    public int getHighRiskNum() {
        return highRiskNum;
    }

    public void setHighRiskNum(int highRiskNum) {
        this.highRiskNum = highRiskNum;
    }

    public int getNewFinanceNum() {
        return newFinanceNum;
    }

    public void setNewFinanceNum(int newFinanceNum) {
        this.newFinanceNum = newFinanceNum;
    }

    public int getCommonInterestsNum() {
        return commonInterestsNum;
    }

    public void setCommonInterestsNum(int commonInterestsNum) {
        this.commonInterestsNum = commonInterestsNum;
    }

    public int getSameAddressNum() {
        return sameAddressNum;
    }

    public void setSameAddressNum(int sameAddressNum) {
        this.sameAddressNum = sameAddressNum;
    }

    public int getCancelNum() {
        return cancelNum;
    }

    public void setCancelNum(int cancelNum) {
        this.cancelNum = cancelNum;
    }

    public int getRelationTotalNum() {
        return relationTotalNum;
    }

    public void setRelationTotalNum(int relationTotalNum) {
        this.relationTotalNum = relationTotalNum;
    }

    public List<String> getNodeCompanyIdList() {
        return nodeCompanyIdList;
    }

    public void setNodeCompanyIdList(List<String> nodeCompanyIdList) {
        this.nodeCompanyIdList = nodeCompanyIdList;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    public List<String> getHighList() {
        return highList;
    }

    public void setHighList(List<String> highList) {
        this.highList = highList;
    }
}
