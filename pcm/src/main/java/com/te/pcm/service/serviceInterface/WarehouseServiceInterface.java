package com.te.pcm.service.serviceInterface;

import java.util.List;

import com.te.pcm.dto.FetchCategoryDto;
import com.te.pcm.dto.FetchOptionDto;
import com.te.pcm.dto.FetchProductDto;
import com.te.pcm.dto.ProductDto;
import com.te.pcm.entity.Categories;
import com.te.pcm.entity.Options;
import com.te.pcm.entity.Products;

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
