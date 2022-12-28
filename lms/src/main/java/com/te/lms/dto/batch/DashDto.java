package com.te.lms.dto.batch;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor

public class DashDto {

	private List<Long> countOfGender;
	private List<Long> countOfYop;
	private List<Long> countOfYoe;
	private String degree;
	private List<Long> mockPerformance;

	public List<Long> getCountOfGrnder() {
		return countOfGender;
	}

	public void setCountOfGrnder(List<Long> countOfGrnder) {
		this.countOfGender = countOfGrnder;
	}

	public List<Long> getCountOfYop() {
		return countOfYop;
	}

	public void setCountOfYop(List<Long> countOfYop) {
		this.countOfYop = countOfYop;
	}

	public List<Long> getCountOfYoe() {
		return countOfYoe;
	}

	public void setCountOfYoe(List<Long> countOfYoe) {
		this.countOfYoe = countOfYoe;
	}

	public String getOfDegree() {
		return degree;
	}

	public void setOfDegree(String ofDegree) {
		degree = ofDegree;
	}

	public List<Long> getMockperformance() {
		return mockPerformance;
	}

	public void setMockperformance(List<Long> mockperformance) {
		mockPerformance = mockperformance;
	}

}
