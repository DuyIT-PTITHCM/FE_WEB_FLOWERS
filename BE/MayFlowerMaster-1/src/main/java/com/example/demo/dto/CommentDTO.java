package com.example.demo.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcomment;
	private String content;
	private String gmail;
	private String usernamecomment;
	public int getIdcomment() {
		return idcomment;
	}
	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getUsernamecomment() {
		return usernamecomment;
	}
	public void setUsernamecomment(String usernamecomment) {
		this.usernamecomment = usernamecomment;
	}
	
	

}
