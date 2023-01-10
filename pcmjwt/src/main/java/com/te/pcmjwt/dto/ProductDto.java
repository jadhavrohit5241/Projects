package com.te.pcmjwt.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.te.pcmjwt.entity.ProductVariations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
	@NotNull
	private Integer productId;
	@NotNull(message = "PRODUCT TITLE ID SHOULD NOT BE NULL")
	@Size(min = 2,message = "LEAST 2 CHAR")
	private String productTitle;
	@NotNull(message = "DEPARTMENT ID SHOULD NOT BE NULL")
	private Integer departmentId;
	@NotNull(message = "VARIATIONTYPE ID SHOULD NOT BE NULL")
	private Integer variationTypeId;
	@NotNull(message = "CATEGORY ID SHOULD NOT BE NULL")
	private Integer categoryId;
	@NotNull(message = "OPTIONTYPE ID SHOULD NOT BE NULL")
	private Integer optionTypeId;
	private List<ProductVariations> productVariations;

}
