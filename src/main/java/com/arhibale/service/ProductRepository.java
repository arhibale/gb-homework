package com.arhibale.service;

import com.arhibale.service.product.Product;

import java.util.List;

public interface ProductRepository {
    Product getProduct(int id);

    List<Product> getProductList();
}
