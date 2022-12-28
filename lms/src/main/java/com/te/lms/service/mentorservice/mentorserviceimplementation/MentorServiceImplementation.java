package com.te.lms.service.mentorservice.mentorserviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dto.batch.DashDto;
import com.te.lms.dto.batch.UpdateStatusDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.dto.employeedto.LineGraphDto;
import com.te.lms.dto.mock.AttendanceDto;
import com.te.lms.dto.mock.MockUpdateDto;
import com.te.lms.dto.mock.UpdateMockRating;
import com.te.lms.entity.batchentity.BatchDetails;
import com.te.lms.entity.batchentity.MockInfo;
import com.te.lms.entity.emploeeentity.Attendance;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;
import com.te.lms.exception.InvalidUserException;
import com.te.lms.exception.UserNotFoundException;
import com.te.lms.repository.AttendanceRepository;
import com.te.lms.repository.BatchRepository;
import com.te.lms.repository.EmployeeEducationInfoRepository;
import com.te.lms.repository.EmployeeExperianceInfoRepository;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.MockDetailsRepository;
import com.te.lms.repository.MockRepository;
import com.te.lms.service.mentorservice.mentorserviceinterface.MentorServiceInterface;

@Service
public class MentorServiceImplementation implements MentorServiceInterface {
	@Autowired
	private MockRepository mockRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BatchRepository batchRepository;

	@Autowired
	private EmployeeEducationInfoRepository educationInfoRepository;

	@Autowired
	private MockDetailsRepository mockDetailsRepository;

	@Autowired
	private EmployeeExperianceInfoRepository employeeExperianceInfoRepository;

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Override
	public MockInfo registerMock(MockInfo mockinfo) {
		return mockRepository.save(mockinfo);

	}

	@Override
	public MockInfo updateMock(MockUpdateDto mockinfo) {
		MockInfo mockInfoTemp = mockRepository.findById(mockinfo.getMockId()).orElse(null);
		if (mockInfoTemp != null) {
			BeanUtils.copyProperties(mockinfo, mockInfoTemp);

			return mockRepository.save(mockInfoTemp);
		} else {
			throw new InvalidUserException("MOCK ID NOT FOUND");
		}
	}

	@Override
	public boolean updateStatusDto(UpdateStatusDto status) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(status.getEmpId()).orElse(null);
		if (employeePrimaryInfo != null) {
			employeePrimaryInfo.setEmployeeStatus(status.getStatus());
			employeeRepository.save(employeePrimaryInfo);
			return true;
		} else {
			throw new InvalidUserException("INVALID USER ID ENTERED");
		}
	}

	@Override
	public List<BatchDetails> getAll() {
		return batchRepository.findAll();
	}

	@Override
	public EmployeePrimaryInfo search(FetchDto search) {
		return employeeRepository.findById(search.getEmployeeId()).orElse(null);

	}

	@Override
	public DashDto getDashInfo() {
		DashDto dashDto = new DashDto();
		dashDto.setCountOfGrnder(employeeRepository.countGender());
		dashDto.setCountOfYoe(employeeExperianceInfoRepository.countEmployeeYoe());
		dashDto.setCountOfYop(educationInfoRepository.countEmployeeYop());
		dashDto.setOfDegree(educationInfoRepository.countEmployeeDegree());
		dashDto.setMockperformance(mockDetailsRepository.countEmployeeOverallfeedback());
		return dashDto;
	}

	@Override
	public LineGraphDto lineGraphInfo(LineGraphDto dto) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(dto.getEmpId()).orElse(null);

		if (employeePrimaryInfo != null) {
			List<String> listRating = new ArrayList<String>();
			List<Integer> listMockId = new ArrayList<Integer>();
			(employeePrimaryInfo.getMockDetails()).forEach((i) -> listRating.add(i.getDetailedFeedback()));
			(employeePrimaryInfo.getMockDetails()).forEach((i) -> listMockId.add(i.getMockId()));

			List<Attendance> attendances = employeePrimaryInfo.getAttendancesList();
			dto.setTotalSessionAttend((attendances.stream()
					.filter((i) -> (i.getEmployeeId() == dto.getEmpId() && i.getEveningAttendance() == 1)).count())
					+ (attendances.stream()
							.filter((i) -> (i.getEmployeeId() == dto.getEmpId() && i.getMorningAttendance() == 1))
							.count()));
			dto.setTotalSessionHeld(
					(attendances.stream().filter((i) -> i.getEmployeeId() == dto.getEmpId()).count()) * 2);
			dto.setMockId(listMockId);
			dto.setOverAllratings(listRating);
			dto.setEmpId(employeePrimaryInfo.getEmployeeId());
			return dto;
		} else {
			throw new InvalidUserException("EMPLOYEE ID NOT FOUND");
		}
	}

	@Override
	public boolean attandanceUpdate(AttendanceDto attendanceDto) {
		EmployeePrimaryInfo info = employeeRepository.findById(attendanceDto.getEmployeeId())
				.orElseThrow(() -> new UserNotFoundException("Inavalid EmployeeId"));

		Attendance attendance = new Attendance();
		info.getAttendancesList();
		BeanUtils.copyProperties(attendanceDto, attendance);
		attendanceRepository.save(attendance);
		return true;
	}

	@Override
	public boolean updateMockRatings(UpdateMockRating mockRating) {
		return false;
	}
}

//	Attendance Logic--->
//	List<Attendance> list =info.getAttendancesList();
//	Attendance attendanceTemp=new Attendance((attendanceDto.getMorningAttendance()), (attendanceDto.getEveningAttendance()),
//	(LocalDate.now().toString()));
//	list.add(attendanceTemp);
//	info.setAttendancesList(list);
//	employeeRepository.save(info);
