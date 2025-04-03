package com.musinsa.homework.exception;

import com.musinsa.homework.enums.ErrorType;

public class ApiRuntimeException extends RuntimeException {
    private boolean successful;
    private final String errorCode;
    private final String errorMessage;

    public ApiRuntimeException(ErrorType errorType) {
        super(errorType.getMessage());

        this.successful = false;
        this.errorCode = errorType.getCode();
        this.errorMessage = errorType.getMessage();
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