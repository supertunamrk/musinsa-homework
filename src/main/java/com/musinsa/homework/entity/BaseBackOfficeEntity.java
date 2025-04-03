package com.musinsa.homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseBackOfficeEntity {
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

    protected BaseBackOfficeEntity() {
    }

    protected BaseBackOfficeEntity(String registeredBy, String modifiedBy) {
        this.registeredBy = registeredBy;
        this.modifiedBy = modifiedBy;
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

    public void modify(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}