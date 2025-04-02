package com.musinsa.homework.enums;

public enum BrandErrorType {
    NOT_EXIST("B0001", "존재하지 않는 브랜드 입니다.");
    private final String code;
    private final String message;

    BrandErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}