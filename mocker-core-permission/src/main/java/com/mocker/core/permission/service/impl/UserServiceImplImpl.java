package com.mocker.core.permission.service.impl;/**
 * Created by sunwukong on 16/12/10.
 */

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

    public UserServiceImplImpl(@Qualifier("userRepository")JpaRepository repository) {
        super(repository);
    }

}
