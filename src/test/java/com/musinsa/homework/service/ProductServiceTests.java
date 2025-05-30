package com.musinsa.homework.service;

import com.musinsa.homework.dto.request.ProductCreateRequest;
import com.musinsa.homework.dto.request.ProductModifyRequest;
import com.musinsa.homework.entity.Brand;
import com.musinsa.homework.enums.ProductErrorType;
import com.musinsa.homework.exception.ApiRuntimeException;
import com.musinsa.homework.repository.BrandRepository;
import com.musinsa.homework.repository.CategoryRepository;
import com.musinsa.homework.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class ProductServiceTests {
    private final JdbcTemplate jdbcTemplate;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    ProductServiceTests(@Autowired JdbcTemplate jdbcTemplate,
                        @Autowired BrandRepository brandRepository, @Autowired ProductRepository productRepository, @Autowired CategoryRepository categoryRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @BeforeEach
    void truncateTable() {
        jdbcTemplate.execute("TRUNCATE TABLE brand RESTART IDENTITY");
        jdbcTemplate.execute("TRUNCATE TABLE product RESTART IDENTITY");
    }

    @Test
    @DisplayName("상품 생성")
    void create_product() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand = brandRepository.save(new Brand("아디다스", "Adidas", "이대호"));
        var category = categoryRepository.findAll().get(0);
        var request = new ProductCreateRequest(brand.getId(), category.getId(), 10000, "10.11", "이대호");

        // Act
        sut.createProduct(request);

        // Assert
        assertThat(productRepository.count()).isEqualTo(1);
        var actual = productRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getBrandId()).isEqualTo(brand.getId()),
                () -> assertThat(actual.getCategoryId()).isEqualTo(category.getId()),
                () -> assertThat(actual.getBasePriceKRW()).isEqualTo(request.basePriceKRW()),
                () -> assertThat(actual.getBasePriceUSD()).isEqualTo(new BigDecimal(request.basePriceUSD())),
                () -> assertThat(actual.getRegisteredBy()).isEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getRegisteredDateTime()).isNotNull(),
                () -> assertThat(actual.getModifiedDateTime()).isNotNull(),
                () -> assertThat(actual.getRegisteredDateTime().truncatedTo(ChronoUnit.SECONDS)).isEqualTo(actual.getModifiedDateTime().truncatedTo(ChronoUnit.SECONDS)));
    }

    @Test
    @DisplayName("존재하지 않는 브랜드에 상품 생성을 할 경우 예외 발생")
    void throw_exception_when_create_not_exist_brand() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var request = new ProductCreateRequest(1L, 1L, 10000, "10.11", "이대호");

        // Act & Assert
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.createProduct(request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_CREATE_NOT_EXIST_BRAND.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_CREATE_NOT_EXIST_BRAND.getMessage()));
    }

    @Test
    @DisplayName("존재하지 않는 카테고리에 상품 생성을 할 경우 예외 발생")
    void throw_exception_when_create_not_exist_category() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand = brandRepository.save(new Brand("Adidas", "이대호", "이대호"));
        var request = new ProductCreateRequest(brand.getId(), categoryRepository.count() + 1, 10000, "10.11", "이대호");

        // Act & Assert
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.createProduct(request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_CREATE_NOT_EXIST_CATEGORY.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_CREATE_NOT_EXIST_CATEGORY.getMessage()));
    }

    @Test
    @DisplayName("상품 수정")
    void modify_product() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand1 = brandRepository.save(new Brand("아디다스", "Adidas", "이대호"));
        var brand2 = brandRepository.save(new Brand("나이키", "Nike", "이대호"));
        sut.createProduct(new ProductCreateRequest(brand1.getId(), 1L, 10000, "10.11", "이대호"));
        var product = productRepository.findAll().get(0);
        var request = new ProductModifyRequest(brand2.getId(), 2L, 5000, "5.55", "이정후");

        // Act
        sut.modifyProduct(product.getId(), request);

        // Assert
        assertThat(productRepository.findAll()).hasSize(1);
        var actual = productRepository.findAll().get(0);
        assertAll(() -> assertThat(actual.getId()).isEqualTo(1L),
                () -> assertThat(actual.getBrandId()).isEqualTo(brand2.getId()),
                () -> assertThat(actual.getCategoryId()).isEqualTo(2L),
                () -> assertThat(actual.getBasePriceKRW()).isEqualTo(request.basePriceKRW()),
                () -> assertThat(actual.getBasePriceUSD()).isEqualTo(new BigDecimal(request.basePriceUSD())),
                () -> assertThat(actual.getModifiedBy()).isEqualTo(request.modifiedBy()),
                () -> assertThat(actual.getRegisteredBy()).isNotEqualTo(actual.getModifiedBy()),
                () -> assertThat(actual.getModifiedDateTime().isAfter(actual.getRegisteredDateTime())).isTrue());
    }

    @Test
    @DisplayName("존재하지 않는 상품에 대한 수정시 예외 발생")
    void throw_exception_when_modify_not_exist_product() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand = brandRepository.save(new Brand("Adidas", "이대호", "이대호"));
        var request = new ProductModifyRequest(brand.getId(), 1L, 5000, "5.55", "이정후");

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.modifyProduct(100L, request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_MODIFY_NOT_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_MODIFY_NOT_EXIST.getMessage()));
    }

    @Test
    @DisplayName("존재하지 않는 브랜드를 사용한 상품 수정시 예외 발생")
    void throw_exception_when_modify_not_exist_brand() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand = brandRepository.save(new Brand("Adidas", "이대호", "이대호"));
        sut.createProduct(new ProductCreateRequest(brand.getId(), 1L, 5000, "5.55", "이대호"));
        var request = new ProductModifyRequest(2L, 1L, 5000, "5.55", "이정후");

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.modifyProduct(1L, request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_BRAND.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_BRAND.getMessage()));
    }

    @Test
    @DisplayName("존재하지 않는 카테고리를 사용한 상품 수정시 예외 발생")
    void throw_exception_when_modify_not_exist_category() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand = brandRepository.save(new Brand("Adidas", "이대호", "이대호"));
        sut.createProduct(new ProductCreateRequest(brand.getId(), 1L, 5000, "5.55", "이대호"));
        var request = new ProductModifyRequest(1L, categoryRepository.count() + 1, 5000, "5.55", "이정후");

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.modifyProduct(1L, request));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_CATEGORY.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_MODIFY_NOT_EXIST_CATEGORY.getMessage()));
    }

    @Test
    @DisplayName("상품 삭제")
    void remove_product() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);
        var brand = brandRepository.save(new Brand("Adidas", "이대호", "이대호"));
        sut.createProduct(new ProductCreateRequest(brand.getId(), 1L, 10000, "10.11", "이대호"));
        var product = productRepository.findAll().get(0);

        // Act
        sut.removeProduct(product.getId());

        // Assert
        assertAll(() -> assertThat(productRepository.findAll()).hasSize(0),
                () -> assertThat(productRepository.findById(product.getId()).isPresent()).isFalse());
    }

    @Test
    @DisplayName("존재하지 않는 상품 삭제시 예외 발생")
    void throw_exception_when_remove_not_exist_product() {
        // Arrange
        var sut = new ProductService(brandRepository, productRepository, categoryRepository);

        // Assert & Act
        var actual = assertThrows(ApiRuntimeException.class, () -> sut.removeProduct(100L));
        assertAll(() -> assertThat(actual.getErrorCode()).isEqualTo(ProductErrorType.CANNOT_REMOVE_NOT_EXIST.getCode()),
                () -> assertThat(actual.getErrorMessage()).isEqualTo(ProductErrorType.CANNOT_REMOVE_NOT_EXIST.getMessage()));
    }
}