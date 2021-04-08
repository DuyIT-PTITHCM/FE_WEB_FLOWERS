package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="catalogflower")
public class CatalogFlower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcatalog;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcatalog")
	private Set<Flower> flowers;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(Set<Flower> flowers) {
		this.flowers = flowers;
	}

	public int getIdcatalog() {
		return idcatalog;
	}

	public void setIdcatalog(int idcatalog) {
		this.idcatalog = idcatalog;
	}

	
	
	
}
