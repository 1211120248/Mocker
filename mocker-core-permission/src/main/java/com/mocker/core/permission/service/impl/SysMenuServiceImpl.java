package com.mocker.core.permission.service.impl;
import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.impl.BaseServiceImpl;
import com.mocker.core.base.wrapper.PageResult;
import com.mocker.core.permission.dao.SysMenuRepository;
import com.mocker.core.permission.data.SysMenuData;
import com.mocker.core.permission.domain.SysMenu;
import com.mocker.core.permission.service.ISysMenuService;
import com.mocker.core.permission.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:02
 * @Version 1.0
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    public SysMenuServiceImpl(@Qualifier("sysMenuRepository")BaseRepository repository) {
        super(repository,SysMenu.class, SysMenuData.class);
    }

    /**
     * 获取所有模块
     * @return
     */
    public List<SysMenu> findAllModule() {
        return sysMenuRepository.findByType(Constants.MenuType.MODULE.getValue());
    }
}
