package com.bbd.dafei.common.modal.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业详情页面关联方相关信息
 * @author anhong.Tu
 * @version $Id: ApiFinancialVO.java, v 0.1 2017/7/28 9:30 anhong.Tu Exp $
 */
public class ApiFinancialVO {
    @SerializedName("bbd_qyxx_id")
    @ApiModelProperty("企业ID")
    private String companyId;
    @SerializedName("total_private_lending_num")
    @ApiModelProperty("3类法律文书中含“民间借贷”的总条数")
    private Integer totalPrivateLendingNum;
    @SerializedName("1d_estatus_num")
    @ApiModelProperty("1度内关联方总数_注吊销企业")
    private Integer estatusNum1d;
    @SerializedName("2d_estatus_num")
    @ApiModelProperty("2度内关联方总数_注吊销企业")
    private Integer estatusNum2d;
    @SerializedName("3d_estatus_num")
    @ApiModelProperty("3度内关联方总数_注吊销企业")
    private Integer estatusNum3d;
    @SerializedName("1d_common_interests_num")
    @ApiModelProperty("1度内关联方总数_关联方与目标公司利益一致")
    private Integer commonInterestsNum1d;
    @SerializedName("2d_common_interests_num")
    @ApiModelProperty("2度内关联方总数_关联方与目标公司利益一致")
    private Integer commonInterestsNum2d;
    @SerializedName("3d_common_interests_num")
    @ApiModelProperty("3度内关联方总数_关联方与目标公司利益一致")
    private Integer commonInterestsNum3d;
    @SerializedName("1d_same_address_num")
    @ApiModelProperty("1度内关联方总数_关联方与目标公司地址相同")
    private Integer sameAddressNum1d;
    @SerializedName("2d_same_address_num")
    @ApiModelProperty("2度内关联方总数_关联方与目标公司地址相同")
    private Integer sameAddressNum2d;
    @SerializedName("3d_same_address_num")
    @ApiModelProperty("3度内关联方总数_关联方与目标公司地址相同")
    private Integer sameAddressNum3d;
    @SerializedName("1d_black_num")
    @ApiModelProperty("1度内关联方总数_关联方为黑名单")
    private Integer blackNum1d;
    @SerializedName("2d_black_num")
    @ApiModelProperty("2度内关联方总数_关联方为黑名单")
    private Integer blackNum2d;
    @SerializedName("3d_black_num")
    @ApiModelProperty("3度内关联方总数_关联方为黑名单")
    private Integer blackNum3d;
    @SerializedName("1d_high_risk_num")
    @ApiModelProperty("1度内关联方总数_关联方为高风险")
    private Integer highRiskNum1d;
    @SerializedName("2d_high_risk_num")
    @ApiModelProperty("2度内关联方总数_关联方为高风险")
    private Integer highRiskNum2d;
    @SerializedName("3d_high_risk_num")
    @ApiModelProperty("3度内关联方总数_关联方为高风险")
    private Integer highRiskNum3d;
    @SerializedName("1d_new_finance_num")
    @ApiModelProperty("1度内关联方总数_关联方为新金融")
    private Integer newFinanceNum1d;
    @SerializedName("2d_new_finance_num")
    @ApiModelProperty("2度内关联方总数_关联方为新金融")
    private Integer newFinanceNum2d;
    @SerializedName("3d_new_finance_num")
    @ApiModelProperty("3度内关联方总数_关联方为新金融")
    private Integer newFinanceNum3d;
    @SerializedName("tar_dishonesty_num")
    @ApiModelProperty("失信被执行的总条数")
    private Integer totalDishonestyNum;
    @SerializedName("tar_zhixing_num")
    @ApiModelProperty("被执行的总条数")
    private Integer totalZhixingNum;
    @SerializedName("tar_xzcf_num")
    @ApiModelProperty("行政处罚的总条数")
    private Integer totalXzcfNum;
    @SerializedName("tar_jyyc_num")
    @ApiModelProperty("经营异常的总条数")
    private Integer totalQyycNum;
    @SerializedName("tar_ssws_num")
    @ApiModelProperty("诉讼文书的总条数")
    private Integer totalDocumentNum;
    @SerializedName("tar_bgxx_total_num")
    @ApiModelProperty("工商变更的总条数")
    private Integer totalBgxxNum;
    @SerializedName("tar_out_drgree")
    @ApiModelProperty("对外投资总数")
    private Integer totalOutDegreeNum;
    @SerializedName("1d_gather_place")
    @ApiModelProperty("1度关联聚集地")
    private String gatherPlace1d;
    @SerializedName("2d_gather_place")
    @ApiModelProperty("2度关联聚集地")
    private String gatherPlace2d;
    @SerializedName("3d_gather_place")
    @ApiModelProperty("3度关联聚集地")
    private String gatherPlace3d;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Integer getTotalPrivateLendingNum() {
        return totalPrivateLendingNum;
    }

    public void setTotalPrivateLendingNum(Integer totalPrivateLendingNum) {
        this.totalPrivateLendingNum = totalPrivateLendingNum;
    }

    public Integer getEstatusNum1d() {
        return estatusNum1d;
    }

    public void setEstatusNum1d(Integer estatusNum1d) {
        this.estatusNum1d = estatusNum1d;
    }

    public Integer getEstatusNum2d() {
        return estatusNum2d;
    }

    public void setEstatusNum2d(Integer estatusNum2d) {
        this.estatusNum2d = estatusNum2d;
    }

    public Integer getEstatusNum3d() {
        return estatusNum3d;
    }

