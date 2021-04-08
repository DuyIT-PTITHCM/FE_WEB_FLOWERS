package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.FlowerConveters;
import com.example.demo.conveters.ProductTopicConveters;
import com.example.demo.dto.FlowerDTO;
import com.example.demo.dto.ProductTopicDTO;
import com.example.demo.entity.Flower;
import com.example.demo.entity.ProductTopic;
import com.example.demo.repository.ProductTopicRepository;
import com.example.demo.serviceImp.ProductTopicServiceImp;
@Service
public class ProductTopicService implements ProductTopicServiceImp{
	@Autowired
	private ProductTopicRepository productTopicRepository;
	@Autowired
	private ProductTopicConveters productTopicConveters;
	@Autowired
	private FlowerConveters flowerConveters;
	@Override
	public boolean addTopicFlower(ProductTopicDTO productTopicDTO) {
		ProductTopic productTopic = new ProductTopic();
		if(productTopicConveters.topicDTOToTopic(productTopicDTO, productTopic)) {
			productTopicRepository.save(productTopic);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTopic(int idTopic) {
		boolean flag = true;
		try {
			productTopicRepository.deleteById(idTopic);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean editTopic(ProductTopicDTO productTopicDTO) {
		ProductTopic productTopic = new ProductTopic();
		if(productTopicConveters.topicDTOToTopic(productTopicDTO, productTopic)) {
			productTopicRepository.save(productTopic);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductTopicDTO> getAllTopic() {
		List<ProductTopic> listTopic = productTopicRepository.findAll();
		List<ProductTopicDTO> listTopicDTO = new ArrayList<ProductTopicDTO>();
		for (ProductTopic productTopic : listTopic) {
			ProductTopicDTO productTopicDTO = new ProductTopicDTO();
			productTopicConveters.topicToTopicDTO(productTopicDTO, productTopic);
			List<FlowerDTO> listFlowerDTO = new ArrayList<FlowerDTO>(); 
			for (Flower flower : productTopic.getFlowers()) {
				FlowerDTO flowerDTO = new FlowerDTO();
				flowerConveters.flowerToFlowerDTO(flowerDTO, flower);
				listFlowerDTO.add(flowerDTO);
			}
			productTopicDTO.setListFlower(listFlowerDTO);
			listTopicDTO.add(productTopicDTO);
		}
		return listTopicDTO;
	}

}
