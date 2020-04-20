package com.example.demo.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StockItem {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	Product product;
	
	int qtyHeld;
	
	
	
	public StockItem() {
		super();
	}

	
	
	public StockItem(Product product, int qtyHeld) {
		this.id = id;
		this.product = product;
		this.qtyHeld = qtyHeld;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQtyHeld() {
		return qtyHeld;
	}
	public void setQtyHeld(int qtyHeld) {
		this.qtyHeld = qtyHeld;
	}
	@Override
	public String toString() {
		return "StockItem [id=" + id + ", product=" + product + ", qtyHeld=" + qtyHeld + "]";
	}
	
	public boolean tryAdjustStock(int qtyAdjustment) {
		if(qtyHeld + qtyAdjustment >0) {
		qtyHeld += qtyAdjustment;
		return true;
		}
		return false;
	}




	
	
	
	
	
	
}
