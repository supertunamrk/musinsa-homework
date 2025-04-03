package com.musinsa.homework.dto.request;

public class BrandCreateRequest {
    private String titleKr;
    private String titleEn;
    private String registeredBy;

    public BrandCreateRequest(String titleKr, String titleEn, String registeredBy) {
        this.titleKr = titleKr;
        this.titleEn = titleEn;
        this.registeredBy = registeredBy;
    }

    public String getTitleKr() {
        return titleKr;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }
}
