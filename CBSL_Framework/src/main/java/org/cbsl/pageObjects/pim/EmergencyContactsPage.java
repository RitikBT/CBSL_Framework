package org.cbsl.pageObjects.pim;

import org.apache.log4j.Logger;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsPage {
	
	@FindBy(xpath = "//a[text()='Emergency Contacts']") private WebElement emergencyContactTab;
	@FindBy(xpath = "//div[@class='orangehrm-action-header']//button[1]") private WebElement addEmegencyContBtn;
	@FindBy(xpath = "//label[contains(text(),'Name')]/following::input[1]") private WebElement emgNametxt;
	@FindBy(xpath = "//label[contains(text(),'Relationship')]/following::input[1]") private WebElement emgRelationshiptxt;
	@FindBy(xpath = "//label[contains(text(),'Home Telephone')]/following::input[1]") private WebElement emgTelephonetxt;
	@FindBy(xpath = "//label[contains(text(),'Mobile')]/following::input[1]") private WebElement emgMobiletxt;
	@FindBy(xpath = "//div[@class='oxd-form-actions']/p/following-sibling::button[2]") private WebElement saveBtn;
	
	
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
		utill.click(saveBtn);
		
		logger.info("Emergency Contact Added Successfully....");
		
		
	}
	
	
	

}
