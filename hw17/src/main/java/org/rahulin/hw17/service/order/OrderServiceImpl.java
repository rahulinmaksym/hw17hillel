package org.rahulin.hw17.service.order;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    List<OrderDTO> orders = new ArrayList<>();

    @Override
    public OrderDTO getById(Long id) {
        return orders.stream()
                .filter(orderFromList -> Objects.equals(orderFromList.getId(), id))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orders;
    }

    @Override
    public void addOrder(OrderDTO order) {
        if(orders.stream()
                .filter(orderFromList -> Objects.equals(orderFromList.getId(), order.getId()))
                .collect(Collectors.toList())
                .isEmpty()) {
            orders.add(order);
        }
        else {
            updateOrderById(order.getId(), order);
        }
    }

    @Override
    public void updateOrderById(Long id, OrderDTO order) {
        for (OrderDTO orderFromList : orders) {
            if(Objects.equals(orderFromList.getId(), id)) {
                orderFromList.setId(order.getId());
                orderFromList.setDate(order.getDate());
                orderFromList.setCost(order.getCost());
                orderFromList.setProducts(order.getProducts());
            }
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        int iterations = 0;
        for (OrderDTO orderFromList : orders) {
            if(Objects.equals(orderFromList.getId(), id)) {
                break;
            }
            iterations++;
        }
        orders.remove(iterations);
    }
}
