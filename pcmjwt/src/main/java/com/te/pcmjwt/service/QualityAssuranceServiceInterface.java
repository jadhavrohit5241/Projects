package com.te.pcmjwt.service;

import java.util.Date;
import java.util.List;

import com.te.pcmjwt.dto.FetchProductDto;
import com.te.pcmjwt.dto.UpdateReportDto;
import com.te.pcmjwt.entity.Categories;
import com.te.pcmjwt.entity.Options;
import com.te.pcmjwt.entity.Products;

public interface QualityAssuranceServiceInterface {

	Products updateReport(UpdateReportDto reportDto);

	List<Products> getAllProduct();

	Products getProduct(FetchProductDto fetchDto);

	List<Categories> getAllCategories();

	List<Options> getAllOpstions();

	List<Products> getexpriedProducts(Date expiryDate);

}
