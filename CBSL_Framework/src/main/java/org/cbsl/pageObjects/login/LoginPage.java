package org.cbsl.pageObjects.login;

import org.apache.log4j.Logger;
import org.cbsl.utility.BaseClass;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@id='txtUsername']") 	private WebElement txtUserID;
	@FindBy(xpath = "//input[@id='txtPassword']") private WebElement txtPwd;
	@FindBy(xpath="//input[@id='btnLogin']") private WebElement btnLogin;

	WebUtill loginutill;
	private  final Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebUtill utill) {
		loginutill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}

	public void setUserID(String userID) {
		loginutill.clear(txtUserID);
		loginutill.setTextBoxValue(txtUserID, userID);
	}

	public void setPwd(String password) {
		loginutill.clear(txtPwd);
		loginutill.setTextBoxValue(txtPwd, password);
	}


	public void clickLogin() {
		loginutill.click(btnLogin);
		logger.info("Click on Login Button......");
		
	}

}
