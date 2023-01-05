package com.te.pcmjwt.security;

import lombok.Getter;

@Getter
public enum AppPermission {
	
	PRODUCT_WRITE("product:write"),
	PRODUCT_READ("product:read"),
	DEPARTMRNT_WRITE("department:write"),
	DEPARTMRNT_READ("department:read"),
	OPTION_WRITE("option:write"),
	OPTION_READ("option:read"),
	CATEGORY_WRITE("category:write"),
	CATEGORY_READ("category:read"),
	EMP_WRITE("emp:write"),
	EMP_READ("emp:read");
	
	private final String permission;

	private AppPermission(String permission) {
		this.permission = permission;
	}
}
