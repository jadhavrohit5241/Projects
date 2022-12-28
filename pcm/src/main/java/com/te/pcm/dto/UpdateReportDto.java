package com.te.pcm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReportDto {
	private Integer productId;
	private String productReport;
	private Integer productTotalStock;
	
}
