package com.musinsa.homework.service;

import com.musinsa.homework.dto.response.*;
import com.musinsa.homework.enums.BrandErrorType;
import com.musinsa.homework.enums.CategoryErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import com.musinsa.homework.repository.CategoryRepository;
import com.musinsa.homework.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public AnswerService(BrandRepository brandRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Map<String, Object> answer1() {
        var result = new LinkedHashMap<String, Object>();
        var products = productRepository.findMinPriceProductsEachCategory();
        var dealResponses = products.stream()
                .map(product ->
                        new DealResponse(categoryRepository.findOpenCategoryById(product.getCategoryId()).orElseThrow(() -> new ApiRuntimeException(CategoryErrorType.NOT_FOUND))
                                , brandRepository.findById(product.getBrandId()).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.NOT_FOUND))
                                , product))
                .toList();

        result.put("minPriceDealResponses", dealResponses);
        result.put("totalPriceKRW", dealResponses.stream().mapToInt(minPriceDealResponse -> minPriceDealResponse.getProductResponse().getBasePriceKRW()).sum());
        result.put("totalPriceUSD", dealResponses.stream()
                .map(minPriceDealResponse -> minPriceDealResponse.getProductResponse().getBasePriceUSD())
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return result;
    }

    public Map<String, Object> answer2() {
        var result = new LinkedHashMap<String, Object>();
        var products = productRepository.findMinPriceBrandProducts();
        var noBrandDealResponses = products.stream()
                .map(product ->
                        new NoBrandDealResponse(categoryRepository.findOpenCategoryById(product.getCategoryId()).orElseThrow(() -> new ApiRuntimeException(CategoryErrorType.NOT_FOUND))
                                , product))
                .toList();

        result.put("brand", new BrandResponse(brandRepository.findById(products.get(0).getBrandId()).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.NOT_FOUND))));
        result.put("categoryAndProduct", noBrandDealResponses);
        result.put("totalPriceKRW", noBrandDealResponses.stream().mapToInt(minPriceDealResponse -> minPriceDealResponse.getProductResponse().getBasePriceKRW()).sum());
        result.put("totalPriceUSD", noBrandDealResponses.stream()
                .map(minPriceDealResponse -> minPriceDealResponse.getProductResponse().getBasePriceUSD())
                .reduce(BigDecimal.ZERO, BigDecimal::add));

        return result;
    }

    public Map<String, Object> answer3(String categoryTitle) {
        var result = new LinkedHashMap<String, Object>();
        var category = categoryRepository.findOpenCategoryByTitle(categoryTitle).orElseThrow(() -> new ApiRuntimeException(CategoryErrorType.NOT_FOUND));
        var minPriceProducts = productRepository.findMinPriceProductsByCategoryId(category.getId());
        var maxPriceProducts = productRepository.findMaxPriceProductsByCategoryId(category.getId());

        result.put("category", new CategoryResponse(category));
        result.put("minPriceProducts", minPriceProducts.stream()
                .map(product ->
                        new NoCategoryDealResponse(brandRepository.findById(product.getBrandId()).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.NOT_FOUND)), product))
                .collect(Collectors.toList()));
        result.put("maxPriceProducts", maxPriceProducts.stream()
                .map(product ->
                        new NoCategoryDealResponse(brandRepository.findById(product.getBrandId()).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.NOT_FOUND)), product))
                .collect(Collectors.toList()));

        return result;
    }
}