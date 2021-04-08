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
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.FlowerRepository;
import com.example.demo.serviceImp.CartServiceImp;

@Service
public class CartService implements CartServiceImp {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartConveters cartConveters;
	@Autowired
	private FlowerRepository flowerRepository;
	@Autowired
	private UserByFlowerConveters userByFlowerConveters;
	@Autowired
	private FlowerConveters flowerConveters;
	@Override
	public boolean addCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		Set<Flower> list = new HashSet<Flower>();
		Set<UserByFlower> listBuy = new HashSet<UserByFlower>();
		if(cartConveters.cartDTOToCart(cartDTO, cart)) {
			for (FlowerDTO item : cartDTO.getFlowers()) {
				Flower flower = flowerRepository.findOneByIdflower(item.getIdflower());
				list.add(flower);
			}
			
			Set<UserByFlowerDTO> listDTO = cartDTO.getUserByFlowers();
			for (UserByFlowerDTO userByFlowerDTO2 : listDTO) {
				UserByFlower userByFlower = new UserByFlower();
				userByFlowerConveters.userBuyDTOToUser(userByFlowerDTO2, userByFlower);
				listBuy.add(userByFlower);
			}
			
			cart.setFlowers(list);
			cart.setUserByFlowers(listBuy);
			cartRepository.save(cart);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCart(int idCart) {
		try {
			cartRepository.deleteById(idCart);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean editCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		Set<Flower> list = new HashSet<Flower>();
		Set<UserByFlower> listBuy = new HashSet<UserByFlower>();
		if(cartConveters.cartDTOToCart(cartDTO, cart)) {
			for (FlowerDTO item : cartDTO.getFlowers()) {
				Flower flower = flowerRepository.findOneByIdflower(item.getIdflower());
				list.add(flower);
			}
			UserByFlowerDTO userByFlowerDTO = cartDTO.getUserByFlowers().iterator().next();
			UserByFlower userByFlower = new UserByFlower();
			userByFlowerConveters.userBuyDTOToUser(userByFlowerDTO, userByFlower);
			cart.setFlowers(list);
			listBuy.add(userByFlower);
			cart.setUserByFlowers(listBuy);
			cartRepository.save(cart);
			return true;
		}
		return false;
	}

	@Override
	public List<CartDTO> getAllCartFlowStatus() {
		List<CartDTO> list = new ArrayList<CartDTO>();
		List<Cart> listCart = cartRepository.findAllByStatus(false);
		for (Cart cart : listCart) {
			CartDTO cartDTO = new CartDTO();
			cartConveters.cartToCartDTO(cartDTO, cart);
			Set<FlowerDTO> listFlower = new HashSet<FlowerDTO>();
			for (Flower flower : cart.getFlowers()) {
				FlowerDTO flowerDTO = new FlowerDTO();
				flowerConveters.flowerToFlowerDTO(flowerDTO, flower);
				listFlower.add(flowerDTO);
			}
			
			Set<UserByFlower> listFlower1 = cart.getUserByFlowers();
			Set<UserByFlowerDTO> setU = new HashSet<UserByFlowerDTO>();
			for (UserByFlower item : listFlower1) {
				UserByFlowerDTO userByFlowerDTO = new UserByFlowerDTO();
				userByFlowerConveters.userBuyToUserDTO(userByFlowerDTO, item);
				setU.add(userByFlowerDTO);
			}
			
			cartDTO.setUserByFlowers(setU);
			cartDTO.setFlowers(listFlower);
			list.add(cartDTO);
			}
		
		
		return list;
	}

}
