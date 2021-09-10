package com.arhibale.homework.repository;

import com.arhibale.homework.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select a from Product a where a.title = :title")
    Product findByName(String title);
}