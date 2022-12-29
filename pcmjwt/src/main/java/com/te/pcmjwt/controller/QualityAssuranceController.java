package com.te.pcmjwt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcmjwt.appresponse.AppResponse;
import com.te.pcmjwt.dto.ExpiryDateDto;
import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.UpdateReportDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.service.QualityAssuranceServiceInterface;

@RestController
@RequestMapping(path = "/auth/qualityAssurance")
public class QualityAssuranceController {

	@Autowired
	private QualityAssuranceServiceInterface assuranceServiceInterface;

	@PostMapping("/updateReport")
	private ResponseEntity<AppResponse> updateReport(@RequestBody UpdateReportDto reportDto) {
		Products products = assuranceServiceInterface.updateReport(reportDto);
		if (products != null) {
			return new ResponseEntity<>(
					new AppResponse(false, 200, "data entered successful", Arrays.asList(products)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllProduct")
	private ResponseEntity<AppResponse> getAllProduct() {
		List<Products> productList = assuranceServiceInterface.getAllProduct();
		if (productList != null) {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).status(200).msg("operation successful").build(),
					HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(
					AppResponse.builder().error(false).status(200).msg("product deleted").build(), HttpStatus.ACCEPTED);

		}
	}

	@PostMapping("/getProduct")
	private ResponseEntity<AppResponse> getProduct(@RequestBody FetchProductDto fetchDto) {
		Products productsTemp = assuranceServiceInterface.getProduct(fetchDto);
		if (productsTemp != null) {
			return new ResponseEntity<>(
					new AppResponse(false, 200, "data found successful", Arrays.asList(productsTemp)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered");
	}

	@GetMapping("/getAllCategories")
	private ResponseEntity<AppResponse> getAllCategories() {
		List<Categories> allCategoriesList = assuranceServiceInterface.getAllCategories();
		if (allCategoriesList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200)
					.msg("operation successful").data(Arrays.asList(allCategoriesList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).build(),
					HttpStatus.ACCEPTED);

		}
	}

	@GetMapping("/getAllOptions")
	private ResponseEntity<AppResponse> getAllOptions() {
		List<Options> allOptionList = assuranceServiceInterface.getAllOpstions();
		if (allOptionList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200)
					.msg("operation successful").data(Arrays.asList(allOptionList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).build(),
					HttpStatus.ACCEPTED);

		}
	}

	@PostMapping("/expriedProducts")
	private ResponseEntity<AppResponse> expriedProducts(@RequestBody ExpiryDateDto dateDto) {
		List<Products> productsList = assuranceServiceInterface.getexpriedProducts(dateDto.getExpiryDate());
		if (productsList.isEmpty()) {
			return new ResponseEntity<>(
					AppResponse.builder().error(true).status(505).msg("DATA NOT AVAILABLE").build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("DATA FOUND")
				.data(Arrays.asList(productsList)).build(), HttpStatus.ACCEPTED);

	}

}
