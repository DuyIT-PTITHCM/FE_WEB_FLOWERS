package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class UserByFlowerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idbuy;
	private String name;
	private String phone;
	private String address;
	private boolean status;
	private List<CartDTO> list;
	public int getIdbuy() {
		return idbuy;
	}
	public void setIdbuy(int idbuy) {
		this.idbuy = idbuy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<CartDTO> getList() {
		return list;
	}
	public void setList(List<CartDTO> list) {
		this.list = list;
	}
	
}
