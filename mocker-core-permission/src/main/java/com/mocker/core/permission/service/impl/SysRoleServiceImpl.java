package com.mocker.core.permission.service.impl;
import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.impl.BaseServiceImpl;
import com.mocker.core.permission.dao.SysMenuRepository;
import com.mocker.core.permission.data.SysMenuData;
import com.mocker.core.permission.domain.SysMenu;
import com.mocker.core.permission.domain.SysRole;
import com.mocker.core.permission.service.ISysMenuService;
import com.mocker.core.permission.service.ISysRoleService;
import com.mocker.core.permission.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:02
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    public SysRoleServiceImpl(@Qualifier("sysRoleRepository")BaseRepository repository) {
        super(repository);
    }

}
