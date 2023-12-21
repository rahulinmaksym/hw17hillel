package org.rahulin.hw17.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class OrderDTO {
    @Id
    private Long id;
    private String date;
    private Float cost;
}
