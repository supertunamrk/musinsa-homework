package com.musinsa.homework.enums;

public enum CategoryErrorType implements ErrorType {
    NOT_FOUND("C0001", "존재하지 않는 카테고리 입니다.");

    private final String code;
    private final String message;

    CategoryErrorType(String code, String message) {
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
