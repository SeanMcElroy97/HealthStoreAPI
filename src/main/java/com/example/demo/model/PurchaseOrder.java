package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "purchase_order_items", joinColumns = { @JoinColumn(name = "fk_purchase_orderID")}, inverseJoinColumns = {@JoinColumn(name = "fk_lineItemID")})
	private List<LineItem> orderItems = new ArrayList<>();
	
	//Each order is attached to one customer.
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer purchaser;
	
	
	
	//Constructor
	public PurchaseOrder() {
		super();
	}


//	Create this by customer
	public PurchaseOrder(List<LineItem> orderItems) {
		super();
		this.orderItems = orderItems;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<LineItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(List<LineItem> orderItems) {
		this.orderItems = orderItems;
	}



	public Customer getPurchaser() {
		return purchaser;
	}



	public void setPurchaser(Customer purchaser) {
		this.purchaser = purchaser;
	}
	

}
