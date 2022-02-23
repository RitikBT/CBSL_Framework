package org.cbsl.pageObjects.pim;

import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']") private WebElement linkPIM;
	@FindBy(xpath = "//input[@id='btnAdd']") private WebElement btnAdd;
	@FindBy(xpath = "//input[@id='firstName']") private WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='lastName']") private WebElement txtLastName;
	@FindBy(xpath = "//input[@id='btnSave']") private WebElement btnSave;
	@FindBy(xpath= "//input[@id='employeeId']") private WebElement employeeID;
	
	WebUtill utill;
	
	public PIMPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}
	 
	public void navigateToPIM() {
		utill.click(linkPIM);
	}
	public void setEmpID() {
		utill.setTextBoxValue(employeeID, utill.randomNumeric(5));
	}
	
	public void clickAddbtn() {
	utill.click(btnAdd);	
	}
	
	public void setFirstName(String firstName) {
		utill.setTextBoxValue(txtFirstName, firstName);
	}
	public void setLastName(String lastName) {
		utill.setTextBoxValue(txtLastName, lastName);
	}
	public void clickSavebtn() {
		utill.click(btnSave);
	}
	
	

}
