package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {
}
