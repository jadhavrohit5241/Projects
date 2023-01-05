package com.te.pcmjwt.dto;


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
	private String optionTitle;
	private Integer optionTypeId;
}
