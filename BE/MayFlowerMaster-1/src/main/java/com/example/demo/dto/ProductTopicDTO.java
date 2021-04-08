package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class ProductTopicDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idtopic;
	private String name;
	private List<FlowerDTO> listFlower;
	public int getIdtopic() {
		return idtopic;
	}
	public void setIdtopic(int idtopic) {
		this.idtopic = idtopic;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
