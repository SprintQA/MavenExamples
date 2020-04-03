package com.sprintqa.class62;

import org.junit.jupiter.api.Test;

import com.sprintqa.pages.HomePage;
import com.sprintqa.pages.LoginPage;
import com.sprintqa.utils.CommonMethods;

public class OrangeHrmUserManagementTest extends CommonMethods{

	@Test
	public void test() throws InterruptedException {
			LoginPage login = new LoginPage(webDriver);
			login.login("Admin", "admin123");
			Thread.sleep(2000);
			
			HomePage home = new HomePage(webDriver);
			home.adminMenu.click();
			Thread.sleep(3000);
			
	}
}
