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
public class UpdateMockRating {
	private int MockDetailsId;

	private String OverallFeedback;
	private String DetailedFeedback;

	private Integer EmployeeId;

	public int getMockDetailsId() {
		return MockDetailsId;
	}

	public void setMockDetailsId(int mockDetailsId) {
		MockDetailsId = mockDetailsId;
	}

	public String getOverallFeedback() {
		return OverallFeedback;
	}

	public void setOverallFeedback(String overallFeedback) {
		OverallFeedback = overallFeedback;
	}

	public String getDetailedFeedback() {
		return DetailedFeedback;
	}

	public void setDetailedFeedback(String detailedFeedback) {
		DetailedFeedback = detailedFeedback;
	}

	public Integer getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		EmployeeId = employeeId;
	}

}
