package com.te.pcmjwt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportDto {
	private Integer productId;
	@NotNull(message = "SHOULD NOT BE NULL")
	@Size(min = 2, message = "DEPARTMENT ID SHOULD NOT BE NULL AND CONATIN ATLEAST TWO CHARACTERS")
	private String productReport;
	@NotNull(message = "SHOULD NOT BE NULL")
	private Integer productTotalStock;

}
