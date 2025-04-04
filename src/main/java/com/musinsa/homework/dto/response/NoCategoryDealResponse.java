package com.musinsa.homework.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musinsa.homework.entity.Brand;
import com.musinsa.homework.entity.Product;

@JsonIgnoreProperties({"categoryResponse"})
public class NoCategoryDealResponse extends DealResponse {
    public NoCategoryDealResponse(Brand brand, Product product) {
        super();

        setBrandResponse(brand);
        setProductResponse(product);
    }
}