package com.arhibale.homework.service;

import com.arhibale.homework.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final UserRepository userRepository;

    public Integer current(String username) {
        return userRepository.current(username);
    }

    public Integer currentById(Long id) {
        return userRepository.currentById(id);
    }
}