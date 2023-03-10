package com.te.pcmjwt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private Integer categoryId;
	@NotNull
	@Size(min = 2)
	private String catagoryTitle;
}
