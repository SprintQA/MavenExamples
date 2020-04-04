package com.sprintqa.utils;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	private WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	@BeforeEach
	void setUp() throws Exception {
		ConfigsReader.readProperties(Constants.CONFIGFILEPATH);

		// Use WebDriverManager to download the correct binary
		// and set classpath
		WebDriverManager.chromedriver().setup();

		// Setup WebDriver to Use Chrome
		webDriver = new ChromeDriver();

		// Set our timeouts
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Set window size
		webDriver.manage().window().fullscreen();

		// Set our starting url based on properties file
		webDriver.get(ConfigsReader.getProperty("url"));
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterEach
	void tearDown() throws Exception {
		// 3.
		try {
			webDriver.close();
		} catch (Exception e) {
			System.out.println("Browser was unable to close: " + e.getMessage());
		}
		try {
			webDriver.quit();
		} catch (NoSuchSessionException e) {
			System.out.println("Browser was already exited.");
		} catch (Exception ex) {
			System.out.println("Browser was unable to Quit: " + ex.getMessage());
		}
	}

}
