package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductTopicDTO;
import com.example.demo.entity.ProductTopic;

@Component
public class ProductTopicConveters {
	public boolean topicDTOToTopic(ProductTopicDTO productTopicDTO ,ProductTopic productTopic) {
		boolean flag = true;
		try {
			if(productTopicDTO.getIdtopic()!= 0) {
				productTopic.setName(productTopicDTO.getName());
				productTopic.setIdtopic(productTopicDTO.getIdtopic());
			}else {
				productTopic.setName(productTopicDTO.getName());
			}
			
		} catch (Exception e) {
			flag = false;
		}
	return flag;
	}	
	
	public boolean topicToTopicDTO(ProductTopicDTO productTopicDTO ,ProductTopic productTopic) {
		boolean flag = true;
		try {
			
			productTopicDTO.setName(productTopic.getName());
			productTopicDTO.setIdtopic(productTopic.getIdtopic());
			productTopicDTO.setIdtopic(productTopic.getIdtopic());
			
		} catch (Exception e) {
			flag = false;
		}
	return flag;
	}	
}
