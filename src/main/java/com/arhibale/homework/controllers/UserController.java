package com.arhibale.homework.controllers;

import com.arhibale.homework.entities.User;
import com.arhibale.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/app/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return user.getUsername() + " : " + user.getEmail() + " : " + user.getScore();
    }
}
