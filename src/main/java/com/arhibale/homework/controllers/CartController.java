package com.arhibale.homework.controllers;

import com.arhibale.homework.dto.CartDto;
import com.arhibale.homework.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public CartDto findAll() {
        return cartService.findAll();
    }

    @PutMapping
    public void add(@RequestParam Long id) {
        cartService.add(id);
    }

    @DeleteMapping
    public void clear() {
        cartService.deleteAll();
    }
}
