package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wish on 2017/8/30.
 */
@ApiModel()
public class YuqingRelateContentDTO {
    @ApiModelProperty(value = "来源")
    @SerializedName("bbd_source")
    private String bbdSource;
    @ApiModelProperty(value = "公司名")
    @SerializedName("company_name")
    private String companyName;
    @ApiModelProperty(value = "新闻id")
    @SerializedName("id")
    private String id;
    @ApiModelProperty(value = "舆情情感")
    @SerializedName("news_evaluate")
    private String newsEvaluate;
    @ApiModelProperty(value = "新闻摘要")
    @SerializedName("news_roundup")
    private String newsRoundup;
    @ApiModelProperty(value = "正文")
    @SerializedName("main")
    private String main;
    @ApiModelProperty(value = "新闻标题")
    @SerializedName("news_title")
    private String newsTitle;
    @ApiModelProperty(value = "pubdate")
    @SerializedName("pubdate")
    private String pubdate;

    public String getBbdSource() {
        return bbdSource;
    }

    public void setBbdSource(String bbdSource) {
        this.bbdSource = bbdSource;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsEvaluate() {
        return newsEvaluate;
    }

    public void setNewsEvaluate(String newsEvaluate) {
        this.newsEvaluate = newsEvaluate;
    }

    public String getNewsRoundup() {
        return newsRoundup;
    }

    public void setNewsRoundup(String newsRoundup) {
        this.newsRoundup = newsRoundup;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }
}
