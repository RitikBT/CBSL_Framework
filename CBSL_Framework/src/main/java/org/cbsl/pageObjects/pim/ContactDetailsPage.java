package org.cbsl.pageObjects.pim;

import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {
	
	@FindBy(xpath = "//a[text()='Contact Details']") private WebElement contactDetailsBtn;
	@FindBy(xpath = "//input[@id='btnSave']") private WebElement editBtnElement;
	@FindBy(xpath = "//input[@id='contact_street1']") private WebElement editBoxAddressStreet1;
	@FindBy(xpath = "//input[@id='contact_street2']") private WebElement editBoxAddressStreet2;
	@FindBy(xpath = "//input[@id='contact_city']") private WebElement editBoxCity;
	@FindBy(xpath = "//input[@id='contact_province']") private WebElement editBoxState;
	@FindBy(xpath = "//input[@id='contact_emp_zipcode']") private WebElement editBoxZipCod;
	@FindBy(xpath = "//input[@id='contact_country']") private WebElement selectCountry;
	@FindBy(xpath = "//input[@id='contact_emp_hm_telephone']") private WebElement editBoxTelephon;
	@FindBy(xpath = "//input[@id='contact_emp_mobile']") private WebElement editBoxMobile;
	@FindBy(xpath = "//input[@id='contact_emp_work_email']") private WebElement editBoxWorkEmail;
	@FindBy(xpath = "//input[@id='btnSave']") private WebElement saveBtn;
	
	

	
	
	
	WebUtill utill;
	public ContactDetailsPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}
	

	public void navigateToContactDetailPage() {
		utill.click(contactDetailsBtn);
	}
	
	public void contactDetailsFields() {
		utill.click(editBtnElement);
		utill.setTextBoxValue(editBoxAddressStreet1, "Kanpur, Phase-2, Silicon Road");
		utill.setTextBoxValue(editBoxAddressStreet2, "Kanpur, Phase-2, Silicon Road");
		utill.setTextBoxValue(editBoxCity, "Kanpur");
		utill.setTextBoxValue(editBoxState, "UP");
		utill.setTextBoxValue(editBoxZipCod, "110098");
		utill.selectDropDownValue(selectCountry, "value", "IN");
		utill.setTextBoxValue(editBoxTelephon, "00566-776770");
		utill.setTextBoxValue(editBoxMobile, "9876543210");
		utill.setTextBoxValue(editBoxWorkEmail, "vikas123@gmail.com");
		utill.click(saveBtn);
		
	}
public void uploadFile() {
	utill.click(contactDetailsBtn);
}
}
