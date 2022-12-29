package com.te.pcmjwt.service.serviceimplemetation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.pcmjwt.dto.FetchCategoryDto;
import com.te.pcmjwt.dto.FetchOptionDto;
import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.ProductDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;
import com.te.pcmjwt.exceptions.DataNotFoundException;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.repository.CategoriesRepository;
import com.te.pcmjwt.repository.OptionsRepository;
import com.te.pcmjwt.repository.ProductRepository;
import com.te.pcmjwt.service.WarehouseServiceInterface;

@Service
public class WarehouseServiceImplementation implements WarehouseServiceInterface {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private OptionsRepository optionsRepository;

	@Override
	public boolean addProduct(ProductDto productDto) {
		Products products = new Products();
		BeanUtils.copyProperties(productDto, products);
		productRepository.save(products);
		return true;
	}

	@Override
	public Products getProduct(FetchProductDto productDto) {
		return productRepository.findById(productDto.getProductId())
				.orElseThrow(() -> new DataNotFoundException("User Entered inavalid Product Id"));
	}

	@Override
	public boolean deleteProduct(FetchProductDto fetchDto) {
		boolean result = true;
		try {
			productRepository.deleteById(fetchDto.getProductId());
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public List<Products> getAllProduct() {
		List<Products> tempList = productRepository.findAll();
		if (tempList.isEmpty()) {
			throw new DataNotFoundException("data not found");
		}
		return tempList;
	}

	@Override
	public boolean addCategory(Categories categories) {
		categoriesRepository.save(categories);
		return true;
	}

	@Override
	public List<Categories> getAllCategories() {
		List<Categories> tempList = categoriesRepository.findAll();
		if (tempList.isEmpty()) {
			throw new DataNotFoundException("data not found");
		}
		return tempList;
	}

	@Override
	public boolean deleteCategory(FetchCategoryDto fetchCategoryDto) {

		Categories categories = categoriesRepository.findById(fetchCategoryDto.getCategoryId())
				.orElseThrow(() -> new DataNotFoundException("User Entered inavalid Category Id"));
		categoriesRepository.deleteById(categories.getCatagoryId());
		return true;
	}

	@Override
	public List<Options> getAllOpstions() {

		List<Options> tempList = optionsRepository.findAll();
		if (tempList.isEmpty()) {
			throw new DataNotFoundException("data not found");
		}
		return tempList;
	}

	@Override
	public boolean addOption(Options options) {
		optionsRepository.save(options);
		return true;
	}

	@Override
	public boolean deleteOption(FetchOptionDto fetchOptionDto) {
		optionsRepository.findById(fetchOptionDto.getOptionId())
				.orElseThrow(() -> new InvalidUserInput("option id  not found "));
		return true;
	}

}
