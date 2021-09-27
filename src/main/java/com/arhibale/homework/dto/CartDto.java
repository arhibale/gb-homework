package com.arhibale.homework.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {

    private List<CartItemDto> items;
    private Integer totalPrice;
}
