package com.musinsa.homework.dto.response;

import com.musinsa.homework.entity.Brand;
import com.musinsa.homework.entity.Category;
import com.musinsa.homework.entity.Product;

public class DealResponse {
    private CategoryResponse categoryResponse;
    private BrandResponse brandResponse;
    private ProductResponse productResponse;

    protected DealResponse() {
    }

    public DealResponse(Category category, Brand brand, Product product) {
        this.categoryResponse = new CategoryResponse(category);
        this.brandResponse = new BrandResponse(brand);
        this.productResponse = new ProductResponse(product);
    }

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(Category category) {
        this.categoryResponse = new CategoryResponse(category);
    }

    public BrandResponse getBrandResponse() {
        return brandResponse;
    }

    public void setBrandResponse(Brand brand) {
        this.brandResponse = new BrandResponse(brand);
    }

    public ProductResponse getProductResponse() {
        return productResponse;
    }

    public void setProductResponse(Product product) {
        this.productResponse = new ProductResponse(product);
    }
}