package com.bbd.dafei.common.dal.po;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017-07-28.
 */
public class ApiFinancialPO {

    @JSONField(name ="total_private_lending_num")
    @ApiModelProperty("3类法律文书中含“民间借贷”的总条数")
    private int totalPrivateLendingNum;
    @JSONField(name ="1d_common_interests_num")
    @ApiModelProperty("1度内关联方总数_关联方与目标公司利益一致")
    private int commonInterestsNum1d;
    @JSONField(name ="2d_common_interests_num")
    @ApiModelProperty("2度内关联方总数_关联方与目标公司利益一致")
    private int commonInterestsNum2d;
    @JSONField(name ="3d_common_interests_num")
    @ApiModelProperty("3度内关联方总数_关联方与目标公司利益一致")
    private int commonInterestsNum3d;
    @JSONField(name ="1d_same_address_num")
    @ApiModelProperty("1度内关联方总数_关联方与目标公司地址相同")
    private int sameAddressNum1d;
    @JSONField(name ="2d_same_address_num")
    @ApiModelProperty("2度内关联方总数_关联方与目标公司地址相同")
    private int sameAddressNum2d;
    @JSONField(name ="3d_same_address_num")
    @ApiModelProperty("3度内关联方总数_关联方与目标公司地址相同")
    private int sameAddressNum3d;
    @JSONField(name ="1d_black_num")
    @ApiModelProperty("1度内关联方总数_关联方为黑名单")
    private int blackNum1d;
    @JSONField(name ="2d_black_num")
    @ApiModelProperty("2度内关联方总数_关联方为黑名单")
    private int blackNum2d;
    @JSONField(name ="3d_black_num")
    @ApiModelProperty("3度内关联方总数_关联方为黑名单")
    private int blackNum3d;
    @JSONField(name ="1d_high_risk_num")
    @ApiModelProperty("1度内关联方总数_关联方为高风险")
    private int highRiskNum1d;
    @JSONField(name ="2d_high_risk_num")
    @ApiModelProperty("2度内关联方总数_关联方为高风险")
    private int highRiskNum2d;
    @JSONField(name ="3d_high_risk_num")
    @ApiModelProperty("3度内关联方总数_关联方为高风险")
    private int highRiskNum3d;
    @JSONField(name ="1d_new_finance_num")
    @ApiModelProperty("1度内关联方总数_关联方为新金融")
    private int newFinanceNum1d;
    @JSONField(name ="2d_new_finance_num")
    @ApiModelProperty("2度内关联方总数_关联方为新金融")
    private int newFinanceNum2d;
    @JSONField(name ="3d_new_finance_num")
    @ApiModelProperty("3度内关联方总数_关联方为新金融")
    private int newFinanceNum3d;
    @JSONField(name ="1d_common_interests_name")
    @ApiModelProperty("1度内关联方所有公司名_关联方与目标公司利益一致")
    private String commonInterestsName1d;
    @JSONField(name ="2d_common_interests_name")
    @ApiModelProperty("2度内关联方所有公司名_关联方与目标公司利益一致")
    private String commonInterestsName2d;
    @JSONField(name ="3d_common_interests_name")
    @ApiModelProperty("3度内关联方所有公司名_关联方与目标公司利益一致")
    private String commonInterestsName3d;
    @JSONField(name="1d_same_address_name")
    @ApiModelProperty("1度内关联方所有公司名_关联方与目标公司地址相同")
    private String sameAddressName1d;
    @JSONField(name="2d_same_address_name")
    @ApiModelProperty("2度内关联方所有公司名_关联方与目标公司地址相同")
    private String sameAddressName2d;
    @JSONField(name="3d_same_address_name")
    @ApiModelProperty("3度内关联方所有公司名_关联方与目标公司地址相同")
    private String sameAddressName3d;
    @JSONField(name="1d_black_name")
    @ApiModelProperty("1度内关联方所有公司名_关联方为黑名单")
    private String blackName1d;
    @JSONField(name="2d_black_name")
    @ApiModelProperty("2度内关联方所有公司名_关联方为黑名单")
    private String blackName2d;
    @JSONField(name="3d_black_name")
    @ApiModelProperty("3度内关联方所有公司名_关联方为黑名单")
    private String blackName3d;
    @JSONField(name="1d_high_risk_name")
    @ApiModelProperty("1度内关联方所有公司名_关联方为高风险")
    private String highRiskName1d;
    @JSONField(name="2d_high_risk_name")
    @ApiModelProperty("2度内关联方所有公司名_关联方为高风险")
    private String highRiskName2d;
    @JSONField(name="3d_high_risk_name")
    @ApiModelProperty("3度内关联方所有公司名_关联方为高风险")
    private String highRiskName3d;
    @JSONField(name="1d_new_finance_name")
    @ApiModelProperty("1度内关联方所有公司名_关联方为新金融")
    private String newFinanceName1d;
    @JSONField(name="2d_new_finance_name")
    @ApiModelProperty("2度内关联方所有公司名_关联方为新金融")
    private String newFinanceName2d;
    @JSONField(name="3d_new_finance_name")
    @ApiModelProperty("3度内关联方所有公司名_关联方为新金融")
    private String newFinanceName3d;
    @JSONField(name="total_dishonesty_num")
    @ApiModelProperty("失信被执行的总条数")
    private String totalDishonestyNum;
    @JSONField(name="total_zhixing_num")
    @ApiModelProperty("被执行的总条数")
    private String totalZhixingNum;
    @JSONField(name="total_xzcf_num")
    @ApiModelProperty("行政处罚的总条数")
    private String totalXzcfNum;
    @JSONField(name="total_qyyc_num")
    @ApiModelProperty("经营异常的总条数")
    private String totalQyycNum;
    @JSONField(name="total_document_num")
    @ApiModelProperty("诉讼文书的总条数")
    private String totalDocumentNum;
    @JSONField(name="total_bgxx_num")
    @ApiModelProperty("工商变更的总条数")
    private String totalBgxxNum;
    @JSONField(name="total_out_degree_num")
    @ApiModelProperty("对外投资总数")
    private String totalOutDegreeNum;

