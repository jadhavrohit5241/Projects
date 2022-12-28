package com.te.pcm.controller;

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

import com.te.pcm.appResponse.AppResponse;
import com.te.pcm.dto.ExpiryDateDto;
import com.te.pcm.dto.FetchProductDto;
import com.te.pcm.dto.UpdateReportDto;
import com.te.pcm.entity.Categories;
import com.te.pcm.entity.Options;
import com.te.pcm.entity.Products;
import com.te.pcm.exceptions.InvalidUserInput;
import com.te.pcm.service.serviceInterface.QualityAssuranceServiceInterface;

@RestController
@RequestMapping(path = "/auth/qualityAssurance")
public class QualityAssuranceController {

	@Autowired
	private QualityAssuranceServiceInterface assuranceServiceInterface;

	@PostMapping("/updateReport")
	private ResponseEntity<AppResponse> updateReport(@RequestBody UpdateReportDto reportDto) {
		Products products = assuranceServiceInterface.updateReport(reportDto);
		if (products != null) {
			return new ResponseEntity<AppResponse>(
					new AppResponse(false, 200, "data entered successful", Arrays.asList(products)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllProduct")
	private ResponseEntity<AppResponse> getAllProduct() {
		List<Products> productList = assuranceServiceInterface.getAllProduct();
		if (productList != null) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().error(false).Status(200).msg("operation successful").build(),
					HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().error(false).Status(200).msg("product deleted").build(), HttpStatus.ACCEPTED);

		}
	}

	@PostMapping("/getProduct")
	private ResponseEntity<AppResponse> getProduct(@RequestBody FetchProductDto fetchDto) {
		Products productsTemp = assuranceServiceInterface.getProduct(fetchDto);
		if (productsTemp != null) {
			return new ResponseEntity<AppResponse>(
					new AppResponse(false, 200, "data found successful", Arrays.asList(productsTemp)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered");
	}

	@GetMapping("/getAllCategories")
	private ResponseEntity<AppResponse> getAllCategories() {
		List<Categories> AllCategoriesList = assuranceServiceInterface.getAllCategories();
		if (AllCategoriesList != null) {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200)
					.msg("operation successful").data(Arrays.asList(AllCategoriesList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200).build(),
					HttpStatus.ACCEPTED);

		}
	}

	@GetMapping("/getAllOptions")
	private ResponseEntity<AppResponse> getAllOptions() {
		List<Options> AllOptionList = assuranceServiceInterface.getAllOpstions();
		if (AllOptionList != null) {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200)
					.msg("operation successful").data(Arrays.asList(AllOptionList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200).build(),
					HttpStatus.ACCEPTED);

		}
	}

	@PostMapping("/expriedProducts")
	private ResponseEntity<AppResponse> expriedProducts(@RequestBody ExpiryDateDto dateDto) {
		List<Products> productsList = assuranceServiceInterface.getexpriedProducts(dateDto.getExpiryDate());
		if (productsList.isEmpty()) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().error(true).Status(505).msg("DATA NOT AVAILABLE").build(),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200).msg("DATA FOUND")
				.data(Arrays.asList(productsList)).build(), HttpStatus.ACCEPTED);

	}

}
