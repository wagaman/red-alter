package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 舆情DTO
 * Created by wish on 2017/8/20.
 */
@ApiModel("舆情")
public class YuqingContentDTO {
    @ApiModelProperty(value = "标题")
    @SerializedName("news_title")
    private String newsTitle;
    @ApiModelProperty(value = "正文")
    @SerializedName("main")
    private String main;
    @ApiModelProperty(value = "摘要")
    @SerializedName("abstract")
    private String abstract_;
    @ApiModelProperty(value = "发布时间")
    @SerializedName("pubdate")
    private String pubdate;
    @ApiModelProperty(value = "来源网站")
    @SerializedName("news_site")
    private String newsSite;
    @ApiModelProperty(value = "浏览数")
    @SerializedName("click_num")
    private String clickNum;
    @ApiModelProperty(value = "评论数")
    @SerializedName("comment_num")
    private String commentNum;
    @ApiModelProperty(value = "所属网站版块")
    @SerializedName("plate")
    private String plate;
    @ApiModelProperty(value = "作者")
    @SerializedName("author")
    private String author;
    @ApiModelProperty(value = "关键词")
    @SerializedName("keyword")
    private String keyword;
    @ApiModelProperty(value = "地名地址")
    @SerializedName("add")
    private String add;
    @ApiModelProperty(value = "算法时间")
    @SerializedName("time")
    private String time;
    @ApiModelProperty(value = "机构")
    @SerializedName("org")
    private String org;
    @ApiModelProperty(value = "政策")
    @SerializedName("pol")
    private String pol;
    @ApiModelProperty(value = "产品")
    @SerializedName("prod")
    private String prod;
    @ApiModelProperty(value = "人名职位")
    @SerializedName("pos")
    private String pos;
    @ApiModelProperty(value = "公司名称")
    @SerializedName("cmp")
    private String cmp;
    @ApiModelProperty(value = "去重hash码")
    @SerializedName("sim_hash")
    private String simHash;
    @ApiModelProperty(value = "新闻类型")
    @SerializedName("news_catg")
    private String newsCatg;
    @ApiModelProperty(value = "行业类型")
    @SerializedName("biz_catg")
    private String bizCatg;
    @ApiModelProperty(value = "通用情感打分")
    @SerializedName("gen_senti")
    private String genSenti;
    @ApiModelProperty(value = "指向情感打分")
    @SerializedName("orit_senti")
    private String oritSenti;
    @ApiModelProperty(value = "算法摘要")
    @SerializedName("summary")
    private String summary;
    @ApiModelProperty(value = "算法关键词")
    @SerializedName("kws_list")
    private String kwsList;
    @ApiModelProperty(value = "新型金融类型")
    @SerializedName("new_fnncl_catg")
    private String newFnnclCatg;
    @ApiModelProperty(value = "金融行业新闻事件情感打分")
    @SerializedName("financial_senti")
    private Integer financialSenti;
    @ApiModelProperty(value = "平台名称")
    @SerializedName("ipgp")
    private String ipgp;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getAbstract_() {
        return abstract_;
    }

    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getClickNum() {
        return clickNum;
    }

    public void setClickNum(String clickNum) {
        this.clickNum = clickNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getSimHash() {
        return simHash;
    }

    public void setSimHash(String simHash) {
        this.simHash = simHash;
    }

    public String getNewsCatg() {
        return newsCatg;
    }

    public void setNewsCatg(String newsCatg) {
        this.newsCatg = newsCatg;
    }

    public String getBizCatg() {
        return bizCatg;
    }

    public void setBizCatg(String bizCatg) {
        this.bizCatg = bizCatg;
    }

    public String getGenSenti() {
        return genSenti;
    }

    public void setGenSenti(String genSenti) {
        this.genSenti = genSenti;
    }

    public String getOritSenti() {
        return oritSenti;
    }

    public void setOritSenti(String oritSenti) {
        this.oritSenti = oritSenti;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKwsList() {
        return kwsList;
    }

    public void setKwsList(String kwsList) {
        this.kwsList = kwsList;
    }

    public String getNewFnnclCatg() {
        return newFnnclCatg;
    }

    public void setNewFnnclCatg(String newFnnclCatg) {
        this.newFnnclCatg = newFnnclCatg;
    }

    public Integer getFinancialSenti() {
        return financialSenti;
    }

    public void setFinancialSenti(Integer financialSenti) {
        this.financialSenti = financialSenti;
    }

    public String getIpgp() {
        return ipgp;
    }

    public void setIpgp(String ipgp) {
        this.ipgp = ipgp;
    }
}
