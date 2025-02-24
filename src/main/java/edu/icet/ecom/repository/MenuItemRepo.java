package edu.icet.ecom.repository;

import edu.icet.ecom.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepo extends JpaRepository<MenuItemEntity,Long> {
}
