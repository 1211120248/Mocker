package com.mocker.core.permission.service.impl;/**
 * Created by sunwukong on 16/12/10.
 */

import com.mocker.core.permission.service.IBaseService;
import com.mocker.core.permission.service.IUserService;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:03
 * @Version 1.0
 */
public class BaseServiceImpl<T> implements IBaseService<T>{

    private JpaRepository repository;

    public BaseServiceImpl(JpaRepository repository) {
        this.repository = repository;
    }

    public void save(T t){
        repository.save(t);
    }

    public void delete(Serializable id){
        repository.delete(id);
    }

    public T getOne(Serializable id){
        return (T) repository.getOne(id);
    }

    public List<T> findAll(Serializable id){
        return  repository.findAll();
    }

}
