package com.mocker.core.base.filter.impl;

import com.mocker.core.base.filter.IDataFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * @author Mocker
 * @Date 2016-12-14 下午9:33
 * @Description 查询条件对象
 * @Version 1.0
 */
@ApiModel("查询对象")
public class BaseDataFilterImpl implements IDataFilter{

    @ApiModelProperty("操作")
    private String operation;

    @ApiModelProperty("字段")
    private String field;

    @ApiModelProperty("连接符")
    private String join;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }
}
