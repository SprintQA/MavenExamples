package com.sprintqa.class61;

import org.junit.jupiter.api.Test;

import com.sprintqa.utils.CommonMethods;
import com.sprintqa.utils.Constants;
import com.sprintqa.utils.ExcelUtil;

class ExcelUtilExample extends CommonMethods{

	@Test
	void test() throws InterruptedException {
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.openExcel(Constants.EXCELFILEPATH, "login");
		
		sendText(getWebElementById("txtUsername"), excelUtil.getCellData(1, 0));
		sendText(getWebElementById("txtPassword"), excelUtil.getCellData(1, 1));

		Thread.sleep(1000);
		
		submitForm(getWebElementById("frmLogin"));
		
		Thread.sleep(3000);
		
	}

}
