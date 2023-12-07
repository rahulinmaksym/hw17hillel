package org.rahulin.hw17.controller;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.service.order.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/readAll")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/firstOrderAdd")
    public void addOrderOne() {

        List<ProductDTO> productList = new ArrayList<>();
        double orderPrice = 0;
        productList.add(ProductDTO.builder()
                .id(2133L)
                .name("product1")
                .cost(312.23)
                .build());
        productList.add(ProductDTO.builder()
                .id(213L)
                .name("product2")
                .cost(3242.13)
                .build());
        productList.add(ProductDTO.builder()
                .id(233L)
                .name("product3")
                .cost(14.0)
                .build());
        for (ProductDTO product : productList) {
            orderPrice += product.getCost();
        }

        orderService.addOrder(OrderDTO.builder()
                .id(312L)
                .date(LocalDateTime.now())
                .cost(orderPrice)
                .products(productList)
                .build());
    }

    @GetMapping("/secondOrderAdd")
    public void addOrderTwo() {

        List<ProductDTO> productList = new ArrayList<>();
        double orderPrice = 0;
        productList.add(ProductDTO.builder()
                .id(2188L)
                .name("product1")
                .cost(32.23)
                .build());
        productList.add(ProductDTO.builder()
                .id(2139L)
                .name("product2")
                .cost(342.13)
                .build());
        for (ProductDTO product : productList) {
            orderPrice += product.getCost();
        }

        orderService.addOrder(OrderDTO.builder()
                .id(332L)
                .date(LocalDateTime.now())
                .cost(orderPrice)
                .products(productList)
                .build());
    }

    @GetMapping("/thirdOrderAdd")
    public void addOrderThree() {

        List<ProductDTO> productList = new ArrayList<>();
        double orderPrice = 0;
        productList.add(ProductDTO.builder()
                .id(88L)
                .name("product1")
                .cost(32123.23)
                .build());
        productList.add(ProductDTO.builder()
                .id(39L)
                .name("product2")
                .cost(33342.13)
                .build());
        for (ProductDTO product : productList) {
            orderPrice += product.getCost();
        }

        orderService.addOrder(OrderDTO.builder()
                .id(1132L)
                .date(LocalDateTime.now())
                .cost(orderPrice)
                .products(productList)
                .build());
    }

    @GetMapping("/firstOrderGet")
    public OrderDTO getOrderOne() {
        return orderService.getById(312L);
    }

    @GetMapping("/secondOrderUpdate")
    public void updateOrderTwo() {

        List<ProductDTO> productList = new ArrayList<>();
        double orderPrice = 0;
        productList.add(ProductDTO.builder()
                .id(8148L)
                .name("product1")
                .cost(3211423.23)
                .build());
        productList.add(ProductDTO.builder()
                .id(329L)
                .name("product2")
                .cost(3344342.13)
                .build());
        for (ProductDTO product : productList) {
            orderPrice += product.getCost();
        }

        orderService.updateOrderById(332L, OrderDTO.builder()
                .id(332L)
                .date(LocalDateTime.now())
                .cost(orderPrice)
                .products(productList)
                .build());
    }

    @GetMapping("/thirdOrderDelete")
    public void deleteOrderThree() {
        orderService.deleteOrderById(1132L);
    }
}
