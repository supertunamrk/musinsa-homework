package com.musinsa.homework.controller;

import com.musinsa.homework.dto.request.ProductCreateRequest;
import com.musinsa.homework.dto.request.ProductModifyRequest;
import com.musinsa.homework.dto.response.ProductResponse;
import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController implements BaseApiController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        if (productId < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public void getProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        productCreateRequest.checkValid();

        productService.createProduct(productCreateRequest);
    }

    @PutMapping("/products/{productId}")
    public void modifyProduct(@PathVariable Long productId, @RequestBody ProductModifyRequest productModifyRequest) {
        if (productId < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        productModifyRequest.checkValid();

        productService.modifyProduct(productId, productModifyRequest);
    }

    @DeleteMapping("/products/{productId}")
    public void removeProduct(@PathVariable Long productId) {
        if (productId < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        productService.removeProduct(productId);
    }
}