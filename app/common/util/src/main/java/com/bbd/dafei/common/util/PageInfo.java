package com.bbd.dafei.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wish on 2017/4/20.
 */
@ApiModel("分页信息")
public class PageInfo<T> {

    @ApiModelProperty("内容")
    private List<T> items;

    @ApiModelProperty("分页大小")
    private int pageSize;   // 分页大小

    @ApiModelProperty("当前页")
    private int page;     // 当前页

    @ApiModelProperty("总页数")
    private int totalPage;  // 总页数

    @ApiModelProperty("总记录数")
    private int totalCount; // 总记录数

    @ApiModelProperty("数据起始")
    private int start = -1;

    public PageInfo() {

    }

    public PageInfo(int page, int pageSize) {
        setPage(page);
        setPageSize(pageSize);
        int start = (page - 1) * pageSize + 1;
        if (start < 1) {
            start = 1;
        }
        setStart(start);
    }

    public PageInfo(ApiReturnBean apiReturnBean, int pageNo) {
        if (apiReturnBean == null) {
            return;
        }
        if (CollectionUtils.isEmpty(apiReturnBean.getResults())) {
            this.items = new ArrayList<T>();
        } else {
            this.items = apiReturnBean.getResults();
        }
        int totalPage = apiReturnBean.getTotal() / apiReturnBean.getRsize();
        if (apiReturnBean.getTotal() % apiReturnBean.getRsize() != 0) {
            totalPage++;
        }
        this.totalPage = totalPage;
        pageSize = apiReturnBean.getRsize();
        this.page = pageNo;
        totalCount = apiReturnBean.getTotal();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (this.pageSize < 0) {
            this.pageSize = 0;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        if (this.pageSize < 0) {
            this.pageSize = 0;
        }
    }

    public int getStart() {

        if (start < 0 && pageSize > 0 && page > 0) {
            start = (page - 1) * pageSize;
        }

        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {

        this.totalCount = totalCount;

        if (pageSize != 0) {
            setTotalPage((totalCount + pageSize - 1) / pageSize);
        }
    }
}
