package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserServices {
	// Autowire user repository
	
	@Autowired
	private UserRepository userRepository;
	
	// getAllUsers Method
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	// Create User method
	public User createUser(User user) throws UserExistsException {
		// if user not exist using username
		// if  exists using userexistsException
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if (existingUser != null) {
			throw new UserExistsException("User already exists in repository");
		}
		
		return userRepository.save(user);
	}
	
	// getUserById
	public Optional<User> getUserById(Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found in user repository");
		}
		
		return user;
	}
	
	// updateUserById
	
	public User updateUserById(Long id, User user) throws UserNotFoundException{
		Optional<User> optUser = userRepository.findById(id);
		if (!optUser.isPresent()) {
			throw new UserNotFoundException("User not found, please provide the correct id...");
		}
		
		user.setUserId(id);
		return userRepository.save(user);
	}
	
	//Delete user by id
	
	public void deleteUserById(Long id) throws UserNotFoundException{
		
		Optional<User> optUser = userRepository.findById(id);
		if (!optUser.isPresent()) {
			throw new UserNotFoundException("User not found, please provide the correct id...");
		}
		userRepository.deleteById(id);
	}
	
	
	// getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	
}
