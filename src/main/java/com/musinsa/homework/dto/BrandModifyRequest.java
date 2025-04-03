package com.musinsa.homework.dto;

public class BrandModifyRequest {
    private String titleKr;
    private String titleEn;
    private String modifiedBy;

    public BrandModifyRequest(String titleKr, String titleEn, String modifiedBy) {
        this.titleKr = titleKr;
        this.titleEn = titleEn;
        this.modifiedBy = modifiedBy;
    }

    public String getTitleKr() {
        return titleKr;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}