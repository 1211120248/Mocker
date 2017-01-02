package com.mocker.core.log.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mocker
 * @Date 2017-01-02 下午11:36
 * @Description 日志
 * @Version 1.0
 */
@Table(name = "S_LOG")
@Entity
public class Log {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ApiModelProperty("请求地址")
    @Column(length = 500)
    private String url;

    @ApiModelProperty("请求方式")
    @Column(length = 20)
    private String method;

    @ApiModelProperty("ip地址")
    @Column(length = 20)
    private String ip;

    @ApiModelProperty("方法")
    @Column(length = 100)
    private String classMethod;

    @ApiModelProperty("请求参数")
    private byte[] args;

    @ApiModelProperty("响应参数")
    private byte[] response;

    @ApiModelProperty("响应时间")
    private Date responseTime;

    @ApiModelProperty("创建时间")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public byte[] getArgs() {
        return args;
    }

    public void setArgs(byte[] args) {
        this.args = args;
    }

    public byte[] getResponse() {
        return response;
    }

    public void setResponse(byte[] response) {
        this.response = response;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
