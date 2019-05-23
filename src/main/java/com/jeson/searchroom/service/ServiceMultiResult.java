package com.jeson.searchroom.service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-23 21:36
 *
 * 通用多结果service返回结构
 **/
public class ServiceMultiResult<T> {
    private long total;
    private List<T> result;

    public ServiceMultiResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
