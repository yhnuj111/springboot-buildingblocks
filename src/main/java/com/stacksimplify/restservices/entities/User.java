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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// Entity
@ApiModel(description = "This model is to create a user")
@Entity
@Table(name = "user")
// @JsonIgnoreProperties({"fname", "lname"})
// @JsonFilter(value = "userFilter") -- used for mapping jackson value filtering section
public class User extends RepresentationModel<User> {
	
	@ApiModelProperty(notes = "Auto generated unique id", required=true, position=1)
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private Long userId;

	@ApiModelProperty(notes = "username should be flname", example = "zxu",required=false, position=2)
	@Size(min = 2, max=50)
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@NotEmpty(message = "Username cannot be empty. Please provide username..")
	@JsonView(Views.External.class)
	private String username;

	@Size(min = 2, max=50, message = "Firstname should have at least 2 characters...")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String fname;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String lname;

	@Column(name = "EMAIL", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String email;

	@Column(name = "ROLE", length = 50, nullable = false)
	@JsonView(Views.Internal.class)
	private String role;

	// @JsonIgnore
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	@JsonView(Views.Internal.class)
	private String ssn;
	
	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	
	@Column(name="ADDRESS")
	private String address;
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

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
			String email, String role, String ssn, String address, List<Order> orders) {
		super();
		this.userId = userId;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.address = address;
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
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", address=" + address + ", orders=" + orders
				+ "]";
	}

	

}
