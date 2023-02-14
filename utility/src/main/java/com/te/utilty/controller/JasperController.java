package com.te.utilty.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.utilty.entity.JasperEmployeeEntitiy;
import com.te.utilty.response.AppResponse;
import com.te.utilty.service.JasperEmployeeService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/jasper")
public class JasperController {

	@Autowired
	private JasperEmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<AppResponse> addEmployee(@RequestBody JasperEmployeeEntitiy employeeEntitiy) {
		return ResponseEntity.ok(
				AppResponse.builder().status(200).msg("Data saved in DataBase").timestamp(LocalDate.now().toString())
						.error(false).data(employeeService.addEmployee(employeeEntitiy)).build());
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<AppResponse> getAllProduct() {
		return new ResponseEntity<>(AppResponse.builder().status(200).msg("data found")
				.timestamp(LocalDate.now().toString()).error(false).data(employeeService.getAllProducts()).build(),
				HttpStatus.OK);
	}

	@GetMapping("/getEmployee/{employeeId}")
	private ResponseEntity<AppResponse> exportTable(@PathVariable Integer employeeId) {
		return ResponseEntity.ok(AppResponse.builder().data(employeeService.getEmployee(employeeId)).status(200)
				.error(false).timestamp(LocalDate.now().toString()).build());
	}

	@GetMapping("/exportTable/{reportFormat}")
	private ResponseEntity<AppResponse> exportTable(@PathVariable String reportFormat) throws Exception, JRException {
		return ResponseEntity.ok(AppResponse.builder().data(employeeService.exportReport(reportFormat)).status(200)
				.error(false).timestamp(LocalDate.now().toString()).build());
	}

}

//InputStreamResource file=new InputStreamResource(ExcelExporter.productsToExcel(productService.getAllProducts()));
//return ResponseEntity.ok()
//.header("sd","attachment; filename=" + fileName+".xlsx")
//.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//.body(file);
