package com.mocker.core.permission.service;/**
 * Created by sunwukong on 16/12/10.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:28
 * @Version 1.0
 * @Description 对基本业务方法进行封装
 */
public interface IBaseService<T> {

    /**
     * 添加 or 修改
     * @param t
     */
    public void save(T t);

    /**
     * 根据主键删除
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    public T getOne(Serializable id);

    /**
     * 获取全部记录
     * @param id
     * @return
     */
    public List<T> findAll(Serializable id);

}
