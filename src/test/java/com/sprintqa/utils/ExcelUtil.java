package com.sprintqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	public void openExcel(String xlFilePath, String sheetName) {

		try {
			
			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public String getCellData(int rowIndex, int colIndex) {
		return sheet
				.getRow(rowIndex)
				.getCell(colIndex)
				.toString();
	}

	public int getNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int getNumberOfColumns(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

}
