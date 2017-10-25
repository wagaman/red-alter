package com.bbd.dafei.common.modal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wish on 2017/5/3.
 */
@ApiModel(value = "关联数据")
public class RelationDataVO {
    @ApiModelProperty(value = "节点")
    private List<RelationNodeVO> nodes;//节点
    @ApiModelProperty(value = "关联")
    private List<RelationLinkVO> links;//关联
    @ApiModelProperty(value="高危企业列表")
    private List<String> highCompanyList = new ArrayList<>();
    @ApiModelProperty(value="黑名单企业列表")
    private List<String> blackCompanyList = new ArrayList<>();;

    public List<String> getHighCompanyList() {
        return highCompanyList;
    }

    public void setHighCompanyList(List<String> highCompanyList) {
        this.highCompanyList = highCompanyList;
    }

    public List<String> getBlackCompanyList() {
        return blackCompanyList;
    }

    public void setBlackCompanyList(List<String> blackCompanyList) {
        this.blackCompanyList = blackCompanyList;
    }

    public List<RelationNodeVO> getNodes() {
        return nodes;
    }

    public void setNodes(List<RelationNodeVO> nodes) {
        this.nodes = nodes;
    }

    public List<RelationLinkVO> getLinks() {
        return links;
    }

    public void setLinks(List<RelationLinkVO> links) {
        this.links = links;
    }
}
