package com.arhibale.homework.model;

import com.arhibale.homework.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String name;

    public static Person toModel(PersonEntity person) {
        return new Person(
                person.getId(),
                person.getName()
        );
    }

    public PersonEntity toEntity() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(id);
        personEntity.setName(name);
        return personEntity;
    }
}
