package com.te.utilty.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.te.utilty.entity.JasperEmployeeEntitiy;
import com.te.utilty.repository.JasperEmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class JasperEmployeeService {

	@Autowired
	private JasperEmployeeRepository employeeRepository;
	
	@Autowired
	private DataSource dataSource;

	public JasperEmployeeEntitiy getEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	public List<JasperEmployeeEntitiy> getAllProducts() {
		return employeeRepository.findAll();
	}

	public JasperEmployeeEntitiy addEmployee(JasperEmployeeEntitiy employeeEntitiy) {
		return employeeRepository.save(employeeEntitiy);
	}

//	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
//		String path = "C:\\Users\\HP\\OneDrive\\Desktop\\result";
//		List<JasperEmployeeEntitiy> listOfEmpoyees = employeeRepository.findAll();
//		File file = ResourceUtils.getFile("classpath:employees.jrxml");
//		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listOfEmpoyees);
//		Map<String, Object> mapParameter = new HashMap<>();
//		mapParameter.put("createdBy", "rohit");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapParameter, beanCollectionDataSource);
//		if (reportFormat.equalsIgnoreCase("html")) {
//			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.html");
//			}
//		if (reportFormat.equalsIgnoreCase("pdf")) {
//			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
//		} 
//		return "REPOET GENERATED IN PATH  "+ path ;
//	}
//	

	public String exportReport(String reportFormat) throws FileNotFoundException, JRException, SQLException {
		String path = "C:\\Users\\HP\\OneDrive\\Desktop\\result";
		File file = ResourceUtils.getFile("classpath:Demo_template2.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		Map<String, Object> mapParameter = new HashMap<>();
		mapParameter.put("createdBy", "rohit");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapParameter,dataSource.getConnection());
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.html");
			}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
		} 
		return "REPOET GENERATED IN PATH  "+ path ;
	}

}