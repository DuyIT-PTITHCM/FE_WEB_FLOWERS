package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.CatalogFlowerConveters;
import com.example.demo.conveters.FlowerConveters;
import com.example.demo.dto.CatalogFlowerDTO;
import com.example.demo.dto.FlowerDTO;
import com.example.demo.entity.CatalogFlower;
import com.example.demo.entity.Flower;
import com.example.demo.repository.CatalogFlowerRepository;
import com.example.demo.serviceImp.CatalogFlowerServiceImp;

@Service
public class CatalogFlowerService implements CatalogFlowerServiceImp {
	@Autowired
	private CatalogFlowerRepository catalogFlowerRepository;
	@Autowired
	private CatalogFlowerConveters catalogFlowerConveters;
	@Autowired
	private FlowerConveters flowerConveters;
	@Override
	public boolean addCatalogFlower(CatalogFlowerDTO catalogFlowerDTO) {
		CatalogFlower catalogFlower = new CatalogFlower();
		if(catalogFlowerConveters.catalogDTOToCatalog(catalogFlowerDTO, catalogFlower)) {
			catalogFlowerRepository.save(catalogFlower);
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteCatalog(int idCatalog) {
		boolean flag = true;
		try {
			catalogFlowerRepository.deleteById(idCatalog);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	@Override
	public boolean editCatalog(CatalogFlowerDTO catalogFlowerDTO) {
		
		CatalogFlower catalogFlower = new CatalogFlower();
		if(catalogFlowerConveters.catalogDTOToCatalog(catalogFlowerDTO, catalogFlower)) {
			catalogFlowerRepository.save(catalogFlower);
			return true;
		}
		return false;
	}
	@Override
	public List<CatalogFlowerDTO> getAllCatalog() {
		List<CatalogFlower> listCatalog = catalogFlowerRepository.findAll();
		List<CatalogFlowerDTO> listCatalogDTO = new ArrayList<CatalogFlowerDTO>();
		for (CatalogFlower catalogFlower : listCatalog) {
			CatalogFlowerDTO catalogFlowerDTO = new CatalogFlowerDTO();
			catalogFlowerConveters.catalogToCatalogDTO(catalogFlowerDTO, catalogFlower);
			List<FlowerDTO> listFlowerDTO = new ArrayList<FlowerDTO>(); 
			for (Flower flower : catalogFlower.getFlowers()) {
				FlowerDTO flowerDTO = new FlowerDTO();
				flowerConveters.flowerToFlowerDTO(flowerDTO, flower);
				listFlowerDTO.add(flowerDTO);
			}
			catalogFlowerDTO.setListFlower(listFlowerDTO);
			listCatalogDTO.add(catalogFlowerDTO);
		}
		return listCatalogDTO;
	}
	
	

	
}
