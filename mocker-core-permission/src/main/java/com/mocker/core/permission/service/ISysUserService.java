package com.mocker.core.permission.service;

import com.mocker.core.base.service.IBaseService;
import com.mocker.core.permission.domain.SysUser;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:02
 * @Description 用户服务
 * @Version 1.0
 */
public interface ISysUserService extends IBaseService<SysUser> {

    /**
     * 登录
     */
    SysUser login(String loginName, String password);
}
