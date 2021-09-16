package com.arhibale.homework.controller;

import com.arhibale.homework.model.Order;
import com.arhibale.homework.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
@Tag(name = "Контроллер заказов", description = "Управление заказами")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Получение всех заказов")
    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Operation(summary = "Получение заказа по id")
    @GetMapping("/{id}")
    public Order findById(@PathVariable @Parameter(description = "id заказа") Long id) {
        return orderService.findById(id);
    }

    @Operation(summary = "Сохранение заказа")
    @PostMapping
    public void save(@RequestBody @Parameter(description = "Тело заказа", required = true) Order order,
                     @RequestParam @Parameter(description = "id пользователя", required = true) Long personId,
                     @RequestParam @Parameter(description = "id продукта", required = true) Long productId) {
        orderService.save(order, personId, productId);
    }

    @Operation(summary = "Удаление заказа")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable @Parameter(description = "id заказа", required = true) Long id) {
        orderService.deleteById(id);
    }
}
