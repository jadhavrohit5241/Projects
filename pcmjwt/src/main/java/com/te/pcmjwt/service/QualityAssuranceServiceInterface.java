<<<<<<< HEAD:pcmjwt/src/main/java/com/te/pcmjwt/service/QualityAssuranceServiceInterface.java
package com.te.pcmjwt.service;
=======
package com.te.pcmjwt.service.serviceinterface;
>>>>>>> e6387db5ba6721c91b187c2dd7f4a5327ea6ffa4:pcmjwt/src/main/java/com/te/pcmjwt/service/serviceInterface/QualityAssuranceServiceInterface.java

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
