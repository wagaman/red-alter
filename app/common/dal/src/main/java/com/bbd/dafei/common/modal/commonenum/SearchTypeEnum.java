package com.bbd.dafei.common.modal.commonenum;

/**
 * Created by wish on 2017/4/25.
 */
public enum SearchTypeEnum {
    SEARCH_TYPE_MIX("mix", "综合"),
    SEARCH_TYPE_COMPANY("company", "企业名"),
    SEARCH_TYPE_PINGTAI("p2p_platform", "平台名"),
    SEARCH_TYPE_GDXX("gdxx", "法人或股东"),
    SEARCH_TYPE_DJG("baxx", "董监高");

    private String code;
    private String name;

    SearchTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
