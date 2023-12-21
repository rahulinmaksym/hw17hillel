package org.rahulin.hw17.service.product;

import org.rahulin.hw17.dto.ProductDTO;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDTO> getById(Long id);
    List<ProductDTO> getAll();
    void add(ProductDTO order);
    void update(ProductDTO order);
    void deleteById(Long id);
    List<ProductDTO> getByOrderId(Long orderId);
}
