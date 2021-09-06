package com.arhibale.homework.service;

import com.arhibale.homework.model.Ordering;
import com.arhibale.homework.repository.dao.DaoSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderingDaoService {

    @Autowired
    private DaoSessionFactory factory;

    @Autowired
    private ProductDaoService productDaoService;

    public List<Ordering> getAll() {
        return factory.getAll("Ordering.findAll", Ordering.class);
    }

    public List<Ordering> getByPersonId(Long id) {
        return factory.getByIdList("Ordering.findByIdPerson", Ordering.class, "person_id", id);
    }

    public List<Ordering> getByProductId(Long id) {
        return factory.getByIdList("Ordering.findByIdProduct", Ordering.class, "product_id", id);
    }

    public void deleteById(Long id) {
        factory.deleteById(Ordering.class, id);
    }

    public void save(Ordering ordering) {
        ordering.setCost(productDaoService.getById(ordering.getProduct_id()).getCost());
        ordering.setDate(new Date());
        factory.save(ordering);
    }

    public void update(Ordering ordering) {
        factory.update(ordering);
    }
}
