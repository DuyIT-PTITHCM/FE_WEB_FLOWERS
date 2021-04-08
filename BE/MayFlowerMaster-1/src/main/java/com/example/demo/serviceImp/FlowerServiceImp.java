package com.example.demo.serviceImp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.dto.FlowerDTO;

public interface FlowerServiceImp {
	public boolean addFlower (FlowerDTO flowerDTO , HttpServletRequest request);
	public boolean editFlower(FlowerDTO flowerDTO);
	public boolean deleteFlower(FlowerDTO flowerDTO);
	public List<FlowerDTO> getAllFlower();
}
