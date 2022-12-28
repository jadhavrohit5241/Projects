package com.te.lms.entity.emploeeentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class EmployeeContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeContactInfo;
	private String employeeContacttype;
	private long employeeContactno;

}
