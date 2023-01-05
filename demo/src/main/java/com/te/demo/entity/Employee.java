package com.te.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class Employee {
	@Id
	private Integer employeeId;
	private String employeeName;

	@Column(unique = true)
	private String userName;
	private String designation;

	private String password;

	private String email;

	private boolean accountStatus;
}
