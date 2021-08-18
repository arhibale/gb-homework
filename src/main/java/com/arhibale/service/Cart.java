package com.arhibale.service;

import com.arhibale.service.product.Product;

import java.util.List;

public interface Cart {

    void add(Product product);

    void remove(int id);

    List<Product> getCart();
}
