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
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
