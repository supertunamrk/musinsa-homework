package com.musinsa.homework.service;

import com.musinsa.homework.dto.request.BrandCreateRequest;
import com.musinsa.homework.dto.request.BrandModifyRequest;
import com.musinsa.homework.dto.response.BrandResponse;
import com.musinsa.homework.entity.Brand;
import com.musinsa.homework.enums.BrandErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponse> getAllBrand() {
        return brandRepository.findAll().stream().map(BrandResponse::new).collect(Collectors.toList());
    }

    public BrandResponse getBrand(Long brandId) {
        var brand = brandRepository.findById(brandId).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.NOT_FOUND));

        return new BrandResponse(brand);
    }

    @Transactional
    public void createBrand(BrandCreateRequest brandCreateRequest) {
        if (brandRepository.countByTitleEnCaseInsensitive(brandCreateRequest.getTitleEn()) != 0) {
            throw new ApiRuntimeException(BrandErrorType.CANNOT_CREATE_DUPLICATED_TITLE);
        }

        try {
            var brand = new Brand(brandCreateRequest.getTitleKr(), brandCreateRequest.getTitleEn(), brandCreateRequest.getRegisteredBy());

            brandRepository.save(brand);
        } catch (DataIntegrityViolationException e) {
            throw new ApiRuntimeException(BrandErrorType.CANNOT_CREATE_DUPLICATED_TITLE);
        }
    }

    @Transactional
    public void modifyBrand(Long brandId, BrandModifyRequest brandModifyRequest) {
        try {
            var brand = brandRepository.findById(brandId).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.CANNOT_MODIFY_NOT_EXIST));

            brand.modify(brandModifyRequest.getTitleKr(), brandModifyRequest.getTitleEn(), brandModifyRequest.getModifiedBy());

            brandRepository.saveAndFlush(brand);
        } catch (DataIntegrityViolationException e) {
            throw new ApiRuntimeException(BrandErrorType.CANNOT_MODIFY_DUPLICATED_TITLE);
        }
    }

    @Transactional
    public void removeBrand(Long brandId) {
        var brand = brandRepository.findById(brandId).orElseThrow(() -> new ApiRuntimeException(BrandErrorType.CANNOT_REMOVE_NOT_EXIST));

        brandRepository.delete(brand);
    }
}