    public int getTotalPrivateLendingNum() {
        return totalPrivateLendingNum;
    }

    public void setTotalPrivateLendingNum(int totalPrivateLendingNum) {
        this.totalPrivateLendingNum = totalPrivateLendingNum;
    }

    public int getCommonInterestsNum1d() {
        return commonInterestsNum1d;
    }

    public void setCommonInterestsNum1d(int commonInterestsNum1d) {
        this.commonInterestsNum1d = commonInterestsNum1d;
    }

    public int getCommonInterestsNum2d() {
        return commonInterestsNum2d;
    }

    public void setCommonInterestsNum2d(int commonInterestsNum2d) {
        this.commonInterestsNum2d = commonInterestsNum2d;
    }

    public int getCommonInterestsNum3d() {
        return commonInterestsNum3d;
    }

    public void setCommonInterestsNum3d(int commonInterestsNum3d) {
        this.commonInterestsNum3d = commonInterestsNum3d;
    }

    public int getSameAddressNum1d() {
        return sameAddressNum1d;
    }

    public void setSameAddressNum1d(int sameAddressNum1d) {
        this.sameAddressNum1d = sameAddressNum1d;
    }

    public int getSameAddressNum2d() {
        return sameAddressNum2d;
    }

    public void setSameAddressNum2d(int sameAddressNum2d) {
        this.sameAddressNum2d = sameAddressNum2d;
    }

    public int getSameAddressNum3d() {
        return sameAddressNum3d;
    }

    public void setSameAddressNum3d(int sameAddressNum3d) {
        this.sameAddressNum3d = sameAddressNum3d;
    }

    public int getBlackNum1d() {
        return blackNum1d;
    }

    public void setBlackNum1d(int blackNum1d) {
        this.blackNum1d = blackNum1d;
    }

    public int getBlackNum2d() {
        return blackNum2d;
    }

    public void setBlackNum2d(int blackNum2d) {
        this.blackNum2d = blackNum2d;
    }

    public int getBlackNum3d() {
        return blackNum3d;
    }

    public void setBlackNum3d(int blackNum3d) {
        this.blackNum3d = blackNum3d;
    }

    public int getHighRiskNum1d() {
        return highRiskNum1d;
    }

    public void setHighRiskNum1d(int highRiskNum1d) {
        this.highRiskNum1d = highRiskNum1d;
    }

    public int getHighRiskNum2d() {
        return highRiskNum2d;
    }

    public void setHighRiskNum2d(int highRiskNum2d) {
        this.highRiskNum2d = highRiskNum2d;
    }

    public int getHighRiskNum3d() {
        return highRiskNum3d;
    }

    public void setHighRiskNum3d(int highRiskNum3d) {
        this.highRiskNum3d = highRiskNum3d;
    }

    public int getNewFinanceNum1d() {
        return newFinanceNum1d;
    }

    public void setNewFinanceNum1d(int newFinanceNum1d) {
        this.newFinanceNum1d = newFinanceNum1d;
    }

    public int getNewFinanceNum2d() {
        return newFinanceNum2d;
    }

    public void setNewFinanceNum2d(int newFinanceNum2d) {
        this.newFinanceNum2d = newFinanceNum2d;
    }

