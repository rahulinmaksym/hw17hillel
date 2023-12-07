package org.rahulin.hw17.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double cost;
}
