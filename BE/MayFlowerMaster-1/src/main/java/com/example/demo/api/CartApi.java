package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartDTO;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartApi {
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public List<CartDTO> getAllCart(){
		return cartService.getAllCartFlowStatus();
	}
	@PostMapping
	public boolean addCard(@RequestBody CartDTO cartDTO) {
		if(cartService.addCart(cartDTO)) {
			return true;
		}
		return false;
	}
	@DeleteMapping
	public boolean deleteCart(@RequestBody CartDTO cartDTO) {
		
		if(cartService.deleteCart(cartDTO.getIdcart())) {
			return true;
		}
		return false;
}
}
 