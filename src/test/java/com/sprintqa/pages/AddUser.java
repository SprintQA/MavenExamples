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
		PageFactory.initElements(webDriver, this);
	}
	
	public void populate(ExcelUtil excelUtil) {
		selectByText(userRole, excelUtil.getCellData(1, 1));
	}
	

}
