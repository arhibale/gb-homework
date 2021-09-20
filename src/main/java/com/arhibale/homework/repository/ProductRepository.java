package com.arhibale.homework.repository;

import com.arhibale.homework.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Modifying
    @Transactional
    @Query("delete from ProductEntity where title = :title")
    void deleteByTitle(String title);
}