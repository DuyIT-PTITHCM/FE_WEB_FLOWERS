package com.example.demo.dto;

import java.io.Serializable;
import java.util.Set;


public class CartDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcart;
	private Set<FlowerDTO> flowers;
	private String iddecive;
	private boolean status;
	private Set<UserByFlowerDTO> userByFlowers;
	private float sumMonney;
	public int getIdcart() {
		return idcart;
	}
	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}
	public Set<FlowerDTO> getFlowers() {
		return flowers;
	}
	public void setFlowers(Set<FlowerDTO> flowers) {
		this.flowers = flowers;
	}
	public String getIddecive() {
		return iddecive;
	}
	public void setIddecive(String iddecive) {
		this.iddecive = iddecive;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<UserByFlowerDTO> getUserByFlowers() {
		return userByFlowers;
	}
	public void setUserByFlowers(Set<UserByFlowerDTO> userByFlowers) {
		this.userByFlowers = userByFlowers;
	}
	public float getSumMonney() {
		return sumMonney;
	}
	public void setSumMonney(float sumMonney) {
		this.sumMonney = sumMonney;
	}
	

}
