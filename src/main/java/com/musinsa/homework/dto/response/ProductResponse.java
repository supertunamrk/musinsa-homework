package com.musinsa.homework.dto.response;

import com.musinsa.homework.entity.Product;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private Long brandId;
    private Long categoryId;
    private Integer basePriceKRW;
    private BigDecimal basePriceUSD;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.brandId = product.getBrandId();
        this.categoryId = product.getCategoryId();
        this.basePriceKRW = product.getBasePriceKRW();
        this.basePriceUSD = product.getBasePriceUSD();
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

    public BigDecimal getBasePriceUSD() {
        return basePriceUSD;
    }
}