package com.te.lms.dto.mock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class AttendanceDto {
	private Integer employeeId;
	private Integer morningAttendance;
	private Integer eveningAttendance;
	private String date;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
