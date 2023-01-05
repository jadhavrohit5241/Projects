package com.te.pcmjwt.service;

import java.util.List;

import com.te.pcmjwt.dto.CategoryAddDto;
import com.te.pcmjwt.dto.FetchCategoryDto;
import com.te.pcmjwt.dto.FetchOptionDto;
import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.OptionDto;
import com.te.pcmjwt.dto.ProductDto;
import com.te.pcmjwt.dto.VariationTypeDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;
import com.te.pcmjwt.entity.VariationsTypes;

public interface WarehouseServiceInterface {

	boolean addProduct(ProductDto productDto);

	Products getProduct(FetchProductDto productDto);

	boolean deleteProduct(FetchProductDto fetchDto);

	List<Products> getAllProduct();

	boolean addCategory(CategoryAddDto categories);

	List<Categories> getAllCategories();

	boolean deleteCategory(FetchCategoryDto fetchCategoryDto);

	List<Options> getAllOpstions();

	boolean addOption(OptionDto options);

	boolean deleteOption(FetchOptionDto fetchOptionDto);

	boolean addVariationType(VariationTypeDto variationTypeDto);

	VariationsTypes updateVariationType(VariationTypeDto variationTypeDto);

	boolean deleteVariationType(Integer id);

}
