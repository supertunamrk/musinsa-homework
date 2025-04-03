package com.musinsa.homework.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titleKr;
    @Column(nullable = false, unique = true)
    private String titleEn;
    @Column(name = "reg_by", nullable = false)
    private String registeredBy;
    @CreationTimestamp
    @Column(name = "reg_dt", nullable = false, updatable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime registeredDateTime;
    @Column(name = "mod_by", nullable = false)
    private String modifiedBy;
    @UpdateTimestamp
    @Column(name = "mod_dt", nullable = false, columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime modifiedDateTime;

    protected Brand() {
    }

    public Brand(String titleKr, String titleEn, String registeredBy) {
        this.titleKr = titleKr;
        this.titleEn = titleEn;
        this.registeredBy = registeredBy;
        this.modifiedBy = registeredBy;
    }

    public Long getId() {
        return id;
    }

    public String getTitleKr() {
        return titleKr;
    }

    public String getTitleEn() {
        return titleEn;
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

    public void modify(String titleKr, String titleEn, String modifiedBy) {
        this.titleKr = titleKr;
        this.titleEn = titleEn;
        this.modifiedBy = modifiedBy;
    }
}