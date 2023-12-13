package org.rahulin.hw17.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Float cost;
    private Long orderId;
}
