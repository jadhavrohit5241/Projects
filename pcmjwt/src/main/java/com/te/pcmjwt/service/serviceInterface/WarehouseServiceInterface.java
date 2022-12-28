package com.te.pcmjwt.service.serviceInterface;

import java.util.List;

import com.te.pcmjwt.dto.FetchCategoryDto;
import com.te.pcmjwt.dto.FetchOptionDto;
import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.ProductDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;

public interface WarehouseServiceInterface {

	boolean addProduct(ProductDto productDto);

	Products getProduct(FetchProductDto productDto);

	boolean deleteProduct(FetchProductDto fetchDto);

	List<Products> getAllProduct();

	boolean addCategory(Categories categories);

	List<Categories> getAllCategories();

	boolean deleteCategory(FetchCategoryDto fetchCategoryDto);

	List<Options> getAllOpstions();

	boolean addOption(Options options);

	boolean deleteOption(FetchOptionDto fetchOptionDto);

	
}
