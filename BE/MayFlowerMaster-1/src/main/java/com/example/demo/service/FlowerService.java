package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.FlowerConveters;
import com.example.demo.dto.FlowerDTO;
import com.example.demo.entity.Flower;
import com.example.demo.repository.CatalogFlowerRepository;
import com.example.demo.repository.FlowerRepository;
import com.example.demo.repository.ProductTopicRepository;
import com.example.demo.serviceImp.FlowerServiceImp;
import com.example.demo.uploadfilebase64.HandleFileUpload;

import org.apache.commons.lang3.RandomStringUtils;



@Service
public class FlowerService implements FlowerServiceImp{
	@Autowired
	private FlowerRepository flowerRepository;
	@Autowired
	private CatalogFlowerRepository catalogFlowerRepository;
	@Autowired
	private ProductTopicRepository productTopicRepository;
	@Autowired
	private FlowerConveters flowerConveters;
	@Autowired
	private HandleFileUpload handleFileUpload;
	@Override
	public boolean addFlower(FlowerDTO flowerDTO ,HttpServletRequest request) {
		Flower flower = new Flower();
		if(flowerConveters.flowerDTOtoFlower(flowerDTO, flower)) {
			String nameFile = flowerDTO.getImgname();
			
			RandomStringUtils randomStringUtils = new RandomStringUtils();
			
			@SuppressWarnings("static-access")
			String nameFileTamp = randomStringUtils.randomAlphanumeric(50) +nameFile;
			String fileimg = "http://localhost:8088/getimg/"+nameFileTamp;
			
			handleFileUpload.uploadFile(nameFileTamp, flowerDTO.getImg(), request);
			
			flower.setImg(fileimg);
			
			flower.setCatalogFlower(catalogFlowerRepository.findOneByIdcatalog(flowerDTO.getIdcatalog()));
			flower.setProductTopic(productTopicRepository.findOneByIdtopic(flowerDTO.getIdtopic()));
			flowerRepository.save(flower);
		}else {
			return false;
		}
	return true;
	}

	@Override
	public boolean editFlower(FlowerDTO flowerDTO) {
		Flower flower = new Flower();
		if(flowerConveters.flowerDTOtoFlower(flowerDTO, flower)) {
			flower.setCatalogFlower(catalogFlowerRepository.findOneByIdcatalog(flowerDTO.getIdcatalog()));
			flower.setProductTopic(productTopicRepository.findOneByIdtopic(flowerDTO.getIdtopic()));
			flowerRepository.save(flower);
		}else {
			return false;
		}
	return true;
	}

	@Override
	public boolean deleteFlower(FlowerDTO flowerDTO) {
		try {
			flowerRepository.deleteById(flowerDTO.getIdflower());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<FlowerDTO> getAllFlower() {
		List<FlowerDTO> listFlower = new ArrayList<FlowerDTO>();
		for (Flower flower : flowerRepository.findAll()) {
			FlowerDTO flowerDTO = new FlowerDTO();
			flowerConveters.flowerToFlowerDTO(flowerDTO, flower);
			listFlower.add(flowerDTO);
		}
		
		return listFlower;
	}
	

}
