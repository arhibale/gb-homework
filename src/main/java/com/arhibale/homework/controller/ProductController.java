package com.arhibale.homework.controller;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                 @RequestParam(name = "size",defaultValue = "4") Integer size) {
        return productService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}