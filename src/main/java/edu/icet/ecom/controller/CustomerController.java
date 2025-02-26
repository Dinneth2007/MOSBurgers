package edu.icet.ecom.controller;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.service.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerDao dao;
    @PostMapping("/add")
    void add(@RequestBody CustomerEntity ent){
        dao.add(ent);
    }
    @DeleteMapping("/delete/{id}")
    void delete(Long id){
        dao.delete(id);

    }
}
