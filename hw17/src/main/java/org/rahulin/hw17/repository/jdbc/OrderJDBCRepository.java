package org.rahulin.hw17.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.rahulin.hw17.dto.OrderDTO;
import org.rahulin.hw17.repository.mappers.OrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderDTO getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM orders WHERE id = " + id, new OrderRowMapper());
    }

    public List<OrderDTO> getAll() {
        return jdbcTemplate.query("SELECT * FROM orders", new OrderRowMapper());
    }

    public void add(OrderDTO order) {
        jdbcTemplate.update("INSERT INTO orders (date, cost) VALUES (?, ?)", order.getDate(), order.getCost());
    }

    public void updateById(Long id, OrderDTO order) {
        jdbcTemplate.update("UPDATE orders SET date = ?, cost = ? WHERE id = ?",
                order.getDate(), order.getCost(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", id);
    }

}
