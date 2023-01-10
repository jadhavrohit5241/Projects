package com.te.pcmjwt.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FetchProductDto {
	@NotNull
	private Integer productId;

}
