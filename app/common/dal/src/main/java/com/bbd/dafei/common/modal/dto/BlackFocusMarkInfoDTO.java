package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by wish on 2017/4/26.
 */
@ApiModel(value = "加入黑名单和关注的原因和数量")
public class BlackFocusMarkInfoDTO {

    @ApiModelProperty(value = "总被加入黑名单数量")
    private int totalBlackNum;
    @ApiModelProperty(value = "总被加入关注数量")
    private int totalFocusNum;
    @ApiModelProperty(value = "被加入黑名单的各原因及数量")
    private List<ReasonNum> blackReasonNumList;
    @ApiModelProperty(value = "被加入关注的各原因及数量")
    private List<ReasonNum> focusReasonNumList;
    @ApiModelProperty(value = "备注信息")
    private List<RaBlackListFocusDTO> marks;

    public int getTotalBlackNum() {
        return totalBlackNum;
    }

    public void setTotalBlackNum(int totalBlackNum) {
        this.totalBlackNum = totalBlackNum;
    }

    public int getTotalFocusNum() {
        return totalFocusNum;
    }

    public void setTotalFocusNum(int totalFocusNum) {
        this.totalFocusNum = totalFocusNum;
    }

    public List<ReasonNum> getBlackReasonNumList() {
        return blackReasonNumList;
    }

    public void setBlackReasonNumList(List<ReasonNum> blackReasonNumList) {
        this.blackReasonNumList = blackReasonNumList;
    }

    public List<ReasonNum> getFocusReasonNumList() {
        return focusReasonNumList;
    }

    public void setFocusReasonNumList(List<ReasonNum> focusReasonNumList) {
        this.focusReasonNumList = focusReasonNumList;
    }

    public List<RaBlackListFocusDTO> getMarks() {
        return marks;
    }

    public void setMarks(List<RaBlackListFocusDTO> marks) {
        this.marks = marks;
    }

    @ApiModel(value = "原因及数量")
    public static class ReasonNum {
        @ApiModelProperty(value = "原因")
        private String reason;
        @ApiModelProperty(value = "数量")
        private int num;

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
