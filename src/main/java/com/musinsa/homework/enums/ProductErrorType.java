package com.musinsa.homework.enums;

public enum ProductErrorType {
    CANNOT_ADD_WITH_NOT_EXIST_CATEGORY("P0001", "존재하지 않는 카테고리로의 상품 추가는 불가능 합니다.");

    private final String code;
    private final String message;

    ProductErrorType(String code, String message) {
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
