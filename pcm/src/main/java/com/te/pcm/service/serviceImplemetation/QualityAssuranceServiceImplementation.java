package com.te.pcm.service.serviceImplemetation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.pcm.dto.FetchProductDto;
import com.te.pcm.dto.UpdateReportDto;
import com.te.pcm.entity.Categories;
import com.te.pcm.entity.Options;
import com.te.pcm.entity.Products;
import com.te.pcm.exceptions.DataNotFoundException;
import com.te.pcm.repository.CategoriesRepository;
import com.te.pcm.repository.OptionsRepository;
import com.te.pcm.repository.ProductRepository;
import com.te.pcm.service.serviceInterface.QualityAssuranceServiceInterface;

@Service
public class QualityAssuranceServiceImplementation implements QualityAssuranceServiceInterface {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private OptionsRepository optionsRepository;

	@Override
	public Products updateReport(UpdateReportDto reportDto) {
		Products products = productRepository.findById(reportDto.getProductId())
				.orElseThrow(() -> new DataNotFoundException("invalid product id"));
		products.setProductsQualityReport(reportDto.getProductReport());
		products.setProductTotalStock(reportDto.getProductTotalStock());
		productRepository.save(products);
		return products;

	}

	@Override
	public Products getProduct(FetchProductDto productDto) {
		return productRepository.findById(productDto.getProductId())
				.orElseThrow(() -> new DataNotFoundException("User Entered inavalid Product Id"));
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
	public List<Categories> getAllCategories() {
		List<Categories> tempList = categoriesRepository.findAll();
		if (tempList.isEmpty()) {
			throw new DataNotFoundException("data not found");
		}
		return tempList;
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
	public List<Products> getexpriedProducts(Date expiryDate) {
		List<Products> list = productRepository.findAll().stream()
				.filter((i) -> i.getExpDate().before(expiryDate))
				.collect(Collectors.toList());
		return list;
	}

}
