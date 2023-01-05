package com.te.pcmjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryAddDto {

	private Integer categoryId;
	private String categoryTitle;
	private Integer departmentId;

}
