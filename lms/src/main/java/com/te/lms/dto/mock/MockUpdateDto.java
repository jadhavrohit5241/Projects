package com.te.lms.dto.mock;

import com.te.lms.entity.batchentity.MockDetails;
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

public class MockUpdateDto {
	private int mockId;
	private String technology;
	private String panel;
	private String date;
	private String time;
	private int bacthId;
	private MockDetails details;
}
