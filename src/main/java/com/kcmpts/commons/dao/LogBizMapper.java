package com.kcmpts.commons.dao;

import com.kcmpts.commons.entity.LogBiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author klauszong
 */
@Mapper
public interface LogBizMapper extends SqlMapper<LogBiz> {

	/**
	 * 查询业务日志
	 * @param begTime 开始时间
	 * @param endTime 结束时间
	 * @return List<LogBiz>
	 */
	List<LogBiz> selectBizLog(@Param("begTime") String begTime, @Param("endTime") String endTime);
}