package com.cust.movie.service.ex;

/** 密码验证失败的异常 */
public class PassWordNotMatchException extends ServiceException{
    public PassWordNotMatchException() {
    }

    public PassWordNotMatchException(String message) {
        super(message);
    }

    public PassWordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassWordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PassWordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
