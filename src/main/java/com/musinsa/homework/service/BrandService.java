package com.musinsa.homework.service;

import com.musinsa.homework.dto.BrandCreateRequest;
import com.musinsa.homework.dto.BrandUpdateRequest;
import com.musinsa.homework.entity.Brand;
import com.musinsa.homework.enums.BrandErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Transactional
    public void createBrand(BrandCreateRequest brandCreateRequest) {
        try {
            var brand = new Brand(brandCreateRequest.getName(), brandCreateRequest.getRegisteredBy(), brandCreateRequest.getRegisteredBy());

            brandRepository.save(brand);
        } catch (DataIntegrityViolationException e) {
            throw new ApiRuntimeException(BrandErrorType.CANNOT_CREATE_ALREADY_EXIST);
        }
    }

    @Transactional
    public void modifyBrand(BrandUpdateRequest brandUpdateRequest) {
        var brand = brandRepository.findById(brandUpdateRequest.getId()).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.CANNOT_MODIFY_NOT_EXIST));

        brand.modify(brandUpdateRequest.getName(), brandUpdateRequest.getModifiedBy());
    }

    @Transactional
    public void removeBrand(Long brandId) {
        var brand = brandRepository.findById(brandId).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.CANNOT_REMOVE_NOT_EXIST));

        brandRepository.delete(brand);
    }
}