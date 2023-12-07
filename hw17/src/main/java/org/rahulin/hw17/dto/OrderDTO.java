package org.rahulin.hw17.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime date;
    private Double cost;
    private List<ProductDTO> products;
}
