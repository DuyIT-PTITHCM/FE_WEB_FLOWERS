package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="roleflower")
public class RoleFlower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrole;
	private String roleadmin;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idadmin")
	private AdminFlower adminFlower;

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

	public AdminFlower getAdminFlower() {
		return adminFlower;
	}

	public void setAdminFlower(AdminFlower adminFlower) {
		this.adminFlower = adminFlower;
	}

	
	
	
}
