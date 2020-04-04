package com.sprintqa.class60;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sprintqa.utils.CommonMethods;
import com.sprintqa.utils.ConfigsReader;

class UsingScreenshotsWithSeleniumExample extends CommonMethods{

	@Test
	void test() throws InterruptedException {

		takeScreenshot("screenshots/orangehrmlive_Login_page.png");
		sendText(getWebElementById("txtUsername"), ConfigsReader.getProperty("username"));
		sendText(getWebElementById("txtPassword"), ConfigsReader.getProperty("password"));		
		
		takeScreenshot("screenshots/orangehrmlive_PopulatedLogin_page.png");
		submitForm(getWebElementById("frmLogin"));
		
		takeScreenshot("screenshots/orangehrmlive_Main_page.png");
		Thread.sleep(3000);
		
	}

}
