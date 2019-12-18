package com.kcmpts.commons.service;


import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * @author klauszong
 */
public abstract class BaseSvcImpl<T extends Serializable> implements BaseSvc<T> {
    @Autowired(required = false)
    private Mapper<T> mapper;

    @Override
    public List<T> getAll() {
        return mapper.selectAll();
    }

    @Override
    public T getByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> getByEntity(T entity) {
        return mapper.select(entity);
    }

    @Override
    public Integer addSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public Integer removeByKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public Integer modifyByKeySelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }
}
