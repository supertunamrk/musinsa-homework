package com.musinsa.homework.service;

import com.musinsa.homework.dto.BrandCreateRequest;
import com.musinsa.homework.dto.BrandUpdateRequest;
import com.musinsa.homework.enums.BrandErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BrandServiceTests {
    private final JdbcTemplate jdbcTemplate;
    private final BrandRepository brandRepository;

    BrandServiceTests(@Autowired JdbcTemplate jdbcTemplate, @Autowired BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void truncateTable() {
        jdbcTemplate.execute("TRUNCATE TABLE brand RESTART IDENTITY");
    }

    @Test
    @DisplayName("브랜드 추가")
    void add_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);
        var request = new BrandCreateRequest("Adidas", "이대호");

        // Act
        sut.createBrand(request);

        // Assert
        assertThat(brandRepository.count()).isEqualTo(1);
        var actual = brandRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getName()).isEqualToIgnoringCase(request.getName()),
                () -> assertThat(actual.getRegisteredBy()).isEqualTo(request.getRegisteredBy()),
                () -> assertThat(actual.getRegisteredBy()).isEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getRegisteredDateTime()).isNotNull(),
                () -> assertThat(actual.getModifiedDateTime()).isNotNull(),
                () -> assertThat(actual.getRegisteredDateTime().truncatedTo(ChronoUnit.SECONDS)).isEqualTo(actual.getModifiedDateTime().truncatedTo(ChronoUnit.SECONDS)));
    }

    @Test
    @DisplayName("브랜드명이 겹치는 경우에 대한 예외 발생 - 케이스 동일")
    void throw_exception_when_add_duplicated_name_with_same_case() {
        // Arrange
        var sut = new BrandService(brandRepository);
        var request1 = new BrandCreateRequest("Adidas", "이대호");
        var request2 = new BrandCreateRequest("Adidas", "이대호");

        // Assert & Act
        sut.createBrand(request1);
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.createBrand(request2));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(BrandErrorType.CANNOT_CREATE_ALREADY_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(BrandErrorType.CANNOT_CREATE_ALREADY_EXIST.getMessage()));
    }

    @Test
    @DisplayName("브랜드명이 겹치는 경우에 대한 예외 발생 - 케이스 무시")
    void throw_exception_when_add_duplicated_name_ignore_case() {
        // Arrange
        var sut = new BrandService(brandRepository);
        var request1 = new BrandCreateRequest("Adidas", "이대호");
        var request2 = new BrandCreateRequest("adidas", "이대호");

        // Assert & Act
        sut.createBrand(request1);
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.createBrand(request2));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(BrandErrorType.CANNOT_CREATE_ALREADY_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(BrandErrorType.CANNOT_CREATE_ALREADY_EXIST.getMessage()));
    }

    @Test
    @DisplayName("브랜드 수정")
    void update_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);
        sut.createBrand(new BrandCreateRequest("Adidas", "이대호"));
        var brand = brandRepository.findAll().get(0);
        var request = new BrandUpdateRequest(brand.getId(), "Nike", "이정후");

        // Act
        sut.modifyBrand(request);

        // Assert
        assertThat(brandRepository.findAll()).hasSize(1);
        var actual = brandRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getName()).isEqualTo(request.getName()),
                () -> assertThat(actual.getModifiedBy()).isEqualTo(request.getModifiedBy()),
                () -> assertThat(actual.getRegisteredBy()).isNotEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getModifiedDateTime().isAfter(actual.getRegisteredDateTime())).isTrue());
    }

    @Test
    @DisplayName("존재하지 않는 브랜드에 대한 수정시 예외 발생")
    void throw_exception_when_modify_not_exist_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);
        var request = new BrandUpdateRequest(1L, "Nike", "이정후");

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.modifyBrand(request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(BrandErrorType.CANNOT_MODIFY_NOT_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(BrandErrorType.CANNOT_MODIFY_NOT_EXIST.getMessage()));
    }

    @Test
    @DisplayName("브랜드 삭제")
    void remove_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);
        sut.createBrand(new BrandCreateRequest("Adidas", "이대호"));
        var brand = brandRepository.findAll().get(0);

        // Act
        sut.removeBrand(brand.getId());

        // Assert
        assertAll(() -> assertThat(brandRepository.findAll()).hasSize(0),
                () -> assertThat(brandRepository.findById(brand.getId()).isPresent()).isFalse());
    }

    @Test
    @DisplayName("존재하지 않는 상품 삭제시 예외 발생")
    void throw_exception_when_remove_not_exist_brand() {
        // Arrange
        var sut = new BrandService(brandRepository);

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.removeBrand(100L));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(BrandErrorType.CANNOT_REMOVE_NOT_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(BrandErrorType.CANNOT_REMOVE_NOT_EXIST.getMessage()));
    }
}