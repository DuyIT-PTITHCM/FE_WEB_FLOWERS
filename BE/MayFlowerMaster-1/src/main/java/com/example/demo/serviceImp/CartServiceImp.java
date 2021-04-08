package com.example.demo.serviceImp;

import java.util.List;

import com.example.demo.dto.CartDTO;

public interface CartServiceImp {

	public boolean addCart(CartDTO cartDTO);
	public boolean deleteCart(int idCart);
	public boolean editCart(CartDTO cartDTO);
	public List<CartDTO> getAllCartFlowStatus();
}
