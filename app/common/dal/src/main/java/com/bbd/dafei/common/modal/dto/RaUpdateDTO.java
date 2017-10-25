package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 更正企业信息DTO
 * Created by tuanhong on 2017-04-20.
 */
@ApiModel(value = "更正企业信息")
public class RaUpdateDTO {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("企业id")
    private String companyId;
    @ApiModelProperty("企业名称")
    private String company;
    @ApiModelProperty("更正内容描述")
    private String content;
    @ApiModelProperty("修改时间")
    private Date gmtUpdate;
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
