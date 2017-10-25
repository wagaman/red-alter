package com.bbd.dafei.common.modal.dto;

import com.bbd.dafei.common.util.AbstractReturnBean;

import java.util.List;

/**
 * transfer关联方返回DTO
 * Created by wish on 2017/4/28.
 */
public class RelationNowDTO extends AbstractReturnBean {
    private boolean success;
    private String msg;
    private String statusCode;
    private RelationData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public RelationData getData() {
        return data;
    }

    public void setData(RelationData data) {
        this.data = data;
    }

    public static class RelationData {
        private List<RelationNodeDTO> nodes;//节点
        private List<RelationLinkDTO> links;//关联

        public List<RelationNodeDTO> getNodes() {
            return nodes;
        }

        public void setNodes(List<RelationNodeDTO> nodes) {
            this.nodes = nodes;
        }

        public List<RelationLinkDTO> getLinks() {
            return links;
        }

        public void setLinks(List<RelationLinkDTO> links) {
            this.links = links;
        }
    }

    @Override
    public boolean accessApiSuccess() {
        return success;
    }

    @Override
    public String returnCode() {
        return statusCode;
    }

    @Override
    public String returnMessage() {
        return msg;
    }

}
