package com.te.lms.controller.admincontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.lms.appresponse.AppResponse;
import com.te.lms.dto.batch.FetchBatchDto;
import com.te.lms.dto.batch.RequestDto;
import com.te.lms.dto.batch.SearchMentor;
import com.te.lms.dto.employeedto.EmpGetAllDto;
import com.te.lms.dto.employeedto.EmpUpdateDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.entity.batchentity.BatchDetails;
import com.te.lms.entity.batchentity.MentorDetails;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;
import com.te.lms.service.adminservice.adminserviceinterface.AdminServiceInterface;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AppResponse appResponse;

	@Autowired
	private AdminServiceInterface adminServiceInterface;

	@PostMapping("/adminRequest")
	private ResponseEntity<AppResponse> adminRequest(@RequestBody RequestDto requestDto) {
		if (requestDto.getRequest()) {
			// add update role
			appResponse.setData(requestDto);
			appResponse.setError(false);
			appResponse.setMsg("request Accepted");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			if (adminServiceInterface.deleteRequest(requestDto)) {

				appResponse.setError(false);
				appResponse.setMsg("request rejected and data deleted successfully");
				appResponse.setStatus(200);
				return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

			} else {
				appResponse.setError(true);
				appResponse.setMsg("request rejected but server not responding  ");
				appResponse.setStatus(200);
				return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
			}
		}
	}

	@GetMapping("/getAll")
	private ResponseEntity<AppResponse> getAll() {
		List<EmpGetAllDto> list = adminServiceInterface.getAll();
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

	@PostMapping("/register")
	private ResponseEntity<AppResponse> addData(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeePrimaryInfo employeePrimaryInfoTemp = adminServiceInterface.register(employeePrimaryInfo);
		if (employeePrimaryInfoTemp != null) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
			appResponse.setData(Arrays.asList(employeePrimaryInfoTemp));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
		return null;
	}

	@PutMapping("/update")
	private ResponseEntity<AppResponse> update(@RequestBody EmpUpdateDto empUpdateDto) {
		EmployeePrimaryInfo employePrimaryInfo = adminServiceInterface.update(empUpdateDto);
		if (employePrimaryInfo != null) {
			appResponse.setData(Arrays.asList(employePrimaryInfo));
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

	@DeleteMapping("/delete")
	private ResponseEntity<AppResponse> delete(@RequestBody FetchDto deleteDto) {
		if (adminServiceInterface.delete(deleteDto)) {
			appResponse.setError(false);
			appResponse.setMsg("data deleted sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(400);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/search")
	private ResponseEntity<AppResponse> search(@RequestBody FetchDto search) {
		EmployeePrimaryInfo employeeTemp = adminServiceInterface.search(search);
		if (employeeTemp != null) {
			appResponse.setData(employeeTemp);
			appResponse.setError(false);
			appResponse.setMsg("data deleted sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/registerBatch")
	private ResponseEntity<AppResponse> addBatch(@RequestBody BatchDetails batchDetails) {
		BatchDetails batchDetailsTemp = adminServiceInterface.registerBatch(batchDetails);
		if (batchDetailsTemp != null) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
			appResponse.setData(Arrays.asList(batchDetailsTemp));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PutMapping("/updateBatch")
	private ResponseEntity<AppResponse> updateBatch(@RequestBody BatchDetails batchDetails) {
		BatchDetails batchDetailsTemp = adminServiceInterface.updateBatch(batchDetails);
		if (batchDetailsTemp != null) {
			appResponse.setData(Arrays.asList(batchDetailsTemp));
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

	@DeleteMapping("/deleteBatch")
	private ResponseEntity<AppResponse> deleteBatch(@RequestBody FetchBatchDto fetchBatchDto) {
		if (adminServiceInterface.deleteBatch(fetchBatchDto)) {
			appResponse.setError(false);
			appResponse.setMsg("data deleted sucessfully");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful deletion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/searchBatch")
	private ResponseEntity<AppResponse> searchBatch(@RequestBody FetchBatchDto search) {
		BatchDetails batchDetails = adminServiceInterface.searchBatch(search);
		if (batchDetails != null) {
			appResponse.setData(batchDetails);
			appResponse.setError(false);
			appResponse.setMsg("data found");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("data not found");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PostMapping("/manageMentor")
	private ResponseEntity<AppResponse> manageMentor(@RequestBody MentorDetails mentorDetails) {
		if (adminServiceInterface.manageMentor(mentorDetails)) {
			appResponse.setError(false);
			appResponse.setMsg("successful");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMsg("Unsuccessful insertion");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}

	@PutMapping("/updateMentor")
	private ResponseEntity<AppResponse> updateMentor(@RequestBody MentorDetails mentorDetails) {
		MentorDetails details = adminServiceInterface.updateMentor(mentorDetails);
		if (details != null) {
			appResponse.setData(Arrays.asList(details));
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

	@PutMapping("/searchMentor")
	private ResponseEntity<AppResponse> searchMentor(@RequestBody SearchMentor searchMentor) {
		MentorDetails details = adminServiceInterface.searchMentor(searchMentor);
		if (details != null) {
			appResponse.setData(Arrays.asList(details));
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

}
