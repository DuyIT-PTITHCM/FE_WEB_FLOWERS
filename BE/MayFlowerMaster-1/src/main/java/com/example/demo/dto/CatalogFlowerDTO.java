package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class CatalogFlowerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idcatalog;
	private String name;
	private List<FlowerDTO> listFlower;
	public int getIdcatalog() {
		return idcatalog;
	}
	public void setIdcatalog(int idcatalog) {
		this.idcatalog = idcatalog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FlowerDTO> getListFlower() {
		return listFlower;
	}
	public void setListFlower(List<FlowerDTO> listFlower) {
		this.listFlower = listFlower;
	}
	
	
}
