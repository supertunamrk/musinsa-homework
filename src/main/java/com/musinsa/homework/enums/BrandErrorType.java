package com.musinsa.homework.enums;

public enum BrandErrorType {
    NOT_EXIST("B0001", "존재하지 않는 브랜드 입니다."),
    ALREADY_EXIST("B0002", "기존에 존재하는 브랜드명이 있습니다.");

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