    public int getNewFinanceNum3d() {
        return newFinanceNum3d;
    }

    public void setNewFinanceNum3d(int newFinanceNum3d) {
        this.newFinanceNum3d = newFinanceNum3d;
    }

    public String getCommonInterestsName1d() {
        return commonInterestsName1d;
    }

    public void setCommonInterestsName1d(String commonInterestsName1d) {
        this.commonInterestsName1d = commonInterestsName1d;
    }

    public String getCommonInterestsName2d() {
        return commonInterestsName2d;
    }

    public void setCommonInterestsName2d(String commonInterestsName2d) {
        this.commonInterestsName2d = commonInterestsName2d;
    }

    public String getCommonInterestsName3d() {
        return commonInterestsName3d;
    }

    public void setCommonInterestsName3d(String commonInterestsName3d) {
        this.commonInterestsName3d = commonInterestsName3d;
    }

    public String getSameAddressName1d() {
        return sameAddressName1d;
    }

    public void setSameAddressName1d(String sameAddressName1d) {
        this.sameAddressName1d = sameAddressName1d;
    }

    public String getSameAddressName2d() {
        return sameAddressName2d;
    }

    public void setSameAddressName2d(String sameAddressName2d) {
        this.sameAddressName2d = sameAddressName2d;
    }

    public String getSameAddressName3d() {
        return sameAddressName3d;
    }

    public void setSameAddressName3d(String sameAddressName3d) {
        this.sameAddressName3d = sameAddressName3d;
    }

    public String getBlackName1d() {
        return blackName1d;
    }

    public void setBlackName1d(String blackName1d) {
        this.blackName1d = blackName1d;
    }

    public String getBlackName2d() {
        return blackName2d;
    }

    public void setBlackName2d(String blackName2d) {
        this.blackName2d = blackName2d;
    }

    public String getBlackName3d() {
        return blackName3d;
    }

    public void setBlackName3d(String blackName3d) {
        this.blackName3d = blackName3d;
    }

    public String getHighRiskName1d() {
        return highRiskName1d;
    }

    public void setHighRiskName1d(String highRiskName1d) {
        this.highRiskName1d = highRiskName1d;
    }

    public String getHighRiskName2d() {
        return highRiskName2d;
    }

    public void setHighRiskName2d(String highRiskName2d) {
        this.highRiskName2d = highRiskName2d;
    }

    public String getHighRiskName3d() {
        return highRiskName3d;
    }

    public void setHighRiskName3d(String highRiskName3d) {
        this.highRiskName3d = highRiskName3d;
    }

    public String getNewFinanceName1d() {
        return newFinanceName1d;
    }

    public void setNewFinanceName1d(String newFinanceName1d) {
        this.newFinanceName1d = newFinanceName1d;
    }

    public String getNewFinanceName2d() {
        return newFinanceName2d;
    }

    public void setNewFinanceName2d(String newFinanceName2d) {
        this.newFinanceName2d = newFinanceName2d;
    }

    public String getNewFinanceName3d() {
        return newFinanceName3d;
    }

    public void setNewFinanceName3d(String newFinanceName3d) {
        this.newFinanceName3d = newFinanceName3d;
    }

    public String getTotalDishonestyNum() {
        return totalDishonestyNum;
    }

    public void setTotalDishonestyNum(String totalDishonestyNum) {
        this.totalDishonestyNum = totalDishonestyNum;
    }

    public String getTotalZhixingNum() {
        return totalZhixingNum;
    }

    public void setTotalZhixingNum(String totalZhixingNum) {
        this.totalZhixingNum = totalZhixingNum;
    }

    public String getTotalXzcfNum() {
        return totalXzcfNum;
    }

    public void setTotalXzcfNum(String totalXzcfNum) {
        this.totalXzcfNum = totalXzcfNum;
    }

    public String getTotalQyycNum() {
        return totalQyycNum;
    }

    public void setTotalQyycNum(String totalQyycNum) {
        this.totalQyycNum = totalQyycNum;
    }

    public String getTotalDocumentNum() {
        return totalDocumentNum;
    }

    public void setTotalDocumentNum(String totalDocumentNum) {
        this.totalDocumentNum = totalDocumentNum;
    }

    public String getTotalBgxxNum() {
        return totalBgxxNum;
    }

    public void setTotalBgxxNum(String totalBgxxNum) {
        this.totalBgxxNum = totalBgxxNum;
    }

    public String getTotalOutDegreeNum() {
        return totalOutDegreeNum;
    }

    public void setTotalOutDegreeNum(String totalOutDegreeNum) {
        this.totalOutDegreeNum = totalOutDegreeNum;
    }
}
