package com.musinsa.homework.dto.request;

public record ProductModifyRequest(Long brandId, Long categoryId, Integer basePriceKRW, String basePriceUSD,
                                   String modifiedBy) {
}