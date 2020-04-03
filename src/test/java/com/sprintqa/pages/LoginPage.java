package com.sprintqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sprintqa.utils.CommonMethods;

public class LoginPage extends CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement userName;

	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "frmLogin")
	public WebElement loginFrm;

	@FindBy(css = "img[src*='logo.png']")
	public WebElement logo;

	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement message;
	
	public LoginPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void login(String user, String password) {
		sendText(userName, user);
		sendText(this.password, password);
		submitForm(loginFrm);
	}
	
	
}












