package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminFlowerDTO;
import com.example.demo.service.AdminFlowerService;

@RestController
@RequestMapping("/api/adminhandle")
public class AdminApi {

	@Autowired
	private AdminFlowerService adminFlowerService;
	@PostMapping
	public boolean addAdmin(@RequestBody AdminFlowerDTO adminFlowerDTO) {
		if(adminFlowerService.addAdmin(adminFlowerDTO)) {
			return true;
		}
		return false;
		
	}
	
}
