package com.musinsa.homework.dto;

public class BrandCreateRequest {
    private String name;
    private String registeredBy;

    public BrandCreateRequest(String name, String registeredBy) {
        this.name = name;
        this.registeredBy = registeredBy;
    }

    public String getName() {
        return name;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }
}
