package com.immortal.immortal4j.support;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/25 21:46
 */
public class PageResult<T> {
    private Integer page;

    private Integer pages;

    private Integer pageSize;

    private Long totals;

    private List<T> data;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
