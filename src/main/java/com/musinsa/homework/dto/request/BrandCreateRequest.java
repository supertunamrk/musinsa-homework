package com.musinsa.homework.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BrandCreateRequest(@NotBlank(message = "브랜드명 - 국문 은 필수 입니다.") String titleKr
        , @NotBlank(message = "브랜드명 - 영문 은 필수 입니다.") String titleEn
        , @NotBlank(message = "등록자명 은 필수 입니다.") String registeredBy) {
}