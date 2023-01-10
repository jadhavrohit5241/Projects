package com.te.pcmjwt.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VariationTypeDto {
	private Integer variationTypeId;
	@NotNull(message = "SHOULD NOT BE NULL")
	private String variationTypeTitle;
	@NotNull(message = "SHOULD NOT BE NULL")
	private Integer categoryId;
}
