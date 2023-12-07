package org.rahulin.hw17.service.order;

import org.rahulin.hw17.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO getById(Long id);
    List<OrderDTO> getAllOrders();
    void addOrder(OrderDTO order);
    void updateOrderById(Long id, OrderDTO order);
    void deleteOrderById(Long id);
}
