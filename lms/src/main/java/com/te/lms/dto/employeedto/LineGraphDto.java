package com.te.lms.dto.employeedto;

import java.util.List;
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

public class LineGraphDto {
	private List<Integer> mockId;
	private List<String> OverAllratings;
	private Long totalSessionHeld;
	private Long totalSessionAttend;
	private Integer EmpId;

	public Long getTotalSessionHeld() {
		return totalSessionHeld;
	}

	public void setTotalSessionHeld(Long totalSessionHeld) {
		this.totalSessionHeld = totalSessionHeld;
	}

	public List<Integer> getMockId() {
		return mockId;
	}

	public void setMockId(List<Integer> mockId) {
		this.mockId = mockId;
	}

	public List<String> getOverAllratings() {
		return OverAllratings;
	}

	public void setOverAllratings(List<String> overAllratings) {
		OverAllratings = overAllratings;
	}

	public Long getTotalSessionAttend() {
		return totalSessionAttend;
	}

	public void setTotalSessionAttend(Long totalSessionAttend) {
		this.totalSessionAttend = totalSessionAttend;
	}

	public Integer getEmpId() {
		return EmpId;
	}

	public void setEmpId(Integer empId) {
		EmpId = empId;
	}

}
