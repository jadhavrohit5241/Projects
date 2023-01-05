package com.te.pcmjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VariationTypeDto {
	private Integer variationTypeId;
	private String variationTypeTitle;
	private Integer categoryId;
}
