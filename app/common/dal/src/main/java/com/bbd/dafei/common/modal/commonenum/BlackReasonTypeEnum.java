package com.bbd.dafei.common.modal.commonenum;

/**
 * 黑名单原因
 * Created by wish on 2017/6/10.
 */
public enum BlackReasonTypeEnum {

    ADD_REASON_ITEM(1, "加入关注时选择的固定项"),

    ADD_REASON_OTHER(2, "加入关注时选择的其他"),

    CANCEL_REASON_ITEM(3, "取消时固定选项"),

    CANCEL_REASON_OTHER(4, "取消时其他原因");

    private Integer code;
    private String describe;

    BlackReasonTypeEnum(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
