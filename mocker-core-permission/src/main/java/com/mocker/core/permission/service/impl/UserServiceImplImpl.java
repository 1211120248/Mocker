package com.mocker.core.permission.service.impl;
import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.impl.BaseServiceImpl;
import com.mocker.core.permission.dao.UserRepository;
import com.mocker.core.permission.domain.User;
import com.mocker.core.permission.service.IUserService;
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
public class UserServiceImplImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImplImpl(@Qualifier("userRepository")BaseRepository repository) {
        super(repository);
    }

}