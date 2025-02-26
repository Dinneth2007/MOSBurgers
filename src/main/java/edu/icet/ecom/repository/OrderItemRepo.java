package edu.icet.ecom.repository;

import edu.icet.ecom.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItemEntity,Long> {
}
