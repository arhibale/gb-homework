package com.arhibale.homework.model;

import com.arhibale.homework.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private Integer cost;

    public static Product toModel(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getTitle(),
                productEntity.getCost()
        );
    }

    public ProductEntity toEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(id);
        productEntity.setTitle(title);
        productEntity.setCost(cost);
        return productEntity;
    }
}
