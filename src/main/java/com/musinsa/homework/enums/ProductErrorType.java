package com.musinsa.homework.enums;

public enum ProductErrorType implements ErrorType {
    CANNOT_CREATE_NOT_EXIST_BRAND("P0001", "존재하지 않는 브랜드로 상품 생성은 불가능 합니다."),
    CANNOT_CREATE_NOT_EXIST_CATEGORY("P0002", "존재하지 않는 카테고리로 상품 생성은 불가능 합니다."),
    CANNOT_MODIFY_NOT_EXIST("P0003", "존재하지 않는 상품의 수정은 불가능 합니다."),
    CANNOT_MODIFY_NOT_EXIST_BRAND("P0004", "존재하지 않는 브랜드로 상품 수정은 불가능 합니다."),
    CANNOT_MODIFY_NOT_EXIST_CATEGORY("P0005", "존재하지 않는 카테고리로 상품 수정은 불가능 합니다."),
    CANNOT_REMOVE_NOT_EXIST("P0006", "존재하지 않는 상품의 삭제는 불가능 합니다."),
    NOT_FOUND("B0007", "존재하지 않는 상품 입니다.");

    private final String code;
    private final String message;

    ProductErrorType(String code, String message) {
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
