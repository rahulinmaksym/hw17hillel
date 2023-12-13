package org.rahulin.hw17.service.product;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.repository.jdbc.ProductJDBCRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductJDBCRepository productJDBCRepository;

    @Override
    public ProductDTO getById(Long id) {
        return productJDBCRepository.getById(id);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productJDBCRepository.getAll();
    }

    @Override
    public void add(ProductDTO product) {
        productJDBCRepository.add(product);
    }

    @Override
    public void updateById(Long id, ProductDTO product) {
        productJDBCRepository.updateById(id, product);
    }

    @Override
    public void deleteById(Long id) {
        productJDBCRepository.delete(id);
    }

    @Override
    public List<ProductDTO> getByOrderId(Long orderId) {
        return productJDBCRepository.getByOrderId(orderId);
    }

}
