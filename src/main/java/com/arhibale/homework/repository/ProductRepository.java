package com.arhibale.homework.repository;

import com.arhibale.homework.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }