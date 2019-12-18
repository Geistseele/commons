package com.kcmpts.commons.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author klauszong
 * DataAccessException 是 RuntimeException
 */
@SuppressWarnings("unused")
public class BizException extends DataAccessException {
    private static final long serialVersionUID = 1L;

    public BizException(String msg) {
        super(msg);
    }
 
    public BizException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
