package com.arhibale.homework.repository;

import com.arhibale.homework.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select a from Person a where a.name = :name")
    Person findByName(String name);
}
