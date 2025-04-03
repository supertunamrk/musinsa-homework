package com.musinsa.homework.dto.request;

public class ProductCreateRequest {
    private Long brandId;
    private Long categoryId;
    private Integer basePriceKRW;
    private String basePriceUSD;
    private String registeredBy;

    public ProductCreateRequest(Long brandId, Long categoryId, Integer basePriceKRW, String basePriceUSD, String registeredBy) {
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
        this.registeredBy = registeredBy;
    }

    public Long getBrandId() {
        return brandId;
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