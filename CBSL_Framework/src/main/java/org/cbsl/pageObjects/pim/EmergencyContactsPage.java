package org.cbsl.pageObjects.pim;

import org.apache.log4j.Logger;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsPage {
	
	@FindBy(xpath = "//a[text()='Emergency Contacts']") private WebElement emergencyContactTab;
	@FindBy(xpath = "//input[@id='btnAddContact']") private WebElement addEmegencyContBtn;
	@FindBy(xpath = "//input[@id='emgcontacts_name']") private WebElement emgNametxt;
	@FindBy(xpath = "//input[@id='emgcontacts_relationship']") private WebElement emgRelationshiptxt;
	@FindBy(xpath = "//input[@id='emgcontacts_homePhone']") private WebElement emgTelephonetxt;
	@FindBy(xpath = "//input[@id='emgcontacts_mobilePhone']") private WebElement emgMobiletxt;
	@FindBy(xpath = "//input[@id='btnSaveEContact']") private WebElement addBtn;
	
	
	public final Logger logger=Logger.getLogger(getClass());
	
	WebUtill utill;
	
	public EmergencyContactsPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}
	
	
	public void navigateToEmergencyContact() {
		utill.click(emergencyContactTab);
		
	}
	
	public void addEmergencyContacts() {
		utill.click(addEmegencyContBtn);
		utill.setTextBoxValue(emgNametxt, "Suraj Sharma");
		utill.setTextBoxValue(emgRelationshiptxt, "Brother");
		utill.setTextBoxValue(emgTelephonetxt, "65430-001110");
		utill.setTextBoxValue(emgMobiletxt, "9876543211");
		utill.click(addBtn);
		
		logger.info("Emergency Contact Added Successfully....");
		
		
	}
	
	
	

}
