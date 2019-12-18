package com.kcmpts.commons.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "as_log_err")
public class LogErr implements Serializable {
    @Id
    private Integer id;

    private String method;

    private String params;

    private String error;

    private String solution;

    private String caller;

    private Date ctime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error
     */
    public void setError(String error) {
        this.error = error == null ? null : error.trim();
    }

    /**
     * @return caller
     */
    public String getCaller() {
        return caller;
    }

    /**
     * @param caller
     */
    public void setCaller(String caller) {
        this.caller = caller == null ? null : caller.trim();
    }

    /**
     * @return ctime
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}