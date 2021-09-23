package com.arhibale.homework.controllers;

import com.arhibale.homework.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/app/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService service;

    @GetMapping("/inc")
    public String increment(Principal principal) {
        return service.increment(principal.getName());
    }

    @GetMapping("/dec")
    public String decrement(Principal principal) {
        return service.decrement(principal.getName());
    }

    @GetMapping("/get/current")
    public Integer current(Principal principal) {
        return service.current(principal.getName());
    }

    @GetMapping("/get/{id}")
    public Integer currentById(@PathVariable Long id) {
        return service.currentById(id);
    }
}
