package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * Created by wish on 2017/4/24.
 */
@ApiModel("企业关联信息")
public class RelationInfoVO {
    @ApiModelProperty(value = "一度关联关键自然人（与3.5KPI定义不同）")
    private List<String> pivotalNaturalPersonsTop1d;
    @ApiModelProperty(value = "二度关联关键自然人（与3.5KPI定义不同）")
    private  List<String> pivotalNaturalPersonsTop2d;
    @ApiModelProperty(value = "三度关联关键自然人（与3.5KPI定义不同）")
    private  List<String> pivotalNaturalPersonsTop3d;
    @ApiModelProperty(value = "一度关联关键非自然人（新增）")
    private  List<String> pivotalNonNaturalPersonsTop1d;
    @ApiModelProperty(value = "二度关联关键非自然人（新增）")
    private  List<String> pivotalNonNaturalPersonsTop2d;
    @ApiModelProperty(value = "三度关联关键非自然人（新增）")
    private  List<String> pivotalNonNaturalPersonsTop3d;
    @ApiModelProperty(value = "一度关联方行业")
    private List<String> industrySpanTop1d;
    @ApiModelProperty(value = "二度关联方行业")
    private List<String> industrySpanTop2d;
    @ApiModelProperty(value = "三度关联方行业")
    private List<String> industrySpanTop3d;

    public List<String> getPivotalNaturalPersonsTop1d() {
        return pivotalNaturalPersonsTop1d;
    }

    public void setPivotalNaturalPersonsTop1d(List<String> pivotalNaturalPersonsTop1d) {
        this.pivotalNaturalPersonsTop1d = pivotalNaturalPersonsTop1d;
    }

    public List<String> getPivotalNaturalPersonsTop2d() {
        return pivotalNaturalPersonsTop2d;
    }

    public void setPivotalNaturalPersonsTop2d(List<String> pivotalNaturalPersonsTop2d) {
        this.pivotalNaturalPersonsTop2d = pivotalNaturalPersonsTop2d;
    }

    public List<String> getPivotalNaturalPersonsTop3d() {
        return pivotalNaturalPersonsTop3d;
    }

    public void setPivotalNaturalPersonsTop3d(List<String> pivotalNaturalPersonsTop3d) {
        this.pivotalNaturalPersonsTop3d = pivotalNaturalPersonsTop3d;
    }

    public List<String> getPivotalNonNaturalPersonsTop1d() {
        return pivotalNonNaturalPersonsTop1d;
    }

    public void setPivotalNonNaturalPersonsTop1d(List<String> pivotalNonNaturalPersonsTop1d) {
        this.pivotalNonNaturalPersonsTop1d = pivotalNonNaturalPersonsTop1d;
    }

    public List<String> getPivotalNonNaturalPersonsTop2d() {
        return pivotalNonNaturalPersonsTop2d;
    }

    public void setPivotalNonNaturalPersonsTop2d(List<String> pivotalNonNaturalPersonsTop2d) {
        this.pivotalNonNaturalPersonsTop2d = pivotalNonNaturalPersonsTop2d;
    }

    public List<String> getPivotalNonNaturalPersonsTop3d() {
        return pivotalNonNaturalPersonsTop3d;
    }

    public void setPivotalNonNaturalPersonsTop3d(List<String> pivotalNonNaturalPersonsTop3d) {
        this.pivotalNonNaturalPersonsTop3d = pivotalNonNaturalPersonsTop3d;
    }

    public List<String> getIndustrySpanTop1d() {
        return industrySpanTop1d;
    }

    public void setIndustrySpanTop1d(List<String> industrySpanTop1d) {
        this.industrySpanTop1d = industrySpanTop1d;
    }

    public List<String> getIndustrySpanTop2d() {
        return industrySpanTop2d;
    }

    public void setIndustrySpanTop2d(List<String> industrySpanTop2d) {
        this.industrySpanTop2d = industrySpanTop2d;
    }

    public List<String> getIndustrySpanTop3d() {
        return industrySpanTop3d;
    }

    public void setIndustrySpanTop3d(List<String> industrySpanTop3d) {
        this.industrySpanTop3d = industrySpanTop3d;
    }

}
