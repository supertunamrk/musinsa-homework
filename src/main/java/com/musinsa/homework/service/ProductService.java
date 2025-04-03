package com.musinsa.homework.service;

import com.musinsa.homework.dto.request.ProductCreateRequest;
import com.musinsa.homework.dto.request.ProductUpdateRequest;
import com.musinsa.homework.entity.Product;
import com.musinsa.homework.enums.ProductErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import com.musinsa.homework.repository.CategoryRepository;
import com.musinsa.homework.repository.ProductRepository;
import com.musinsa.homework.util.ConvertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(BrandRepository brandRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createProduct(ProductCreateRequest productCreateRequest) {
        brandRepository.findById(productCreateRequest.getBrandId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_CREATE_NOT_EXIST_BRAND));
        categoryRepository.findById(productCreateRequest.getCategoryId()).orElseThrow((() -> new ApiRuntimeException(ProductErrorType.CANNOT_CREATE_NOT_EXIST_CATEGORY)));

        var product = new Product(productCreateRequest.getBrandId(), productCreateRequest.getCategoryId(),
                productCreateRequest.getBasePriceKRW(), ConvertUtil.toBigDecimal(productCreateRequest.getBasePriceUSD()), productCreateRequest.getRegisteredBy());

        productRepository.save(product);
    }

    @Transactional
    public void modifyProduct(ProductUpdateRequest productUpdateRequest) {
        brandRepository.findById(productUpdateRequest.getBrandId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_BRAND));
        categoryRepository.findById(productUpdateRequest.getCategoryId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_CATEGORY));
        var product = productRepository.findById(productUpdateRequest.getId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_MODIFY_NOT_EXIST));

        product.modify(productUpdateRequest);
    }

    @Transactional
    public void removeProduct(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_REMOVE_NOT_EXIST));

        productRepository.delete(product);
    }
}