package com.mocker.core.base.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Mocker
 * @Date 2016-12-12 上午12:24
 * @Description Json数据返回封装
 * @Version 1.0
 */
@ApiModel("JSON消息返回对象")
public class JsonResult {

    private static  final JsonResult SUCCESS = new JsonResult(true);

    private static  final JsonResult ERROR = new JsonResult(false);


    @ApiModelProperty("是否操作成功")
    private boolean success;

    @ApiModelProperty("错误码")
    private String  code;

    @ApiModelProperty("消息")
    private String  msg;

    @ApiModelProperty("字段错误")
    private Object  fieldErrors;

    @ApiModelProperty("数据")
    private Object data;

    public JsonResult(boolean success) {
        this.success = success;
    }

    public JsonResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public JsonResult(boolean success, String meg) {
        this.success = success;
        this.msg = meg;
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

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

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getFieldErrors() {
        return fieldErrors;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult getSuccess(){
        return SUCCESS;
    }

    public static JsonResult getSuccess(Object data){
        return new JsonResult(true,data);
    }

    public static JsonResult getError() {
        return ERROR;
    }

    public static JsonResult getError(String msg) {
        return new JsonResult(false,msg);
    }

}
