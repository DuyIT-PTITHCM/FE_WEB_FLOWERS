package com.example.demo.dto;

import java.io.Serializable;

public class RoleFlowerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idrole;
	private String roleadmin;
	private int idadmin;
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	public String getRoleadmin() {
		return roleadmin;
	}
	public void setRoleadmin(String roleadmin) {
		this.roleadmin = roleadmin;
	}
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	
}
