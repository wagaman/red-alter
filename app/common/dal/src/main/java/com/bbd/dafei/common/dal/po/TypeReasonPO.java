package com.bbd.dafei.common.dal.po;

/**
 * 类型原因对应数量
 * Created by wish on 2017/4/26.
 */
public class TypeReasonPO {

    /** 类型 1 黑名单 2关注 3备注*/
    private Integer type;
    /** 原因 */
    private String reasons;
    /** 数量 */
    private int num;

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
