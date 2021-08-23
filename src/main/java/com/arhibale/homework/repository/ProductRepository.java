package com.arhibale.homework.repository;

import com.arhibale.homework.model.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Log4j2
@Repository
public class ProductRepository {

    private final Map<Long, Product> productDb;

    public ProductRepository() {
        this.productDb = new ConcurrentHashMap<>();
    }

    public List<Product> findAll() {
        return productDb.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Product> findById(Long id) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(productDb.size() + 1L);
        }
        log.info("product info: {} {} {}", product.getId(), product.getTitle(), product.getCost());
        productDb.put(product.getId(), product);
    }
}
