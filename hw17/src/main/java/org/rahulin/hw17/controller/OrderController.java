package org.rahulin.hw17.controller;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("orderId") Long orderId) {
        OrderDTO order = orderService.getById(orderId);
        if(order != null) {
            return ResponseEntity.ok(order);
        }
        return (ResponseEntity<OrderDTO>) ResponseEntity.notFound();
    }

    @CrossOrigin("*")
    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<OrderDTO> orders = orderService.getAll();
        if(!CollectionUtils.isEmpty(orders)) {
            return ResponseEntity.ok(orders);
        }
        return (ResponseEntity<List<OrderDTO>>) ResponseEntity.notFound();
    }

    @CrossOrigin("*")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody OrderDTO order) {
        orderService.add(order);
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable("orderId") Long orderId,
                           @RequestBody OrderDTO order) {
        orderService.updateById(orderId, order);
    }

    @PutMapping("/{orderId}/refreshCost")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void refreshCostById(@PathVariable("orderId") Long orderId) {
        orderService.refreshCostById(orderId);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("orderId") Long orderId) {
        orderService.deleteById(orderId);
    }

}
