package com.mocker.core.permission.service.impl;
import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.impl.BaseServiceImpl;
import com.mocker.core.permission.dao.AuthMenuRepository;
import com.mocker.core.permission.domain.AuthMenu;
import com.mocker.core.permission.service.IAuthMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:02
 * @Version 1.0
 */
@Service
public class AuthMenuServiceImpl extends BaseServiceImpl<AuthMenu> implements IAuthMenuService {

    @Autowired
    private AuthMenuRepository authMenuRepository;

    public AuthMenuServiceImpl(@Qualifier("authMenuRepository")BaseRepository repository) {
        super(repository);
    }


}
