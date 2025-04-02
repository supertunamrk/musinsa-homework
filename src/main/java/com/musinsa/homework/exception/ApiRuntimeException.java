package com.musinsa.homework.exception;

import com.musinsa.homework.enums.BrandErrorType;

public class ApiRuntimeException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public ApiRuntimeException(BrandErrorType brandErrorType) {
        this.errorCode = brandErrorType.getCode();
        this.errorMessage = brandErrorType.getMessage();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}