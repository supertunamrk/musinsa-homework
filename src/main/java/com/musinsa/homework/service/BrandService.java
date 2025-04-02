package com.musinsa.homework.service;

import com.musinsa.homework.dto.BrandCreateRequest;
import com.musinsa.homework.dto.BrandUpdateRequest;
import com.musinsa.homework.entity.Brand;
import com.musinsa.homework.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void createBrand(BrandCreateRequest brandCreateRequest) {
        var brand = new Brand(brandCreateRequest.getName(), brandCreateRequest.getRegisteredBy(), brandCreateRequest.getRegisteredBy());

        brandRepository.save(brand);
    }

    public void updateBrand(BrandUpdateRequest brandUpdateRequest) {
        var brand = brandRepository.findById(brandUpdateRequest.getId()).orElseThrow();

        brand.modify(brandUpdateRequest.getName(), brandUpdateRequest.getModifiedBy());
    }
}