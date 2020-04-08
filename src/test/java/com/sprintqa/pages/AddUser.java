package com.sprintqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sprintqa.utils.CommonMethods;
import com.sprintqa.utils.ExcelUtil;

public class AddUser extends CommonMethods{
	
	@FindBy(id = "systemUser_userType")
	public WebElement userRole;

	@FindBy(id = "systemUser_employeeName_empName")
	public WebElement employeeName;

	@FindBy(id = "systemUser_userName")
	public WebElement userName;

	@FindBy(id = "systemUser_status")
	public WebElement status;

	@FindBy(id = "systemUser_password")
	public WebElement password;

	@FindBy(id = "systemUser_confirmPassword")
	public WebElement confirm;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(id = "btnCancel")
	public WebElement cancelBtn;

	public AddUser(WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public void populate(ExcelUtil excelUtil) {
		selectByText(userRole, excelUtil.getCellData(1, 0));
		sendText(employeeName, excelUtil.getCellData(1, 1));
		sendText(userName, excelUtil.getCellData(1, 2));
		selectByText(status, excelUtil.getCellData(1, 3));
		sendText(password, excelUtil.getCellData(1, 4));
		sendText(confirm, excelUtil.getCellData(1, 4));
	}
	

}
