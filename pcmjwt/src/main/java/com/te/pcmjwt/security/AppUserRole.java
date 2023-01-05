package com.te.pcmjwt.security;

import java.util.Set;

import com.google.common.collect.Sets;

import lombok.Getter;
@Getter
public enum AppUserRole {

	ENGINEER(Sets.newHashSet(AppPermission.CATEGORY_READ, AppPermission.DEPARTMRNT_READ, AppPermission.OPTION_READ,
			AppPermission.PRODUCT_READ, AppPermission.PRODUCT_WRITE)),
	MANGER(Sets.newHashSet(AppPermission.DEPARTMRNT_WRITE, AppPermission.DEPARTMRNT_READ, AppPermission.CATEGORY_WRITE,
			AppPermission.CATEGORY_READ, AppPermission.EMP_READ, AppPermission.EMP_WRITE, AppPermission.PRODUCT_WRITE,
			AppPermission.PRODUCT_READ, AppPermission.OPTION_WRITE, AppPermission.OPTION_READ));

	private final Set<AppPermission> appPermissions;

	private AppUserRole(Set<AppPermission> appPermissions) {
		this.appPermissions = appPermissions;
	}

}
