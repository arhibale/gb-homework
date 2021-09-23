package com.arhibale.homework.repositories;

import com.arhibale.homework.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("update User s set s.score = :score where s.username = :username")
    void incrementScore(String username, Integer score);

    @Modifying
    @Transactional
    @Query("update User s set s.score = :score where s.username = :username and s.score > 0")
    void decrementScore(String username, Integer score);

    @Query("select u.score from User u where u.username = :username")
    Integer current(String username);

    @Query("select u.score from User u where u.id = :id")
    Integer currentById(Long id);
}