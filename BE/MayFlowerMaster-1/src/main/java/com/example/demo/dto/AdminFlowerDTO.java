package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

public class AdminFlowerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idadmin ;
	private String username;
	private String password;
	private List<RoleFlowerDTO> list;
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleFlowerDTO> getList() {
		return list;
	}
	public void setList(List<RoleFlowerDTO> list) {
		this.list = list;
	}
	


}
