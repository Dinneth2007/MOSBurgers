package edu.icet.ecom.controller;

import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.service.OrderDAO;
import edu.icet.ecom.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderDAO dao;
    @PostMapping("/place")

    public void placeOrder(@RequestBody OrderEntity ent){

            dao.placeOrder(ent);

    }
    @GetMapping("/get-all")
    List<OrderEntity> getAll(){
       return dao.getAll();
    }
    //update
    @PutMapping("/update/{id}/{status}")
    void updateOrder(@PathVariable Long id, @PathVariable OrderStatus status){
        dao.updateOrderStatus(id,status);
    }
    //deletes both the record in Order and OrderItems Table
    @DeleteMapping("delete/{id}")
    void deleteOrder(@PathVariable Long id){
        dao.deleteOrder(id);
    }
}
