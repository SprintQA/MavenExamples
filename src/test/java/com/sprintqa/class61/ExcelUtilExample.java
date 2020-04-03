package com.sprintqa.class61;

import org.junit.jupiter.api.Test;

import com.sprintqa.utils.CommonMethods;
import com.sprintqa.utils.Constants;
import com.sprintqa.utils.ExcelUtil;

class ExcelUtilExample extends CommonMethods{

	@Test
	void test() throws InterruptedException {
		ExcelUtil loginSheet = new ExcelUtil();
		loginSheet.openExcel(Constants.EXCELFILEPATH, "login");
		
		sendText(getWebElementById("txtUsername"), loginSheet.getCellData(1, 0));
		sendText(getWebElementById("txtPassword"), loginSheet.getCellData(1, 1));

		Thread.sleep(1000);
		
		submitForm(getWebElementById("frmLogin"));
		
		
		ExcelUtil userMaintSheet = new ExcelUtil();
		userMaintSheet.openExcel(Constants.EXCELFILEPATH, "usermaint");
		
		
		
		
		Thread.sleep(3000);
		
	}

}
