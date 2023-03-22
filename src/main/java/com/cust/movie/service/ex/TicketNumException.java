package com.cust.movie.service.ex;

public class TicketNumException extends ServiceException{

    public TicketNumException() {
    }

    public TicketNumException(String message) {
        super(message);
    }

    public TicketNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketNumException(Throwable cause) {
        super(cause);
    }

    public TicketNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
