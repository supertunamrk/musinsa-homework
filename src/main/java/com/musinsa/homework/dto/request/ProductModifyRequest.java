package com.musinsa.homework.dto.request;

public class ProductModifyRequest {
    private Long brandId;
    private Long categoryId;
    private Integer basePriceKRW;
    private String basePriceUSD;
    private String modifiedBy;

    public ProductModifyRequest(Long brandId, Long categoryId, Integer basePriceKRW, String basePriceUSD, String modifiedBy) {
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
        this.modifiedBy = modifiedBy;
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

    public String getModifiedBy() {
        return modifiedBy;
    }
}