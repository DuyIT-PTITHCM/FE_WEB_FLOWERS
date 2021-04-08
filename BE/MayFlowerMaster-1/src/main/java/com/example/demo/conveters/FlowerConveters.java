package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.FlowerDTO;
import com.example.demo.entity.Flower;

@Component
public class FlowerConveters {
	public boolean flowerDTOtoFlower(FlowerDTO flowerDTO,Flower flower) {
			if(flowerDTO.getIdflower() != 0) {
				flower.setName(flowerDTO.getName());
				flower.setPrice(flowerDTO.getPrice());
				flower.setIdflower(flowerDTO.getIdflower());
			}else {
				flower.setName(flowerDTO.getName());
				flower.setPrice(flowerDTO.getPrice());
			}
			
		return true;
	}
	public boolean flowerToFlowerDTO(FlowerDTO flowerDTO,Flower flower) {
		flowerDTO.setIdflower(flower.getIdflower());
		flowerDTO.setName(flower.getName());
		flowerDTO.setPrice(flower.getPrice());
		flowerDTO.setIdcatalog(flower.getCatalogFlower().getIdcatalog());
		flowerDTO.setIdtopic(flower.getProductTopic().getIdtopic());
		flowerDTO.setImg(flower.getImg());
	return true;
}

}
