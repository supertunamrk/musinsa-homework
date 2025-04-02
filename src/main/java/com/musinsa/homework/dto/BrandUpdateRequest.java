package com.musinsa.homework.dto;

public class BrandUpdateRequest {
    private Long id;
    private String name;
    private String modifiedBy;

    public BrandUpdateRequest(Long id, String name, String modifiedBy) {
        this.id = id;
        this.name = name;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}