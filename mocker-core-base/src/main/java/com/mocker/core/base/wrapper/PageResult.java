package com.mocker.core.base.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

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
    private List<T> rows;

    @ApiModelProperty("总页数")
    private Integer totalPage;

    @ApiModelProperty("总行数")
    private Long totalCount;



    public PageResult() {
    }

    public PageResult(List<T> rows,Integer totalPage, Long totalCount) {
        this.rows = rows;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public static <T> PageResult<T> getInstance(Page page) {
        return  new PageResult<T>(page.getContent(),page.getTotalPages(),page.getTotalElements());
    }
}
