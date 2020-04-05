package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Customer extends User{
	
		
	private String shippingAddress;
	private String cardNumber;
	
	
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
