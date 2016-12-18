package com.mocker.core.permission.dao;

import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.wrapper.PageResult;
import com.mocker.core.permission.domain.SysMenu;
import com.mocker.core.permission.domain.SysUser;
import com.mocker.core.permission.utils.Constants;

import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:01
 * @Version 1.0
 */
public interface SysMenuRepository extends BaseRepository<SysMenu> {
    /**
     * 根据Type获取
     * @param type
     * @return
     */
    List<SysMenu> findByType(Integer type);
}
