package com.te.pcm.service.serviceImplemetation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.pcm.dto.FetchCategoryDto;
import com.te.pcm.dto.FetchOptionDto;
import com.te.pcm.dto.FetchProductDto;
import com.te.pcm.dto.ProductDto;
import com.te.pcm.entity.Categories;
import com.te.pcm.entity.Options;
import com.te.pcm.entity.Products;
import com.te.pcm.exceptions.DataNotFoundException;
import com.te.pcm.exceptions.InvalidUserInput;
import com.te.pcm.repository.CategoriesRepository;
import com.te.pcm.repository.OptionsRepository;
import com.te.pcm.repository.ProductRepository;
import com.te.pcm.service.serviceInterface.WarehouseServiceInterface;

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
