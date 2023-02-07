package com.te.utilty.service;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.te.utilty.entity.Product;
import com.te.utilty.helper.Helper;
import com.te.utilty.repository.ProductRepository;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private ProductRepository productRepo;

	public void save(MultipartFile file) {
		List<Product> dbList = productRepo.findAll();
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				Boolean var = true;
				for (Product producttemp : dbList) {
					if (producttemp.getProductName().equalsIgnoreCase(t)) {
						var = false;
					}
				}
				return var;
			}
		};

		try {
			List<Product> newProducts = Helper.convertExcelToListOfProduct(file.getInputStream());
			dbList.addAll(newProducts.stream().distinct().filter((i) -> predicate.test(i.getProductName()))
					.collect(Collectors.toList()));
			System.out.println(dbList);
			if (!dbList.isEmpty()) {
				productRepo.saveAll(dbList);
			} else {
				productRepo.saveAll(newProducts);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}

}

//public void save(MultipartFile file) {
//	
//	
//    try {
//        List<Product> products = Helper.convertExcelToListOfProduct(file.getInputStream());
//        List<Product> persentList = productRepo.findAll();
//        if (persentList.isEmpty()) {
//        	productRepo.saveAll(products);
//		}else {
//			
//			
//		}
//        
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//}