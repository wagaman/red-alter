package com.bbd.dafei.common.modal.commonenum;

/**
 * 风险等级
 * Created by wish on 2017/5/14.
 */
public enum RiskLevelEnum {
    RISK_LEVEL_HIGH("高危预警"),
    RISK_LEVEL_FOCUS("重点关注"),
    RISK_LEVEL_MONITORING("持续监控");

    private String name;

    RiskLevelEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
