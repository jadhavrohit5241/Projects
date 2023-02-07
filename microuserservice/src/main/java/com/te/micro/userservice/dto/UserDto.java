package com.te.micro.userservice.dto;

import com.te.micro.userservice.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private Integer userId;
	private String userName;
	private String userEmail;
	private String userConatactNo;
	private String userAddress;

	public UserDto(User user) {
		this.userName = user.getUserName();
		this.userId = user.getUserId();
		this.userAddress = user.getUserAddress();
		this.userConatactNo = user.getUserConatactNo();
		this.userEmail = user.getUserEmail();
	}

}
