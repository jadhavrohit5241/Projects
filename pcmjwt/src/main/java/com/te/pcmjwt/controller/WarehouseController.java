package com.te.pcmjwt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcmjwt.appresponse.AppResponse;
import com.te.pcmjwt.dto.CategoryAddDto;
import com.te.pcmjwt.dto.FetchCategoryDto;
import com.te.pcmjwt.dto.FetchOptionDto;
import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.OptionDto;
import com.te.pcmjwt.dto.VariationTypeDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;
import com.te.pcmjwt.entity.VariationsTypes;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.service.WarehouseServiceInterface;

@RestController
@RequestMapping(path = "/auth/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseServiceInterface warehouseServiceInterface;

	@PostMapping("/addVariationType")
	private ResponseEntity<AppResponse> addVariationType(@RequestBody VariationTypeDto variationTypeDto) {

		if (warehouseServiceInterface.addVariationType(variationTypeDto)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).msg("DATA ADDED SUCCESSFULLY").build(),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).msg("DATA INSERTION FAILED ").build(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateVariationType")
	private ResponseEntity<AppResponse> updateVariationType(@RequestBody VariationTypeDto variationTypeDto) {
	VariationsTypes variationsTypes=warehouseServiceInterface.updateVariationType(variationTypeDto);
		if (true) {
			return new ResponseEntity<>(AppResponse.builder().error(false).msg("UPDATED").data(Arrays.asList(variationsTypes)).build(),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(AppResponse.builder().error(true).msg("DATA INSERTION FAILED").build(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteVariationType")
	private ResponseEntity<AppResponse> deleteVariationType(@RequestParam Integer id) {

		if (warehouseServiceInterface.deleteVariationType(id)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("variationType deleted").build(),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}
	
	
	@PostMapping("/addProduct")
	private ResponseEntity<AppResponse> addProduct(@RequestBody Products productDto) {

		if (warehouseServiceInterface.addProduct(productDto)) {
			return new ResponseEntity<>(
					new AppResponse(false, 200, "Data entered successful", Arrays.asList(productDto)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("Invalid data Entered");
	}

	@GetMapping("/getAllProduct")
	private ResponseEntity<AppResponse> getAllProduct() {
		List<Products> productList = warehouseServiceInterface.getAllProduct();
		if (productList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("Operation successful")
					.data(Arrays.asList(productList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("Product Not found").build(),
					HttpStatus.ACCEPTED);

		}
	}

	@PostMapping("/getProduct")
	private ResponseEntity<AppResponse> getProduct(@RequestBody FetchProductDto fetchDto) {
		Products productsTemp = warehouseServiceInterface.getProduct(fetchDto);
		if (productsTemp != null) {
			return new ResponseEntity<>(
					new AppResponse(false, 200, "data found successful", Arrays.asList(productsTemp)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered");
	}

	@DeleteMapping("/deleteProduct")
	private ResponseEntity<AppResponse> deleteProduct(@RequestBody FetchProductDto fetchDto) {

		if (warehouseServiceInterface.deleteProduct(fetchDto)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("product deleted").build(),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("Invalid Data Entered ");
	}

	@DeleteMapping("/deleteCategory")
	private ResponseEntity<AppResponse> deleteCategory(@RequestBody FetchCategoryDto fetchCategoryDto) {

		if (warehouseServiceInterface.deleteCategory(fetchCategoryDto)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("Category deleted").build(),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@PostMapping("/addCategory")
	private ResponseEntity<AppResponse> addProduct(@RequestBody CategoryAddDto categories) {

		if (warehouseServiceInterface.addCategory(categories)) {
			return new ResponseEntity<>(
					new AppResponse(false, 200, "data entered successful", Arrays.asList(categories)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllCategories")
	private ResponseEntity<AppResponse> getAllCategories() {
		List<Categories> allCategoriesList = warehouseServiceInterface.getAllCategories();
		if (allCategoriesList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("operation successful")
					.data(Arrays.asList(allCategoriesList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).build(), HttpStatus.ACCEPTED);

		}
	}

	@DeleteMapping("/deleteOption")
	private ResponseEntity<AppResponse> deleteOption(@RequestBody FetchOptionDto fetchOptionDto) {

		if (warehouseServiceInterface.deleteOption(fetchOptionDto)) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("Option is deleted").build(),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@PostMapping("/addOption")
	private ResponseEntity<AppResponse> addProduct(@RequestBody OptionDto option) {

		if (warehouseServiceInterface.addOption(option)) {
			return new ResponseEntity<>(new AppResponse(false, 200, "data entered successful", Arrays.asList(option)),
					HttpStatus.ACCEPTED);
		}
		throw new InvalidUserInput("invalid data entered ");
	}

	@GetMapping("/getAllOptions")
	private ResponseEntity<AppResponse> getAllOptions() {
		List<Options> allOptionList = warehouseServiceInterface.getAllOpstions();
		if (allOptionList != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).msg("operation successful")
					.data(Arrays.asList(allOptionList)).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(false).status(200).build(), HttpStatus.ACCEPTED);

		}
	}
}
