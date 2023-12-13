package org.rahulin.hw17.repository.mappers;

import org.rahulin.hw17.dto.OrderDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<OrderDTO> {

    @Override
    public OrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDTO order = new OrderDTO();
        order.setId(rs.getLong("id"));
        order.setDate(rs.getString("date"));
        order.setCost(rs.getFloat("cost"));

        return order;
    }
}
