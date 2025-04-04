package com.musinsa.homework.controller;

import com.musinsa.homework.dto.request.BrandCreateRequest;
import com.musinsa.homework.dto.request.BrandModifyRequest;
import com.musinsa.homework.dto.response.BrandResponse;
import com.musinsa.homework.service.BrandService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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
    public BrandResponse getBrand(@PathVariable @Min(value = 1, message = "PATH 에 사용되는 브랜드 ID 는 0 보다 큰 수여야 합니다.") Long brandId) {
        return brandService.getBrand(brandId);
    }

    @PostMapping("/brands")
    public void getBrand(@Valid @RequestBody BrandCreateRequest brandCreateRequest) {
        brandService.createBrand(brandCreateRequest);
    }

    @PutMapping("/brands/{brandId}")
    public void modifyBrand(@PathVariable @Min(value = 1, message = "PATH 에 사용되는 브랜드 ID 는 0 보다 큰 수여야 합니다.") Long brandId
            , @Valid @RequestBody BrandModifyRequest brandModifyRequest) {
        brandService.modifyBrand(brandId, brandModifyRequest);
    }

    @DeleteMapping("/brands/{brandId}")
    public void removeBrand(@PathVariable @Min(value = 1, message = "PATH 에 사용되는 브랜드 ID 는 0 보다 큰 수여야 합니다.") Long brandId) {
        brandService.removeBrand(brandId);
    }
}