package com.mocker.core.permission.domain;/**
 * Created by sunwukong on 16/12/10.
 */

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Mocker
 * @Date 2016-12-10 下午4:52
 * @Description 用户
 * @Version 1.0
 */
@Entity
@Table(name = "S_USER")
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ApiModelProperty("用户名")
    @Column(name = "username",length = 50,nullable = false)
    private String username;

    @ApiModelProperty("密码")
    @Column(name = "password",length = 50,nullable = false)
    private String password;

    @ApiModelProperty("登录名")
    @Column(name = "loginName",length = 50,nullable = false)
    private String loginName;

    @ApiModelProperty("用户状态")
    @Column(name = "status")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
