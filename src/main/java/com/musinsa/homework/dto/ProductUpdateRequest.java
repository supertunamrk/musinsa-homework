package com.musinsa.homework.dto;

public class ProductUpdateRequest {
    private Long id;
    private Integer basePriceKRW;
    private String basePriceUSD;
    private String modifiedBy;

    public ProductUpdateRequest(Long id, Integer basePriceKRW, String basePriceUSD, String modifiedBy) {
        this.id = id;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
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