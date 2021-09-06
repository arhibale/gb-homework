package com.arhibale.homework.service;

import com.arhibale.homework.model.Product;
import com.arhibale.homework.repository.dao.DaoSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoService {

    @Autowired
    private DaoSessionFactory service;

    public List<Product> getAll() {
        return service.getAll("Product.findAll", Product.class);
    }

    public Product getById(Long id) {
        return service.getById("Product.findById", Product.class, "id", id);
    }

    public void deleteById(Long id) {
        service.deleteById(Product.class, id);
    }

    public void save(Product product) {
        service.save(product);
    }

    public void update(Product product) {
        service.update(product);
    }
}