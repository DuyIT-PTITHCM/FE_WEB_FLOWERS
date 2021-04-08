package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.RoleFlowerDTO;
import com.example.demo.entity.RoleFlower;

@Component
public class RoleFlowerConveters {

	public boolean roleDTOToRole(RoleFlowerDTO roleFlowerDTO , RoleFlower roleFlower) {
		boolean flag = true;
		try {
			roleFlower.setRoleadmin(roleFlowerDTO.getRoleadmin());
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
