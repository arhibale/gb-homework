package com.arhibale.homework.model;

import com.arhibale.homework.entity.ProductEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность продукта")
public class Product {

    @Schema(description = "id продукта", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Название продукта", accessMode = Schema.AccessMode.READ_ONLY)
    private String title;

    @Schema(description = "Цена продукта", accessMode = Schema.AccessMode.READ_ONLY)
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
