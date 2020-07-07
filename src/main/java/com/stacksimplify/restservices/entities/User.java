package com.stacksimplify.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	private String username;

	@Column(name="FIRST_NAME", length=50, nullable=false)
	private String fname;

	@Column(name="LAST_NAME", length=50, nullable=false)
	private String lname;

	@Column(name="EMAIL", length=50, nullable=false)
	private String email;

	@Column(name="ROLE", length=50, nullable=false)
	private String role;

	@Column(name="SSN", length=50, nullable=false, unique=true)
	private String ssn;



	// No argument constructor
	public User() {

	}

	// Fields constructor
	public User(Long id, String username, String fname, String lname, String email, String role, String ssn) {
		this.id = id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	// to string
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fname=" + fname + ", lname=" + lname + ", email="
				+ email + ", role=" + role + ", ssn=" + ssn + "]";
	}

}
