package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(name = "order_product", joinColumns = { @JoinColumn(name = "fk_order")}, inverseJoinColumns = {@JoinColumn(name = "fk_product")})
	private List<Product> products = new ArrayList<>();
	
	//Each order is attached to one customer.
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer purchaser;
	
	
	
	//Constructor
	public Order() {
		super();
	}

	public Order(List<Product> products, Customer purchaser) {
		super();
		this.products = products;
		this.purchaser = purchaser;
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Customer purchaser) {
		this.purchaser = purchaser;
	}
	
	
	

}
