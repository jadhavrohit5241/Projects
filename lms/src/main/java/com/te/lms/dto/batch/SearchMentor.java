package com.te.lms.dto.batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter

public class SearchMentor {

	private int mentorDetailsId;
	private int employeeId;

	public int getMentorDetailsId() {
		return mentorDetailsId;
	}

	public void setMentorDetailsId(int mentorDetailsId) {
		this.mentorDetailsId = mentorDetailsId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
