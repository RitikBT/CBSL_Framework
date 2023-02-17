package org.cbsl.testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static DriverFactory instance = new DriverFactory();

	// Single design pattern - only one instance exist pattern
	// Factory design pattern - 
	private DriverFactory() {

	}

	

	public static DriverFactory getInstance() {
		return instance;
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}

	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}
}
