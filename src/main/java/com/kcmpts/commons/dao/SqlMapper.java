package com.kcmpts.commons.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * @author klauszong
 */
public interface SqlMapper<T> extends Mapper<T>, MySqlMapper<T> {
    /**
     * 重写mybatis的insertList方法，适应表中有自增的主键
     *
     * @param recordList 对象List
     * @return 受影响的条数
     */
    @Override
    @Options(useGeneratedKeys = false, keyProperty = "id")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertList(List<? extends T> recordList);
}
 