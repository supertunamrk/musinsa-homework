package com.musinsa.homework.repository;

import com.musinsa.homework.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT COUNT(*) FROM Brand AS b WHERE LOWER(b.titleEn) = LOWER(:titleEn)")
    int countByTitleEnCaseInsensitive(@Param("titleEn") String titleEn);
}