package com.arhibale.homework.model;

import com.arhibale.homework.annotation.Company;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    @Company
    private String company;
    private Integer cost;
}