package com.mocker.core.permission.dao;/**
 * Created by sunwukong on 16/12/10.
 */

import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.permission.domain.SysUser;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:01
 * @Version 1.0
 */
public interface SysUserRepository extends BaseRepository<SysUser>{
    /**
     * 根据账号和密码查询用户
     * @param password
     * @return
     */
    SysUser findByLoginNameAndPassword(String loginName, String password);
}
