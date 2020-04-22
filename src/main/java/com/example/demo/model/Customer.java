package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer{
	
	@Id
	private String email;
	private String password;
	private String roles = "ROLE_CUSTOMER";
	private boolean active;
	private String shippingAddress;
	private String cardNumber;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
	private List<LineItem> shoppingCart = new ArrayList();
	
    public void addItemToCart(LineItem lItem) {
    	shoppingCart.add(lItem);
    	lItem.setCustomer(this);
    }
    

	public void removeItemFromCart(LineItem lItem) {
       orders.remove(lItem);
       lItem.setCustomer(null);
    }
	
	public Customer() {
		super();
		this.roles="ROLE_CUSTOMER";
	}


	public Customer(String email, String password, String shippingAddress, String cardNumber) {
		super();
		this.email = email;
		this.password = password ;
		this.roles = "ROLE_CUSTOMER";
		this.shippingAddress = shippingAddress;
		this.cardNumber = cardNumber;
		
		
	}
	
	
	
	@OneToMany(mappedBy = "purchaser", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseOrder> orders = new ArrayList();
	
	//Utility Methods for adding + removing reviews. synchronizes both sides
    public void addOrder(PurchaseOrder order) {
    	orders.add(order);
    	order.setPurchaser(this);
    }
    

	public void removeOrder(PurchaseOrder order) {
       orders.remove(order);
       order.setPurchaser(null);
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public List<PurchaseOrder> getOrders() {
		return orders;
	}


	public void setOrders(List<PurchaseOrder> orders) {
		this.orders = orders;
	}


	public List<LineItem> getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(List<LineItem> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	
	
	
	

}
