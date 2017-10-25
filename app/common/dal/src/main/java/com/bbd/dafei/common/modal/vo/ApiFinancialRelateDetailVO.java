package com.bbd.dafei.common.modal.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017-08-10.
 */
public class ApiFinancialRelateDetailVO {
    @SerializedName("dishonesty_num")
    @ApiModelProperty("失信被执行的总条数")
    private Integer totalDishonestyNum;
    @SerializedName("zhixing_num")
    @ApiModelProperty("被执行的总条数")
    private Integer totalZhixingNum;
    @SerializedName("xzcf_num")
    @ApiModelProperty("行政处罚的总条数")
    private Integer totalXzcfNum;
    @SerializedName("jyyc_num")
    @ApiModelProperty("经营异常的总条数")
    private Integer totalQyycNum;
    @SerializedName("ssws_num")
    @ApiModelProperty("诉讼文书的总条数")
    private Integer totalDocumentNum;
    @SerializedName("bgxx_num")
    @ApiModelProperty("工商变更的总条数")
    private Integer totalBgxxNum;
    @SerializedName("out_degree")
    @ApiModelProperty("对外投资总数")
    private Integer totalOutDegreeNum;
    @SerializedName("black_relation_num")
    @ApiModelProperty("黑名单数量")
    private Integer blackRelationNum;
    @SerializedName("high_relation_num")
    @ApiModelProperty("高风险数量")
    private Integer highRelationNum;
    @SerializedName("lending_num")
    @ApiModelProperty("民间借贷")
    private Integer lendingNum;

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

    public Integer getBlackRelationNum() {
        return blackRelationNum;
    }

    public void setBlackRelationNum(Integer blackRelationNum) {
        this.blackRelationNum = blackRelationNum;
    }

    public Integer getHighRelationNum() {
        return highRelationNum;
    }

    public void setHighRelationNum(Integer highRelationNum) {
        this.highRelationNum = highRelationNum;
    }

    public Integer getLendingNum() {
        return lendingNum;
    }

    public void setLendingNum(Integer lendingNum) {
        this.lendingNum = lendingNum;
    }
}
