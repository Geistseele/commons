package com.kcmpts.commons.service;

import com.github.pagehelper.PageInfo;
import com.kcmpts.commons.controller.PageQuery;
import com.kcmpts.commons.entity.LogErr;

/**
 *
 * @author 15170
 * @date 2018/5/30
 * 记录系统异常到数据库
 */
public interface LogErrSvc extends BaseSvc<LogErr> {
    /**
     * 查询错误请求
     * @param pq 分页参数
     * @param begTime 开始时间
     * @param endTime 结束时间
     * @return PageInfo<LogErr>
     */
    PageInfo<LogErr> findErrLog(PageQuery pq, String begTime, String endTime);
}
