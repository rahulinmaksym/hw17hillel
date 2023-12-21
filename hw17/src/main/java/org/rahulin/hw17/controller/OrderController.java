package org.rahulin.hw17.controller;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("orderId") Long orderId) {
        Optional<OrderDTO> orderOptional = orderService.getById(orderId);
        OrderDTO order = null;
        if(orderOptional.isPresent()) {
            order = orderOptional.get();
        }
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

    @CrossOrigin("*")
    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody OrderDTO order) {
        orderService.update(order);
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
