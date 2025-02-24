package edu.icet.ecom.controller;

import edu.icet.ecom.entity.CatergoryEntity;
import edu.icet.ecom.service.CatergoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catergory")
public class CatergoryController {
    @Autowired
    CatergoryDAO dao;
    @PostMapping("/add")
    public void addCatergory(@RequestBody CatergoryEntity catergory){
            dao.addCatergory(catergory);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        dao.deleteCatergory(id);
    }
}
