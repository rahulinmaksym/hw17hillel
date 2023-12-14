package org.rahulin.hw17.controller.response;

import lombok.Data;
import java.util.List;

// Пробував використовувати цей клас в якості стандартного респонсу,
// але вирішив, що ResponseEntity все ж таки зручніше в моєму випадку.
@Data
public class ApiResponse <D> {
    private boolean success;
    private D data;
    private List<String> messages;
}
