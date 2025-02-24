package edu.icet.ecom.service;

import edu.icet.ecom.entity.CatergoryEntity;

import java.util.List;


public interface CatergoryDAO{
    void addCatergory(CatergoryEntity catergory);
    void deleteCatergory(Long id);
    List<CatergoryEntity> getALl();
}
