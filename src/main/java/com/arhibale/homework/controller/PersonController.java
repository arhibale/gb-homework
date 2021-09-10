package com.arhibale.homework.controller;

import com.arhibale.homework.model.Person;
import com.arhibale.homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @GetMapping("/name")
    public Person getByName(@RequestParam String name) {
        return personService.getByName(name);
    }

    @DeleteMapping("/{id}")
    public Long deleteById(@PathVariable Long id) {
        return personService.deleteById(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }
}
