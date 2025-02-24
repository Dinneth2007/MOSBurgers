package edu.icet.ecom.service.impl;

import edu.icet.ecom.entity.CatergoryEntity;
import edu.icet.ecom.repository.CatergoryRepo;
import edu.icet.ecom.service.CatergoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatergorDAOImpl implements CatergoryDAO {
    @Autowired
    CatergoryRepo repo;
    @Override
    public void addCatergory(CatergoryEntity catergory) {
        repo.save(catergory);

    }

    @Override
    public void deleteCatergory(Long id) {
        repo.deleteById(id);
    }
}
