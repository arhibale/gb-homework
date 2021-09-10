package com.arhibale.homework.service;

import com.arhibale.homework.model.Person;
import com.arhibale.homework.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(Long id) {
        return personRepository.findById(id).get();
    }

    public Person getByName(String name) {
        return personRepository.findByName(name);
    }

    public Long deleteById(Long id) {
        personRepository.deleteById(id);
        return id;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }
}
