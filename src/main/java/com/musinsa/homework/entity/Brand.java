package com.musinsa.homework.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "reg_by", nullable = false)
    private String registeredBy;
    @Column(name = "reg_dt", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registeredDateTime;
    @Column(name = "mod_by", nullable = false)
    private String modifiedBy;
    @Column(name = "mod_dt", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedDateTime;

    protected Brand() {
    }

    public Brand(String name, String registeredBy, String modifiedBy) {
        this.name = name;
        this.registeredBy = registeredBy;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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