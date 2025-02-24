package edu.icet.ecom.service;

import edu.icet.ecom.entity.MenuItemEntity;

import java.util.List;

public interface MenuItemDAO {
    void addItem(MenuItemEntity item);
    void delete(Long id);
    void updateById(MenuItemEntity item);
    List<MenuItemEntity> getAll();
    MenuItemEntity getById(Long id);
    void updatestatus(MenuItemEntity entity);
}
