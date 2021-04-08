package com.example.demo.dto;

import java.io.Serializable;

public class FlowerDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idflower;
	private String name;
	private float price;
	private int idcatalog;
	private int idtopic;
	private String imgname;
	private String img;
	public int getIdflower() {
		return idflower;
	}
	public void setIdflower(int idflower) {
		this.idflower = idflower;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getIdcatalog() {
		return idcatalog;
	}
	public void setIdcatalog(int idcatalog) {
		this.idcatalog = idcatalog;
	}
	public int getIdtopic() {
		return idtopic;
	}
	public void setIdtopic(int idtopic) {
		this.idtopic = idtopic;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	

}
