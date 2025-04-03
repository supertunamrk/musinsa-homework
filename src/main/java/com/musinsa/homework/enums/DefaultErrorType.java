package com.musinsa.homework.enums;

public enum DefaultErrorType implements ErrorType {
    INVALID_PARAMETER("E0001", "입력값이 올바르지 않습니다."),
    UNKNOWN("E9999", "예기치 못한 예외가 발생했습니다.");

    private final String code;
    private final String message;

    DefaultErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}