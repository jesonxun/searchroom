package com.jeson.searchroom.exception;

import java.text.MessageFormat;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 15:28
 *
 * 自定义异常
 **/
public class BaseException extends RuntimeException {
    private int code;
    private String msg;

    public BaseException()
    {
        super();
    }

    public BaseException(int code, String msg)
    {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BaseException(int code, String msg, Throwable e)
    {
        super(e);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(int code) {
        super();
        this.code = code;
    }

    public BaseException(String msg, Object ... args)
    {
        super();
        this.code = -1;
        this.msg = MessageFormat.format(msg, args);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
