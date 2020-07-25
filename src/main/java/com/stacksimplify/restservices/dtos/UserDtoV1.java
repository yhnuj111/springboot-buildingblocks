package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

public class UserDtoV1 {
	
	private Long userId;

	
	private String username;

	
	private String fname;
	private String lname;

	private String email;

	private String role;

	private String ssn;
	
	private List<Order> orders;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserDtoV1(Long userId, String username, String fname, String lname, String email, String role, String ssn,
			List<Order> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public UserDtoV1() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



}
