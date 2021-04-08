package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CatalogFlowerDTO;
import com.example.demo.service.CatalogFlowerService;

@RestController
@RequestMapping("/api/catalog")
public class CatalogFlowerApi {

	@Autowired
	private CatalogFlowerService catalogFlowerService;
	
	@PostMapping
	public boolean addCatalogFlower(@RequestBody CatalogFlowerDTO catalogFlowerDTO) {
		catalogFlowerDTO.setIdcatalog(0);
		if(catalogFlowerService.addCatalogFlower(catalogFlowerDTO)) {
			return true;
		}
		return false;
	}
	@PutMapping 
	public boolean editCatalogFlower(@RequestBody CatalogFlowerDTO catalogFlowerDTO) {
		if(catalogFlowerService.editCatalog(catalogFlowerDTO)) {
			return true;
		}
		return false;
	}
	@DeleteMapping
	public boolean deleteCatalogFlower(@RequestBody List<CatalogFlowerDTO> listCatalog) {
		int count = 0;
		for (CatalogFlowerDTO catalogFlowerDTO : listCatalog) {
			if(!catalogFlowerService.deleteCatalog(catalogFlowerDTO.getIdcatalog())) {
				count++;
				continue;
			}
		}
		if(count == listCatalog.size()) {
			return false;
		}
		return true;
	}
	@GetMapping
	public List<CatalogFlowerDTO> getAllCatalog(){
		return catalogFlowerService.getAllCatalog();
	}
}
