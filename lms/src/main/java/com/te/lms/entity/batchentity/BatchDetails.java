package com.te.lms.entity.batchentity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.te.lms.entity.emploeeentity.EmployeePrimaryInfo;

import lombok.Data;

@Data
@Entity
public class BatchDetails {

	@Id
	private Integer batchId;
	private String batchName;
	private String mentorName;
	private String technologies;
	private String startDate;
	private String endDate;
	private String status;
	
	@OneToOne(targetEntity = MockInfo.class, cascade = CascadeType.ALL)
	private MockInfo info;
	
	@OneToMany(targetEntity = EmployeePrimaryInfo.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "foreign_keyList", referencedColumnName = "batchId")
	private List<EmployeePrimaryInfo>employeePrimaryInfos;


//	@OneToMany(targetEntity = EmployeePrimaryInfo.class ,cascade = CascadeType.ALL)
//	
//	public List<EmployeePrimaryInfo> getList() {
//		return employeePrimaryInfo;
//	}
//
//	public void setList(List<EmployeePrimaryInfo> list) {
//		this.employeePrimaryInfo = list;
//	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MockInfo getInfo() {
		return info;
	}

	public void setInfo(MockInfo info) {
		this.info = info;
	}
//
//	public List<EmployeePrimaryInfo> getEmployeePrimaryInfo() {
//		return employeePrimaryInfo;
//	}
//
//	public void setEmployeePrimaryInfo(List<EmployeePrimaryInfo> employeePrimaryInfo) {
//		this.employeePrimaryInfo = employeePrimaryInfo;
//	}

	public List<EmployeePrimaryInfo> getEmployeePrimaryInfos() {
		return employeePrimaryInfos;
	}

	public void setEmployeePrimaryInfos(List<EmployeePrimaryInfo> employeePrimaryInfos) {
		this.employeePrimaryInfos = employeePrimaryInfos;
	}
}
