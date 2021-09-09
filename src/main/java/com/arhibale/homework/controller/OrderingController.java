package com.arhibale.homework.controller;

import com.arhibale.homework.model.Ordering;
import com.arhibale.homework.service.OrderingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ordering")
public class OrderingController {

    private final OrderingService orderingService;

    @GetMapping
    public List<Ordering> getAll() {
        return orderingService.getAll();
    }

    @GetMapping("/person")
    public List<Ordering> getAllByPersonId(@RequestParam Long id) {
        return orderingService.getAllByPersonId(id);
    }

    @GetMapping("/product")
    public List<Ordering> getAllByProductId(@RequestParam Long id) {
        return orderingService.getAllByProductId(id);
    }

    @GetMapping("/cost")
    public List<Ordering> filterByCost(@RequestParam Integer from, @RequestParam Integer to) {
        return orderingService.filterByCost(from, to);
    }

    @DeleteMapping("/{id}")
    public Long deleteById(@PathVariable Long id) {
        return orderingService.deleteById(id);
    }

    @PostMapping
    public Ordering save(@RequestBody Ordering ordering) {
        return orderingService.save(ordering);
    }
}