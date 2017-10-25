package com.bbd.dafei.common.modal.commonenum;

/**
 * 前端关联节点类型
 * Created by wish on 2017/5/3.
 */
public enum RelationNodeVOTypeEnum {

    TARGET(0, "目标公司"),
    INVESTED(1, "投资目标"),
    INVEST(2, "法人股东"),
    HUMAN_INVEST(3, "自然人股东"),
    DJG(4, "董监高"),
    HIGH_RISK(5, "高风险企业"),
    BLACK(6, "黑名单企业"),
    OTHER(7, "二度以上关联方");

    private Integer code;
    private String name;

    RelationNodeVOTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
