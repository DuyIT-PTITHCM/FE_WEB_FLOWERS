package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserByFlowerDTO;
import com.example.demo.service.UserByFlowerService;

@RestController
@RequestMapping("/api/userbuyflower")
public class UserByFlowerApi {

	@Autowired
	private UserByFlowerService userByFlowerService;
	
	@PostMapping
	public boolean addUserBuyFlower(@RequestBody UserByFlowerDTO userByFlowerDTO) {
		
		if(userByFlowerService.addUserBuyFlower(userByFlowerDTO)) {
			return true;
		}
		return false;
	}
	@GetMapping
	public List<UserByFlowerDTO> getAllUserBuyFlower(){
		return userByFlowerService.getAllUserBuy();
	}
	@DeleteMapping
	public boolean deleteUserBuyFlower(@RequestBody UserByFlowerDTO userByFlowerDTO) {
		if(userByFlowerService.deleteUserBuyFlower(userByFlowerDTO)) {
			return true;
		}
		return false;
	}
	
}
