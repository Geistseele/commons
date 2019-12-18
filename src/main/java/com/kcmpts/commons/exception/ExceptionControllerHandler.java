package com.kcmpts.commons.exception;

import com.kcmpts.commons.Const;
import com.kcmpts.commons.controller.ApiResult;
import com.kcmpts.commons.controller.ResultCode;
import com.kcmpts.commons.service.LogErrSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author klauszong
 */
@RestControllerAdvice
public class ExceptionControllerHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionControllerHandler.class);

    private final LogErrSvc les;

    @Autowired
    public ExceptionControllerHandler(LogErrSvc les) {
        this.les = les;
    }

    /**
     * //ArithmeticException
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResult handler(Exception ex) {
        if (ex.getCause() instanceof NumberFormatException) {
            log.error("捕获异常 {}", "NumberFormatException");
            return ApiResult.failure(ResultCode.ex_NumberFormatException);
        } else if (ex.getCause() instanceof IndexOutOfBoundsException) {
            log.error("捕获异常 {}", "IndexOutOfBoundsException");
            return ApiResult.failure(ResultCode.ex_IndexOutOfBoundsException);
        } else if (ex.getCause() instanceof DataIntegrityViolationException) {
            log.error("捕获异常 {}", "DataIntegrityViolationException");
            return ApiResult.failure(ResultCode.ex_DataIntegrityViolationException);
//        } else if (ex instanceof IOException) {
//            log.error("捕获异常 {}", ResultCode.ex_id);
//            return ApiResult.failure(ResultCode.ex_id);
//        } else if (ex instanceof NoSuchMethodException) {
//            log.error("捕获异常 {}", ResultCode.ex_not_method);
//            return ApiResult.failure(ResultCode.ex_not_method);
//        } else if (ex instanceof IndexOutOfBoundsException) {
//            log.error("捕获异常 {}", ResultCode.ex_not_method);
//            return ApiResult.failure(ResultCode.ex_not_method);
//        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
//            log.error("捕获异常 {}", ResultCode.ex_run_time);
//            return ApiResult.failure(ResultCode.ex_run_time);
//        } else if (ex instanceof IllegalArgumentException) {
//            log.error("捕获异常 {}", ResultCode.ex_run_time);
//            return ApiResult.failure(ResultCode.ex_run_time);
//        } else if (ex instanceof MissingServletRequestParameterException) {
//            log.error("捕获异常 {}", ResultCode.ex_run_time);
//            return ApiResult.failure(ResultCode.ex_run_time);
        } else {//其他未捕获异常
            log.error("捕获异常 {}", ex.getMessage());
            return ApiResult.common(Const.OP_FAILURE, ex.getMessage());
        }
    }
}