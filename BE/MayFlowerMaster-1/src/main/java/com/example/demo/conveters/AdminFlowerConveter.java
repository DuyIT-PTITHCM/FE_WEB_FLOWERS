package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.AdminFlowerDTO;
import com.example.demo.entity.AdminFlower;

@Component
public class AdminFlowerConveter {

	public boolean adminDTOToAdmin(AdminFlowerDTO adminFlowerDTO, AdminFlower adminFlower) {
		boolean flag = true;
		try {
			adminFlower.setUsername(adminFlowerDTO.getUsername());
			adminFlower.setPassword(adminFlowerDTO.getPassword());
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}  
}
