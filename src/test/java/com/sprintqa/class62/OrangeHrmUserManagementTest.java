package com.sprintqa.class62;

import org.junit.jupiter.api.Test;

import com.sprintqa.pages.HomePage;
import com.sprintqa.pages.LoginPage;
import com.sprintqa.utils.BaseTest;

public class OrangeHrmUserManagementTest extends BaseTest{

	@Test
	public void test() throws InterruptedException {
			LoginPage login = new LoginPage(getWebDriver());
			login.login("Admin", "admin123");
			Thread.sleep(2000);
			
			HomePage home = new HomePage(getWebDriver());
			home.adminMenu.click();
			Thread.sleep(3000);
			
	}
}
