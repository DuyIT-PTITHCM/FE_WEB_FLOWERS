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
import com.example.demo.dto.ProductTopicDTO;
import com.example.demo.service.ProductTopicService;

@RestController
@RequestMapping("/api/topic")
public class ProductTopicApi {

	@Autowired
	private ProductTopicService productTopicService;
	
	@PostMapping
	public boolean addTopicFlower(@RequestBody ProductTopicDTO productTopicDTO) {
		productTopicDTO.setIdtopic(0);
		if(productTopicService.addTopicFlower(productTopicDTO)) {
			return true;
		}
		return false;
	}
	@PutMapping 
	public boolean editTopicFlower(@RequestBody ProductTopicDTO productTopicDTO) {
		if(productTopicService.editTopic(productTopicDTO)) {
			return true;
		}
		return false;
	}
	@DeleteMapping
	public boolean deleteCatalogFlower(@RequestBody List<ProductTopicDTO> listTopic) {
		int count = 0;
		for (ProductTopicDTO productTopicDTO : listTopic) {
			if(!productTopicService.deleteTopic(productTopicDTO.getIdtopic())) {
				count++;
				continue;
			}
		}
		if(count == listTopic.size()) {
			return false;
		}
		return true;
	}
	@GetMapping
	public List<ProductTopicDTO> getAllProductTopic(){
		return productTopicService.getAllTopic();
	}
}
