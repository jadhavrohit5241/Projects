package com.te.micro.userservice.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.micro.userservice.custexception.InvalidUserInputException;
import com.te.micro.userservice.dto.UserDto;
import com.te.micro.userservice.entity.User;
import com.te.micro.userservice.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto register(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		Optional<User> userFromDb = userRepository.findById(userDto.getUserId());
		if (!userFromDb.isEmpty()) {
			throw new InvalidUserInputException("Already present");
		}
		return new UserDto(userRepository.save(user));
	}

	@Override
	public UserDto getUserInfo(Integer driverId) {
		Optional<User> userFromDb = userRepository.findById(driverId);
		if (userFromDb.isEmpty()) {
			throw new InvalidUserInputException("Already present");
		}
		return new UserDto(userFromDb.get());
	}
}
