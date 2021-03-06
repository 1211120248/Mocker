package com.mocker.core.base.service.impl;

import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.query.BaseQuery;
import com.mocker.core.base.service.IBaseService;
import com.mocker.core.base.utils.BeanCopyUtils;
import com.mocker.core.base.wrapper.PageResult;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:03
 * @Version 1.0
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

    private BeanCopier beanCopier;

    private BaseRepository<T> repository;

    private Class targetClass;

    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public BaseServiceImpl(BaseRepository<T> repository,Class sourceClass,Class targetClass) {
        this.repository = repository;
        this.targetClass = targetClass;
        this.beanCopier = BeanCopier.create(sourceClass,targetClass,false);
    }

    @Modifying
    public void save(T t){
        repository.save(t);
    }

    @Modifying
    public void delete(Serializable id){
        repository.delete(id);
    }

    public T getOne(Serializable id){
        return (T) repository.getOne(id);
    }

    @Override
    public T findById(Serializable id) {
        return (T) repository.findOne(id);
    }

    public List<T> findAll(){
        return  repository.findAll();
    }

    public PageResult findAll(BaseQuery baseQuery) {
        Pageable pageable = new PageRequest(baseQuery.getPage(),baseQuery.getRows());
        Page page =  repository.findAll(pageable);
        PageResult<T> pageResult = PageResult.getInstance(page);
        return pageResult;
    }

    public List copyList(List data){
        List result = new ArrayList();
        BeanCopyUtils.copyList(beanCopier,targetClass,data,result);
        return  result;
    }
}
