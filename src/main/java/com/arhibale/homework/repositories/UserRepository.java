package com.arhibale.homework.repositories;

import com.arhibale.homework.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select u.score from User u where u.username = :username")
    Integer current(String username);

    @Query("select u.score from User u where u.id = :id")
    Integer currentById(Long id);
}