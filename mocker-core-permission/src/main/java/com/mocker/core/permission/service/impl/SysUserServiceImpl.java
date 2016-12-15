package com.mocker.core.permission.service.impl;
import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.impl.BaseServiceImpl;
import com.mocker.core.permission.dao.SysUserRepository;
import com.mocker.core.permission.domain.SysUser;
import com.mocker.core.permission.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:02
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUserServiceImpl(@Qualifier("sysUserRepository")BaseRepository repository) {
        super(repository);
    }

    public SysUser login(String loginName, String  password) {
        return sysUserRepository.findByLoginNameAndPassword(loginName,password);
    }

}
