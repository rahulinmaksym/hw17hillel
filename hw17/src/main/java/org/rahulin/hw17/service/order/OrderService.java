package org.rahulin.hw17.service.order;

import org.rahulin.hw17.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    OrderDTO getById(Long id);
    List<OrderDTO> getAll();
    void add(OrderDTO order);
    void updateById(Long id, OrderDTO order);
    void deleteById(Long id);
    void refreshCostById(Long id);
}
