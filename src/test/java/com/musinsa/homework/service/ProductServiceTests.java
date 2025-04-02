package com.musinsa.homework.service;

import com.musinsa.homework.dto.ProductCreateRequest;
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
        var sut = new ProductService(productRepository);
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
}