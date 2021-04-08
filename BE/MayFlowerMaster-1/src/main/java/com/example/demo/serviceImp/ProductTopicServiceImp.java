package com.example.demo.serviceImp;


import java.util.List;

import com.example.demo.dto.ProductTopicDTO;

public interface ProductTopicServiceImp {

	public boolean addTopicFlower(ProductTopicDTO productTopicDTO);
	public boolean deleteTopic(int idTopic);
	public boolean editTopic(ProductTopicDTO productTopicDTO);
	public List<ProductTopicDTO> getAllTopic();
	
}
