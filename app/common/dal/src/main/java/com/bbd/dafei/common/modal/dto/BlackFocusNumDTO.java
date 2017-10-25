package com.bbd.dafei.common.modal.dto;

import com.bbd.dafei.common.dal.po.RaCompanyPO;

import java.util.Date;
import java.util.List;

/**
 * 企业拉黑和关注数量DTO
 * Created by wish on 2017/4/24.
 */
public class BlackFocusNumDTO {
    /**
     * 公司信息
     */
    RaCompanyPO raCompanyPO;
    /**
     * 企业关注数量
     */
    private int focusNum;

    /**
     * 是否拉黑
     */
    private boolean black;

    /**
     * 拉黑id
     */
    private Integer blackId;
    /**
     * 拉黑时间
     */
    private Date addBlackDate;

    /**
     * 拉黑原因
     */
    private List<String> blackReasons;

    /**
     * 用户是否关注
     */
    private boolean userFocus;
    /**
     * 用户对该公司的关注id
     */
    private Integer focusId;

    public RaCompanyPO getRaCompanyPO() {
        return raCompanyPO;
    }

    public void setRaCompanyPO(RaCompanyPO raCompanyPO) {
        this.raCompanyPO = raCompanyPO;
    }

    public int getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(int focusNum) {
        this.focusNum = focusNum;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public Integer getBlackId() {
        return blackId;
    }

    public void setBlackId(Integer blackId) {
        this.blackId = blackId;
    }

    public Date getAddBlackDate() {
        return addBlackDate;
    }

    public void setAddBlackDate(Date addBlackDate) {
        this.addBlackDate = addBlackDate;
    }

    public List<String> getBlackReasons() {
        return blackReasons;
    }

    public void setBlackReasons(List<String> blackReasons) {
        this.blackReasons = blackReasons;
    }

    public boolean isUserFocus() {
        return userFocus;
    }

    public void setUserFocus(boolean userFocus) {
        this.userFocus = userFocus;
    }

    public Integer getFocusId() {
        return focusId;
    }

    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }
}
