package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;



@Entity
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_product")
	private Product product;
	
	private int quantity;
	
	//Constructors
	public LineItem() {
		super();
	}
	
	


	public LineItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}




	@Override
	public String toString() {
		return "LineItem [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	



	
	
	
}
