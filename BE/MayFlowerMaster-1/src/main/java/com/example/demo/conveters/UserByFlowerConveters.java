package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserByFlowerDTO;
import com.example.demo.entity.UserByFlower;

@Component
public class UserByFlowerConveters {

	public boolean userBuyDTOToUser(UserByFlowerDTO userByFlowerDTO ,UserByFlower userByFlower) {
		boolean flag = true;
		try {
			userByFlower.setAddress(userByFlowerDTO.getAddress());
			userByFlower.setName(userByFlowerDTO.getName());
			userByFlower.setPhone(userByFlowerDTO.getPhone());
			userByFlower.setStatus(userByFlowerDTO.isStatus());
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean userBuyToUserDTO(UserByFlowerDTO userByFlowerDTO ,UserByFlower userByFlower) {
		boolean flag = true;
		try {
			userByFlowerDTO.setAddress(userByFlower.getAddress());
			userByFlowerDTO.setName(userByFlower.getName());
			userByFlowerDTO.setPhone(userByFlower.getPhone());
			userByFlowerDTO.setStatus(userByFlower.isStatus());
			userByFlowerDTO.setIdbuy(userByFlower.getIdbuy());
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
