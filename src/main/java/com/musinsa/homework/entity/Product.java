package com.musinsa.homework.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoryId;
    private Integer basePriceKRW;
    private BigDecimal basePriceUSD;
    @Column(name = "reg_by", nullable = false)
    private String registeredBy;
    @CreationTimestamp
    @Column(name = "reg_dt", nullable = false, updatable = false)
    private LocalDateTime registeredDateTime;
    @Column(name = "mod_by", nullable = false)
    private String modifiedBy;
    @UpdateTimestamp
    @Column(name = "mod_dt", nullable = false)
    private LocalDateTime modifiedDateTime;

    protected Product() {
    }

    public Product(Long categoryId, Integer basePriceKRW, BigDecimal basePriceUSD, String registeredBy) {
        this.categoryId = categoryId;
        this.basePriceKRW = basePriceKRW;
        this.basePriceUSD = basePriceUSD;
        this.registeredBy = registeredBy;
        this.modifiedBy = registeredBy;
    }

    public Long getId() {
        return id;
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

    public String getRegisteredBy() {
        return registeredBy;
    }

    public LocalDateTime getRegisteredDateTime() {
        return registeredDateTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }
}