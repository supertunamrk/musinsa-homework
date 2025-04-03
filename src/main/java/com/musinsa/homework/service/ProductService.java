package com.musinsa.homework.service;

import com.musinsa.homework.dto.request.ProductCreateRequest;
import com.musinsa.homework.dto.request.ProductModifyRequest;
import com.musinsa.homework.dto.response.ProductResponse;
import com.musinsa.homework.entity.Product;
import com.musinsa.homework.enums.ProductErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import com.musinsa.homework.repository.CategoryRepository;
import com.musinsa.homework.repository.ProductRepository;
import com.musinsa.homework.util.ConvertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    public ProductResponse getProduct(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.NOT_FOUND));

        return new ProductResponse(product);
    }

    @Transactional
    public void createProduct(ProductCreateRequest productCreateRequest) {
        brandRepository.findById(productCreateRequest.brandId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_CREATE_NOT_EXIST_BRAND));
        categoryRepository.findById(productCreateRequest.categoryId()).orElseThrow((() -> new ApiRuntimeException(ProductErrorType.CANNOT_CREATE_NOT_EXIST_CATEGORY)));

        var product = new Product(productCreateRequest.brandId(), productCreateRequest.categoryId(),
                productCreateRequest.basePriceKRW(), ConvertUtil.toBigDecimal(productCreateRequest.basePriceUSD()), productCreateRequest.registeredBy());

        productRepository.save(product);
    }

    @Transactional
    public void modifyProduct(Long productId, ProductModifyRequest productModifyRequest) {
        brandRepository.findById(productModifyRequest.brandId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_BRAND));
        categoryRepository.findById(productModifyRequest.categoryId()).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_CATEGORY));
        var product = productRepository.findById(productId).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_MODIFY_NOT_EXIST));

        product.modify(productModifyRequest);
    }

    @Transactional
    public void removeProduct(Long productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> new ApiRuntimeException(ProductErrorType.CANNOT_REMOVE_NOT_EXIST));

        productRepository.delete(product);
    }
}