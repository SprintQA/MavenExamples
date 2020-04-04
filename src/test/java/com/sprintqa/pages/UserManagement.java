package com.sprintqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagement {
	@FindBy(name = "btnAdd")
	public WebElement btnAdd;

	@FindBy(id = "frmList_ohrmListComponent")
	public WebElement bntDelete;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(id = "resetBtn")
	public WebElement resetBtn;

	public UserManagement(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
}
