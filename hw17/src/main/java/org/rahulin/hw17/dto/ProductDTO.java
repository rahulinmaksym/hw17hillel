package org.rahulin.hw17.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "products")
public class ProductDTO {
    @Id
    private Long id;
    private String name;
    private Float cost;
    private Long orderId;
}
