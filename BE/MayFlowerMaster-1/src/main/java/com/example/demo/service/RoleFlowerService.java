package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.RoleFlowerConveters;
import com.example.demo.dto.RoleFlowerDTO;
import com.example.demo.entity.RoleFlower;
import com.example.demo.repository.RoleFlowerRepository;
import com.example.demo.serviceImp.RoleFlowerServiceImp;

@Service
public class RoleFlowerService implements RoleFlowerServiceImp {
	@Autowired
	private RoleFlowerRepository roleFlowerRepository;
	@Autowired
	private RoleFlowerConveters roleFlowerConveters;

	@Override
	public boolean addRoleFlower(RoleFlowerDTO roleFlowerDTO) {
		RoleFlower roleFlower = new RoleFlower();
		if(roleFlowerConveters.roleDTOToRole(roleFlowerDTO, roleFlower)) {
			roleFlowerRepository.save(roleFlower);
			return true;
		}
		return false;
	}

}
