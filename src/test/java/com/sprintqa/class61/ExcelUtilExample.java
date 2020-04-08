package com.sprintqa.class61;

import org.junit.jupiter.api.Test;

import com.sprintqa.utils.BaseTest;
import com.sprintqa.utils.Constants;
import com.sprintqa.utils.ExcelUtil;

class ExcelUtilExample extends BaseTest {

	/**
	 * Example using test data loaded from an Excel Spreadsheet
	 * 
	 * @throws InterruptedException
	 */
	@Test
	void excelUtilTest() throws InterruptedException {
		// Instantiate new ExcelUtil class
		ExcelUtil loginSheet = new ExcelUtil();

		// Open the Excel workbook "src/test/resources/testdata/OrangeHrmData.xlsx"
		// and load the work sheet login.
		loginSheet.openExcel(Constants.EXCELFILEPATH, "login");

		// Remember to user the row/column index of a cell starting at 0.
		// To get user name we need to get the data from Row 2 / Column A
		sendText(getWebElementById("txtUsername"), loginSheet.getCellData(1, 0));

		// To get user name we need to get the data from Row 2 / Column B
		sendText(getWebElementById("txtPassword"), loginSheet.getCellData(1, 1));

		// Pause to see inputs
		Thread.sleep(1000);

		// Click the login button
		submitForm(getWebElementById("frmLogin"));

		// Use this for how work assignment
		ExcelUtil userMaintSheet = new ExcelUtil();
		userMaintSheet.openExcel(Constants.EXCELFILEPATH, "usermaint");

	}

}
