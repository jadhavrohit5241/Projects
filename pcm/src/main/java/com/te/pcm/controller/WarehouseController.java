package com.te.pcm.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcm.appResponse.AppResponse;
import com.te.pcm.dto.FetchCategoryDto;
import com.te.pcm.dto.FetchOptionDto;
import com.te.pcm.dto.FetchProductDto;
import com.te.pcm.dto.ProductDto;
import com.te.pcm.entity.Categories;
import com.te.pcm.entity.Options;
import com.te.pcm.entity.Products;
import com.te.pcm.exceptions.InvalidUserInput;
import com.te.pcm.service.serviceInterface.WarehouseServiceInterface;

@RestController
@RequestMapping(path = "/auth/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseServiceInterface warehouseServiceInterface;

	@PostMapping("/addProduct")
	private ResponseEntity<AppResponse> addProduct(@RequestBody ProductDto productDto) {

		if (warehouseServiceInterface.addProduct(productDto)) {
			return new ResponseEntity<AppResponse>(
					new AppResponse(false, 200, "data entered successful", Arrays.asList(productDto)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllProduct")
	private ResponseEntity<AppResponse> getAllProduct() {
		List<Products> productList = warehouseServiceInterface.getAllProduct();
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
		Products productsTemp = warehouseServiceInterface.getProduct(fetchDto);
		if (productsTemp != null) {
			return new ResponseEntity<AppResponse>(
					new AppResponse(false, 200, "data found successful", Arrays.asList(productsTemp)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered");
	}

	@DeleteMapping("/deleteProduct")
	private ResponseEntity<AppResponse> deleteProduct(@RequestBody FetchProductDto fetchDto) {

		if (warehouseServiceInterface.deleteProduct(fetchDto)) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().error(false).Status(200).msg("product deleted").build(), HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@DeleteMapping("/deleteCategory")
	private ResponseEntity<AppResponse> deleteCategory(@RequestBody FetchCategoryDto fetchCategoryDto) {

		if (warehouseServiceInterface.deleteCategory(fetchCategoryDto)) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().error(false).Status(200).msg("product deleted").build(), HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@PostMapping("/addCategory")
	private ResponseEntity<AppResponse> addProduct(@RequestBody Categories categories) {

		if (warehouseServiceInterface.addCategory(categories)) {
			return new ResponseEntity<AppResponse>(
					new AppResponse(false, 200, "data entered successful", Arrays.asList(categories)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllCategories")
	private ResponseEntity<AppResponse> getAllCategories() {
		List<Categories> AllCategoriesList = warehouseServiceInterface.getAllCategories();
		if (AllCategoriesList != null) {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200)
					.msg("operation successful").data(Arrays.asList(AllCategoriesList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200).build(),
					HttpStatus.ACCEPTED);

		}
	}

	@DeleteMapping("/deleteOption")
	private ResponseEntity<AppResponse> deleteOption(@RequestBody FetchOptionDto fetchOptionDto) {

		if (warehouseServiceInterface.deleteOption(fetchOptionDto)) {
			return new ResponseEntity<AppResponse>(
					AppResponse.builder().error(false).Status(200).msg("product deleted").build(), HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@PostMapping("/addOption")
	private ResponseEntity<AppResponse> addProduct(@RequestBody Options options) {

		if (warehouseServiceInterface.addOption(options)) {
			return new ResponseEntity<AppResponse>(
					new AppResponse(false, 200, "data entered successful", Arrays.asList(options)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllOptions")
	private ResponseEntity<AppResponse> getAllOptions() {
		List<Options> AllOptionList = warehouseServiceInterface.getAllOpstions();
		if (AllOptionList != null) {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200)
					.msg("operation successful").data(Arrays.asList(AllOptionList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<AppResponse>(AppResponse.builder().error(false).Status(200).build(),
					HttpStatus.ACCEPTED);

		}
	}
}
