package com.stacksimplify.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	// User To User DTO

	@Mapping(source="email", target="emailAddress")
	UserMsDto userToUserMsDto(User user);

	// List<User> to List<UserMsDTO>
	
	List<UserMsDto> userToUserDtos(List<User> users);
}
