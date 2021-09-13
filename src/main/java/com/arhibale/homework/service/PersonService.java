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

    public List<Person> findAll() {
        return personRepository.findAll().stream()
                .map(Person::toModel).toList();
    }

    public Person findById(Long id) {
        return Person.toModel(personRepository.findById(id).get());
    }

    public void save(Person person) {
        personRepository.save(person.toEntity());
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}