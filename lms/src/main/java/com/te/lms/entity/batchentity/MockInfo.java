package com.te.lms.entity.batchentity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class MockInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mockId;
	private String technology;
	private String panel;
	private String date;
	private String time;

	@OneToOne(targetEntity = MockDetails.class, cascade = CascadeType.ALL)
	private MockDetails details;

	public int getMockId() {
		return mockId;
	}

	public void setMockId(int mockNo) {
		this.mockId = mockNo;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public MockDetails getDetails() {
		return details;
	}

	public void setDetails(MockDetails details) {
		this.details = details;
	}
}
