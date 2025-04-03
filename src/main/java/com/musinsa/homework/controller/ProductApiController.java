package com.musinsa.homework.controller;

import com.musinsa.homework.dto.request.ProductCreateRequest;
import com.musinsa.homework.dto.request.ProductModifyRequest;
import com.musinsa.homework.dto.response.ProductResponse;
import com.musinsa.homework.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductApiController {
    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public void getProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        productService.createProduct(productCreateRequest);
    }

    @PutMapping("/products/{productId}")
    public void modifyProduct(@PathVariable Long productId, @RequestBody ProductModifyRequest productModifyRequest) {
        productService.modifyProduct(productId, productModifyRequest);
    }

    @DeleteMapping("/products/{productId}")
    public void removeProduct(@PathVariable Long productId) {
        productService.removeProduct(productId);
    }
}