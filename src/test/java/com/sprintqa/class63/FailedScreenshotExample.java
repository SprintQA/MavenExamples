package com.sprintqa.class63;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.sprintqa.utils.CommonMethods;
import com.sprintqa.utils.ConfigsReader;

class FailedScreenshotExample extends CommonMethods {

	@Test
	void test() throws InterruptedException {
		try {
			
			takeScreenshot2("screenshots/orangehrmlive_Login_page.png");
			sendText(getWebElementById("txtUsername"), ConfigsReader.getProperty("username"));
			sendText(getWebElementById("txtPassword"), ConfigsReader.getProperty("password"));

			takeScreenshot2("screenshots/orangehrmlive_PopulatedLogin_page.png");
			submitForm(getWebElementById("frmLogin"));

			takeScreenshot2("screenshots/orangehrmlive_Main_page.png");
			Thread.sleep(3000);
		
		} catch (IOException ioe) {
			fail(ioe.getMessage());
		}
	}

}
