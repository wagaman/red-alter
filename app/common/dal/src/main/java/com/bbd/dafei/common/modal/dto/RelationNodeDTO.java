package com.bbd.dafei.common.modal.dto;

import com.bbd.wellspring.common.service.facade.relation.NodeVoSymbolEnum;
import com.bbd.wellspring.common.service.facade.relation.NodeVoTypeEnum;

import java.util.Set;

/**
 * 关联节点DTO
 * Created by wish on 2017/4/28.
 */
public class RelationNodeDTO {
    private String addflag = "false";
    private String name;
    private int category;
    private Set<NodeVoTypeEnum> nodeVoTypes;
    private String cname;
    private NodeVoSymbolEnum symbol;
    private String color;

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

    public Set<NodeVoTypeEnum> getNodeVoTypes() {
        return nodeVoTypes;
    }

    public void setNodeVoTypes(Set<NodeVoTypeEnum> nodeVoTypes) {
        this.nodeVoTypes = nodeVoTypes;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
