package com.te.jasperdemo.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.te.jasperdemo.entity.CustomerInfo;
import com.te.jasperdemo.entity.OrderInfo;
import com.te.jasperdemo.entity.Product;
import com.te.jasperdemo.repository.CustomerInfoRepository;
import com.te.jasperdemo.repository.OrderInfoRepository;
import com.te.jasperdemo.repository.ProductRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class JasperService {

	@Autowired
	private CustomerInfoRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderInfoRepository orderInfoRepository;

	@Autowired
	private DataSource dataSource;

	final static String PATH = "C:\\Users\\HP\\OneDrive\\Desktop\\result";
	
	public Object addProdcut(Product product) {
		return productRepository.save(product);
	}

	public Object addCustomer(CustomerInfo customerInfo) {
		return customerRepository.save(customerInfo);
	}

	public Object addOrder(String customerId, String productId, String orderID) {
		OrderInfo build = OrderInfo.builder().orderId(orderID).timestamp(LocalDate.now().toString())
				.customerInfos(new ArrayList<>()).products(new ArrayList<>()).build();
		CustomerInfo customerInfo = customerRepository.findById(customerId).get();
		Product product = productRepository.findById(productId).get();
		customerInfo.getOrderInfos().add(build);
		product.getOrderInfos().add(build);
		build.getProducts().add(product);
		build.getCustomerInfos().add(customerInfo);
		return orderInfoRepository.save(build);
	}

	public Object exportReport(String reportFormat) throws Exception {
		File file = ResourceUtils.getFile("classpath:allorder.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		Map<String, Object> mapParameter = new HashMap<>();
		mapParameter.put("createdBy", "rohit");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapParameter, dataSource.getConnection());
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, PATH + "\\order.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, PATH + "\\order.pdf");
		}
		return "REPOET GENERATED IN PATH  " + PATH;
	}

	public InputStream downloadReport(String reportFormat) throws Exception {
		byte[] exportReportToPdf = null;
		File file = ResourceUtils.getFile("classpath:allorder.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		Map<String, Object> mapParameter = new HashMap<>();
		mapParameter.put("createdBy", "rohit");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapParameter, dataSource.getConnection());
		if (reportFormat.equalsIgnoreCase("pdf")) {
			exportReportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);
		}
		InputStream inputStream = new ByteArrayInputStream(exportReportToPdf);
		return inputStream;
	}

	public InputStream sortAndDownload(String order) throws Exception {
		byte[] exportReportToPdf = null;
		Map<String, Object>   staticmMap = new HashMap<>();
		staticmMap.put("name", "jasperdemo.product.product_name");
		staticmMap.put("id", "jasperdemo.product.product_id");
		staticmMap.put("price", "jasperdemo.product.product_price");
		File file = ResourceUtils.getFile("classpath:allorder.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		Map<String, Object> mapParameter = new HashMap<>();
		mapParameter.put("createdBy", "name of emp");
		mapParameter.put("ORDERBY", order);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapParameter, dataSource.getConnection());
		exportReportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);
		InputStream inputStream = new ByteArrayInputStream(exportReportToPdf);
		return inputStream;
	}

//	public String exportReport(String reportFormat) throws FileNotFoundException, JRException, SQLException {
//		String path = "C:\\Users\\HP\\OneDrive\\Desktop\\result";
//		File file = ResourceUtils.getFile("classpath:Demo_template2.jrxml");
//		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//		Map<String, Object> mapParameter = new HashMap<>();
//		mapParameter.put("createdBy", "rohit");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapParameter,dataSource.getConnection());
//		if (reportFormat.equalsIgnoreCase("html")) {
//			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.html");
//			}
//		if (reportFormat.equalsIgnoreCase("pdf")) {
//			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
//		} 
//		return "REPOET GENERATED IN PATH  "+ path ;
//	}

}