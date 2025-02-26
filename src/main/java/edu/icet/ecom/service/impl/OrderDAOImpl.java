package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.MenuItemEntity;
import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.entity.OrderItemEntity;
import edu.icet.ecom.repository.MenuItemRepo;
import edu.icet.ecom.repository.OrderItemRepo;
import edu.icet.ecom.repository.OrderRepo;
import edu.icet.ecom.service.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    OrderRepo repo;
    @Autowired
    OrderItemRepo orderItemRepo;
    @Autowired
    MenuItemRepo menuItemRepo;
    @Override
    @Transactional
    public boolean placeOrder(OrderEntity entity) {
       Double orderTotal=0.0;
        for (OrderItemEntity ent: entity.getOrderItems()){
            setSubtotalAndUpdateStock(ent);
            ent.setOrder(entity);
            orderTotal+=ent.getSubtotal();
            System.out.println(ent.getSubtotal());
            System.out.println(orderTotal);
            if(ent.getQuantity()<=0){
                throw new RuntimeException("Insufficient stock for menu item");
            }

        }
        System.out.println(orderTotal);
        entity.setTotalAmount(orderTotal);
        repo.save(entity);
//        for (OrderItemEntity ent:entity.getOrderItems()){
//            orderItemRepo.save(ent);
//        }
        return true;

    }
    public void setSubtotalAndUpdateStock(OrderItemEntity entity){
        MenuItemEntity menuItem = menuItemRepo.findById(entity.getMenuItem().getId())
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        menuItem.setStockQuantity(menuItem.getStockQuantity()- entity.getQuantity());
        entity.setSubtotal(menuItem.getPrice()*entity.getQuantity());
    }
    @Override
    public void updateStatus(OrderEntity entity) {

    }
}
