package com.te.pcmjwt.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class DeptAddDto{
	private Integer departmentId;
	@NotEmpty
	@Size(min =2,message ="NAME MUST HAVE 2 CHARACTERS"  )
	private String departmentTitle;

}
