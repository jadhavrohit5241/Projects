package com.te.lms.entity.emploeeentity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.lms.entity.batchentity.MockDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class EmployeePrimaryInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	@Column(nullable = false)
	private String employeeName;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private String employeeDoj;
	@Column(nullable = false)
	private String employeeDob;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private String employeeEmailId;
	@Column(nullable = false)
	private String employeeBloodGroup;
	@Column(nullable = false)
	private String employeeGender;
	@Column(nullable = false)
	private String employeeNationality;
	@Column(nullable = false)
	private String employeeStatus;
	@Column(nullable = false)
	private String employeeRole;
//	@ManyToOne
//	private Integer batchId;

	private String employeePass;
	@OneToMany(targetEntity = Attendance.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<Attendance> attendancesList;

	@OneToMany(targetEntity = MockDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<MockDetails> mockDetails;

	@OneToOne(targetEntity = EmployeeSecondaryInfo.class, cascade = CascadeType.ALL)
	// @JoinColumn(name="foreign_skill",referencedColumnName ="employeeId")
	private EmployeeSecondaryInfo employeeSecondaryInfo;

	@OneToMany(targetEntity = EmployeeAddressInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<EmployeeAddressInfo> employeeAddressInfo;

	@OneToMany(targetEntity = EmployeeBankInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<EmployeeBankInfo> employeeBankInfos;

	@OneToMany(targetEntity = EmployeeContactInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<EmployeeContactInfo> employeeContactInfos;

	@OneToMany(targetEntity = EmployeeEducationInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<EmployeeEducationInfo> employeeEducationInfos;

	@OneToMany(targetEntity = EmployeeTechnicalskillInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<EmployeeTechnicalskillInfo> employeeTechnicalskillInfos;

	@OneToMany(targetEntity = EmployeeExperienceInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "employeeId")
	private List<EmployeeExperienceInfo> employeeExperienceInfos;


}
