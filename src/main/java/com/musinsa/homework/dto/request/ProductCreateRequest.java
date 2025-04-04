package com.musinsa.homework.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ProductCreateRequest(@NotNull(message = "브랜드 ID 는 필수 입니다.") @Min(value = 1, message = "브랜드 ID 는 0 보다 큰 수여야 합니다.") Long brandId
        , @NotNull(message = "카테고리 ID 는 필수 입니다.") @Min(value = 1, message = "카테고리 ID 는 0 보다 큰 수여야 합니다.") Long categoryId
        , @NotNull(message = "원화 가격은 필수 입니다.") @Min(value = 1, message = "원화 가격은 0 보다 큰 수여야 합니다.") Integer basePriceKRW
        , @NotBlank(message = "미화 가격 은 필수 입니다.") @Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "미화 가격은 소수점 두자리를 가지는 형태여야 합니다.") String basePriceUSD
        , @NotBlank(message = "등록자명 은 필수 입니다.") String registeredBy) {
}