package com.arhibale.homework.service;

import com.arhibale.homework.model.Order;
import com.arhibale.homework.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final PersonService personService;
    private final ProductService productService;

    public List<Order> findAll() {
        return orderRepository.findAll().stream()
                .map(Order::toModel).toList();
    }

    public Order findById(Long id) {
        return Order.toModel(orderRepository.findById(id).get());
    }

    public void save(Order order, Long personId, Long productId) {
        order.setPerson(personService.findById(personId));
        order.setProduct(productService.findById(productId));
        order.setCost(order.getProduct().getCost());
        order.setDate(LocalDateTime.now());
        orderRepository.save(order.toEntity());
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
