package org.rahulin.hw17.service.product;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductDTO> getAll() {
        return (List<ProductDTO>) productRepository.findAll();
    }

    @Override
    public void add(ProductDTO product) {
        productRepository.save(product);
    }

    @Override
    public void update(ProductDTO product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getByOrderId(Long orderId) {
        return (List<ProductDTO>) productRepository.findByOrderId(orderId);
    }

}
