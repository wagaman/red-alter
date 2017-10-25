package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人关联方详细信息
 * @author anhong.Tu
 * @version $Id: PersonDetailInfoVO.java, v 0.1 2017/7/28 9:30 anhong.Tu Exp $
 */
@ApiModel(value = "个人关联方详细信息",description = "个人关联方详细信息")
public class PersonDetailInfoVO {
    @ApiModelProperty("个人姓名")
    private String personName;
    @ApiModelProperty("简介")
    private String profile;
    @ApiModelProperty("个人关联方详细信息列表")
    private List<PersonRelationInfoVO> personRelationInfoVOS;
    @ApiModelProperty("关联黑名单企业")
    List<PersonRelationInfoVO> blackPersonRelationInfos;
    @ApiModelProperty("关联高风险企业")
    List<PersonRelationInfoVO> highRiskPersonRelationInfos;
    @ApiModelProperty("关联新金融企业")
    List<PersonRelationInfoVO> financePersonRelationInfos;
    @ApiModelProperty("关联吊注销企业")
    List<PersonRelationInfoVO> revokePersonRelationInfos;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<PersonRelationInfoVO> getPersonRelationInfoVOS() {
        return personRelationInfoVOS;
    }

    public void setPersonRelationInfoVOS(List<PersonRelationInfoVO> personRelationInfoVOS) {
        this.personRelationInfoVOS = personRelationInfoVOS;
    }

    public List<PersonRelationInfoVO> getBlackPersonRelationInfos() {
        return blackPersonRelationInfos;
    }

    public void setBlackPersonRelationInfos(List<PersonRelationInfoVO> blackPersonRelationInfos) {
        this.blackPersonRelationInfos = blackPersonRelationInfos;
    }

    public List<PersonRelationInfoVO> getHighRiskPersonRelationInfos() {
        return highRiskPersonRelationInfos;
    }

    public void setHighRiskPersonRelationInfos(List<PersonRelationInfoVO> highRiskPersonRelationInfos) {
        this.highRiskPersonRelationInfos = highRiskPersonRelationInfos;
    }

    public List<PersonRelationInfoVO> getFinancePersonRelationInfos() {
        return financePersonRelationInfos;
    }

    public void setFinancePersonRelationInfos(List<PersonRelationInfoVO> financePersonRelationInfos) {
        this.financePersonRelationInfos = financePersonRelationInfos;
    }

    public List<PersonRelationInfoVO> getRevokePersonRelationInfos() {
        return revokePersonRelationInfos;
    }

    public void setRevokePersonRelationInfos(List<PersonRelationInfoVO> revokePersonRelationInfos) {
        this.revokePersonRelationInfos = revokePersonRelationInfos;
    }
}
