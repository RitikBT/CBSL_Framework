package org.cbsl.pageObjects.pim;

import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContacts {
	
	@FindBy(xpath = "//a[text()='Emergency Contacts']") private WebElement emergencyContactTab;
	@FindBy(xpath = "//input[@id='btnAddContact']") private WebElement addEmegencyContBtn;
	@FindBy(xpath = "=//input[@id='btnAddContact']")
	
	
	
	WebUtill utill;
	
	public EmergencyContacts(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}
	
	
	public void navigateToEmergencyContact() {
		utill.click(emergencyContactTab);
		
	}
	
	public void addEmergencyContacts() {
		utill.click(addEmegencyContBtn);
	}
	
	
	

}
