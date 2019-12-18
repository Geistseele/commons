package com.kcmpts.commons.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kcmpts.commons.entity.LogBiz;
import com.kcmpts.commons.service.LogBizSvc;
import com.kcmpts.commons.service.LogErrSvc;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.collect.Lists.newArrayList;

/**
 *
 */
public class InterfaceLogAspect {
    private static final Logger log = LoggerFactory.getLogger(InterfaceLogAspect.class);

    private final LogBizSvc lbs;
    private final LogErrSvc les;

    @Autowired
    public InterfaceLogAspect(LogBizSvc lbs, LogErrSvc les) {
        this.lbs = lbs;
        this.les = les;
    }

    /**
     * 将需要记录的接口加上该注解@InterfaceLogger即可织入该切面
     */
    @Pointcut("@annotation(com.hqmc.commonsetting.annotation.InterfaceLogger)")
    @SuppressWarnings("unused")
    private void logCutPoint() {
    }

    /**
     * 1.方法前置通知
     * @param joinPoint
     * @throws Exception
     */
    @Before("logCutPoint()")
    @SuppressWarnings("all")
    public void PrintLog(JoinPoint joinPoint) throws Exception {
        log.info("@Before：对象" + joinPoint.getSignature().getDeclaringTypeName());
        log.info("@Before：方法" + joinPoint.getSignature().getName());
        log.info("@Before：参数" + newArrayList(joinPoint.getArgs()).toString());
        log.debug("@Before：被织入目标对象：" + joinPoint.getTarget());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("===================url={}", request.getRequestURL());
        log.info("===================method={}", request.getMethod());
        log.info("===================ip={}", request.getRemoteAddr());

        Object[] array = joinPoint.getArgs();
        StringBuffer sbf = new StringBuffer();
        for (Object obj : array) {
            sbf.append(JSON.toJSONString(obj));
            log.info("==================="+ JSONObject.toJSONString(obj));
            log.info("==================="+ JSON.toJSONString(obj));
        }

        LogBiz logbiz = new LogBiz();
        logbiz.setAction(request.getRequestURL().toString());
        logbiz.setMethod(request.getMethod());
        logbiz.setParams(sbf.toString());
        logbiz.setCaller("auto");
    }

    /**
     * 2.方法环绕通知
     */
    @Around("logCutPoint()")
    public void around(){}

    /**
     * 3.方法后置通知
     * Around 后 ProceedingJoinPoint.proceed()方法执行后
     */
    @After("logCutPoint()")
    public void after() {
        System.out.println("【注解-After】:不管方法有没有正常执行完成," + "一定会返回的");
    }

    /**
     * 4.应用异常抛出后通知
     * @param ex
     */
    @AfterThrowing(pointcut = "logCutPoint()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        log.error("【注解-异常抛出后通知】:方法执行时出异常了");
    }

    /**
     * 5.方法正常结束
     */
    @AfterReturning("logCutPoint()")
    public void afterReturning() {
    }
}
