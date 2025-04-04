package com.musinsa.homework.exception;

import com.musinsa.homework.enums.ErrorType;

public class ApiRuntimeException extends RuntimeException {
    private boolean successful;
    private final String errorCode;
    private final String errorMessage;

    public ApiRuntimeException(ErrorType errorType) {
        this.successful = false;
        this.errorCode = errorType.getCode();
        this.errorMessage = errorType.getMessage();
    }

    public ApiRuntimeException(String errorCode, String errorMessage) {
        this.successful = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}