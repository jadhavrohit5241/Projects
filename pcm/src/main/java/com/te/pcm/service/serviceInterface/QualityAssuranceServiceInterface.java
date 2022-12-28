package com.te.pcm.service.serviceInterface;

import java.util.Date;
import java.util.List;

import com.te.pcm.dto.FetchProductDto;
import com.te.pcm.dto.UpdateReportDto;
import com.te.pcm.entity.Categories;
import com.te.pcm.entity.Options;
import com.te.pcm.entity.Products;

public interface QualityAssuranceServiceInterface {

	Products updateReport(UpdateReportDto reportDto);

	List<Products> getAllProduct();

	Products getProduct(FetchProductDto fetchDto);

	List<Categories> getAllCategories();

	List<Options> getAllOpstions();

	List<Products> getexpriedProducts(Date expiryDate);

}
