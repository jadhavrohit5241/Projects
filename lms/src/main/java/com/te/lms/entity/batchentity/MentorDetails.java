package com.te.lms.entity.batchentity;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MentorDetails {
	@Id
	private int mentorDetailsId;
	private String mentorName;
	private int employeeId;
	private String emailId;
	private String skill;

	public int getMentorDetailsId() {
		return mentorDetailsId;
	}

	public void setMentorDetailsId(int mentorDetailsId) {
		this.mentorDetailsId = mentorDetailsId;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
}
