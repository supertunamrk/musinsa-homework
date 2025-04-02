package com.musinsa.homework.service;

import com.musinsa.homework.dto.ProductCreateRequest;
import com.musinsa.homework.entity.Product;
import com.musinsa.homework.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductCreateRequest productCreateRequest) {
        var product = new Product(productCreateRequest.getCategoryId(), productCreateRequest.getBasePriceKRW(), this.toBigDecimal(productCreateRequest.getBasePriceUSD()), productCreateRequest.getRegisteredBy());

        productRepository.save(product);
    }

    private BigDecimal toBigDecimal(String target) {
        return new BigDecimal(target);
    }
}