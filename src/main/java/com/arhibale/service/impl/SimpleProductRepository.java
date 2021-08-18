package com.arhibale.service.impl;

import com.arhibale.service.ProductRepository;
import com.arhibale.service.product.Product;
import com.arhibale.service.utill.RandomNumberOrString;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SimpleProductRepository implements ProductRepository {

    private List<Product> productList;

    public SimpleProductRepository() {
        productList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 5; i++) {
            productList.add(new Product(i,
                    RandomNumberOrString.randomString(),
                    RandomNumberOrString.randomNumber(100)));
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy \\^-^/");
    }

    @Override
    public Product getProduct(int id) {
        if (id < 0 || id >= productList.size()) {
            return null;
        }
        return productList.get(id);
    }
}
