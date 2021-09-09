package com.arhibale.homework.repository;

import com.arhibale.homework.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }
