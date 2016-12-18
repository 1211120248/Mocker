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

    private int rows = 10;

    public BaseDataFilterImpl getFilter() {
        return filter;
    }

    public void setFilter(BaseDataFilterImpl filter) {
        this.filter = filter;
    }

    public Integer getPage() {
        return page > 0 ? page - 1 : page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
