package com.musinsa.homework.service;

import com.musinsa.homework.dto.ProductCreateRequest;
import com.musinsa.homework.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductCreateRequest productCreateRequest) {
    }
}