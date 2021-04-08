package com.example.demo.serviceImp;

import java.util.List;

import com.example.demo.dto.CatalogFlowerDTO;

public interface CatalogFlowerServiceImp {

	public boolean addCatalogFlower(CatalogFlowerDTO catalogFlowerDTO);
	public boolean deleteCatalog(int idCatalog);
	public boolean editCatalog(CatalogFlowerDTO catalogFlowerDTO);
	public List<CatalogFlowerDTO> getAllCatalog();
	
	
}
