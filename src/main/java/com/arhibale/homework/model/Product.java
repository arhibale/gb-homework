package com.arhibale.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select a from Product a"),
        @NamedQuery(name = "Product.findById", query = "select a from Product a where a.id_product = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Integer cost;
}