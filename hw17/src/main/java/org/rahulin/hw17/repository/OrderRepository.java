package org.rahulin.hw17.repository;

import org.rahulin.hw17.dto.OrderDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDTO, Long> {
}
