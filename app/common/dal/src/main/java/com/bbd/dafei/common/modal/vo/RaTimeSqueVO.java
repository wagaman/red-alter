package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tuanhong on 2017-05-11.
 */
@ApiModel("企业时序图中位数与平均数")
public class RaTimeSqueVO {
    @ApiModelProperty(value = "值类型")
    private String valType;
    @ApiModelProperty(value = "时序图值")
    private String timeSque;

    public String getValType() {
        return valType;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }

    public String getTimeSque() {
        return timeSque;
    }

    public void setTimeSque(String timeSque) {
        this.timeSque = timeSque;
    }


}
