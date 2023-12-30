package org.rahulin.hw17.service.order;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.repository.OrderRepository;
import org.rahulin.hw17.service.product.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    private final Long ORDER_ID = 1L;

    @InjectMocks
    private OrderServiceImpl testInstance;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @Mock
    private OrderDTO order;

    @Test
    public void shouldReturnOptionalOfOrderById() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        testInstance.getById(ORDER_ID);

        verify(orderRepository).findById(ORDER_ID);
    }

    @Test
    public void shouldNotReturnOptionalOfOrderById() {
        when(orderRepository.findById(anyLong())).thenThrow(RuntimeException.class);

        testInstance.getById(ORDER_ID);

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldReturnListOfOrders() {
        List<OrderDTO> list = new ArrayList<>();

        when(orderRepository.findAll()).thenReturn(list);

        testInstance.getAll();

        verify(orderRepository).findAll();
    }

    @Test
    public void shouldNotReturnListOfOrders() {
        when(orderRepository.findAll()).thenThrow(RuntimeException.class);

        testInstance.getAll();

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldAddOrder() {
        testInstance.add(order);

        verify(orderRepository).save(order);
    }

    @Test
    public void shouldNotAddOrder() {
        when(orderRepository.save(order)).thenThrow(RuntimeException.class);

        testInstance.add(order);

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldUpdateOrder() {
        testInstance.update(order);

        verify(orderRepository).save(order);
    }

    @Test
    public void shouldNotUpdateOrder() {
        when(orderRepository.save(order)).thenThrow(RuntimeException.class);

        testInstance.update(order);

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldDeleteOrderById() {
        testInstance.deleteById(ORDER_ID);

        verify(orderRepository).deleteById(ORDER_ID);
    }

    @Test
    public void shouldRefreshCostById() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        Optional<OrderDTO> optionalOfOrderDTO = orderRepository.findById(ORDER_ID);
        OrderDTO result = null;
        if(optionalOfOrderDTO.isPresent()) {
            result = optionalOfOrderDTO.get();
            orderRepository.save(result);
        }

        testInstance.refreshCostById(ORDER_ID);

        verify(orderRepository, times(2)).findById(ORDER_ID);
        assert result != null;
        verify(orderRepository, times(2)).save(result);
    }

    @Test
    public void shouldNotRefreshCostById() {
        when(orderRepository.findById(anyLong())).thenThrow(RuntimeException.class);

        testInstance.refreshCostById(ORDER_ID);

        assertThrowsExactly(RuntimeException.class, any());
    }
}
