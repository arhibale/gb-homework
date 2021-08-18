package com.arhibale.service.impl;

import com.arhibale.service.Cart;
import com.arhibale.service.product.Product;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Scope("prototype")
@Component("simpleCart")
public class SimpleCart implements Cart {

    private final List<Product> cart;

    public SimpleCart() {
        cart = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        cart.add(product);
    }

    @Override
    public void remove(int id) {
        if (id < 0 || id >= cart.size()) {
            return;
        }
        cart.remove(id);
    }
}