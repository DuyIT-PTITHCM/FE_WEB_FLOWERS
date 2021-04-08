package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CatalogFlowerDTO;
import com.example.demo.entity.CatalogFlower;


@Component
public class CatalogFlowerConveters  {
	public boolean catalogDTOToCatalog(CatalogFlowerDTO catalogFlowerDTO ,CatalogFlower catalogFlower) {
		boolean flag = true;
		try {
			if(catalogFlowerDTO.getIdcatalog()!= 0) {
				catalogFlower.setName(catalogFlowerDTO.getName());
				catalogFlower.setIdcatalog(catalogFlowerDTO.getIdcatalog());
			}else {
				catalogFlower.setName(catalogFlowerDTO.getName());
			}
			
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean catalogToCatalogDTO(CatalogFlowerDTO catalogFlowerDTO ,CatalogFlower catalogFlower) {
		boolean flag = true;
		try {
				catalogFlowerDTO.setName(catalogFlower.getName());
				catalogFlowerDTO.setIdcatalog(catalogFlower.getIdcatalog());
			
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	
}
