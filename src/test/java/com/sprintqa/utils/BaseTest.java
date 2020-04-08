package com.sprintqa.utils;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends CommonMethods {
	
	@BeforeEach
	void setUp() throws Exception {
		ConfigsReader.readProperties(Constants.CONFIGFILEPATH);

		// Use WebDriverManager to download the correct binary
		// and set classpath
		WebDriverManager.chromedriver().setup();

		// Setup WebDriver to Use Chrome
		setWebDriver(new ChromeDriver());

		// Set our timeouts
		getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Set window size
		getWebDriver().manage().window().fullscreen();

		// Set our starting url based on properties file
		getWebDriver().get(ConfigsReader.getProperty("url"));
		
		// Set implicit page timeout
		getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Wrap close/quit methods to handle quitting the browser
		// Some browser require both, some do not.
		try {
			getWebDriver().close();
		} catch (Exception e) {
			System.out.println("Browser was unable to close: " + e.getMessage());
		}
		try {
			getWebDriver().quit();
		} catch (NoSuchSessionException e) {
			System.out.println("Browser was already exited.");
		} catch (Exception ex) {
			System.out.println("Browser was unable to Quit: " + ex.getMessage());
		}
	}

}
