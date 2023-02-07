package com.te.micro.userservice.service;

import com.te.micro.userservice.dto.UserDto;

public interface UserServiceInterface {

	UserDto register(UserDto userDto);

	UserDto getUserInfo(Integer driverId);
}
