package com.arhibale.homework.controller;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "product";
    }

    @GetMapping("/delete{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute @Valid Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/product";
    }
}