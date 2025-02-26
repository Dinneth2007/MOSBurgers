package edu.icet.ecom.controller;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.service.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerDao dao;
    @PostMapping("/add")
    void add(@RequestBody CustomerEntity ent){
        dao.add(ent);
    }
}
