package com.musinsa.homework.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musinsa.homework.entity.Category;
import com.musinsa.homework.entity.Product;

@JsonIgnoreProperties({"brandResponse"})
public class NoBrandDealResponse extends DealResponse {
    public NoBrandDealResponse(Category category, Product product) {
        super();

        setCategoryResponse(category);
        setProductResponse(product);
    }
}