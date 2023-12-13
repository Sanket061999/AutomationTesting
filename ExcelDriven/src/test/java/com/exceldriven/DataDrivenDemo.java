package com.exceldriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenDemo {

	// We are Printing Row using Specific column name and row name

	public static void main(String[] args) throws IOException {
		String sheetName = "testSheet";
		String columnName = "testCases";
		String rowName = "Purchase";
		List<String> data=getData(sheetName, columnName, rowName);
		System.out.println(data);
		System.out.println(getData(sheetName, columnName, "Login"));
	}

	public static List<String> getData(String sheetName, String columnName, String rowName) throws IOException {
		
		List<String> list = new ArrayList<String>();
		// It accept FileInputStream object
		FileInputStream fis = new FileInputStream("C://Selenium_Practice//ExcelDriven//demo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;

		// Go to specific sheet
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				sheet = workbook.getSheetAt(i);
				// Indentifying the sheet column name by scanning the first row
				Iterator<Row> rows = sheet.iterator();// sheet having collection of rows

				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					
					Cell cellValue = ce.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase(columnName)) {
						// After getting column the search for specific row
						column = k;
					}
					k++;
				}
				// column is identified and now we will iterate it all the row in specific
				// column

				while (rows.hasNext()) {
					Row r = rows.next();
					String cellValue = r.getCell(column).getStringCellValue();
					if (cellValue.equalsIgnoreCase(rowName)) {
						// We already got column now we got its row as well
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {							
							Cell c =cv.next();
							//An cell contain different types of data like string or integer
							if(c.getCellTypeEnum()==CellType.STRING) {
							list.add(c.getStringCellValue());
							}else {
								
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}

			}

		}
		return list;
	}

}
