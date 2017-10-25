package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tuanhong on 2017-04-23.
 */
@ApiModel("企业信息（易燃指数雷达图，风险提示，易燃指数时序图）")
public class RaCompanyVO {
    @ApiModelProperty(value = "易燃指数雷达图")
    private String indexRadar;
    @ApiModelProperty(value = "风险扫描 -- 风险提示")
    private String riskScan;
    @ApiModelProperty(value = "易燃指数时序图")
    private String indexSort;

    public String getIndexRadar() {
        return indexRadar;
    }

    public void setIndexRadar(String indexRadar) {
        this.indexRadar = indexRadar;
    }

    public String getRiskScan() {
        return riskScan;
    }

    public void setRiskScan(String riskScan) {
        this.riskScan = riskScan;
    }

    public String getIndexSort() {
        return indexSort;
    }

    public void setIndexSort(String indexSort) {
        this.indexSort = indexSort;
    }
}
