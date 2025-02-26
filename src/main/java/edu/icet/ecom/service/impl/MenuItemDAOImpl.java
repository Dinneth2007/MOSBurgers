package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.entity.MenuItemEntity;
import edu.icet.ecom.repository.MenuItemRepo;
import edu.icet.ecom.service.MenuItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class MenuItemDAOImpl implements MenuItemDAO {
    @Autowired
    MenuItemRepo repo;

    @Override
    public void addItem(MenuItemEntity item) {
        repo.save(item);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateById(MenuItemEntity item) {
        repo.save(item);
    }

    @Override
    public List<MenuItemEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public MenuItemEntity getById(Long id) {
        return repo.getById(id);
    }
    public void updatestatus(MenuItemEntity entity){
        repo.save(entity);
    }

    @Override
    public void checkforStock() {
        for(MenuItemEntity ent: repo.findAll()){
            if (ent.getStockQuantity()<=0){
                ent.setActive(false);

            }

        }
    }

}
