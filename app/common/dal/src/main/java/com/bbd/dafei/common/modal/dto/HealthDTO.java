package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: HealthPO.java, v 0.1 2017/4/18 9:49 Ian.Su Exp $
 */
@ApiModel(value = "新金融健康度相关信息")
public class HealthDTO {

    @ApiModelProperty(value = "全国总数")
    private int count;

    @ApiModelProperty(value = "当前用户所在省份的排名")
    private int ranking;

    @ApiModelProperty(value = "当前用户所在省份")
    private String province;

    @ApiModelProperty(value = "排名靠前的省份")
    private List<String> top;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getTop() {
        return top;
    }

    public void setTop(List<String> top) {
        this.top = top;
    }
}
