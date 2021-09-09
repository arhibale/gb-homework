package com.arhibale.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordering")
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
    private LocalDateTime date;
}