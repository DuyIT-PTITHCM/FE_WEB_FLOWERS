package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;

@Component
public class CartConveters {

	public boolean cartDTOToCart(CartDTO cartDTO,Cart cart) {
		boolean flag = true;
		try {
			if(cartDTO.getIdcart() !=0 ) {
				cart.setIdcart(cartDTO.getIdcart());
				cart.setIddecive(cartDTO.getIddecive());
				cart.setStatus(cartDTO.isStatus());
				cart.setSummonney(cartDTO.getSumMonney());
			}else {
				cart.setIddecive(cartDTO.getIddecive());
				cart.setStatus(cartDTO.isStatus());
				cart.setSummonney(cartDTO.getSumMonney());
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean cartToCartDTO(CartDTO cartDTO,Cart cart) {
		boolean flag = true;
		try {
		
			cartDTO.setIdcart(cart.getIdcart());
			cartDTO.setIddecive(cart.getIddecive());
			cartDTO.setStatus(cart.isStatus());
			cartDTO.setSumMonney(cart.getSummonney());
			cartDTO.setIdcart(cart.getIdcart());
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
