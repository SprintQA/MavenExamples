package com.sprintqa.class62;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sprintqa.pages.LoginPage;
import com.sprintqa.utils.BaseTest;

public class LoginPageExample extends BaseTest{

	@Test
	public void test() throws InterruptedException {
		
		LoginPage login = new LoginPage(getWebDriver());
		
		
		WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
		
		wait.until(ExpectedConditions.visibilityOf(login.logo));
		
		login.login("Admin", "admin123");
		
		Thread.sleep(3000);
		
	}
	
	
}
