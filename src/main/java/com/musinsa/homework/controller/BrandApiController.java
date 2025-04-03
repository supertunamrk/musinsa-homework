package com.musinsa.homework.controller;

import com.musinsa.homework.dto.request.BrandCreateRequest;
import com.musinsa.homework.dto.request.BrandModifyRequest;
import com.musinsa.homework.dto.response.BrandResponse;
import com.musinsa.homework.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandApiController {
    private final BrandService brandService;

    public BrandApiController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandResponse> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/brands/{brandId}")
    public BrandResponse getBrand(@PathVariable Long brandId) {
        return brandService.getBrand(brandId);
    }

    @PostMapping("/brands")
    public void getBrand(@RequestBody BrandCreateRequest brandCreateRequest) {
        brandService.createBrand(brandCreateRequest);
    }

    @PutMapping("/brands/{brandId}")
    public void modifyBrand(@PathVariable Long brandId, @RequestBody BrandModifyRequest brandModifyRequest) {
        brandService.modifyBrand(brandId, brandModifyRequest);
    }

    @DeleteMapping("/brands/{brandId}")
    public void removeBrand(@PathVariable Long brandId) {
        brandService.removeBrand(brandId);
    }
}