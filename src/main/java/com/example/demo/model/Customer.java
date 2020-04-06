package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	
		
	private String shippingAddress;
	private String cardNumber;
	
	
	
	
	public Customer() {
		super();
	}


	public Customer(String email, String password, String shippingAddress, String cardNumber) {
		super();
		super.setEmail(email);
		super.setPassword(password);
		super.setRoles("ROLE_CUSTOMER");
		this.shippingAddress = shippingAddress;
		this.cardNumber = cardNumber;
	}
	
	
	@OneToMany(mappedBy = "purchaser", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orders;
	
	//Utility Methods for adding + removing reviews. synchronizes both sides
    public void addOrder(Order order) {
    	orders.add(order);
    	order.setPurchaser(this);
    }
    

	public void removeReview(Order order) {
       orders.remove(order);
       order.setPurchaser(null);
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


	@Override
	public String toString() {
		return "Customer [shippingAddress=" + shippingAddress + ", cardNumber=" + cardNumber + ", orders=" + orders
				+ "]";
	}
	
	
	
	

}
