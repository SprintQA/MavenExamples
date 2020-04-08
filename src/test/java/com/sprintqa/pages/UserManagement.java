package com.sprintqa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sprintqa.utils.CommonMethods;

public class UserManagement extends CommonMethods {
	
	@FindBy(name = "btnAdd")
	public WebElement btnAdd;

	@FindBy(id = "frmList_ohrmListComponent")
	public WebElement bntDelete;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(id = "resetBtn")
	public WebElement resetBtn;

	public UserManagement(WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public boolean isUserNameInTable(String expectedText) {
		List<WebElement> rows = getWebElementsByXpath("//table[@id='resultTable']/tbody/tr");

		boolean isFound = false;
		for (int i = 1; i <= rows.size(); i++) {
			// If the row contains the expected text set isFound to true and exit
			if(getWebElementByXpath("//table[@id='resultTable']/tbody/tr[" + i + "]")
					.getText().contains(expectedText)){
				isFound = true;
				break;
			}
		}

		return isFound;
	}
}
