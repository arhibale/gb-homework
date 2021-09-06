package com.arhibale.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordering")
@NamedQueries({
        @NamedQuery(name = "Ordering.findAll", query = "select a from Ordering a "),
        @NamedQuery(name = "Ordering.findByIdPerson", query = "select a from Ordering a where a.person_id = :person_id"),
        @NamedQuery(name = "Ordering.findByIdProduct", query = "select a from Ordering a where a.product_id = :product_id"),
})
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "date")
    private Date date;
}