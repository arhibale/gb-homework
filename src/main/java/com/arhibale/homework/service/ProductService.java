package com.arhibale.homework.service;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public Long deleteById(Long id) {
        productRepository.deleteById(id);
        return id;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}