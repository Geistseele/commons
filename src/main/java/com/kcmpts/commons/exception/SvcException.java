package com.kcmpts.commons.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author klauszong
 */
@SuppressWarnings("unused")
public class SvcException extends DataAccessException {

	public SvcException(String msg) {
		super(msg);
	}

	public SvcException(String msg, Throwable cause) {
        super(msg, cause);
    }
	
	private static final long serialVersionUID = 1L;

}
