package com.te.pcmjwt.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtDto {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
