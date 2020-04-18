package com.example.demo.model;

import javax.persistence.Id;

public class Admin {
	
	private static Admin ADMIN_SINGLE_INSTANCE = null;

	@Id
	String email;
	String password;
	String Roles;
	
	
	private Admin() {
		super();
		this.email = "adminHealth";
		this.password = "adminPassword";
		Roles = "ROLE_ADMIN";
	}
	
	
	public Admin getInstance() {
		if (ADMIN_SINGLE_INSTANCE == null) {
			ADMIN_SINGLE_INSTANCE = new Admin();
		}
			return ADMIN_SINGLE_INSTANCE;
			
		
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


	public static Admin getADMIN_SINGLE_INSTANCE() {
		return ADMIN_SINGLE_INSTANCE;
	}
	
	
	
	
	
	
}
