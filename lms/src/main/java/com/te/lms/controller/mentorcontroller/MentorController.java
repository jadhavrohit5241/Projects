package com.te.lms.controller.mentorcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.appresponse.AppResponse;
import com.te.lms.dto.batch.UpdateStatusDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.dto.employeedto.LineGraphDto;
import com.te.lms.dto.mock.AttendanceDto;
import com.te.lms.dto.mock.MockUpdateDto;
import com.te.lms.dto.mock.UpdateMockRating;
import com.te.lms.entity.batchentity.BatchDetails;
import com.te.lms.entity.batchentity.MockInfo;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;
import com.te.lms.service.mentorservice.mentorserviceinterface.MentorServiceInterface;

@RestController
@RequestMapping("/mentor")

public class MentorController {
	@Autowired
	private MentorServiceInterface mentorServiceInterface;

	@Autowired
	private AppResponse appResponse;

	@PutMapping("/updateMockRatings")
	private ResponseEntity<AppResponse> updateMockRatings(@RequestBody UpdateMockRating mockRating) {
		if (mentorServiceInterface.updateMockRatings(mockRating)) {
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@GetMapping("/dashBorad")
	private ResponseEntity<AppResponse> getDashInfo() {
		appResponse.setData(Arrays.asList(mentorServiceInterface.getDashInfo()));
		appResponse.setError(false);
		appResponse.setMsg("sucessful");
		appResponse.setStatus(200);
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
	}

	@PostMapping("/lineGraph")
	private ResponseEntity<AppResponse> lineGraphInfo(@RequestBody LineGraphDto dto) {
		appResponse.setData(Arrays.asList(mentorServiceInterface.lineGraphInfo(dto)));
		appResponse.setError(false);
		appResponse.setMsg("sucessful");
		appResponse.setStatus(200);
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
	}

	@PostMapping("/registerMock")
	private ResponseEntity<AppResponse> addData(@RequestBody MockInfo mockinfo) {
		MockInfo info = mentorServiceInterface.registerMock(mockinfo);
		if (info != null) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
			appResponse.setData(Arrays.asList(info));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
		return null;
	}

	@PutMapping("/updateMock")
	private ResponseEntity<AppResponse> update(@RequestBody MockUpdateDto mockinfo) {
		MockInfo info = mentorServiceInterface.updateMock(mockinfo);
		if (info != null) {
			appResponse.setData(Arrays.asList(info));
			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PutMapping("/updateStatus")
	private ResponseEntity<AppResponse> updateStatusDto(@RequestBody UpdateStatusDto status) {

		if (mentorServiceInterface.updateStatusDto(status)) {

			appResponse.setError(false);
			appResponse.setMsg("data updated sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/search")
	private ResponseEntity<AppResponse> search(@RequestBody FetchDto search) {
		EmployeePrimaryInfo employeeTemp = mentorServiceInterface.search(search);
		if (employeeTemp != null) {
			appResponse.setData(employeeTemp);
			appResponse.setError(false);
			appResponse.setMsg("data found");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Data not found");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@GetMapping("/getAllBatch")
	private ResponseEntity<AppResponse> getAll() {
		List<BatchDetails> list = mentorServiceInterface.getAll();
		if (list != null) {
			appResponse.setData(Arrays.asList(list));
			appResponse.setError(false);
			appResponse.setMsg("sucessful");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("not found serverunder maintanance");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PutMapping("/attendanceUpdate")
	private ResponseEntity<AppResponse> attandanceUpdate(@RequestBody AttendanceDto attendanceDto) {
		if (mentorServiceInterface.attandanceUpdate(attendanceDto)) {
			appResponse.setMsg("attendance updated");
			appResponse.setError(false);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

		else {
			appResponse.setError(true);
			appResponse.setMsg("not updated");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}
}
