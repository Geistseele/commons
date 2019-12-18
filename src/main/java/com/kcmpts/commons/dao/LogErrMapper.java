package com.kcmpts.commons.dao;

import com.kcmpts.commons.entity.LogErr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author klauszong
 */
@Mapper
public interface LogErrMapper extends SqlMapper<LogErr> {
    /**
     * 查询错误日志
     *
     * @param begTime 开始时间
     * @param endTime 结束时间
     * @return List<LogErr>
     */
    List<LogErr> selectErrLog(@Param("begTime") String begTime, @Param("endTime") String endTime);
}
