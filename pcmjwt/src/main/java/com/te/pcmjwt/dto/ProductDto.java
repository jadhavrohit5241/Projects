package com.te.pcmjwt.dto;

import java.util.List;

import com.te.pcmjwt.entity.ProductVariations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

	private Integer productId;
	private String productTitle;
	private Integer departmentId;
	private Integer variationTypeId;
	private Integer categoryId;
	private Integer optionTypeId;
	private List<ProductVariations> productVariations;

}
