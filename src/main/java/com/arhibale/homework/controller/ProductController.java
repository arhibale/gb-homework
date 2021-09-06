package com.arhibale.homework.controller;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.service.ProductDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private ProductDaoService productDaoService;

    @Autowired
    public ProductController(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productDaoService.getAll());
        return "product";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("products", productDaoService.getById(id));
        return "product";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productDaoService.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping
    public String save(@ModelAttribute @Valid Product product) {
        productDaoService.save(product);
        return "redirect:/product";
    }
}