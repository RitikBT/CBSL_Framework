package org.cbsl.pageObjects.login;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@name='username']") 	private WebElement txtUserID;
	@FindBy(xpath = "//input[@name='password']") private WebElement txtPwd;
	@FindBy(xpath="//button[@type='submit']") private WebElement btnLogin;

	WebUtill loginutill;
//	public final static Logger logger=LogManager.getLogger();

	public LoginPage(WebUtill utill) {
		loginutill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}

	public void setUserID(String userID) {
		loginutill.clear(txtUserID);
		loginutill.setTextBoxValue(txtUserID, userID, "User ID");
	}

	public void setPwd(String password) {
		loginutill.clear(txtPwd);
		loginutill.setTextBoxValue(txtPwd, password, "Password");
	}


	public void clickLogin() {
		loginutill.click(btnLogin, "Login");
		//logger.info("Click on Login Button......");
		
	}

}
