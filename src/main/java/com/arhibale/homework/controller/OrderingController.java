package com.arhibale.homework.controller;

import com.arhibale.homework.model.Ordering;
import com.arhibale.homework.service.OrderingDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/ordering")
@RequiredArgsConstructor
public class OrderingController {

    private final OrderingDaoService orderingDaoService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("orderings", orderingDaoService.getAll());
        return "ordering";
    }

    @GetMapping("/person/{id}")
    public String getByPersonId(@PathVariable Long id, Model model) {
        model.addAttribute("orderings", orderingDaoService.getByPersonId(id));
        return "ordering";
    }

    @GetMapping("/product/{id}")
    public String getByProductId(@PathVariable Long id, Model model) {
        model.addAttribute("orderings", orderingDaoService.getByProductId(id));
        return "ordering";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        orderingDaoService.deleteById(id);
        return "redirect:/ordering";
    }

    @PostMapping
    public String save(@ModelAttribute @Valid Ordering ordering) {
        orderingDaoService.save(ordering);
        return "redirect:/ordering";
    }
}
