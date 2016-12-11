package com.mocker.core.base.wapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mocker
 * @Date 2016-12-12 上午12:24
 * @Description Json数据返回封装
 * @Version 1.0
 */
@ApiModel("JSON消息返回对象")
public class JsonResult {

    @ApiModelProperty("是否操作成功")
    private boolean success;

    @ApiModelProperty("错误码")
    private String  code;

    @ApiModelProperty("消息")
    private String  msg;

    @ApiModelProperty("字段错误")
    private Object  fieldErrors;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setFieldErrors(Object fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
