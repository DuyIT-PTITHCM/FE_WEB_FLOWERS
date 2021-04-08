package com.example.demo.dto;

import java.io.Serializable;

public class StoryFlowerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idstory;
	private String name;
	private String story;
	private String img;
	private String dateupdate;
	public int getIdstory() {
		return idstory;
	}
	public void setIdstory(int idstory) {
		this.idstory = idstory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDateupdate() {
		return dateupdate;
	}
	public void setDateupdate(String dateupdate) {
		this.dateupdate = dateupdate;
	}
	
}
