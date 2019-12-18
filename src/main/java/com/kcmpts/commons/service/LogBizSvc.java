package com.kcmpts.commons.service;

import com.github.pagehelper.PageInfo;
import com.kcmpts.commons.entity.LogBiz;
import org.omg.CORBA.SystemException;

public interface LogBizSvc extends BaseSvc<LogBiz>{

	PageInfo<LogBiz> findSysLog(int pageNum, int pageSize, String sort, String order, String startTime, String endTime) throws SystemException;
}
