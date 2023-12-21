package org.rahulin.hw17.service.order;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.repository.OrderRepository;
import org.rahulin.hw17.service.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Override
    public Optional<OrderDTO> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderDTO> getAll() {
        return (List<OrderDTO>) orderRepository.findAll();
    }

    @Override
    public void add(OrderDTO order) {
        orderRepository.save(order);
    }

    @Override
    public void update(OrderDTO order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        List<ProductDTO> productsOfOrder = productService.getByOrderId(id);
        for (ProductDTO product : productsOfOrder) {
            productService.deleteById(product.getId());
        }
        orderRepository.deleteById(id);
    }

    @Override
    public void refreshCostById(Long id) {
        Optional<OrderDTO> orderOptional = getById(id);
        if(orderOptional.isPresent()) {
            OrderDTO order = orderOptional.get();
            List<ProductDTO> productsOfOrder = productService.getByOrderId(order.getId());
            float refreshedCost = 0;
            for (ProductDTO product : productsOfOrder) {
                refreshedCost += product.getCost();
            }
            order.setCost(refreshedCost);
            update(order);
        }
    }

}
