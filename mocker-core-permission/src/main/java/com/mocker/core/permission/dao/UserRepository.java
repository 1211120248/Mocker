package com.mocker.core.permission.dao;/**
 * Created by sunwukong on 16/12/10.
 */

import com.mocker.core.permission.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:01
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, Serializable> {
}
