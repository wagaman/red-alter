package com.bbd.dafei.common.modal.vo;

import com.bbd.wellspring.common.service.facade.relation.NodeVoSymbolEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * 关联节点VO
 * Created by wish on 2017/5/3.
 */
public class RelationNodeVO {
    private String addflag = "false";
    private String name;
    @ApiModelProperty(value = "关联度")
    private int category;
    @ApiModelProperty(value = "企业名称")
    private String cname;
    private NodeVoSymbolEnum symbol;
    @ApiModelProperty(value = "节点分类")
    private Integer color;
    @ApiModelProperty(value = "行业")
    private String industry;
    @ApiModelProperty(value = "关联关系")
    private String relationDescribe;
    @ApiModelProperty(value = "风险等级")
    private String riskLevel;
    @ApiModelProperty(value = "易燃指数")
    private Float riskIndex;
    @ApiModelProperty(value = "是否加入黑名单")
    private Boolean black;
    @ApiModelProperty(value = "序号")
    private Integer numIndex;

    public String getAddflag() {
        return addflag;
    }

    public void setAddflag(String addflag) {
        this.addflag = addflag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public NodeVoSymbolEnum getSymbol() {
        return symbol;
    }

    public void setSymbol(NodeVoSymbolEnum symbol) {
        this.symbol = symbol;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRelationDescribe() {
        return relationDescribe;
    }

    public void setRelationDescribe(String relationDescribe) {
        this.relationDescribe = relationDescribe;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Float getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(Float riskIndex) {
        this.riskIndex = riskIndex;
    }

    public Boolean getBlack() {
        return black;
    }

    public void setBlack(Boolean black) {
        this.black = black;
    }

    public Integer getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(Integer numIndex) {
        this.numIndex = numIndex;
    }
    
}
