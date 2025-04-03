package com.musinsa.homework.dto.response;

import com.musinsa.homework.entity.Brand;

public class BrandResponse {
    private final Long id;
    private final String titleKr;
    private final String titleEn;

    public BrandResponse(Brand brand) {
        this.id = brand.getId();
        this.titleKr = brand.getTitleKr();
        this.titleEn = brand.getTitleEn();
    }

    public Long getId() {
        return id;
    }

    public String getTitleKr() {
        return titleKr;
    }

    public String getTitleEn() {
        return titleEn;
    }
}