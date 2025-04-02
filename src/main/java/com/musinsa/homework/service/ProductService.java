package com.musinsa.homework.service;

import com.musinsa.homework.dto.ProductCreateRequest;
import com.musinsa.homework.dto.ProductUpdateRequest;
import com.musinsa.homework.entity.Product;
import com.musinsa.homework.enums.ProductErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.CategoryRepository;
import com.musinsa.homework.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createProduct(ProductCreateRequest productCreateRequest) {
        categoryRepository.findById(productCreateRequest.getCategoryId()).orElseThrow((() -> new ApiRuntimeException(ProductErrorType.CANNOT_ADD_WITH_NOT_EXIST_CATEGORY)));

        var product = new Product(productCreateRequest.getCategoryId(),
                productCreateRequest.getBasePriceKRW(), this.toBigDecimal(productCreateRequest.getBasePriceUSD()), productCreateRequest.getRegisteredBy());

        productRepository.save(product);
    }

    public void updateProduct(ProductUpdateRequest productUpdateRequest) {
    }

    private BigDecimal toBigDecimal(String target) {
        return new BigDecimal(target);
    }
}