package com.testapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] readExcelData(String sheetName) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(PropertyManager.getInstance().getString("test_data"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {

			book = WorkbookFactory.create(fis);

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				if ((sheet.getRow(i).getCell(j)) != null) {
					testData[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}

		}
		return testData;
	}


}
