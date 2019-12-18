package com.kcmpts.commons.service;

import com.github.pagehelper.PageInfo;
import com.kcmpts.commons.dao.LogBizMapper;
import com.kcmpts.commons.entity.LogBiz;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author klauszong
 */
@Service
public class LogBizSvcImpl extends BaseSvcImpl<LogBiz> implements LogBizSvc {

    @Autowired
    private LogBizMapper logBizMapper;

//    @Autowired
//    public LogBizSvcImpl(LogBizMapper logBizMapper) {
//        this.logBizMapper = logBizMapper;
//    }

    @Override
    public PageInfo<LogBiz> findSysLog(int pageNum, int pageSize, String sort, String order, String startTime, String endTime) throws SystemException {

//        PageMethod.startPage(pageNum, pageSize);
//        if (sort != null) {
//            sort = AttributeToColumn.getColumn(sort);
//        }
//
//        List<LogBiz> sLog = logBizMapper.selectLogBizList(startTime, endTime, sort, order);

        return new PageInfo<>(new ArrayList<>());
    }
}
