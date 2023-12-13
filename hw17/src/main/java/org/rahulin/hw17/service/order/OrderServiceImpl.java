package org.rahulin.hw17.service.order;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.repository.jdbc.OrderJDBCRepository;
import org.rahulin.hw17.service.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderJDBCRepository orderJDBCRepository;
    private final ProductService productService;

    @Override
    public OrderDTO getById(Long id) {
        return orderJDBCRepository.getById(id);
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderJDBCRepository.getAll();
    }

    @Override
    public void add(OrderDTO order) {
        orderJDBCRepository.add(order);
    }

    @Override
    public void updateById(Long id, OrderDTO order) {
        orderJDBCRepository.updateById(id, order);
    }

    @Override
    public void deleteById(Long id) {
        List<ProductDTO> productsOfOrder = productService.getByOrderId(id);
        for (ProductDTO product : productsOfOrder) {
            productService.deleteById(product.getId());
        }
        orderJDBCRepository.delete(id);
    }

    @Override
    public void refreshCostById(Long id) {
        OrderDTO order = getById(id);
        List<ProductDTO> productsOfOrder = productService.getByOrderId(order.getId());
        float refreshedCost = 0;
        for (ProductDTO product : productsOfOrder) {
            refreshedCost += product.getCost();
        }
        order.setCost(refreshedCost);
        updateById(id, order);
    }

}
