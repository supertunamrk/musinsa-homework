package com.musinsa.homework.controller;

import com.musinsa.homework.dto.request.BrandCreateRequest;
import com.musinsa.homework.dto.request.BrandModifyRequest;
import com.musinsa.homework.dto.response.BrandResponse;
import com.musinsa.homework.enums.DefaultErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController implements BaseApiController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandResponse> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/brands/{brandId}")
    public BrandResponse getBrand(@PathVariable Long brandId) {
        if (brandId < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        return brandService.getBrand(brandId);
    }

    @PostMapping("/brands")
    public void getBrand(@RequestBody BrandCreateRequest brandCreateRequest) {
        brandCreateRequest.checkValid();

        brandService.createBrand(brandCreateRequest);
    }

    @PutMapping("/brands/{brandId}")
    public void modifyBrand(@PathVariable Long brandId, @RequestBody BrandModifyRequest brandModifyRequest) {
        if (brandId < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        brandModifyRequest.checkValid();

        brandService.modifyBrand(brandId, brandModifyRequest);
    }

    @DeleteMapping("/brands/{brandId}")
    public void removeBrand(@PathVariable Long brandId) {
        if (brandId < 0) {
            throw new ApiRuntimeException(DefaultErrorType.INVALID_PARAMETER);
        }

        brandService.removeBrand(brandId);
    }
}