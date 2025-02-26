package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.MenuItemEntity;
import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.entity.OrderItemEntity;
import edu.icet.ecom.repository.CustomerRepo;
import edu.icet.ecom.repository.MenuItemRepo;
import edu.icet.ecom.repository.OrderItemRepo;
import edu.icet.ecom.repository.OrderRepo;
import edu.icet.ecom.service.OrderDAO;
import edu.icet.ecom.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    OrderRepo repo;
    @Autowired
    OrderItemRepo orderItemRepo;
    @Autowired
    MenuItemRepo menuItemRepo;
    @Override
    @Transactional
    public boolean placeOrder(OrderEntity entity) {
        //validation if a customer exists
        customerRepo.findById(entity.getCustomer().getId()).orElseThrow(()->new RuntimeException());
       Double orderTotal=0.0;
        for (OrderItemEntity ent: entity.getOrderItems()){
            setSubtotalAndUpdateStock(ent);
            ent.setOrder(entity);
            orderTotal+=ent.getSubtotal();
            System.out.println(ent.getSubtotal());
            System.out.println(orderTotal);
            MenuItemEntity menuItem = menuItemRepo.findById(ent.getMenuItem().getId()).orElseThrow(()->new RuntimeException());

            if(ent.getQuantity()>menuItem.getStockQuantity()){
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
    @Transactional
    public void setSubtotalAndUpdateStock(OrderItemEntity entity){
        MenuItemEntity menuItem = menuItemRepo.findById(entity.getMenuItem().getId())
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        menuItem.setStockQuantity(menuItem.getStockQuantity()- entity.getQuantity());
        entity.setSubtotal(menuItem.getPrice()*entity.getQuantity());
    }
    @Override
    public void updateOrderStatus(Long id, OrderStatus status) {
        OrderEntity orderEntity = repo.findById(id).orElseThrow();
        orderEntity.setStatus(status);
        repo.save(orderEntity);
    }

    @Override
    public void deleteOrder(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<OrderEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public void serchByCuustomer(Long CustomerId) {

    }
}
