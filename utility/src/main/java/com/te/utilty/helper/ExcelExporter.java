package com.te.utilty.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.te.utilty.entity.Product;

public class ExcelExporter {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "ProductName", "Description", "Price" };
	static String SHEET = "Products";

	public static ByteArrayInputStream productsToExcel(List<Product> products) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (Product product : products) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(product.getProductId());
				row.createCell(0).setCellValue(product.getProductName());
				row.createCell(1).setCellValue(product.getProductDesc());
				row.createCell(2).setCellValue(product.getProductPrice());

			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
			
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}
}

/*
 * private XSSFWorkbook workbook; private XSSFSheet sheet; private List<Product>
 * listProduct;
 * 
 * public ExcelExporter(List<Product> listProduct) { this.listProduct =
 * listProduct; workbook = new XSSFWorkbook(); }
 * 
 * private void writeHeaderLine() { sheet = workbook.createSheet("Products");
 * 
 * Row row = sheet.createRow(0);
 * 
 * CellStyle style = workbook.createCellStyle(); XSSFFont font =
 * workbook.createFont(); font.setBold(true); font.setFontHeight(16);
 * style.setFont(font);
 * 
 * createCell(row, 0, "PRODUCT ID", style); createCell(row, 1, "PRODUCR NAME",
 * style); createCell(row, 2, "PRODUCT DESC", style); createCell(row, 3,
 * "PRODUCT PRICE", style); }
 * 
 * private void createCell(Row row, int columnCount, Object value, CellStyle
 * style) { sheet.autoSizeColumn(columnCount); Cell cell =
 * row.createCell(columnCount); if (value instanceof Integer) {
 * cell.setCellValue((Integer) value); } else { cell.setCellValue((String)
 * value); } }
 * 
 * private void writeDataLines() { int rowCount = 1;
 * 
 * CellStyle style = workbook.createCellStyle(); XSSFFont font =
 * workbook.createFont(); font.setFontHeight(14); style.setFont(font);
 * 
 * for (Product product : listProduct) { Row row = sheet.createRow(rowCount++);
 * int columnCount = 0;
 * 
 * createCell(row, columnCount++, product.getProductId(), style);
 * createCell(row, columnCount++, product.getProductName(), style);
 * createCell(row, columnCount++, product.getProductDesc(), style);
 * createCell(row, columnCount++, product.getProductPrice(), style); } }
 * 
 * public Byte[] getContentInByte() { writeHeaderLine(); writeDataLines();
 * 
 * return new Byte; }
 * 
 * public void export(HttpServletResponse response) throws IOException {
 * writeHeaderLine(); writeDataLines(); OutPutS ServletOutputStream outputStream
 * = response.getOutputStream(); workbook.write(outputStream); workbook.close();
 * 
 * outputStream.close();
 * 
 * }
 */