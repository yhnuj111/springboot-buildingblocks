package com.stacksimplify.restservices.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Controller -
@Api(tags = "User Management RESTful Services", value = "UserController", description = "Controller for User mangement")
@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserServices userService;

	// getAllUsers methods
	@ApiOperation(value = "Retrieve list of Users")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// create user method
	// RequestBody
	@ApiOperation(value = "Create a new user")
	@PostMapping
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
		try {
			userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getUserId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserExistsException err) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
		}
	}

	// get User by ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> useropt = userService.getUserById(id);
			return useropt.get();
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// updateUserById
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// deleteUserById
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		try {
			userService.deleteUserById(id);
		} catch (UserNotFoundException err) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage());
		}
	}

	// getUserByUsername
	@GetMapping("/byUserName/{username}")
	public User getUserByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UserNameNotFoundException("Username '" + username + "' not found in repository");
		}
		return user;
	}

}
