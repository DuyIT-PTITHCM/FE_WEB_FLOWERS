package com.example.demo.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.CartConveters;
import com.example.demo.conveters.FlowerConveters;
import com.example.demo.conveters.UserByFlowerConveters;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.FlowerDTO;
import com.example.demo.dto.UserByFlowerDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Flower;
import com.example.demo.entity.UserByFlower;
import com.example.demo.repository.FlowerRepository;
import com.example.demo.repository.UserByFlowerRepository;
import com.example.demo.serviceImp.UserByFlowerServiceImp;


@Service
public class UserByFlowerService implements UserByFlowerServiceImp {

	@Autowired
	private UserByFlowerRepository userByFlowerRepository;
	@Autowired
	private UserByFlowerConveters userByFlowerConveters;
	@Autowired
	private CartConveters cartConveters;
	@Autowired
	private FlowerConveters flowerConveters;
	@Autowired
	private FlowerRepository flowerRepository;
	@Override
	public boolean addUserBuyFlower(UserByFlowerDTO userByFlowerDTO) {
		UserByFlower userByFlower  = new UserByFlower();
		if(userByFlowerConveters.userBuyDTOToUser(userByFlowerDTO, userByFlower)) {
			
			Set<Cart> listCart = new HashSet<Cart>();
			
			List<CartDTO> listCartDTO = userByFlowerDTO.getList();
			
			for (CartDTO cartDTO : listCartDTO) {
				Cart cart = new Cart();
				cartConveters.cartDTOToCart(cartDTO, cart);
				
				Set<Flower> list = new HashSet<Flower>();
				for (FlowerDTO item : cartDTO.getFlowers()) {
					Flower flower = flowerRepository.findOneByIdflower(item.getIdflower());
					list.add(flower);
				}
				cart.setFlowers(list);
				listCart.add(cart);
			}
			userByFlower.setCarts(listCart);
			userByFlowerRepository.save(userByFlower);
			return true;
		}
		
		return false;
	}
	@Override
	public boolean deleteUserBuyFlower(UserByFlowerDTO userByFlowerDTO) {
		boolean flag = true;
		try {
			userByFlowerRepository.deleteById(userByFlowerDTO.getIdbuy());
		} catch (Exception e) {
			flag = false;
			System.out.println(e);
		}
		return flag;
	}
	@Override
	public List<UserByFlowerDTO> getAllUserBuy() {
		
		List<UserByFlowerDTO> listUserDTO = new ArrayList<UserByFlowerDTO>();
		List<UserByFlower> listUser = userByFlowerRepository.findAllByStatus(false);
		for (UserByFlower userByFlower : listUser) {
			UserByFlowerDTO userByFlowerDTO = new UserByFlowerDTO();
			userByFlowerConveters.userBuyToUserDTO(userByFlowerDTO, userByFlower);
			List<CartDTO> listCartDTO = new ArrayList<CartDTO>();
			Set<Cart> listCart = userByFlower.getCarts();
			for (Cart cart : listCart) {
				CartDTO cartDTO = new CartDTO();
				cartConveters.cartToCartDTO(cartDTO, cart);
				
				
				Set<FlowerDTO> listFlower = new HashSet<FlowerDTO>();
				for (Flower flower : cart.getFlowers()) {
					FlowerDTO flowerDTO = new FlowerDTO();
					flowerConveters.flowerToFlowerDTO(flowerDTO, flower);
					listFlower.add(flowerDTO);
				}
				cartDTO.setFlowers(listFlower);
				listCartDTO.add(cartDTO);
			}
			userByFlowerDTO.setList(listCartDTO);
			listUserDTO.add(userByFlowerDTO);
		}
		
		
		return listUserDTO;
	}
	

}
