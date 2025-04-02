package com.musinsa.homework.exception;

import com.musinsa.homework.enums.ErrorType;

public class ApiRuntimeException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public ApiRuntimeException(ErrorType errorType) {
        this.errorCode = errorType.getCode();
        this.errorMessage = errorType.getMessage();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}