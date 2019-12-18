package com.kcmpts.commons.service;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.kcmpts.commons.controller.PageQuery;
import com.kcmpts.commons.dao.LogErrMapper;
import com.kcmpts.commons.entity.LogErr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author 15170
 * @date 2018/5/30
 */
@Service
public class LogErrSvcImpl extends BaseSvcImpl<LogErr> implements LogErrSvc {

    @Autowired(required = false)
    private LogErrMapper errMapper ;

    @Override
    public PageInfo<LogErr> findErrLog(PageQuery pq, String begTime, String endTime) {
        PageMethod.startPage(pq.getPage(), pq.getRows());
        PageMethod.orderBy(pq.getOrder()+" "+pq.getSort());
        List<LogErr> sLog = errMapper.selectErrLog(begTime, endTime);
        return new PageInfo<>(sLog);
    }
}
