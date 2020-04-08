package com.sprintqa.class60;

import org.junit.jupiter.api.Test;

import com.sprintqa.utils.BaseTest;
import com.sprintqa.utils.ConfigsReader;

/**
 * Example using common methods to populate input fields.
 * Testing Maven build environment
 * @author mpmeloche
 *
 */
class UsingScreenshotsWithSeleniumExample extends BaseTest{

	@Test
	void test() throws InterruptedException {
		
		takeScreenShot("screenshots/orangehrmlive_Login_page.png");
		sendText(getWebElementById("txtUsername"), ConfigsReader.getProperty("username"));
		sendText(getWebElementById("txtPassword"), ConfigsReader.getProperty("password"));		
		
		takeScreenShot("screenshots/orangehrmlive_PopulatedLogin_page.png");
		submitForm(getWebElementById("frmLogin"));
		
		takeScreenShot("screenshots/orangehrmlive_Main_page.png");
		Thread.sleep(3000);
		
	}

}
