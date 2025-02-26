package edu.icet.ecom.controller;

import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.service.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderDAO dao;
    @PostMapping("/place")

    public void placeOrder(@RequestBody OrderEntity ent){
        dao.placeOrder(ent);
    }
}
