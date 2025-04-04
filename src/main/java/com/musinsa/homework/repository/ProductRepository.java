package com.musinsa.homework.repository;

import com.musinsa.homework.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.id =" +
            " (SELECT sub.id FROM Product sub WHERE sub.categoryId = p.categoryId AND sub.basePriceKRW =" +
            " (SELECT MIN(innerSub.basePriceKRW) FROM Product innerSub WHERE innerSub.categoryId = p.categoryId) ORDER BY sub.brandId DESC LIMIT 1)" +
            " ORDER BY p.categoryId ASC")
    List<Product> findMinPriceProductsEachCategory();

    @Query("SELECT p FROM Product p WHERE p.brandId =" +
            " (SELECT q.brandId FROM Product q WHERE (q.brandId, q.basePriceKRW) IN" +
            " (SELECT sub.brandId, MIN(sub.basePriceKRW) FROM Product sub GROUP BY sub.brandId, sub.categoryId)" +
            " GROUP BY q.brandId ORDER BY SUM(q.basePriceKRW) ASC, q.brandId DESC LIMIT 1) AND (p.brandId, p.basePriceKRW) IN" +
            " (SELECT sub.brandId, MIN(sub.basePriceKRW) FROM Product sub GROUP BY sub.brandId, sub.categoryId) ORDER BY p.categoryId ASC")
    List<Product> findMinPriceBrandProducts();

    @Query("SELECT p FROM Product p WHERE p.id IN" +
            " (SELECT sub.id FROM Product sub WHERE sub.categoryId = p.categoryId AND sub.basePriceKRW =" +
            " (SELECT MIN(innerSub.basePriceKRW) FROM Product innerSub WHERE innerSub.categoryId = p.categoryId))" +
            " AND p.categoryId = :categoryId ORDER BY p.brandId DESC")
    List<Product> findMinPriceProductsByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE p.id IN" +
            " (SELECT sub.id FROM Product sub WHERE sub.categoryId = p.categoryId AND sub.basePriceKRW =" +
            " (SELECT MAX(innerSub.basePriceKRW) FROM Product innerSub WHERE innerSub.categoryId = p.categoryId))" +
            " AND p.categoryId = :categoryId ORDER BY p.brandId DESC")
    List<Product> findMaxPriceProductsByCategoryId(@Param("categoryId") Long categoryId);
}