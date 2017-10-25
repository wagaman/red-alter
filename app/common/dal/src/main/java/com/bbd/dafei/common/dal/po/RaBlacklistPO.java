package com.bbd.dafei.common.dal.po;

import java.util.Date;

/**
 * 黑名单PO
 * Created by wish on 2017/5/10.
 */
public class RaBlacklistPO {
    /**
     * id
     */
    private Integer id;
    /**
     * 加入关注用户
     */
    private String addUser;
    /**
     * 移除人员
     */
    private String cancelUser;
    /**
     * 省份
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 企业id
     */
    private String companyId;
    /**
     * 企业名称
     */
    private String company;
    /**
     * 0:正常黑名单企业,1:已取消黑名单
     */
    private Integer status;
    /**
     * 0:人工加入的黑名单,1:数据平台爬取的黑名单,2:数据平台建议将此企业修改为白名单,3:数据平台认为此企业应再次成为黑名单
     */
    private Integer statusUpdate;
    /**
     * 被别人除黑名单是否后是否已被查看:0未查看,1已查看
     */
    private Integer cancelLookOver;

    /**
     * 加入黑名单方式:0用户加入,1网络爬取,2后台导入,3后台用户加入
     */
    private Integer joinType;
    /**
     * 加入黑名单时间
     */
    private Date joinDate;
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

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getCancelUser() {
        return cancelUser;
    }

    public void setCancelUser(String cancelUser) {
        this.cancelUser = cancelUser;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(Integer statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public Integer getCancelLookOver() {
        return cancelLookOver;
    }

    public void setCancelLookOver(Integer cancelLookOver) {
        this.cancelLookOver = cancelLookOver;
    }

    public Integer getJoinType() {
        return joinType;
    }

    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
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
