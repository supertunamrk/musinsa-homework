package com.musinsa.homework.controller;

import com.musinsa.homework.dto.request.ProductCreateRequest;
import com.musinsa.homework.dto.request.ProductModifyRequest;
import com.musinsa.homework.dto.response.ProductResponse;
import com.musinsa.homework.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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
    public ProductResponse getProduct(@PathVariable @Min(value = 1, message = "PATH 에 사용되는 상품 ID 는 0 보다 큰 수여야 합니다.") Long productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public void getProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        productService.createProduct(productCreateRequest);
    }

    @PutMapping("/products/{productId}")
    public void modifyProduct(@PathVariable @Min(value = 1, message = "PATH 에 사용되는 상품 ID 는 0 보다 큰 수여야 합니다.") Long productId
            , @RequestBody ProductModifyRequest productModifyRequest) {
        productService.modifyProduct(productId, productModifyRequest);
    }

    @DeleteMapping("/products/{productId}")
    public void removeProduct(@PathVariable @Min(value = 1, message = "PATH 에 사용되는 상품 ID 는 0 보다 큰 수여야 합니다.") Long productId) {
        productService.removeProduct(productId);
    }
}