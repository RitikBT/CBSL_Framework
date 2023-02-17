package org.cbsl.testBase;

import java.util.concurrent.TimeUnit;

import org.cbsl.resuableComponent.PropertiesOperations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	BrowserFactory browserfact = new BrowserFactory();
	
	@BeforeMethod
	public void launchApplication() throws Exception {

		DriverFactory.getInstance().setDriver(browserfact.createBrowserInstance(PropertiesOperations.getPropertyValueByKey("browser")));
		WebDriver driver = DriverFactory.getInstance().getDriver();
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(PropertiesOperations.getPropertyValueByKey("url"));
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
