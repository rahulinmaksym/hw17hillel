package org.rahulin.hw17.repository.mappers;

import org.rahulin.hw17.dto.ProductDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDTO> {

    @Override
    public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDTO product = new ProductDTO();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setCost(rs.getFloat("cost"));
        product.setOrderId(rs.getLong("order_id"));

        return product;
    }
}
