package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User{
	
		
	private String shippingAddress;
	private String cardNumber;
	
	
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
	
	

}
