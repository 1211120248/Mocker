package com.mocker.core.base.query;

import com.mocker.core.base.filter.impl.BaseDataFilterImpl;

/**
 * @author Mocker
 * @Date 2016-12-13 下午11:20
 * @Description 基本查询对象
 * @Version 1.0
 */
public class BaseQuery {

    private BaseDataFilterImpl filter;

    private int page = 0;

    private int pageSize = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
