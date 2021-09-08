package com.arhibale.homework.service;

import com.arhibale.homework.model.Person;
import com.arhibale.homework.repository.dao.DaoSessionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonDaoService {

    private final DaoSessionFactory factory;

    public List<Person> getAll() {
        return factory.getAll("Person.findAll", Person.class);
    }

    public Person getById(Long id) {
        return factory.getById("Person.findById", Person.class, "id", id);
    }

    public void deleteById(Long id) {
        factory.deleteById(Person.class, id);
    }

    public void save(Person person) {
        factory.save(person);
    }

    public void update(Person person) {
        factory.update(person);
    }
}
