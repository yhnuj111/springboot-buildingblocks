package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/mapStruct/users")
public class UserMapStructController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
//	
//	@GetMapping
//	public List<UserMsDto> getAllUserDtos() {
//		return userMapper.userToUserDtos(userRepository.findAll());
//	}
//	
//	@GetMapping("/{id}")
//	public UserMsDto getUserById(@PathVariable Long id) throws UserNotFoundException {
//		Optional<User> userOpt = userRepository.findById(id);
//		if (!userOpt.isPresent()) {
//			throw new UserNotFoundException("User not found");
//		}
//		User user = userOpt.get();
//		return userMapper.userToUserMsDto(user);
//		
//	}
}
