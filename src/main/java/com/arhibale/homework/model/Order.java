package com.arhibale.homework.model;

import com.arhibale.homework.entity.OrderEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность заказа")
public class Order {
    @Schema(description = "id заказа", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Пользователь", accessMode = Schema.AccessMode.READ_ONLY)
    private Person person;

    @Schema(description = "Продукт", accessMode = Schema.AccessMode.READ_ONLY)
    private Product product;

    @Schema(description = "Цена продукта на момент офромления", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer cost;

    @Schema(description = "Время офромления", accessMode = Schema.AccessMode.READ_ONLY)
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