package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel(value = "司法拍卖")
public class SfpmDto {
    @ApiModelProperty(value = "标题")
    @SerializedName("title")
    private String title;
    @ApiModelProperty(value = "起拍价")
    @SerializedName("start_price")
    private String startPrice;
    @ApiModelProperty(value = "竞买公告")
    @SerializedName("bid_announce")
    private String bidAnnounce;
    @ApiModelProperty(value = "资产处置单位")
    @SerializedName("disposal_unit")
    private String disposalUnit;
    @ApiModelProperty(value = "拍卖法院")
    @SerializedName("auction_court")
    private String auctionCourt;
    @ApiModelProperty(value = "竞买记录")
    @SerializedName("bid_document")
    private String bidDocument;
    @ApiModelProperty(value = "竞买须知")
    @SerializedName("bid_instructions")
    private String bidInstructions;
    @ApiModelProperty(value = "拍卖人")
    @SerializedName("auctioneer")
    private String auctioneer;
    @ApiModelProperty(value = "拍卖日期")
    @SerializedName("auction_date")
    private String auctionDate;
    @ApiModelProperty(value = "拍品现状及瑕疵")
    @SerializedName("auction_status")
    private String auctionStatus;
    @ApiModelProperty(value = "权证情况")
    @SerializedName("warrants_status")
    private String warrantsStatus;
    @ApiModelProperty(value = "拍品名称")
    @SerializedName("auction_name")
    private String auctionName;
    @ApiModelProperty(value = "提供的文件")
    @SerializedName("provid_file")
    private String providFile;
    @ApiModelProperty(value = "拍品介绍")
    @SerializedName("auction_introduce")
    private String auctionIntroduce;
    @ApiModelProperty(value = "权利限制情况")
    @SerializedName("right_restriction")
    private String rightRestriction;
    @ApiModelProperty(value = "处置依据")
    @SerializedName("disposal_basis")
    private String disposalBasis;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getBidAnnounce() {
        return bidAnnounce;
    }

    public void setBidAnnounce(String bidAnnounce) {
        this.bidAnnounce = bidAnnounce;
    }

    public String getDisposalUnit() {
        return disposalUnit;
    }

    public void setDisposalUnit(String disposalUnit) {
        this.disposalUnit = disposalUnit;
    }

    public String getAuctionCourt() {
        return auctionCourt;
    }

    public void setAuctionCourt(String auctionCourt) {
        this.auctionCourt = auctionCourt;
    }

    public String getBidDocument() {
        return bidDocument;
    }

    public void setBidDocument(String bidDocument) {
        this.bidDocument = bidDocument;
    }

    public String getBidInstructions() {
        return bidInstructions;
    }

    public void setBidInstructions(String bidInstructions) {
        this.bidInstructions = bidInstructions;
    }

    public String getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(String auctioneer) {
        this.auctioneer = auctioneer;
    }

    public String getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(String auctionDate) {
        this.auctionDate = auctionDate;
    }

    public String getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public String getWarrantsStatus() {
        return warrantsStatus;
    }

    public void setWarrantsStatus(String warrantsStatus) {
        this.warrantsStatus = warrantsStatus;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public String getProvidFile() {
        return providFile;
    }

    public void setProvidFile(String providFile) {
        this.providFile = providFile;
    }

    public String getAuctionIntroduce() {
        return auctionIntroduce;
    }

    public void setAuctionIntroduce(String auctionIntroduce) {
        this.auctionIntroduce = auctionIntroduce;
    }

    public String getRightRestriction() {
        return rightRestriction;
    }

    public void setRightRestriction(String rightRestriction) {
        this.rightRestriction = rightRestriction;
    }

    public String getDisposalBasis() {
        return disposalBasis;
    }

    public void setDisposalBasis(String disposalBasis) {
        this.disposalBasis = disposalBasis;
    }
}
