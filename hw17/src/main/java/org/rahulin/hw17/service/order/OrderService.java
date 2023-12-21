package org.rahulin.hw17.service.order;

import org.rahulin.hw17.dto.OrderDTO;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<OrderDTO> getById(Long id);
    List<OrderDTO> getAll();
    void add(OrderDTO order);
    void update(OrderDTO order);
    void deleteById(Long id);
    void refreshCostById(Long id);
}
