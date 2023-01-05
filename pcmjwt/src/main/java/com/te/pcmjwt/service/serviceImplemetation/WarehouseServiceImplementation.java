package com.te.pcmjwt.service.serviceimplemetation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.pcmjwt.dto.CategoryAddDto;
import com.te.pcmjwt.dto.FetchCategoryDto;
import com.te.pcmjwt.dto.FetchOptionDto;
import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.OptionDto;
import com.te.pcmjwt.dto.ProductDto;
import com.te.pcmjwt.dto.VariationTypeDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Departments;
import com.te.pcmjwt.entity.OptionTypes;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;
import com.te.pcmjwt.entity.VariationsTypes;
import com.te.pcmjwt.exceptions.DataNotFoundException;
import com.te.pcmjwt.exceptions.InvalidUserInput;
import com.te.pcmjwt.repository.CategoriesRepository;
import com.te.pcmjwt.repository.DepartmentRepository;
import com.te.pcmjwt.repository.OptionsRepository;
import com.te.pcmjwt.repository.OptionsTypeRepository;
import com.te.pcmjwt.repository.ProductRepository;
import com.te.pcmjwt.repository.VariationTypeRepository;
import com.te.pcmjwt.service.WarehouseServiceInterface;

@Service
public class WarehouseServiceImplementation implements WarehouseServiceInterface {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private OptionsRepository optionsRepository;

	@Autowired
	private OptionsTypeRepository optionsTypeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private VariationTypeRepository variationTypeRepository;

	@Override
	public boolean addCategory(CategoryAddDto categoryDto) {
		if (categoriesRepository.findById(categoryDto.getCategoryId()).orElse(null) != null) {
			throw new InvalidUserInput("category is already present");
		} else {
			Categories categories = new Categories(categoryDto.getCategoryId(), categoryDto.getCategoryTitle(), null,
					null, null);
			Departments departments = departmentRepository.findById(categoryDto.getDepartmentId())
					.orElseThrow(() -> new InvalidUserInput("INVALID DEPARTMENT ID"));
			List<Categories> categoryList = departments.getCategoryList();
			categoryList.add(categories);
			departments.setCategoryList(categoryList);
			departmentRepository.save(departments);
			return true;
		}
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
	public boolean addOption(OptionDto options) {
		Options opt = new Options();
		BeanUtils.copyProperties(options, opt);
		OptionTypes optiontype = optionsTypeRepository.findById(options.getOptionTypeId())
				.orElseThrow(() -> new InvalidUserInput("OPTION TYPE NOT EXIST"));
		List<Options> optionsList = optiontype.getOptions();
		optionsList.add(opt);
		optionsTypeRepository.save(optiontype);
		return true;
	}

	@Override
	public boolean deleteOption(FetchOptionDto fetchOptionDto) {
		optionsRepository.findById(fetchOptionDto.getOptionId())
				.orElseThrow(() -> new InvalidUserInput("option id  not found "));
		return true;
	}

	@Override
	public boolean addVariationType(VariationTypeDto variationTypeDto) {
		VariationsTypes variationsTypes = new VariationsTypes();
		BeanUtils.copyProperties(variationTypeDto, variationsTypes);
		Categories catList = categoriesRepository.findById(variationTypeDto.getCategoryId())
				.orElseThrow(() -> new DataNotFoundException("INVALID CATEGORY_ID"));
		List<VariationsTypes> varTypes = catList.getVariationsTypes();
		varTypes.add(variationsTypes);
		try {
			categoriesRepository.save(catList);
		} catch (Exception e) {
			throw new InvalidUserInput("TYPE ALREDY EXIST");
		}
		return true;
	}

	@Override
	public VariationsTypes updateVariationType(VariationTypeDto variationTypeDto) {
		VariationsTypes variationTypeTemp = variationTypeRepository.findById(variationTypeDto.getVariationTypeId())
				.orElse(null);
		if (variationTypeTemp == null) {
			throw new InvalidUserInput("INVALID VARIATIONTYPE_ID ID");
		} else {
			variationTypeTemp.setVariationTypeTitle(variationTypeDto.getVariationTypeTitle());
			return variationTypeRepository.save(variationTypeTemp);
		}

	}

	@Override
	public boolean deleteVariationType(Integer id) {
		optionsRepository.findById(id).orElseThrow(() -> new InvalidUserInput("option id  not found "));
		return true;
	}

	@Override
	public boolean addProduct(ProductDto productDto) {

		/**
		 * Departments dept =
		 * departmentRepository.findById(productDto.getDepartmentId()).orElseThrow(() ->
		 * new DataNotFoundException("INVALID DEPARTMENTID")); Categories categories =
		 * categoriesRepository.findById(productDto.getCategoryId()).orElseThrow(() ->
		 * new DataNotFoundException("INVALID CAT_ID")); VariationsTypes variationsTypes
		 * =
		 * variationTypeRepository.findById(productDto.getVariationTypeId()).orElseThrow(()
		 * -> new DataNotFoundException("INVALID VARIATIONTYPE_ID")); OptionTypes
		 * optionTypes =
		 * optionsTypeRepository.findById(productDto.getOptionTypeId()).orElseThrow(()
		 * -> new DataNotFoundException("INVALID OPTION TYPE_ID")); Products products =
		 * Products.builder().productTitle(productDto.getProductTitle())
		 * .categories(categories).departments(dept).productVariations(productDto.getProductVariations())
		 * .optionTypes(optionTypes).variationsTypes(variationsTypes).build();
		 * productRepository.save(products);
		 **/

		Products products = new Products();
		products.setDepartments(departmentRepository.findById(productDto.getDepartmentId())
				.orElseThrow(() -> new DataNotFoundException("INVALID DEPARTMENTID")));
		products.setCategories(categoriesRepository.findById(productDto.getCategoryId()).orElseThrow(() ->
		new DataNotFoundException("INVALID CAT_ID")));
		products.setOptionTypes(optionsTypeRepository.findById(productDto.getOptionTypeId()).orElseThrow(()
				 -> new DataNotFoundException("INVALID OPTION TYPE_ID")));
		products.setVariationsTypes(variationTypeRepository.findById(productDto.getVariationTypeId()).orElseThrow(()
				 -> new DataNotFoundException("INVALID VARIATIONTYPE_ID")));
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

}
