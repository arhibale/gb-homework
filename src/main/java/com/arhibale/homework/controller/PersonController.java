package com.arhibale.homework.controller;

import com.arhibale.homework.model.Person;
import com.arhibale.homework.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
@Tag(name = "Контроллер пользователей", description = "Управление пользователями")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @Operation(summary = "Получение всех пользователей")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователей по id")
    public Person findById(@PathVariable @Parameter(description = "id пользователя") Long id) {
        return personService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Сохранение пользователя")
    public void save(@RequestBody @Parameter(description = "Тело пользователя", required = true) Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление пользователя по id")
    public void deleteById(@PathVariable @Parameter(description = "id пользователя") Long id) {
        personService.deleteById(id);
    }
}
