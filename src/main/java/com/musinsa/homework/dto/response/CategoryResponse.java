package com.musinsa.homework.dto.response;

import com.musinsa.homework.entity.Category;

public class CategoryResponse {
    private Long id;
    private String titleKr;
    private String titleEn;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.titleKr = category.getTitleKr();
        this.titleEn = category.getTitleEn();
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