package com.musinsa.homework.service;

import com.musinsa.homework.dto.ProductCreateRequest;
import com.musinsa.homework.dto.ProductUpdateRequest;
import com.musinsa.homework.enums.ProductErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.CategoryRepository;
import com.musinsa.homework.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class ProductServiceTests {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceTests(@Autowired ProductRepository productRepository, @Autowired CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Test
    @DisplayName("상품 추가")
    void add_product() {
        // Arrange
        var sut = new ProductService(productRepository, categoryRepository);
        var category = categoryRepository.findAll().get(0);
        var request = new ProductCreateRequest(category.getId(), 10000, "10.11", "이대호");

        // Act
        sut.createProduct(request);

        // Assert
        assertThat(productRepository.count()).isEqualTo(1);
        var actual = productRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getBasePriceKRW()).isEqualTo(request.getBasePriceKRW()),
                () -> assertThat(actual.getBasePriceUSD()).isEqualTo(new BigDecimal(request.getBasePriceUSD())),
                () -> assertThat(actual.getRegisteredBy()).isEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getRegisteredDateTime()).isNotNull(),
                () -> assertThat(actual.getModifiedDateTime()).isNotNull(),
                () -> assertThat(actual.getRegisteredDateTime().truncatedTo(ChronoUnit.SECONDS)).isEqualTo(actual.getModifiedDateTime().truncatedTo(ChronoUnit.SECONDS)));
    }

    @Test
    @DisplayName("존재하지 않는 카테고리에 대한 상품 추가에 대한 예외 발생")
    void throw_exception_when_add_not_exist_category() {
        // Arrange
        var sut = new ProductService(productRepository, categoryRepository);
        var request = new ProductCreateRequest(categoryRepository.count() + 1, 10000, "10.11", "이대호");

        // Act & Assert
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.createProduct(request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_ADD_WITH_NOT_EXIST_CATEGORY.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_ADD_WITH_NOT_EXIST_CATEGORY.getMessage()));
    }

    @Test
    @DisplayName("상품 수정")
    void update_product() {
        // Arrange
        var sut = new ProductService(productRepository, categoryRepository);
        sut.createProduct(new ProductCreateRequest(1L, 10000, "10.11", "이대호"));
        var product = productRepository.findAll().get(0);
        var request = new ProductUpdateRequest(product.getId(), 5000, "5.55", "이정후");

        // Act
        sut.updateProduct(request);

        // Assert
        assertThat(productRepository.findAll()).hasSize(1);
        var actual = productRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getBasePriceKRW()).isEqualTo(request.getBasePriceKRW()),
                () -> assertThat(actual.getBasePriceUSD()).isEqualTo(new BigDecimal(request.getBasePriceUSD())),
                () -> assertThat(actual.getModifiedBy()).isEqualTo(request.getModifiedBy()),
                () -> assertThat(actual.getRegisteredBy()).isNotEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getModifiedDateTime().isAfter(actual.getRegisteredDateTime())).isTrue());
    }

    @Test
    @DisplayName("존재하지 않는 상품에 대한 수정시 예외 발생")
    void throw_exception_when_modify_not_exist_product() {
        // Arrange
        var sut = new ProductService(productRepository, categoryRepository);
        var request = new ProductUpdateRequest(1L, 5000, "5.55", "이정후");

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.updateProduct(request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.NOT_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.NOT_EXIST.getMessage()));
    }
}