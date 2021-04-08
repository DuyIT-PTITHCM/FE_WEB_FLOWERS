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
import javax.persistence.OneToOne;

@Entity(name = "flower")
public class Flower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idflower;
	
	private String name;
	private float price;
	private String img;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcatalog")
	private CatalogFlower catalogFlower;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idtopic")
	private ProductTopic productTopic;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "detailproduct",
	joinColumns = {@JoinColumn(name="idflower",referencedColumnName = "idflower")},
	inverseJoinColumns = {@JoinColumn(name="idcart",referencedColumnName = "idcart")})
	private Set<Cart> carts;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "detailevent",
	joinColumns = {@JoinColumn(name="idflower",referencedColumnName = "idflower")},
	inverseJoinColumns = {@JoinColumn(name="idevent",referencedColumnName = "idevent")})
	private Set<EventFlower> eventFlowers;


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

	public CatalogFlower getCatalogFlower() {
		return catalogFlower;
	}

	public void setCatalogFlower(CatalogFlower catalogFlower) {
		this.catalogFlower = catalogFlower;
	}

	public ProductTopic getProductTopic() {
		return productTopic;
	}

	public void setProductTopic(ProductTopic productTopic) {
		this.productTopic = productTopic;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<EventFlower> getEventFlowers() {
		return eventFlowers;
	}

	public void setEventFlowers(Set<EventFlower> eventFlowers) {
		this.eventFlowers = eventFlowers;
	}

	public int getIdflower() {
		return idflower;
	}

	public void setIdflower(int idflower) {
		this.idflower = idflower;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}
