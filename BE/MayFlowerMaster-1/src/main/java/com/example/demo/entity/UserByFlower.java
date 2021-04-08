package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "userbuyflower")
public class UserByFlower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbuy;
	
	private String name;
	private String phone;
	private String address;
	private boolean status;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "detailbuyproduct",
	joinColumns = {@JoinColumn(name="idbuy",referencedColumnName = "idbuy")},
	inverseJoinColumns = {@JoinColumn(name="idcart",referencedColumnName = "idcart")})
	private Set<Cart> carts;

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

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public int getIdbuy() {
		return idbuy;
	}

	public void setIdbuy(int idbuy) {
		this.idbuy = idbuy;
	}
	
	
}
