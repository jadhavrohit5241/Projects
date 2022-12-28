package com.te.pcm.dto;

import java.util.List;

import com.te.pcm.entity.ProductVariations;

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
	private Integer categoryId;
	private Integer optionTypeId;
	private List<ProductVariations> productVariations;

}
