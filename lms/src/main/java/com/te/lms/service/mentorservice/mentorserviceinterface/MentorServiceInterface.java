package com.te.lms.service.mentorservice.mentorserviceinterface;

import java.util.List;

import com.te.lms.dto.batch.DashDto;
import com.te.lms.dto.batch.UpdateStatusDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.dto.employeedto.LineGraphDto;
import com.te.lms.dto.mock.AttendanceDto;
import com.te.lms.dto.mock.MockUpdateDto;
import com.te.lms.dto.mock.UpdateMockRating;
import com.te.lms.entity.batchentity.BatchDetails;
import com.te.lms.entity.batchentity.MockInfo;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;

public interface MentorServiceInterface {

	MockInfo updateMock(MockUpdateDto mockinfo);

	MockInfo registerMock(MockInfo mockinfo);

	boolean updateStatusDto(UpdateStatusDto status);

	EmployeePrimaryInfo search(FetchDto search);

	List<BatchDetails> getAll();

	DashDto getDashInfo();

	LineGraphDto lineGraphInfo(LineGraphDto dto);

	boolean updateMockRatings(UpdateMockRating mockRating);

	boolean attandanceUpdate(AttendanceDto attendanceDto);

}
