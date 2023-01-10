package com.te.pcmjwt.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotEmpty
	@Size(min =2,message ="NAME MUST HAVE 2 CHARACTERS"  )
	private String categoryTitle;
	@NotNull
	private Integer departmentId;

}
