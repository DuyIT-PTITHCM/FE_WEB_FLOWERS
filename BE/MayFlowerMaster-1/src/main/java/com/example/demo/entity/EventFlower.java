package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="eventflower")
public class EventFlower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idevent;
	
	private float percentdow;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "detailevent",
	joinColumns = {@JoinColumn(name="idevent",referencedColumnName = "idevent")},
	inverseJoinColumns = {@JoinColumn(name="idflower",referencedColumnName = "idflower")})
	private Set<Flower> flowers;

	public float getPercentdow() {
		return percentdow;
	}

	public void setPercentdow(float percentdow) {
		this.percentdow = percentdow;
	}

	public int getIdevent() {
		return idevent;
	}

	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(Set<Flower> flowers) {
		this.flowers = flowers;
	}
	
}
