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
    @Column(nullable = false)
    private String name;
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

    public void modify(String name, String modifiedBy) {
        this.name = name;
        this.modifiedBy = modifiedBy;
    }
}