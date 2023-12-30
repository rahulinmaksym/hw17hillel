package org.rahulin.hw17.service.product;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    private final Long ID = 1L;

    @InjectMocks
    private ProductServiceImpl testInstance;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDTO product;

    @Test
    public void shouldReturnOptionalOfProduct() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        testInstance.getById(ID);

        verify(productRepository).findById(ID);
    }

    @Test
    public void shouldNotReturnOptionalOfProduct() {
        when(productRepository.findById(anyLong())).thenThrow(RuntimeException.class);

        testInstance.getById(ID);

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldReturnListOfProducts() {
        List<ProductDTO> list = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(list);

        testInstance.getAll();

        verify(productRepository).findAll();
    }

    @Test
    public void shouldNotReturnListOfProducts() {
        when(productRepository.findAll()).thenThrow(RuntimeException.class);

        testInstance.getAll();

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldAddProduct() {
        testInstance.add(product);

        verify(productRepository).save(product);
    }

    @Test
    public void shouldNotAddProduct() {
        when(productRepository.save(product)).thenThrow(RuntimeException.class);

        testInstance.add(product);

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldUpdateProduct() {
        testInstance.update(product);

        verify(productRepository).save(product);
    }

    @Test
    public void shouldNotUpdateOrder() {
        when(productRepository.save(product)).thenThrow(RuntimeException.class);

        testInstance.update(product);

        assertThrowsExactly(RuntimeException.class, any());
    }

    @Test
    public void shouldDeleteOrderById() {
        testInstance.deleteById(ID);

        verify(productRepository).deleteById(ID);
    }

    @Test
    public void shouldReturnListOfProductsByOrderId() {
        List<ProductDTO> list = new ArrayList<>();

        when(productRepository.findByOrderId(anyLong())).thenReturn(list);

        testInstance.getByOrderId(ID);

        verify(productRepository).findByOrderId(ID);
    }

    @Test
    public void shouldNotReturnListOfProductsByOrderId() {
        when(productRepository.findByOrderId(anyLong())).thenThrow(RuntimeException.class);

        testInstance.getByOrderId(ID);

        assertThrowsExactly(RuntimeException.class, any());
    }

}