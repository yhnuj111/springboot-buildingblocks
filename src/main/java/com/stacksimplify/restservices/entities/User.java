package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

// Entity
@Entity
@Table(name = "user")
public class User extends RepresentationModel<User>{
	@Id
	@GeneratedValue
	private Long userId;

	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@NotEmpty(message = "Username cannot be empty. Please provide username..")
	private String username;

	@Size(min = 2, message = "Firstname should have at least 2 characters...")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String fname;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lname;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "ROLE", length = 50, nullable = false)
	private String role;

	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;

	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	// No argument constructor
	public User() {

	}

	// Fields constructor
	public User(Long userId, @NotEmpty(message = "Username cannot be empty. Please provide username..") String username,
			@Size(min = 2, message = "Firstname should have at least 2 characters...") String fname, String lname,
			String email, String role, String ssn, List<Order> orders) {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}

}
