package com.arhibale.homework.repository;

import com.arhibale.homework.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final Map<Long, Product> productDb = new ConcurrentHashMap<>();
    private final AtomicLong atomicLong = new AtomicLong();

    public List<Product> findAll() {
        return productDb.values().stream().collect(Collectors.toUnmodifiableList());
    }

    public Optional<Product> findById(Long id) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public void deleteById(Long id) {
        productDb.remove(id);
    }

    public void save (Product product) {
        if (product.getId() == null) {
            product.setId(atomicLong.incrementAndGet());
        }
        productDb.put(product.getId(), product);
    }
}
