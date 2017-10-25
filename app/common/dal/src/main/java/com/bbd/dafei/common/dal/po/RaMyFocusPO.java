package com.bbd.dafei.common.dal.po;

import java.util.Date;

/**
 * 我的关注PO
 * Created by wish on 2017/5/10.
 */
public class RaMyFocusPO {
    /**
     * id
     */
    private Integer id;
    /**
     * 操作用户
     */
    private String userName;
    /**
     * 企业id
     */
    private String companyId;
    /**
     * 企业名
     */
    private String companyName;
    /**
     * 是否已查看风险变动;0:否，1：是，默认0
     */
    private Integer lookOver;
    /**
     * 0:关注中,1:已取消关注
     */
    private int status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
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

    public Integer getLookOver() {
        return lookOver;
    }

    public void setLookOver(Integer lookOver) {
        this.lookOver = lookOver;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
