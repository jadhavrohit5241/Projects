package com.te.lms.service.adminservice.adminserviceinterface;

import java.util.List;

import com.te.lms.dto.batch.FetchBatchDto;
import com.te.lms.dto.batch.RequestDto;
import com.te.lms.dto.batch.SearchMentor;
import com.te.lms.dto.employeedto.EmpGetAllDto;
import com.te.lms.dto.employeedto.EmpUpdateDto;
import com.te.lms.dto.employeedto.FetchDto;
import com.te.lms.entity.batchentity.BatchDetails;
import com.te.lms.entity.batchentity.MentorDetails;
import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;

public interface AdminServiceInterface {

	EmployeePrimaryInfo register(EmployeePrimaryInfo employeePrimaryInfo);

	EmployeePrimaryInfo update(EmpUpdateDto empUpdateDto);

	boolean delete(FetchDto deleteDto);

	EmployeePrimaryInfo search(FetchDto search);

	BatchDetails registerBatch(BatchDetails batchDetails);

	BatchDetails updateBatch(BatchDetails batchDetails);

	boolean deleteBatch(FetchBatchDto fetchBatchDto);

	BatchDetails searchBatch(FetchBatchDto search);

	boolean deleteRequest(RequestDto requestDto);

	List<EmpGetAllDto> getAll();

	Boolean manageMentor(MentorDetails mentorDetails);

	MentorDetails updateMentor(MentorDetails mentorDetails);

	MentorDetails searchMentor(SearchMentor searchMentor);

}
