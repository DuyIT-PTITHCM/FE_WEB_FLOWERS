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

@Entity(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcart;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "detailproduct",
	joinColumns = {@JoinColumn(name="idcart",referencedColumnName = "idcart")},
	inverseJoinColumns = {@JoinColumn(name="idflower",referencedColumnName = "idflower")})
	private Set<Flower> flowers;
	
	private String iddecive;
	private boolean status;
	private float summonney;
	

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "detailbuyproduct",
	joinColumns = {@JoinColumn(name="idcart",referencedColumnName = "idcart")},
	inverseJoinColumns = {@JoinColumn(name="idbuy",referencedColumnName = "idbuy")})
	private Set<UserByFlower> userByFlowers;

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(Set<Flower> flowers) {
		this.flowers = flowers;
	}

	public String getIddecive() {
		return iddecive;
	}

	public void setIddecive(String iddecive) {
		this.iddecive = iddecive;
	}

	public Set<UserByFlower> getUserByFlowers() {
		return userByFlowers;
	}

	public void setUserByFlowers(Set<UserByFlower> userByFlowers) {
		this.userByFlowers = userByFlowers;
	}
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getIdcart() {
		return idcart;
	}

	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}

	public float getSummonney() {
		return summonney;
	}

	public void setSummonney(float summonney) {
		this.summonney = summonney;
	}

	
	
	
	

}
