package com.arhibale.homework.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private final Map<Long, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Map<Long, Integer> findAll() {
        return Collections.unmodifiableMap(products);
    }

    public void addProduct(Long id) {
        products.merge(id, 1, Integer::sum);
    }

    public void deleteAll() {
        products.clear();
    }
}
