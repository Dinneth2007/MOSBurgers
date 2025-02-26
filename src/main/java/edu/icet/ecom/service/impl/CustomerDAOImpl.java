package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.repository.CustomerRepo;
import edu.icet.ecom.service.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAOImpl implements CustomerDao {
    @Autowired
    CustomerRepo repo;
    @Override
    public void add(CustomerEntity entity) {
        repo.save(entity);
    }
}
