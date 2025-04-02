package com.musinsa.homework.service;

import com.musinsa.homework.dto.BrandCreateRequest;
import com.musinsa.homework.dto.BrandUpdateRequest;
import com.musinsa.homework.repository.BrandRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class BrandServiceTests {
    private final BrandRepository brandRepository;

    BrandServiceTests(@Autowired BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Test
    @DisplayName("브랜드 추가")
    void add_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);
        var request = new BrandCreateRequest();

        // Act
        sut.createBrand(request);

        // Assert
        assertThat(brandRepository.count()).isEqualTo(1);
        var actual = brandRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getName()).isEqualTo(request.getName()),
                () -> assertThat(actual.getRegisteredBy()).isEqualTo(request.getRegisteredBy()),
                () -> assertThat(actual.getRegisteredBy()).isEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getRegisteredDateTime()).isNotNull(),
                () -> assertThat(actual.getModifiedDateTime()).isNotNull(),
                () -> assertThat(actual.getRegisteredDateTime()).isEqualTo(actual.getModifiedDateTime()));
    }

    @Test
    @DisplayName("브랜드 수정")
    void update_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);
        sut.createBrand(new BrandCreateRequest());
        var request = new BrandUpdateRequest();

        // Act
        sut.updateBrand(request);

        // Assert
        assertThat(brandRepository.findAll()).hasSize(1);
        var actual = brandRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getName()).isEqualTo(request.getName()),
                () -> assertThat(actual.getModifiedBy()).isEqualTo(request.getModifiedBy()),
                () -> assertThat(actual.getRegisteredBy()).isNotEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getModifiedDateTime().isAfter(actual.getRegisteredDateTime())).isTrue());
    }
}