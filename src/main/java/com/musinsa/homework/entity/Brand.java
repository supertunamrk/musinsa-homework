package com.musinsa.homework.entity;

import jakarta.persistence.*;

@Entity
public class Brand extends BaseBackOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titleKr;
    @Column(nullable = false, unique = true)
    private String titleEn;

    protected Brand() {
    }

    public Brand(String titleKr, String titleEn, String registeredBy) {
        super(registeredBy, registeredBy);

        this.titleKr = titleKr;
        this.titleEn = titleEn;
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

    public void modify(String titleKr, String titleEn, String modifiedBy) {
        this.titleKr = titleKr;
        this.titleEn = titleEn;

        modify(modifiedBy);
    }
}