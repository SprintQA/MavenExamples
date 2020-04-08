package com.sprintqa.class61.hwsolution;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sprintqa.utils.BaseTest;
import com.sprintqa.utils.Constants;
import com.sprintqa.utils.ExcelUtil;

class UserManagementAddUserTest extends BaseTest {

	/**
	 * Add a new ESS User to Orange HRM Data
	 * 
	 * 1. Login with Excel Test Data
	 * 
	 * 2. Go to the Admin -> User Management -> Users page
	 * 
	 * 3. Click the "Add" button to open the "Add User" page.
	 * 
	 * 4. Populate Add user from Excel Test Data
	 * 
	 * 5. Make sure you Prefix the test data for username with your name. I.E
	 * "Michael" + jsmith
	 * 
	 * 6. Click Save Button.
	 * 
	 * 7. Verify new User is in the user's table.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	void userManagementAddUserTest() throws InterruptedException {
		// 1. Login with Excel Test Data
		// Instantiate new ExcelUtil class
		ExcelUtil loginSheet = new ExcelUtil();

		// Open the Excel workbook "src/test/resources/testdata/OrangeHrmData.xlsx"
		// and load the work sheet login.
		loginSheet.openExcel(Constants.EXCELFILEPATH, "login");

		// Remember to user the row/column index of a cell starting at 0.
		// To get user name we need to get the data from Row 2 / Column A
		sendText(getWebElementById("txtUsername"), loginSheet.getCellData(1, 0));

		// To get user name we need to get the data from Row 2 / Column B
		sendText(getWebElementById("txtPassword"), loginSheet.getCellData(1, 1));

		// Pause to see inputs
		Thread.sleep(1000);

		// Click the login button
		submitForm(getWebElementById("frmLogin"));

		// Mixing implicit & Explicit waits is causing a load timeout issue
		// Waiting for the css to load, so we need to add a hard pause for 1 sec
		Thread.sleep(1000);

		// 2. Go to the Admin -> User Management -> Users page
		waitForPresenceOfElementLocated(By.id("menu_admin_viewAdminModule"), 30);
		getWebElementById("menu_admin_viewAdminModule").click();
		
		// 3. Click the "Add" button to open the "Add User" page.
		waitForElementBeClickable(By.id("btnAdd"), 30);
		getWebElementById("btnAdd").click();

		// 4. Populate Add user from Excel Test Data
		// Use this for how work assignment
		ExcelUtil userMaintSheet = new ExcelUtil();
		userMaintSheet.openExcel(Constants.EXCELFILEPATH, "usermaint");

		waitForElementBeVisible(By.id("btnSave"), 30);
		selectByText(getWebElementById("systemUser_userType"), userMaintSheet.getCellData(1, 0));

		sendText(getWebElementById("systemUser_employeeName_empName"), userMaintSheet.getCellData(1, 1));

		// 5. Make sure you Prefix the test data for username with your name. I.E
		// "Michael" + jsmith
		sendText(getWebElementById("systemUser_userName"), "Michael5_" + userMaintSheet.getCellData(1, 2));

		selectByText(getWebElementById("systemUser_status"), userMaintSheet.getCellData(1, 3));
		sendText(getWebElementById("systemUser_password"), userMaintSheet.getCellData(1, 4));
		sendText(getWebElementById("systemUser_confirmPassword"), userMaintSheet.getCellData(1, 4));

		// 6. Click Save Button.
		getWebElementById("btnSave").click();
		
		// 7. Verify new User is in the user's table.
		//Get Row and Column Elements
		List<WebElement> rows = getWebElementsByXpath("//table[@id='resultTable']/tbody/tr");

		// Set expected value to search for.
		String expectedText = "Michael5_" + userMaintSheet.getCellData(1, 2);

		boolean isFound = false;
		for (int i = 1; i <= rows.size(); i++) {
			// If the row contains the expected text set isFound to true and exit
			if(getWebElementByXpath("//table[@id='resultTable']/tbody/tr[" + i + "]")
					.getText().contains(expectedText)){
				isFound = true;
				break;
			}
		}

		if(!isFound) {
			fail("User: " + expectedText + " was NOT added.");
		}
	
	}

}
