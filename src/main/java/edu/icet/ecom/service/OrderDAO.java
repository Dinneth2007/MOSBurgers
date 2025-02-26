package edu.icet.ecom.service;

import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.util.OrderStatus;

import java.util.List;

public interface OrderDAO {
    public boolean placeOrder(OrderEntity entity);
    public void updateOrderStatus(Long id, OrderStatus status);
    void deleteOrder(Long id);
    List<OrderEntity> getAll();
    void serchByCuustomer(Long CustomerId);

}
