
package com.te.lms.service.adminservice.adminserviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dto.batch.FetchBatchDto;
import com.te.lms.dto.batch.RequestDto;
import com.te.lms.dto.batch.SearchMentor;
import com.te.lms.dto.employeedto.EmpGetAllDto;
import com.te.lms.dto.employeedto.EmpUpdateDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.entity.batchentity.BatchDetails;
import com.te.lms.entity.batchentity.MentorDetails;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;
import com.te.lms.exception.BatchDeleteException;
import com.te.lms.exception.BatchEditException;
import com.te.lms.exception.InvalidUserException;
import com.te.lms.repository.BatchRepository;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.MentorDetailsRepository;
import com.te.lms.service.adminservice.adminserviceinterface.AdminServiceInterface;

@Service
public class AdminServiceImplemantion implements AdminServiceInterface {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BatchRepository batchRepository;

	@Autowired
	private MentorDetailsRepository mentorDetailsRepository;

	@Override
	public EmployeePrimaryInfo register(EmployeePrimaryInfo employeePrimaryInfo) {

		employeePrimaryInfo.setEmployeePass(employeePrimaryInfo.getEmployeeName() + otp());
		return employeeRepository.save(employeePrimaryInfo);
	}

	@Override
	public EmployeePrimaryInfo update(EmpUpdateDto empUpdateDto) {
		EmployeePrimaryInfo employeeTemp = employeeRepository.findById(empUpdateDto.getEmployeeId()).orElse(null);
		if (employeeTemp != null) {
			BeanUtils.copyProperties(empUpdateDto, employeeTemp);
			return employeeRepository.save(employeeTemp);
		} else {
			throw new InvalidUserException("Invalid Input");
		}
	}

	@Override
	public boolean delete(FetchDto deleteDto) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(deleteDto.getEmployeeId()).orElse(null);
		if (employeePrimaryInfo != null) {
			employeeRepository.deleteById(employeePrimaryInfo.getEmployeeId());
			return true;
		} else {

			throw new InvalidUserException("Inavalid id");
		}
	}

	@Override
	public EmployeePrimaryInfo search(FetchDto search) {
		return employeeRepository.findById(search.getEmployeeId()).orElse(null);

	}

	@Override
	public BatchDetails registerBatch(BatchDetails batchDetails) {
		return batchRepository.save(batchDetails);
	}

	@Override
	public BatchDetails updateBatch(BatchDetails batchDetails) {
		BatchDetails batchDetailsTemp = batchRepository.findById(batchDetails.getBatchId()).orElse(null);
		if (batchDetailsTemp != null) {
			BeanUtils.copyProperties(batchDetails, batchDetailsTemp);
			batchRepository.save(batchDetailsTemp);
			return batchDetailsTemp;
		} else {
			throw new BatchEditException("Enter valid BatchID");
		}
	}

	@Override
	public boolean deleteBatch(FetchBatchDto fetchBatchDto) {
		BatchDetails batchDetails = batchRepository.findById(fetchBatchDto.getBatchId()).orElse(null);
		if (batchDetails != null) {
			batchRepository.deleteById(batchDetails.getBatchId());
			return true;
		} else {
			throw new BatchDeleteException("Invalid batchId");
		}
	}

	@Override
	public BatchDetails searchBatch(FetchBatchDto search) {
		BatchDetails batchDetails = batchRepository.findById(search.getBatchId()).orElse(null);
		if (batchDetails != null) {
			return batchDetails;
		} else {
			throw new BatchDeleteException("Invalid batchId");
		}
	}

	@Override
	public boolean deleteRequest(RequestDto requestDto) {
		EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.findById(requestDto.getEmpId()).orElse(null);
		if (employeePrimaryInfo != null) {
			employeeRepository.deleteById(employeePrimaryInfo.getEmployeeId());
			return true;
		} else {
			throw new BatchDeleteException("Invalid batchId");
		}
	}

	@Override
	public List<EmpGetAllDto> getAll() {
		List<EmployeePrimaryInfo> employeePrimaryInfos = employeeRepository.findAll();
		List<EmpGetAllDto> getAll = new ArrayList<EmpGetAllDto>();
		employeePrimaryInfos.forEach((i) -> getAll.add(new EmpGetAllDto(i.getEmployeeId(), i.getEmployeeName(),
				i.getEmployeeEmailId(), i.getEmployeeStatus(), i.getEmployeeRole())));
		return getAll;
	}

	@Override
	public Boolean manageMentor(MentorDetails mentorDetails) {
		if (employeeRepository.findById(mentorDetails.getEmployeeId()).orElse(null) != null) {
			mentorDetailsRepository.save(mentorDetails);
			return true;
		} else {
			throw new InvalidUserException("Mentor Id not found");
		}
	}

	@Override
	public MentorDetails updateMentor(MentorDetails mentorDetails) {
		MentorDetails details = mentorDetailsRepository.findById(mentorDetails.getMentorDetailsId()).orElse(null);
		if (details != null) {
			BeanUtils.copyProperties(mentorDetails, details);
			mentorDetailsRepository.save(details);
			return details;
		} else {
			throw new InvalidUserException("Mentor Id not found");
		}
	}

	@Override
	public MentorDetails searchMentor(SearchMentor searchMentor) {
		return mentorDetailsRepository.findById(searchMentor.getMentorDetailsId()).orElse(null);
	}

	public static int otp() {
		double det = 99999999 * Math.random() + 99999999;
		int res1 = (int) det;
		return res1;

	}

}
