package com.mocker.core.base.service.impl;

import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.IBaseService;
import com.mocker.core.base.wapper.PageResult;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:03
 * @Version 1.0
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

    private BaseRepository<T> repository;

    public BaseServiceImpl(BaseRepository<T> repository) {
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

    public List<T> findAll(){
        return  repository.findAll();
    }

    public PageResult findAll(Pageable pageable) {
        Page<T> page = repository.findAll(pageable);
        PageResult<T> pageResult = PageResult.getInstance(page.getTotalPages(),page.getTotalElements(),page.getContent());
        return pageResult;
    }
}
