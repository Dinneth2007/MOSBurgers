package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByCustomer(CustomerEntity customer);

}
