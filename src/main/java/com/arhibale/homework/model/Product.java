package com.arhibale.homework.model;

import com.arhibale.homework.annotation.Company;
import com.arhibale.homework.utill.deserializer.ProductDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonDeserialize(using = ProductDeserializer.class)
public class Product {

    private Long id;

    private String title;

    @Company
    private String company;

    private Integer cost;
}