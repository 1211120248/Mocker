package com.mocker.core.permission.service;

import com.mocker.core.base.service.IBaseService;
import com.mocker.core.base.wrapper.PageResult;
import com.mocker.core.permission.domain.SysMenu;

import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:02
 * @Description 权限菜单服务
 * @Version 1.0
 */
public interface ISysMenuService extends IBaseService<SysMenu> {

    /**
     * 获取所有模块
     * @return
     */
    List<SysMenu> findAllModule();
}
