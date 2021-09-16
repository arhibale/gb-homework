package com.arhibale.homework.controller;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
@Tag(name = "Контроллер продуктов", description = "Управление продуктами")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Получение всех продуктов")
    public List<Product> findAll(@RequestParam(name = "page", defaultValue = "0") @Parameter(description = "Страница") Integer page,
                                 @RequestParam(name = "size",defaultValue = "4") @Parameter(description = "Размер страницы") Integer size) {
        return productService.findAll(page, size);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение продукта по id")
    public Product findById(@PathVariable @Parameter(description = "id продукта") Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Сохранение продукта")
    public void save(@RequestBody @Parameter(description = "Тело продукта", required = true) Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление продукта по id")
    public void deleteById(@PathVariable @Parameter(description = "id продукта", required = true) Long id) {
        productService.deleteById(id);
    }
}