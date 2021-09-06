package com.arhibale.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select a from Person a"),
        @NamedQuery(name = "Person.findById", query = "select a from Person a where a.id = :id"),
        @NamedQuery(name = "Person.findByName", query = "select a from Person a where a.name = :name")
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "ordering",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    public Person(String name) {
        this.name = name;
    }
}
