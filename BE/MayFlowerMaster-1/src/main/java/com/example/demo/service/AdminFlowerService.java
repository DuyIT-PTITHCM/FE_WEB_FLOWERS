package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.AdminFlowerConveter;
import com.example.demo.conveters.RoleFlowerConveters;
import com.example.demo.dto.AdminFlowerDTO;
import com.example.demo.dto.RoleFlowerDTO;
import com.example.demo.entity.AdminFlower;
import com.example.demo.entity.RoleFlower;
import com.example.demo.repository.AdminFlowerResository;
import com.example.demo.serviceImp.AdminFlowerServiceImp;
@Service
public class AdminFlowerService implements AdminFlowerServiceImp{
	@Autowired
	private AdminFlowerResository adminFlowerResository;
	@Autowired
	private AdminFlowerConveter adminFlowerConveter;
	@Autowired
	private RoleFlowerConveters roleFlowerConveters;

	@Override
	public boolean addAdmin(AdminFlowerDTO adminFlowerDTO) {
		AdminFlower adminFlower = new AdminFlower();
		if(adminFlowerConveter.adminDTOToAdmin(adminFlowerDTO, adminFlower)) {
			Set<RoleFlower> list = new HashSet<RoleFlower>();
			for (RoleFlowerDTO roleFlowerDTO : adminFlowerDTO.getList()) {
				RoleFlower roleFlowerTamp = new RoleFlower();
				if(roleFlowerConveters.roleDTOToRole(roleFlowerDTO, roleFlowerTamp)) {
					list.add(roleFlowerTamp);
				}
			}
			adminFlower.setRoleFlowers(list);
			adminFlowerResository.save(adminFlower);
			return true;
		}
		return false;
	}
	@Override
	public boolean editAdminPassword(AdminFlowerDTO adminFlowerDTO) {
		try {
			AdminFlower adminFlower = new AdminFlower();
			adminFlower.setPassword(adminFlowerDTO.getPassword());
			adminFlower.setIdadmin(adminFlowerDTO.getIdadmin());
			adminFlowerResository.save(adminFlower);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteAdmin(int idAdmin) {
		try {
			adminFlowerResository.deleteById(idAdmin);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
