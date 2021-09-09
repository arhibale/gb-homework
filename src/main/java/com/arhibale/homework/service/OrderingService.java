package com.arhibale.homework.service;

import com.arhibale.homework.model.Ordering;
import com.arhibale.homework.model.Product;
import com.arhibale.homework.repository.OrderingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderingService {

    private final OrderingRepository orderingRepository;
    private final ProductService productService;

    public List<Ordering> getAll() {
        return orderingRepository.findAll();
    }

    public List<Ordering> getAllByPersonId(Long id) {
        return orderingRepository.findByPersonId(id);
    }

    public List<Ordering> getAllByProductId(Long id) {
        return orderingRepository.findByProductId(id);
    }

    public List<Ordering> filterByCost(Integer from, Integer to) {
        return orderingRepository.filterByCost(from, to);
    }

    public Long deleteById(Long id) {
        orderingRepository.deleteById(id);
        return id;
    }

    public Ordering save(Ordering ordering) {
        Product product = productService.getById(ordering.getProduct_id());
        ordering.setCost(product.getCost());
        ordering.setDate(LocalDateTime.now());
        return orderingRepository.save(ordering);
    }
}
