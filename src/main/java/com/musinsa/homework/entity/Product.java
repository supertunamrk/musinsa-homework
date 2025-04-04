package com.musinsa.homework.entity;

import com.musinsa.homework.dto.request.ProductModifyRequest;
import com.musinsa.homework.util.ConvertUtil;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(indexes = {
        @Index(name = "idx_category_id", columnList = "categoryId"),
        @Index(name = "idx_brand_id_category_id", columnList = "brandId, categoryId")
})
public class Product extends BaseBackOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private Long categoryId;
    @Column(name = "base_price_krw")
    private Integer basePriceKRW;
    @Column(name = "base_price_usd", precision = 10, scale = 2)
    private BigDecimal basePriceUSD;

    protected Product() {
    }

    public Product(Long brandId, Long categoryId, Integer basePriceKRW, BigDecimal basePriceUSD, String registeredBy) {
        super(registeredBy, registeredBy);

        this.brandId = brandId;
        this.categoryId = categoryId;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
    }

    public Long getId() {
        return id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Integer getBasePriceKRW() {
        return basePriceKRW;
    }

    public BigDecimal getBasePriceUSD() {
        return basePriceUSD;
    }

    public void modify(ProductModifyRequest productUpdateRequest) {
        this.brandId = productUpdateRequest.brandId();
        this.categoryId = productUpdateRequest.categoryId();
        this.basePriceKRW = productUpdateRequest.basePriceKRW();
        this.basePriceUSD = ConvertUtil.toBigDecimal(productUpdateRequest.basePriceUSD());

        modify(productUpdateRequest.modifiedBy());
    }
}