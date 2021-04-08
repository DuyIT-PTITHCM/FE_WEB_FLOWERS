package com.example.demo.serviceImp;

import java.util.List;

import com.example.demo.dto.UserByFlowerDTO;

public interface UserByFlowerServiceImp {

	public boolean addUserBuyFlower(UserByFlowerDTO userByFlowerDTO);
	public boolean deleteUserBuyFlower(UserByFlowerDTO userByFlowerDTO);
	public List<UserByFlowerDTO> getAllUserBuy();
	
}
