package com.arhibale.homework.repository;

import com.arhibale.homework.model.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {

    @Query("select a from Ordering a where a.person_id = :person_id")
    List<Ordering> findByPersonId(Long person_id);

    @Query("select a from Ordering a where a.product_id = :product_id")
    List<Ordering> findByProductId(Long product_id);

    @Query("select a from Ordering a order by a.person_id")
    List<Ordering> findAll();

    @Query("select a from Ordering a where a.cost between :from and :to order by a.cost")
    List<Ordering> filterByCost(Integer from, Integer to);
}
