package com.sinyuk.utils;

public class ErrorResponseException extends RuntimeException {
    public ErrorResponseException() {
        super();
    }

    public ErrorResponseException(String detailMessage) {
        super(detailMessage);
    }


    public ErrorResponseException(String message, int code) {
        super(message);
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}