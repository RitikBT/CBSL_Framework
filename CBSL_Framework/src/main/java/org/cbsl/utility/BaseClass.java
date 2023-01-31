package org.cbsl.utility;


import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.cbsl.pageObjects.login.LoginPage;
import org.cbsl.pageObjects.pim.ContactDetailsPage;
import org.cbsl.pageObjects.pim.EmergencyContactsPage;
import org.cbsl.pageObjects.pim.PIMPage;
import org.cbsl.pageObjects.pim.PersonalDetailsPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseClass {


	protected LoginPage loginPg;
	protected PIMPage pimPage;
	protected PersonalDetailsPage personalDetails;
	protected ContactDetailsPage contactDetails;
	protected EmergencyContactsPage emgContact;

	public  ExtentHtmlReporter htmlReporter;
	public  ExtentReports extent;
	public  ExtentTest test;


	protected WebUtill utill=new WebUtill();
//	protected Config conPro= new Config();

	private  final Logger logger = Logger.getLogger(BaseClass.class);

	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();

	@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentHtmlReporter("ExtentReport/STMExtentReport.html");
		// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Conneqt Bussiness Solution Lim.");
		extent.setSystemInfo("Environment", "Local");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("User Name", "Ritik Yadav");

		htmlReporter.config().setDocumentTitle("Automation Report"); 
		// Name of the report
		htmlReporter.config().setReportName("Functional Report"); 
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);			
	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun =true )
	public void launch(Method methodName,String b) {
		test=extent.createTest(methodName.getName());
		extentTest.set(test);
		utill.launchBrowser(b);
		logger.info("Browser launched...");
	utill.openUrl(utill.getProperty("url"));//https://opensource-demo.orangehrmlive.com/
	//utill.getDriver().set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
		test=extent.createTest(methodName.getName());
		loginPg =new LoginPage(utill);
		loginPg.setPwd(utill.getProperty("userPwd"));
		loginPg.setUserID(utill.getProperty("userID"));
		loginPg.clickLogin();
	}


	@AfterMethod
	public void getResult(ITestResult result){

		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 

			//	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			//	String screenshotPath = utill.takeSnapshot(result.getName());
			//To add it in the extent report 

			try {
				test.fail("<b><font color=red>"+"Screenshot of failure "+ "</font></b>");
				String screenshotPath = utill.takeSnapshot(result.getName());	
				logger.info("Screenshot taken for failed "+result.getName()+" testcases");
				extentTest.get().fail(result.getThrowable());
			}catch (IOException e) {
				test.fail("Test Failed, cannot attach screenshot");
			}


		}
		else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS){

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		
			utill.closeBrowser();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

} 
