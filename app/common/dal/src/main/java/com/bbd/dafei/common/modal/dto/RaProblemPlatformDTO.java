package com.bbd.dafei.common.modal.dto;

/**
 * 问题平台信息
 * Created by wish on 2017/5/5.
 */
public class RaProblemPlatformDTO {
    /** id */
    private Integer id;
    /** 平台名称 */
    private String name;
    /** 问题时间 */
    private String problemTime;
    /** 注册资本(万元) */
    private String registeredFund;
    /** 地区 */
    private String area;
    /** 事件类型 */
    private String eventType;
    /** 创建时间  */
    private String gmtCreate;
    /** 更新时间 */
    private String gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblemTime() {
        return problemTime;
    }

    public void setProblemTime(String problemTime) {
        this.problemTime = problemTime;
    }

    public String getRegisteredFund() {
        return registeredFund;
    }

    public void setRegisteredFund(String registeredFund) {
        this.registeredFund = registeredFund;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(String gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
