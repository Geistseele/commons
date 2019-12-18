package com.kcmpts.commons.controller;

/**
 * @author Luoz
 */
public class PageQuery {
    private Integer page;
    private Integer rows;
    private String sort;
    private String order;

    public PageQuery() {
    }

    public PageQuery(Integer page, Integer rows, String sort, String order) {
        this.page = page;
        this.rows = rows;
        this.sort = sort;
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
