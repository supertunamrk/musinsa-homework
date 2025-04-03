package com.musinsa.homework.dto.request;

public record ProductCreateRequest(Long brandId, Long categoryId, Integer basePriceKRW, String basePriceUSD,
                                   String registeredBy) {
}