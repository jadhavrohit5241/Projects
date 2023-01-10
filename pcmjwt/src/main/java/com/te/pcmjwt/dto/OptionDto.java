package com.te.pcmjwt.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptionDto {
	private Integer optionId;
	@NotNull
	@Size(min = 2,message = "LEAST 2 CHAR")
	private String optionTitle;
	@NotNull
	private Integer optionTypeId;
}
