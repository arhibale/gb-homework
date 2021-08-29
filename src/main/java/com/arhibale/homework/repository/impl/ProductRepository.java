package com.arhibale.homework.repository.impl;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.repository.MapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements MapRepository<Product> {

    private final Map<Long, Product> productDb = new ConcurrentHashMap<>();
    private final AtomicLong atomicLong = new AtomicLong();

    @Override
    public List<Product> findAll() {
        return productDb.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Product findById(Long id) {
        return productDb.get(id);
    }

    @Override
    public void deleteById(Long id) {
        productDb.remove(id);
    }

    @Override
    public void save (Product product) {
        product.setId(atomicLong.incrementAndGet());
        productDb.put(product.getId(), product);
    }
}