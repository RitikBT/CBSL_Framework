package org.cbsl.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtill {
	
	private static  WebDriver driver=null;

	public static  WebDriver getDriver() {
		return driver;
	}

	public void click(WebElement we ) {
		we.click();
	}

	public void input(WebElement we ,String inputData) {
		we.sendKeys( inputData);
	}

	public void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			
		}else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else
			System.out.println("Please Enter Browser Name: Chrome or Firefox");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphanumeric(4);
	}
	
	public void clearAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void windowSize(int width, int height ) {
		driver.manage().window().setSize(new Dimension(width, height));
	}
	
	public boolean enabled(WebElement we) {
		return we.isEnabled();
	}

	public boolean displayed(WebElement we) {
		return we.isDisplayed();
	}

	public boolean selected(WebElement we) {
		return we.isSelected();
	}

	public void setUrl(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();	
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void clearValue(WebElement we) {
		we.clear();
	}
	
	public String getTitleName() {
		return	driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void getWindowHandles(String expWindowTitle) {
		Set<String> windows=	driver.getWindowHandles();
		for (String windoName:windows) {
			String actWindowTitle=	driver.switchTo().window(windoName).getTitle();
			if(actWindowTitle.equalsIgnoreCase(expWindowTitle)) {
				break;
			}
		}
	}

	public void clear(WebElement we) {
		we.click();
	}
	public String takeSnapshot(String imgName) {
		String dateAndTimeFormat=new SimpleDateFormat(" yyyy-MM-dd hhmmss").format(new Date());
		
		TakesScreenshot snapshot=(TakesScreenshot)driver;
		File srcFile=	snapshot.getScreenshotAs(OutputType.FILE);
		String fileDestination="ScreenShot//"+imgName+dateAndTimeFormat+".png";
		File strFile=new File(fileDestination);
		try {
			FileUtils.copyFile(srcFile, strFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileDestination;
	}
	
	
}
