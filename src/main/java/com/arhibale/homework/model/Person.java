package com.arhibale.homework.model;

import com.arhibale.homework.entity.PersonEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность пользователя")
public class Person {

    @Schema(description = "id пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Имя пользователя", accessMode = Schema.AccessMode.READ_ONLY)
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
