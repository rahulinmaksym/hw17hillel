package org.rahulin.hw17.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.ProductDTO;
import org.rahulin.hw17.repository.mappers.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductDTO getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = " + id, new ProductRowMapper());
    }

    public List<ProductDTO> getAll() {
        return jdbcTemplate.query("SELECT * FROM products", new ProductRowMapper());
    }

    public void add(ProductDTO product) {
        jdbcTemplate.update("INSERT INTO products (name, cost, order_id) VALUES (?, ?, ?)",
                product.getName(), product.getCost(), product.getOrderId());
    }

    public void updateById(Long id, ProductDTO product) {
        jdbcTemplate.update("UPDATE products SET name = ?, cost = ?, order_id = ? WHERE id = ?",
                product.getName(), product.getCost(), product.getOrderId(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }

    public List<ProductDTO> getByOrderId(Long orderId) {
        return jdbcTemplate.query("SELECT * FROM products WHERE order_id = " + orderId, new ProductRowMapper());
    }

}
