package com.mocker.core.base.dao;/**
 * Created by sunwukong on 16/12/10.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:01
 * @Version 1.0
 */
public interface BaseRepository<T> extends JpaRepository<T, Serializable>,JpaSpecificationExecutor<T>{
}
