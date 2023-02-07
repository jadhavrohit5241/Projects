package com.te.utilty.helper;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.te.utilty.entity.Product;

public class Helper {
	public static boolean checkExcelFormat(MultipartFile file) {
		if (file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		return false;

	}

	// convert excel to list of products

	public static List<Product> convertExcelToListOfProduct(InputStream is) {
		List<Product> list = Lists.newArrayList();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);

			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;

				Product p = new Product();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						p.setProductId((int) cell.getNumericCellValue());
						break;
					case 1:
						p.setProductName(cell.getStringCellValue());
						break;
					case 2:
						p.setProductDesc(cell.getStringCellValue());
						break;
					case 3:
						p.setProductPrice(cell.getNumericCellValue());
						break;
					default:
						break;
					}
					cid++;

				}

				list.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
