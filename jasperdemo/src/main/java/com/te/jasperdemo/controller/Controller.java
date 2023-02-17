package com.te.jasperdemo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.jasperdemo.entity.CustomerInfo;
import com.te.jasperdemo.entity.Product;
import com.te.jasperdemo.response.AppResponse;
import com.te.jasperdemo.service.JasperService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/jasper")
public class Controller {

	@Autowired
	private JasperService employeeService;

	@PostMapping("/addProduct")
	public ResponseEntity<AppResponse> addProdcut(@RequestBody Product product) {
		return ResponseEntity.ok(AppResponse.builder().status(200).msg("Data saved in DataBase")
				.timestamp(LocalDate.now().toString()).error(false).data(employeeService.addProdcut(product)).build());
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<AppResponse> addCustomer(@RequestBody CustomerInfo customerInfo) {
		return ResponseEntity.ok(
				AppResponse.builder().status(200).msg("Data saved in DataBase").timestamp(LocalDate.now().toString())
						.error(false).data(employeeService.addCustomer(customerInfo)).build());
	}

	@PostMapping("/addOrder/{customerId}/{productId}/{orderID}")
	public ResponseEntity<AppResponse> addCustomer(@PathVariable String customerId, @PathVariable String productId,
			@PathVariable String orderID) {
		return ResponseEntity.ok(
				AppResponse.builder().status(200).msg("Data saved in DataBase").timestamp(LocalDate.now().toString())
						.error(false).data(employeeService.addOrder(customerId, productId, orderID)).build());
	}

	@GetMapping("/downloadPdf/{reportFormat}")
	private ResponseEntity<Resource> exportTable(@PathVariable String reportFormat) throws Exception, JRException {
		return ResponseEntity.ok().header("download pdf", "orderdetails.pdf").contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(employeeService.downloadReport(reportFormat)));
	}

	@GetMapping("/sortAndDownload/{order}")
	private ResponseEntity<Resource> sortAndDownload(@PathVariable String order) throws Exception, JRException {
		return ResponseEntity.ok().header("download pdf", "orderdetails.pdf").contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(employeeService.sortAndDownload(order)));
	}
}

//InputStreamResource file=new InputStreamResource(ExcelExporter.productsToExcel(productService.getAllProducts()));
//return ResponseEntity.ok()
//.header("sd","attachment; filename=" + fileName+".xlsx")
//.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//.body(file);
