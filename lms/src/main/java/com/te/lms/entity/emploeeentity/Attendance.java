package com.te.lms.entity.emploeeentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendanceId;
	private Integer morningAttendance;
	private Integer eveningAttendance;
	private String date;
	private Integer employeeId;

	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Attendance(Integer morningAttendance, Integer eveningAttendance, String date) {
		this.morningAttendance = morningAttendance;
		this.eveningAttendance = eveningAttendance;
		this.date = date;
	}

	public Integer getSrNo() {
		return attendanceId;
	}

	public void setSrNo(Integer srNo) {
		this.attendanceId = srNo;
	}

	public Integer getMorningAttendance() {
		return morningAttendance;
	}

	public void setMorningAttendance(Integer morningAttendance) {
		this.morningAttendance = morningAttendance;
	}

	public Integer getEveningAttendance() {
		return eveningAttendance;
	}

	public void setEveningAttendance(Integer eveningAttendance) {
		this.eveningAttendance = eveningAttendance;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
