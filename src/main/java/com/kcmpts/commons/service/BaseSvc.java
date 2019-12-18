package com.kcmpts.commons.service;



import java.util.List;

/**
 * @author klauszong
 */
public interface BaseSvc<T> {
    /**
     * 添加自选字段对象
     *
     * @param entity 实体对象
     * @return 受影响行数
     *
     */
    Integer addSelective(T entity) ;

    /**
     * 删除对象
     *
     * @param key 主键
     * @return 受影响行数
     */
    @SuppressWarnings("unused")
    Integer removeByKey(Object key);

    /**
     * 修改对象
     *
     * @param entity 实体对象
     * @return 受影响行数
     */
    @SuppressWarnings("unused")
    Integer modifyByKeySelective(T entity);

    List<T> getAll();

    /**
     * 获取对象
     *
     * @param key 主键
     * @return 对象
     */
    T getByKey(Object key);

    /**
     * 获取对象列表
     *
     * @param entity 实体对象
     * @return 对象列表
     */
    @SuppressWarnings("unused")
    List<T> getByEntity(T entity);
}
