package com.arhibale.homework.controllers;

import com.arhibale.homework.dto.ProductDto;
import com.arhibale.homework.entity.Product;
import com.arhibale.homework.exceptions.ProductNotFountException;
import com.arhibale.homework.repositories.specifications.ProductSpecifications;
import com.arhibale.homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam MultiValueMap<String, String> params,
                                    @RequestParam(name = "p", defaultValue = "1") Integer page) {
        return productService.findAll(ProductSpecifications.build(params), page, 4);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id)
                .orElseThrow(() -> new ProductNotFountException("product not found: id = " + id));
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        productService.deleteById(id);
    }
}