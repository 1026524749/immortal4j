package com.immortal.immortal4j.support;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/25 19:59
 */
public class PageParam {
    /**
     * 页码
     */
    private Integer page;

    /**
     * 页面大小
     */
    private Integer pageSize;

    public PageParam() {
        page = 1;
        pageSize = 10;
    }

    public Integer getPage() {
        //查询的页码从0开始，但是页面显示的一般都是从1开始，做个简单的适配
        return page-1;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
