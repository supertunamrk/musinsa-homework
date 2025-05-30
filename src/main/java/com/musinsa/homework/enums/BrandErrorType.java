package com.musinsa.homework.enums;

public enum BrandErrorType implements ErrorType {
    CANNOT_CREATE_DUPLICATED_TITLE("B0001", "브랜드명이 겹쳐서 생성이 불가능 합니다."),
    CANNOT_MODIFY_NOT_EXIST("B0002", "존재하지 않는 브랜드의 수정은 불가능 합니다."),
    CANNOT_MODIFY_DUPLICATED_TITLE("B0003", "브랜드명이 겹쳐서 수정이 불가능 합니다."),
    CANNOT_REMOVE_NOT_EXIST("B0004", "존재하지 않는 브랜드의 삭제는 불가능 합니다."),
    NOT_FOUND("B0005", "존재하지 않는 브랜드 입니다.");

    private final String code;
    private final String message;

    BrandErrorType(String code, String message) {
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