package com.example.demo.model;

import javax.persistence.Id;

public class Admin {
	

	private String email;
	private String password;
	private String Roles;
	private boolean active;
	
	
	public Admin() {
		super();
		this.email = "adminHealth";
		this.password = "adminPassword";
		Roles = "ROLE_ADMIN";
		this.active=true;
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
		return Roles;
	}


	public void setRoles(String roles) {
		Roles = roles;
	}
	
	
	
	
	
	
}
