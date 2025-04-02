package com.musinsa.homework.entity;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleKr;
    private String titleEn;
    @Column(name = "open_yn")
    private Boolean open = false;

    protected Category() {
    }

    public Category(String titleKr, String titleEn) {
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

    public Boolean isOpen() {
        return open;
    }
}