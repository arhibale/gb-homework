package com.arhibale.homework.service;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size)).stream()
                .map(Product::toModel)
                .toList();
    }

    public Product findById(Long id) {
        return Product.toModel(productRepository.findById(id).get());
    }

    public void save(Product product) {
        productRepository.save(product.toEntity());
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
