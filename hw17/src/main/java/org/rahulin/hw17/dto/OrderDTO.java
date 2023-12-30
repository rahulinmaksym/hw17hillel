package org.rahulin.hw17.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "orders")
public class OrderDTO {
    @Id
    private Long id;
    private String date;
    private Float cost;
}
