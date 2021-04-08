package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "producttopic")
public class ProductTopic {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idtopic;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "idtopic")
	private Set<Flower> flowers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(Set<Flower> flowers) {
		this.flowers = flowers;
	}

	public int getIdtopic() {
		return idtopic;
	}

	public void setIdtopic(int idtopic) {
		this.idtopic = idtopic;
	}
	
	
	
}
