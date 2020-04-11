package com.example.demo.model;

import javax.persistence.Entity;

//@Entity
public class Admin extends User{
	
	public Admin(String email, String password) {
		super();
		super.setEmail(email);
		super.setPassword(password);
		super.setRoles("ROLE_ADMIN");
	}

}
