package org.cbsl.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebUtill extends Config {

	public static  final Logger logger = Logger.getLogger(WebUtill.class);

	private   WebDriver driver=null;
	private JavaScriptUtil jsUtil=null;


	public   WebDriver getDriver() {
		return driver;
	}

	/**
	 * This function will pause the current thread by specified time in seconds.
	 * @param timeOutInSeconds time in seconds.
	 */
	public void holdOn(int timeOutInSecond)  {
		try {
			Thread.sleep(timeOutInSecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This function will click on web element and will wait for page to load completely.
	 * @param element Web element which you want to get clicked.
	 * @throws InterruptedException 
	 */
	public void click(WebElement we ) {

		try {
			we.click();
			BaseClass.test.log(Status.PASS, "Click on button");
			logger.info("Click on "+we);
		}
		catch (ElementNotVisibleException e) {
			logger.info("ElementNotVisibleException occured try again on click "+e);
			jsUtil.jsClick(we);
		}
	}


	/**
	 * This function will input value in Lookups present in the application and then click on search to get the desired result.
	 * @param locatorName Locator Name of webelement defined in Locator Source
	 * @return String value
	 * @throws InterruptedException 
	 */
	public String setTextBoxValue(WebElement we ,String inputData) {
		try {
			we.clear();
			we.sendKeys(inputData);
			BaseClass.test.log(Status.PASS, inputData+" is entered in text box");
			logger.info(inputData+" is entered in text box.");
		}
		catch (NoSuchElementException e) {
			logger.info(e);
			holdOn(5);
			we.clear();
			we.sendKeys(inputData);
		}
		catch (WebDriverException e) {
			logger.info(e);
			jsUtil.jsSetTextBoxValue(we, inputData);

		}
		return inputData;	
	}


	/** This function will return  inner-text of the webelement which is fetched from the locater name provided.
	 * @param locaterName Locater Name of webElement defined in Locater Source
	 * @return String inner text of specified weElement.
	 */	
	public String getText(WebElement element) {
		return element.getText();
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
		}else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
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

	/**
	 * This function will return status of webelement in boolean format.
	 * @param locatorName Locator name provided in the locator source.
	 * @return True if element is enabled, otherwise false.
	 */
	public boolean enabled(WebElement we) {
		return we.isEnabled();
	}

	/**
	 * This function will return display status of webelement in boolean format.
	 * @param locatorName Locator name provided in the locator source.
	 * @return True if element is visible, otherwise false.
	 */
	public boolean displayed(WebElement we) {
		return we.isDisplayed();
	}

	public boolean selected(WebElement we) {
		return we.isSelected();
	}

	public void openUrl(String url) {
		try{
			driver.get(url);
			logger.info( url+" opened successfully");
		}catch(WebDriverException e){
			logger.debug( "Error occured while opening url- "+url, e);
		}catch(NullPointerException e){
			logger.debug( "Error occured while opening url. webdriver object has null value - ", e);
		}
	}

	public void closeBrowser() {
		driver.close();	
	}

	public void quitBrowser() {
		driver.quit();
	}
	
	/**
	 *  This function will switch to main frame window.
	 *  @param no params.
	 */
	public void switchToMainWindowFrame() {
		try {
			driver.switchTo().defaultContent();
		}catch (Exception e) {
			logger.error("Unable to switch to main window "+e);
		}	
	}
	
	/**
	 *  This function will switch to parent frame window.
	 *  @param no params.
	 */
	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
		}catch(Exception e) {
			logger.error("Parent frame unavailable");
		}
	}
	

	public void handleAlertAccept() {
		int i=0;
		while(i++<10) {
			try {
				driver.switchTo().alert().accept();
				break;
			} catch (NoAlertPresentException e) {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}


	public void handleAlertDismiss() {
		int i=0;
		while(i++<5) {
			try{
				driver.switchTo().alert().dismiss();
				break;
			} catch(NoAlertPresentException e){
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}


	public String handleAlertGetText() {
		int i=0;
		String alertTextString=null;
		while(i++<5){
			try {
				alertTextString=	driver.switchTo().alert().getText();
			}catch(NoAlertPresentException e) {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
		return  alertTextString;

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

	public void selectDropDownValue(WebElement we, String type, String value) {

		Select sel=	new Select(we);

		switch(type) {
		case "index" :
			sel.selectByIndex(Integer.parseInt(value));
			break;

		case "value" :
			sel.selectByValue(value);
			break;

		case "visiabletext" :
			sel.selectByVisibleText(value);
			break;

		default:
			System.out.println("Please Pass correct selection criteria.....");
			System.out.println("Type is exist: value, index and visiabletext ");
			break;
		}

	}

	public void clear(WebElement we) {
		we.click();
	}
	public String takeSnapshot(String methodName) throws IOException {


		String dateAndTimeFormat=new SimpleDateFormat(" yyyy-MM-dd hhmmss").format(new Date());
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFile="ScreenShot//"+methodName+dateAndTimeFormat+".png";
		//String timeStamp=SystemUtil.getObject().getTimeStamp(Constants.DATE_FORMAT_PATTERN);
		//		File destFile=new File(System.getProperty(USER_DIR)+File.separator+"test-output"+ File.separator+methodName+"_"+timeStamp+".png");
		File strFile =new File(destFile);
		FileUtils.copyFile(scrFile, strFile);
		// To add it in the extent report 
		Reporter.log("<a href='"+ strFile.getAbsolutePath() + "'> <img src='"+ strFile.getAbsolutePath() + "' height='100' width='100'/> </a>",true);
		BaseClass.test.log(Status.PASS, "<a href='"+ strFile.getAbsolutePath() + "'> <img src='"+ strFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		return  destFile;


		/***		String dateAndTimeFormat=new SimpleDateFormat(" yyyy-MM-dd hhmmss").format(new Date());
//
//		TakesScreenshot snapshot=(TakesScreenshot)driver;
//		File srcFile=	snapshot.getScreenshotAs(OutputType.FILE);
//		String fileDestination="ScreenShot//"+imgName+dateAndTimeFormat+".png";
//		File strFile=new File(fileDestination);
//		try {
//			FileUtils.copyFile(srcFile, strFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return fileDestination;
		 ***/
	}


}
