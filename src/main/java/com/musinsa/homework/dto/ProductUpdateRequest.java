package com.musinsa.homework.dto;

public class ProductUpdateRequest {
    private Long id;
    private Long brandId;
    private Long categoryId;
    private Integer basePriceKRW;
    private String basePriceUSD;
    private String modifiedBy;

    public ProductUpdateRequest(Long id, Long brandId, Long categoryId, Integer basePriceKRW, String basePriceUSD, String modifiedBy) {
        this.id = id;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
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