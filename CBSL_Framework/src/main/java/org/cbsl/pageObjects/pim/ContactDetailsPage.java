package org.cbsl.pageObjects.pim;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {

	@FindBy(xpath = "//a[text()='Contact Details']")
	private WebElement contactDetailsBtn;
	@FindBy(xpath = "//label[text()='Street 1']/following::input[1]")
	private WebElement editBoxAddressStreet1;
	@FindBy(xpath = "//label[text()='Street 2']/following::input[1]")
	private WebElement editBoxAddressStreet2;
	@FindBy(xpath = "//label[text()='City']/following::input[1]")
	private WebElement editBoxCity;
	@FindBy(xpath = "//label[contains(text(),'State')]/following::input[1]")
	private WebElement editBoxState;
	@FindBy(xpath = "//label[contains(text(),'Zip')]/following::input[1]")
	private WebElement editBoxZipCod;
	@FindBy(xpath = "//select[@id='contact_country']")
	private WebElement selectCountry;
	@FindBy(xpath = "//label[contains(text(),'Home')]/following::input[1]")
	private WebElement editBoxTelephon;
	@FindBy(xpath = "//label[contains(text(),'Mobile')]/following::input[1]")
	private WebElement editBoxMobile;
	@FindBy(xpath = "//label[contains(text(),'Work Email')]/following::input[1]")
	private WebElement editBoxWorkEmail;
	@FindBy(xpath = "//div[@class='oxd-form-actions']/p/following-sibling::button")
	private WebElement saveBtn;
	@FindBy(xpath = "//input[@id='btnAddAttachment']")
	private WebElement addAttachementBtn;
	@FindBy(xpath = "//textarea[@id='txtAttDesc']")
	private WebElement commentBxfield;
	@FindBy(xpath = "//input[@id='ufile']")
	private WebElement chooseFileBtn;
	@FindBy(xpath = "//input[@id='btnSaveAttachment']")
	private WebElement uploadBtn;

	private final Logger logger = LogManager.getLogger(getClass());

	WebUtill utill;

	public ContactDetailsPage(WebUtill utill) {
		this.utill = utill;
		PageFactory.initElements(utill.getDriver(), this);
	}

	public void navigateToContactDetailPage() {
		utill.jsScrollDownPage(250);
		utill.click(contactDetailsBtn,"Contact ");
	}

	public void contactDetailsFields() {
		utill.setTextBoxValue(editBoxAddressStreet1, "Kanpur, Phase-2, Silicon Road", "Street 1");
		utill.setTextBoxValue(editBoxAddressStreet2, "Kanpur, Phase-2, Silicon Road", "Street 2");
		utill.setTextBoxValue(editBoxCity, "Kanpur", "City");
		utill.setTextBoxValue(editBoxState, "UP", "State");
		utill.setTextBoxValue(editBoxZipCod, "110098","Pincode");
		// utill.selectDropDownValue(selectCountry, "value", "IN");
		utill.setTextBoxValue(editBoxTelephon, "9088776770", "Telephone");
		utill.setTextBoxValue(editBoxMobile, "9876543210", "Mobile");
		utill.setTextBoxValue(editBoxWorkEmail, "vikas" + utill.randomString(2) + "@gmail.com", "Email");
		utill.click(saveBtn, "Save");

		logger.info("Contact details addedd........");

	}

	public void uploadFile() {

		utill.click(addAttachementBtn,"Add attachement");
		try {
			utill.click(chooseFileBtn, "File Button");
			utill.holdOn(2);
			utill.uploadFile("‪C:\\Users\\288568\\Pictures\\Screenshots\\Screenshot.png");
		} catch (AWTException e) {
			e.printStackTrace();
		}
		utill.setTextBoxValue(commentBxfield, "Doc is uploaded......!!!!!", "Comment");
		utill.click(uploadBtn, "Upload");
	}
}
