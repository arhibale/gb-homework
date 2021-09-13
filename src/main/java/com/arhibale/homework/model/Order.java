package com.arhibale.homework.model;

import com.arhibale.homework.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Person person;
    private Product product;
    private Integer cost;
    private LocalDateTime date;

    public static Order toModel(OrderEntity orderEntity) {
        return new Order(
                orderEntity.getId(),
                Person.toModel(orderEntity.getPerson()),
                Product.toModel(orderEntity.getProduct()),
                orderEntity.getProduct().getCost(),
                LocalDateTime.now()
        );
    }

    public OrderEntity toEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(id);
        orderEntity.setPerson(person.toEntity());
        orderEntity.setProduct(product.toEntity());
        orderEntity.setCost(product.getCost());
        orderEntity.setDate(date);
        return orderEntity;
    }
}