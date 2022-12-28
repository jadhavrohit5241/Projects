package com.te.pcmjwt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	private Integer employeeId;
	private String employeeName;
	private String designation;
	private String password;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Departments department;

}
