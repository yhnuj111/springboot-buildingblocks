package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserMmDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserServices;

@RestController
@RequestMapping("modelmapper/users")
public class UserModelMapperController {
	@Autowired
	private UserServices userService;
	
	@Autowired
	private ModelMapper modelMapper;

	// get User by ID
	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException{
		
		Optional<User> userOpt = userService.getUserById(id);
		if (!userOpt.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
		User user = userOpt.get();
		
		UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
		return userMmDto;
		
	}
}
