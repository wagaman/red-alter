package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 舆情DTO
 * Created by wish on 2017/4/19.
 */
@ApiModel(value = "舆情")
public class YuqingDTO {
    @ApiModelProperty(value = "表类型")
    @SerializedName("bbd_type")
    private String bbdType;
    @ApiModelProperty(value = "日期")
    @SerializedName("bbd_dotime")
    private String bbdDotime;
    @ApiModelProperty(value = "来源url")
    @SerializedName("bbd_url")
    private String bbdUrl;
    @ApiModelProperty(value = "标题")
    @SerializedName("news_title")
    private String newsTitle;
    @ApiModelProperty(value = "网站")
    @SerializedName("news_site")
    private String newsSite;
    @ApiModelProperty(value = "发布时间")
    @SerializedName("pubdate")
    private String pubdate;
    @ApiModelProperty(value = "搜索关键字")
    @SerializedName("search_key")
    private String searchKey;
    @ApiModelProperty(value = "作者名称")
    @SerializedName("author")
    private String author;
    @ApiModelProperty(value = "原文")
    @SerializedName("main")
    private String main;
    @ApiModelProperty(value = "正文图片")
    @SerializedName("picture")
    private String picture;
    @ApiModelProperty(value = "status")
    @SerializedName("status")
    private Integer status;
    @ApiModelProperty(value = "table_name")
    @SerializedName("table_name")
    private String tableName;
    @ApiModelProperty(value = "转发量")
    @SerializedName("transfer_num")
    private Integer transferNum;
    @ApiModelProperty(value = "评论数")
    @SerializedName("comment_num")
    private Integer commentNum;
    @ApiModelProperty(value = "文章摘要")
    @SerializedName("abstract")
    private String articleAbstract;
    @ApiModelProperty(value = "所属网站板块")
    @SerializedName("plate")
    private String plate;
    @ApiModelProperty(value = "公司简称")
    @SerializedName("ipgp")
    private String ipgp;
    @ApiModelProperty(value = "关键词")
    @SerializedName("keyword")
    private String keyword;
    @ApiModelProperty(value = "点击数量")
    @SerializedName("click_num")
    private Integer clickNum;
    @ApiModelProperty(value = "新闻数量")
    @SerializedName("news_num")
    private Integer newsNum;
    @ApiModelProperty(value = "新闻总量")
    @SerializedName("total_news")
    private Integer totalNews;

    public String getBbdType() {
        return bbdType;
    }

    public void setBbdType(String bbdType) {
        this.bbdType = bbdType;
    }

    public String getBbdDotime() {
        return bbdDotime;
    }

    public void setBbdDotime(String bbdDotime) {
        this.bbdDotime = bbdDotime;
    }

    public String getBbdUrl() {
        return bbdUrl;
    }

    public void setBbdUrl(String bbdUrl) {
        this.bbdUrl = bbdUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTransferNum() {
        return transferNum;
    }

    public void setTransferNum(Integer transferNum) {
        this.transferNum = transferNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getIpgp() {
        return ipgp;
    }

    public void setIpgp(String ipgp) {
        this.ipgp = ipgp;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getNewsNum() {
        return newsNum;
    }

    public void setNewsNum(Integer newsNum) {
        this.newsNum = newsNum;
    }

    public Integer getTotalNews() {
        return totalNews;
    }

    public void setTotalNews(Integer totalNews) {
        this.totalNews = totalNews;
    }


}
