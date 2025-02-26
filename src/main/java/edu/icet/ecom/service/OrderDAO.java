package edu.icet.ecom.service;

import edu.icet.ecom.entity.OrderEntity;

public interface OrderDAO {
    public boolean placeOrder(OrderEntity entity);
    public void updateStatus(OrderEntity entity);

}
