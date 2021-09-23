package com.arhibale.homework.service;

import com.arhibale.homework.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final UserRepository userRepository;

    public String increment(String username) {
        int score = current(username) + 1;
        userRepository.incrementScore(username, score);
        return "ok: " + score;
    }

    public String decrement(String username) {
        int score = current(username) - 1;
        if (score < 0) {
            return "the score is less than zero: " + score;
        } else {
            userRepository.decrementScore(username, score);
            return "ok: " + score;
        }
    }

    public Integer current(String username) {
        return userRepository.current(username);
    }

    public Integer currentById(Long id) {
        return userRepository.currentById(id);
    }
}