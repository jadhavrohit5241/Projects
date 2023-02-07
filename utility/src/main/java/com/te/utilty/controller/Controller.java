package com.te.utilty.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.utilty.helper.ExcelExporter;
import com.te.utilty.helper.Helper;
import com.te.utilty.response.AppResponse;
import com.te.utilty.service.Service;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	private Service productService;

	@PostMapping("/product/upload")
	public ResponseEntity<AppResponse> upload(@RequestParam("file") MultipartFile file) {
		if (Helper.checkExcelFormat(file)) {
			// true
			productService.save(file);
			return ResponseEntity.ok(AppResponse.builder().status(200).msg("Data saved in DataBase")
					.timestamp(LocalDate.now().toString()).error(false).build());
		}
		return new ResponseEntity<>(AppResponse.builder().status(200).msg("Operation failed")
				.timestamp(LocalDate.now().toString()).error(true).build(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/product")
	public ResponseEntity<AppResponse> getAllProduct() {
		return new ResponseEntity<>(
				AppResponse.builder().status(200).msg("data found").timestamp(LocalDate.now().toString())
						.error(false).data(Arrays.asList(productService.getAllProducts())).build(),
				HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/exportTable/{fileName}")
	private ResponseEntity<Resource>exportTable(@PathVariable String fileName){
		
		InputStreamResource file=new InputStreamResource(ExcelExporter.productsToExcel(productService.getAllProducts()));
		return ResponseEntity.ok()
        .header("sd","attachment; filename=" + fileName+".xlsx")
        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
        .body(file);
	}	
}
