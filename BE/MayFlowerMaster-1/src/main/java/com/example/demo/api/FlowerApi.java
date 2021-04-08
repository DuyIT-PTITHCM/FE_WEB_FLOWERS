package com.example.demo.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlowerDTO;
import com.example.demo.service.FlowerService;

@RestController
@RequestMapping("/api/flower")
public class FlowerApi {

	@Autowired
	private FlowerService flowerService;
	
	@PostMapping
	public void addFlower(@RequestBody FlowerDTO flowerDTO,HttpServletRequest request) {
		flowerService.addFlower(flowerDTO,request);
	}
	@PutMapping
	public boolean editFlower(@RequestBody FlowerDTO flowerDTO) {
		flowerService.editFlower(flowerDTO);
		return true;
	}
	@DeleteMapping
	public boolean deleteFlower(@RequestBody FlowerDTO flowerDTO) {
		flowerService.deleteFlower(flowerDTO);
		return true;
	}
	@GetMapping
	public List<FlowerDTO> getAllTopic(){
		return flowerService.getAllFlower();
	}
	
}
