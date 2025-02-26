package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.entity.OrderItemEntity;
import edu.icet.ecom.repository.OrderItemRepo;
import edu.icet.ecom.repository.OrderRepo;
import edu.icet.ecom.service.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    OrderRepo repo;
    @Autowired
    OrderItemRepo orderItemRepo;
    @Override
    @Transactional
    public boolean placeOrder(OrderEntity entity) {
       Double orderTotal=0.0;
        for (OrderItemEntity ent: entity.getOrderItems()){
            orderTotal+=ent.getSubtotal();
            System.out.println(ent.getSubtotal());
            System.out.println(orderTotal);
//            if(ent.getQuantity()<=0){
//                return false;
//            }
        }
        System.out.println(orderTotal);
        entity.setTotalAmount(orderTotal);
        repo.save(entity);
//        for (OrderItemEntity ent:entity.getOrderItems()){
//            orderItemRepo.save(ent);
//        }
        return true;

    }

    @Override
    public void updateStatus(OrderEntity entity) {

    }
}
