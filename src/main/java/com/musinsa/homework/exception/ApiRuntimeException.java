package com.musinsa.homework.exception;

public class ApiRuntimeException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}