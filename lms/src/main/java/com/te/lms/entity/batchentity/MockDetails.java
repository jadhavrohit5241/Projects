package com.te.lms.entity.batchentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MockDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mockDetailsId;
	private String mockType;
	private String mockTakenBy;
	private String technologies;
	private String parcticalKnowledege;
	private String theoreticalKnowledege;
	private String overallFeedback;
	private String detailedFeedback;

	private Integer mockId;

	public Integer getMockDetailsId() {
		return mockDetailsId;
	}

	public void setMockDetailsId(Integer mockDetailsId) {
		this.mockDetailsId = mockDetailsId;
	}

	public String getMockType() {
		return mockType;
	}

	public void setMockType(String mockType) {
		this.mockType = mockType;
	}

	public String getMockTakenBy() {
		return mockTakenBy;
	}

	public void setMockTakenBy(String mockTakenBy) {
		this.mockTakenBy = mockTakenBy;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getParcticalKnowledege() {
		return parcticalKnowledege;
	}

	public void setParcticalKnowledege(String parcticalKnowledege) {
		this.parcticalKnowledege = parcticalKnowledege;
	}

	public String getTheoreticalKnowledege() {
		return theoreticalKnowledege;
	}

	public void setTheoreticalKnowledege(String theoreticalKnowledege) {
		this.theoreticalKnowledege = theoreticalKnowledege;
	}

	public String getOverallFeedback() {
		return overallFeedback;
	}

	public void setOverallFeedback(String overallFeedback) {
		this.overallFeedback = overallFeedback;
	}

	public String getDetailedFeedback() {
		return detailedFeedback;
	}

	public void setDetailedFeedback(String detailedFeedback) {
		this.detailedFeedback = detailedFeedback;
	}

	public Integer getMockId() {
		return mockId;
	}

	public void setMockId(Integer mockId) {
		this.mockId = mockId;
	}

}
