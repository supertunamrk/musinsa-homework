package com.musinsa.homework.dto;

public class ProductCreateRequest {
    private Long categoryId;
    private Integer basePriceKRW;
    private String basePriceUSD;
    private String registeredBy;

    public ProductCreateRequest(Long categoryId, Integer basePriceKRW, String basePriceUSD, String registeredBy) {
        this.categoryId = categoryId;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
        this.registeredBy = registeredBy;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Integer getBasePriceKRW() {
        return basePriceKRW;
    }

    public String getBasePriceUSD() {
        return basePriceUSD;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }
}