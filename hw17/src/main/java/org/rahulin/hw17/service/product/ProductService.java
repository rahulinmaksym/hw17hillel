package org.rahulin.hw17.service.product;

import org.rahulin.hw17.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    void add(ProductDTO order);
    void updateById(Long id, ProductDTO order);
    void deleteById(Long id);
    List<ProductDTO> getByOrderId(Long orderId);
}
