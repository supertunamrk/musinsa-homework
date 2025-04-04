package com.musinsa.homework.repository;

import com.musinsa.homework.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.id = :id AND c.open = true")
    Optional<Category> findOpenCategoryById(@Param("id") Long id);

    @Query("SELECT c FROM Category c WHERE (c.titleKr = :title OR LOWER(c.titleEn) = LOWER(:title)) AND c.open = true")
    Optional<Category> findOpenCategoryByTitle(@Param("title") String title);
}