package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class EventFlowerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idevent;
	private float percentdow;
	private List<FlowerDTO> list;
	public int getIdevent() {
		return idevent;
	}
	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}
	public float getPercentdow() {
		return percentdow;
	}
	public void setPercentdow(float percentdow) {
		this.percentdow = percentdow;
	}
	public List<FlowerDTO> getList() {
		return list;
	}
	public void setList(List<FlowerDTO> list) {
		this.list = list;
	}
	
}
