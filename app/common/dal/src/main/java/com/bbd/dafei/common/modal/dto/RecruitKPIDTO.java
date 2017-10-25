package com.bbd.dafei.common.modal.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * 招聘KPI DTO
 * Created by wish on 2017/4/21.
 */
public class RecruitKPIDTO {
    @ApiModelProperty(value = "学历分布")
    private Map<String,Integer> educationMap;
    @ApiModelProperty(value = "时间分布")
    private Map<String,Integer> dateMap;
    @ApiModelProperty(value = "行业分布")
    private Map<String,String> industryMap;

    public Map<String, Integer> getEducationMap() {
        return educationMap;
    }

    public void setEducationMap(Map<String, Integer> educationMap) {
        this.educationMap = educationMap;
    }

    public Map<String, Integer> getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map<String, Integer> dateMap) {
        this.dateMap = dateMap;
    }

    public Map<String, String> getIndustryMap() {
        return industryMap;
    }

    public void setIndustryMap(Map<String, String> industryMap) {
        this.industryMap = industryMap;
    }
}
