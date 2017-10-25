package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tuanhong on 2017-05-24.
 */
@ApiModel(value = "黑名单信息（导出WORD使用）")
public class WrodBlackListInfoVO {
    @ApiModelProperty(value = "企业名称")
    private String company;
    @ApiModelProperty(value = "所属行业")
    private String industry;
    @ApiModelProperty(value = "加入日期")
    private String joinDate;
    @ApiModelProperty(value = "加入原因")
    private String reasons;
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }


}
