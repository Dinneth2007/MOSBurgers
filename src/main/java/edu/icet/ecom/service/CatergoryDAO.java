package edu.icet.ecom.service;

import edu.icet.ecom.entity.CatergoryEntity;



public interface CatergoryDAO{
    void addCatergory(CatergoryEntity catergory);
    void deleteCatergory(Long id);

}
