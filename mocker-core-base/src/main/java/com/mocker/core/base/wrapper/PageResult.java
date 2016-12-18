package com.mocker.core.base.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-12 上午12:29
 * @Description 分页信息封装对象
 * @Version 1.0
 */
@ApiModel("分页信息")
public class PageResult<T> {

    @ApiModelProperty("分页数据")
    private List<T> data;

    @ApiModelProperty("页数")
    private Integer page;

    @ApiModelProperty("总行数")
    private Long rows;

    public PageResult() {
    }

    public PageResult(List<T> data, Integer page, Long rows) {
        this.data = data;
        this.page = page;
        this.rows = rows;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    public static <T> PageResult getInstance(int page, long rows, List<T> data) {
        return  new PageResult(data,page,rows);
    }
}