    public void setEstatusNum3d(Integer estatusNum3d) {
        this.estatusNum3d = estatusNum3d;
    }

    public Integer getCommonInterestsNum1d() {
        return commonInterestsNum1d;
    }

    public void setCommonInterestsNum1d(Integer commonInterestsNum1d) {
        this.commonInterestsNum1d = commonInterestsNum1d;
    }

    public Integer getCommonInterestsNum2d() {
        return commonInterestsNum2d;
    }

    public void setCommonInterestsNum2d(Integer commonInterestsNum2d) {
        this.commonInterestsNum2d = commonInterestsNum2d;
    }

    public Integer getCommonInterestsNum3d() {
        return commonInterestsNum3d;
    }

    public void setCommonInterestsNum3d(Integer commonInterestsNum3d) {
        this.commonInterestsNum3d = commonInterestsNum3d;
    }

    public Integer getSameAddressNum1d() {
        return sameAddressNum1d;
    }

    public void setSameAddressNum1d(Integer sameAddressNum1d) {
        this.sameAddressNum1d = sameAddressNum1d;
    }

    public Integer getSameAddressNum2d() {
        return sameAddressNum2d;
    }

    public void setSameAddressNum2d(Integer sameAddressNum2d) {
        this.sameAddressNum2d = sameAddressNum2d;
    }

    public Integer getSameAddressNum3d() {
        return sameAddressNum3d;
    }

    public void setSameAddressNum3d(Integer sameAddressNum3d) {
        this.sameAddressNum3d = sameAddressNum3d;
    }

    public Integer getBlackNum1d() {
        return blackNum1d;
    }

    public void setBlackNum1d(Integer blackNum1d) {
        this.blackNum1d = blackNum1d;
    }

    public Integer getBlackNum2d() {
        return blackNum2d;
    }

    public void setBlackNum2d(Integer blackNum2d) {
        this.blackNum2d = blackNum2d;
    }

    public Integer getBlackNum3d() {
        return blackNum3d;
    }

    public void setBlackNum3d(Integer blackNum3d) {
        this.blackNum3d = blackNum3d;
    }

    public Integer getHighRiskNum1d() {
        return highRiskNum1d;
    }

    public void setHighRiskNum1d(Integer highRiskNum1d) {
        this.highRiskNum1d = highRiskNum1d;
    }

    public Integer getHighRiskNum2d() {
        return highRiskNum2d;
    }

    public void setHighRiskNum2d(Integer highRiskNum2d) {
        this.highRiskNum2d = highRiskNum2d;
    }

    public Integer getHighRiskNum3d() {
        return highRiskNum3d;
    }

    public void setHighRiskNum3d(Integer highRiskNum3d) {
        this.highRiskNum3d = highRiskNum3d;
    }

    public Integer getNewFinanceNum1d() {
        return newFinanceNum1d;
    }

    public void setNewFinanceNum1d(Integer newFinanceNum1d) {
        this.newFinanceNum1d = newFinanceNum1d;
    }

    public Integer getNewFinanceNum2d() {
        return newFinanceNum2d;
    }

    public void setNewFinanceNum2d(Integer newFinanceNum2d) {
        this.newFinanceNum2d = newFinanceNum2d;
    }

    public Integer getNewFinanceNum3d() {
        return newFinanceNum3d;
    }

    public void setNewFinanceNum3d(Integer newFinanceNum3d) {
        this.newFinanceNum3d = newFinanceNum3d;
    }

    public Integer getTotalDishonestyNum() {
        return totalDishonestyNum;
    }

    public void setTotalDishonestyNum(Integer totalDishonestyNum) {
        this.totalDishonestyNum = totalDishonestyNum;
    }

    public Integer getTotalZhixingNum() {
        return totalZhixingNum;
    }

    public void setTotalZhixingNum(Integer totalZhixingNum) {
        this.totalZhixingNum = totalZhixingNum;
    }

    public Integer getTotalXzcfNum() {
        return totalXzcfNum;
    }

    public void setTotalXzcfNum(Integer totalXzcfNum) {
        this.totalXzcfNum = totalXzcfNum;
    }

    public Integer getTotalQyycNum() {
        return totalQyycNum;
    }

    public void setTotalQyycNum(Integer totalQyycNum) {
        this.totalQyycNum = totalQyycNum;
    }

    public Integer getTotalDocumentNum() {
        return totalDocumentNum;
    }

    public void setTotalDocumentNum(Integer totalDocumentNum) {
        this.totalDocumentNum = totalDocumentNum;
    }

    public Integer getTotalBgxxNum() {
        return totalBgxxNum;
    }

    public void setTotalBgxxNum(Integer totalBgxxNum) {
        this.totalBgxxNum = totalBgxxNum;
    }

    public Integer getTotalOutDegreeNum() {
        return totalOutDegreeNum;
    }

    public void setTotalOutDegreeNum(Integer totalOutDegreeNum) {
        this.totalOutDegreeNum = totalOutDegreeNum;
    }

    public String getGatherPlace1d() {
        return gatherPlace1d;
    }

    public void setGatherPlace1d(String gatherPlace1d) {
        this.gatherPlace1d = gatherPlace1d;
    }

    public String getGatherPlace2d() {
        return gatherPlace2d;
    }

    public void setGatherPlace2d(String gatherPlace2d) {
        this.gatherPlace2d = gatherPlace2d;
    }

    public String getGatherPlace3d() {
        return gatherPlace3d;
    }

    public void setGatherPlace3d(String gatherPlace3d) {
        this.gatherPlace3d = gatherPlace3d;
    }
}
