package com.arhibale.homework.controller;

import com.arhibale.homework.model.Person;
import com.arhibale.homework.service.PersonDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonDaoService personDaoService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("persons", personDaoService.getAll());
        return "person";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("persons", personDaoService.getById(id));
        return "person";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        personDaoService.deleteById(id);
        return "redirect:/person";
    }

    @PostMapping
    public String save(@ModelAttribute @Valid Person person) {
        personDaoService.save(person);
        return "redirect:/person";
    }
}
