package com.bbd.dafei.common.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 区域统计数据
 * @author Ian.Su
 * @version $Id: ScatterMapPO.java, v 0.1 2017/4/18 18:33 Ian.Su Exp $
 */
@ApiModel(value = "区域统计数据")
public class AreaCountDTO {

    @ApiModelProperty("地区")
    private String region;

    @ApiModelProperty("监测地区")
    private int monitorRegion;

    @ApiModelProperty("高危集聚区")
    private String highCollect;

    @ApiModelProperty("高危企业数")
    private int highCompany;

    @ApiModelProperty("增加高危企业数")
    private Integer addHighRisk;

    @ApiModelProperty("减少高危企业数")
    private Integer lessenHighRisk;

    @ApiModelProperty("减少监控企业数")
    private int lessenMonitor;

    @ApiModelProperty("增加监控企业数")
    private int addMonitor;

    @ApiModelProperty("持续监控企业数")
    private int sustainMonitor;

    @ApiModelProperty("重点关注企业数")
    private int focusOn;


    @ApiModelProperty("高危企业变动数")
    private int changeHighCompany;

    @ApiModelProperty("监控企业数")
    private int monitorCompany;



    @ApiModelProperty("监控企业变动数")
    private int changeMonitorCompany;

    @ApiModelProperty("占比,如5%,则本字段的值为0.05")
    private BigDecimal proportion;

    public int getLessenMonitor() {
        return lessenMonitor;
    }

    public void setLessenMonitor(int lessenMonitor) {
        this.lessenMonitor = lessenMonitor;
    }

    public int getAddMonitor() {
        return addMonitor;
    }

    public void setAddMonitor(int addMonitor) {
        this.addMonitor = addMonitor;
    }

    public Integer getAddHighRisk() {
        return addHighRisk;
    }

    public void setAddHighRisk(Integer addHighRisk) {
        this.addHighRisk = addHighRisk;
    }

    public Integer getLessenHighRisk() {
        return lessenHighRisk;
    }

    public void setLessenHighRisk(Integer lessenHighRisk) {
        this.lessenHighRisk = lessenHighRisk;
    }

    public int getSustainMonitor() {
        return sustainMonitor;
    }

    public void setSustainMonitor(int sustainMonitor) {
        this.sustainMonitor = sustainMonitor;
    }

    public int getFocusOn() {
        return focusOn;
    }

    public void setFocusOn(int focusOn) {
        this.focusOn = focusOn;
    }

    public BigDecimal getProportion() {

        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMonitorRegion() {
        return monitorRegion;
    }

    public void setMonitorRegion(int monitorRegion) {
        this.monitorRegion = monitorRegion;
    }

    public String getHighCollect() {
        return highCollect;
    }

    public void setHighCollect(String highCollect) {
        this.highCollect = highCollect;
    }

    public int getHighCompany() {
        return highCompany;
    }

    public void setHighCompany(int highCompany) {
        this.highCompany = highCompany;
    }

    public int getChangeHighCompany() {
        return changeHighCompany;
    }

    public void setChangeHighCompany(int changeHighCompany) {
        this.changeHighCompany = changeHighCompany;
    }

    public int getMonitorCompany() {
        return monitorCompany;
    }

    public void setMonitorCompany(int monitorCompany) {
        this.monitorCompany = monitorCompany;
    }

    public int getChangeMonitorCompany() {
        return changeMonitorCompany;
    }

    public void setChangeMonitorCompany(int changeMonitorCompany) {
        this.changeMonitorCompany = changeMonitorCompany;
    }
}
