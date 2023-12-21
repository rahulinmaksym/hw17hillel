package org.rahulin.hw17.repository;

import org.rahulin.hw17.dto.ProductDTO;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductDTO, Long> {
    @Modifying
    @Query("SELECT * FROM products WHERE order_id = :order_id")
    Iterable<ProductDTO> findByOrderId(@Param("order_id") Long orderId);
}
