package com.bbd.dafei.common.modal.commonenum;

/**
 * Created by wish on 2017/8/30.
 */
public enum YuqingSortTypeEnum {
    YUQING_SORT_TYPE_VALUE_ASC("情感分数升序"),
    YUQING_SORT_TYPE_VALUE_DESC("情感分数降序"),
    YUQING_SORT_TYPE_PUBDATE_ASC("发布时间升序"),
    YUQING_SORT_TYPE_PUBDATE_DESC("发布时间降序");

    private String name;

    YuqingSortTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
