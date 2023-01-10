package com.te.pcmjwt.dto;

import javax.validation.constraints.NotEmpty;
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
public class AssignRoleDto {
	@NotEmpty
	@Size(min =5,message ="NAME MUST HAVE 5 CHARACTERS"  )
	private String employeeName;
	private Integer roleId;

}
