package org.rahulin.hw17.controller;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.service.order.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/id=1")
    public OrderDTO getWithId1() {
        return orderService.getById(1L);
    }

    @GetMapping("/getAll")
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/addWithCurrentDate")
    public void addWithCurrentDate() {
        OrderDTO order = new OrderDTO();
        order.setDate("13.12.2023");
        order.setCost(1F);
        orderService.add(order);
    }

    @GetMapping("/changeDateToPreviousYearWhereId=2")
    public void changeDateToPreviousYearWhereId2() {
        OrderDTO order = orderService.getById(2L);
        order.setDate("13.12.2022");
        orderService.updateById(2L, order);
    }

    @GetMapping("/deleteWhereId=1")
    public void deleteWhereId1() {
        orderService.deleteById(1L);
    }

    @GetMapping("/refreshCostWhereId=3")
    public void refreshCostWhereId3() {
        orderService.refreshCostById(3L);
    }

}
