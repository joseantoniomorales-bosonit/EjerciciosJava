package com.bosonit.block7crudvalidation2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;

@ControllerAdvice
public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String msg;

    public CustomError(Date timestamp, int httpCode, String msg) {
        this.timestamp = timestamp;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public CustomError(){
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return "{\n" +
                "timestamp=" + timestamp +
                ", \nHttpCode=" + httpCode +
                ", \nmsg=" + msg +
                "\n}";
    }
}
