package com.example.demo.entity;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity(name = "adminflower")
public class AdminFlower {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idadmin ;
	private String username;
	@JsonIgnore
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "idadmin")
	private Set<RoleFlower> roleFlowers;

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

	public Set<RoleFlower> getRoleFlowers() {
		return roleFlowers;
	}

	public void setRoleFlowers(Set<RoleFlower> roleFlowers) {
		this.roleFlowers = roleFlowers;
	}

	

	
}
