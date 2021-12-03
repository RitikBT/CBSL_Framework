package org.cbsl.pageObjects.login;

import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@id='txtUsername']") 	private WebElement txtUserID;
	@FindBy(xpath = "//input[@id='txtPassword']") private WebElement txtPwd;
	@FindBy(xpath="//input[@id='btnLogin']") private WebElement btnLogin;

	WebUtill utill;
	
	public LoginPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}

	public void setUserID(String userID) {
		utill.clear(txtUserID);
		utill.input(txtUserID, userID);
	}

	public void setPwd(String password) {
		utill.clear(txtPwd);
		utill.input(txtPwd, password);
	}


	public void clickLogin() {
		utill.click(btnLogin);
	}

}
