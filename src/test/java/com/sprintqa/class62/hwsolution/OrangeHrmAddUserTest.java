package com.sprintqa.class62.hwsolution;

import org.junit.jupiter.api.Test;

import com.sprintqa.pages.AddUser;
import com.sprintqa.pages.HomePage;
import com.sprintqa.pages.LoginPage;
import com.sprintqa.pages.UserManagement;
import com.sprintqa.utils.BaseTest;
import com.sprintqa.utils.Constants;
import com.sprintqa.utils.ExcelUtil;

public class OrangeHrmAddUserTest extends BaseTest {

	/**
	 * Requires a new PageObject Class: AddUserPage
	 * 
	 * Login and verify the menu bar is loaded. Click Admin Click Add Button Add
	 * User Click Save Verify the user is in table
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void addUserWithPageObjectTest() throws InterruptedException {
		// Instantiate new ExcelUtil class
		ExcelUtil loginSheet = new ExcelUtil();

		// Open the Excel workbook "src/test/resources/testdata/OrangeHrmData.xlsx"
		// and load the work sheet login.
		loginSheet.openExcel(Constants.EXCELFILEPATH, "login");

		// Use LoginPOM to login to site
		LoginPage login = new LoginPage(getWebDriver());
		login.login(loginSheet.getCellData(1, 0), loginSheet.getCellData(1, 1));
		Thread.sleep(1000);

		// Use HomePOM to navigate to User Management page
		HomePage home = new HomePage(getWebDriver());
		home.adminMenu.click();
		Thread.sleep(1000);

		// Use UserManagementPOM to navigate to AddUSer page 
		UserManagement userManagement = new UserManagement(getWebDriver());
		userManagement.btnAdd.click();
		Thread.sleep(1000);

		// Open the Excel workbook "src/test/resources/testdata/OrangeHrmData.xlsx"
		// and load the work sheet useMaint.
		ExcelUtil userMaintSheet = new ExcelUtil();
		userMaintSheet.openExcel(Constants.EXCELFILEPATH, "usermaint");

		// Use AddUserPOM to populate user and save 
		AddUser addUser = new AddUser(getWebDriver());
		addUser.populate(userMaintSheet);
		addUser.saveBtn.click();		
		Thread.sleep(1000);
		
		// Use UserManagementPOM to verify AddUser added the user to the list
		userManagement = new UserManagement(getWebDriver());
		userManagement.isUserNameInTable(userMaintSheet.getCellData(1, 2));
		
	}
}
