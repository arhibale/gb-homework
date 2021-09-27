package com.arhibale.homework.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartItemDto {

    private String productTitle;
    private Integer quantity;
    private Integer pricePerProduct;
    private Integer price;
}
