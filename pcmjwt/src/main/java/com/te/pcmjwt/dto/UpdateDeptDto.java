package com.te.pcmjwt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDeptDto {
	@Size(min = 2,message = "DEPARTMENT ID SHOULD NOT BE NULL AND CONATIN ATLEAST TWO CHARACTERS")
	private String deptName;
	@NotNull(message = "DEPARTMENT ID SHOULD NOT BE NULL")
	@Size(min = 2,message = "DEPARTMENT ID SHOULD NOT BE NULL AND CONATIN ATLEAST TWO CHARACTERS")
	private String upadeteDeptName;
}
