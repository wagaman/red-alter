package com.bbd.dafei.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Ian.Su
 * @version $Id: Paging.java, v 0.1 2017/4/20 14:20 Ian.Su Exp $
 */
@ApiModel("分页数据")
public class Paging<T> {


    @ApiModelProperty("总数")
    private int count;

    @ApiModelProperty("记录开始")
    private Integer start;

    @ApiModelProperty("显示记录数")
    private Integer size;

    @ApiModelProperty("数据")
    private List<T> records;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
