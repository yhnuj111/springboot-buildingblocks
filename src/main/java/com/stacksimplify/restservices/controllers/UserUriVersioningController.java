package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserServices;

@RestController
@RequestMapping("versioning/modelmapper/users")
public class UserUriVersioningController {
	@Autowired
	private UserServices userService;
	
	@Autowired
	private ModelMapper modelMapper;

	// URI based Versioning - V1
	@GetMapping({"/v1.0/{id}", "/v1.1/{id}"})
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException{
		
		Optional<User> userOpt = userService.getUserById(id);
		if (!userOpt.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		User user = userOpt.get();
		
		UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
		return userDtoV1;
		
	}
	
	@GetMapping({"/v2.0/{id}", "/v2.1/{id}"})
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException{
		
		Optional<User> userOpt = userService.getUserById(id);
		if (!userOpt.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		User user = userOpt.get();
		
		UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
		return userDtoV2;
		
	}
}
