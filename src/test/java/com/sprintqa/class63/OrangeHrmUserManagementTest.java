package com.sprintqa.class63;

import org.junit.jupiter.api.Test;

import com.sprintqa.pages.AddUser;
import com.sprintqa.pages.HomePage;
import com.sprintqa.pages.LoginPage;
import com.sprintqa.pages.UserManagement;
import com.sprintqa.utils.BaseTest;
import com.sprintqa.utils.Constants;
import com.sprintqa.utils.ExcelUtil;

public class OrangeHrmUserManagementTest extends BaseTest{

	@Test
	public void test() throws InterruptedException {
		
			LoginPage login = new LoginPage(getWebDriver());
			login.login("Admin", "admin123");
			Thread.sleep(2000);
			
			HomePage home = new HomePage(getWebDriver());
			home.adminMenu.click();
			Thread.sleep(3000);
			
			UserManagement userManagement = new UserManagement(getWebDriver());
			userManagement.btnAdd.click();
			
			ExcelUtil userMaintSheet = new ExcelUtil();
			userMaintSheet.openExcel(Constants.EXCELFILEPATH, "usermaint");
			
			AddUser addUser = new AddUser(getWebDriver());
			addUser.populate(userMaintSheet);

			
			Thread.sleep(3000);
			
	}
}
