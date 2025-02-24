package edu.icet.ecom.controller;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.entity.MenuItemEntity;
import edu.icet.ecom.service.MenuItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuItemDAO dao;
    @GetMapping("/add")
    public void addMenuItem(@RequestBody  MenuItemEntity itm){
        dao.addItem(itm);
    }
    @GetMapping("/get-all")
    List<MenuItemEntity> getAll(){
        return dao.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable  Long id){
        dao.delete(id);
    }
    @PutMapping("/update-item")
    void update(@RequestBody MenuItemEntity entity){
        dao.updateById(entity);

    }
    @PatchMapping("/update-status")
    void updateStatus(@RequestBody MenuItemEntity entity){
        dao.updatestatus(entity);
    }
}
