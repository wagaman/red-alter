package com.bbd.dafei.common.dal.po;

import java.util.Date;

/**
 * 拉黑、关注、备注PO
 * Created by wish on 2017/4/26.
 */
public class RaBlackListFocusPO {
    /** id */
    private Integer id;
    /** 操作用户 */
    private String userName;
    /** 企业id */
    private String companyId;
    /** 公司名 */
    private String companyName;
    /** 类型；1:黑名单，2：关注，3：备注 */
    private Integer type;
    /** 事由；如：“已立案/已查处” */
    private String reasons;
    /** 备注；保存备注等信息 */
    private String mark;
    /** 是否已查看风险变动;0:否，1：是，默认0 */
    private Integer lookOver;
    /** 创建时间 */
    private Date gmtCreate;
    /** 修改时间 */
    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getLookOver() {
        return lookOver;
    }

    public void setLookOver(Integer lookOver) {
        this.lookOver = lookOver;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
