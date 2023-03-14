package org.cbsl.pageObjects.pim;

import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

	@FindBy(xpath = "//div[@class='oxd-form-actions']/p/following-sibling::button") private WebElement btnEdit_Save;
	@FindBy(xpath = "//label[contains(text(),'License Number')]/following::div[1]/input") private WebElement txtDLNumber;
	@FindBy(xpath = "//label[text()='License Expiry Date']//following::div//input[1]") private WebElement txtDLExpDate;
	@FindBy(xpath = "//label[contains(text(),'SSN')]/following::div[1]/input") private WebElement txtSSNNumber;
	@FindBy(xpath = "//label[contains(text(),'SIN')]/following::div[1]/input") private WebElement txtSINNum;
	@FindBy(xpath = "//label[text()='Male']") private WebElement selMale;
	@FindBy(xpath = "//label[text()='Female']") private WebElement selFemale;
	@FindBy(xpath = "//select[@id='personal_cmbMarital']") private WebElement selMaritalStatus;
	@FindBy(xpath = "//label[contains(text(),'Nationality')]//following::div[@class='oxd-select-text-input'][1]") private WebElement seleNationality;
	@FindBy(xpath = "//label[contains(text(),'Birth')]/following::input[1]") private WebElement txtDOB;
	@FindBy(xpath = "//label[contains(text(),'Nick')]/following::div[1]/input") private WebElement txtNickName;
	@FindBy(xpath = "//label[contains(text(),'Smoker')]//following::span[1]") private WebElement chkbxSmoker;
	@FindBy(id="btnEditCustom") private WebElement btEdit_CustomField;
	@FindBy(name="custom1") private WebElement bloodTypeDropDown;
	@FindBy(id="btnAddAttachment") private WebElement btnAddAttachment;
	@FindBy(xpath= "//input[@id='ufile']") private WebElement chooseFileBtn;
	@FindBy(xpath = "//input[@id='btnSaveAttachment']") private WebElement uploadBtn; 
	@FindBy(xpath = "//span[text()='Turkish']") private WebElement country;

	//(//div[contains(text(),'-- Select --')])[1] //label[contains(text(),'Nationality')]//following::div[@class='oxd-select-text-input'][1]


	public final static Logger logger=LogManager.getLogger();


	WebUtill utill;

	public PersonalDetailsPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);

	}

	public void selectNationality() {
		utill.click(seleNationality, "Nationality");
		utill.click(country, "Nation");
	}


	public void clickEditbtn() {
		utill.click(btnEdit_Save,"Save");	
	}

	public void enterLicenNumber(String licenNumber) {
	//	utill.clear(txtDLNumber);
		utill.setTextBoxValue(txtDLNumber, licenNumber,"DL Number");
	}

	public void enterLicenExpDate(String yyyy_mm_dd_ExpDate) {
		utill.setTextBoxValue(txtDLExpDate, yyyy_mm_dd_ExpDate,"Expiary Date");
		
	}

	public void enterSSN_Number(String ssnString ) {
		utill.clear(txtSSNNumber);
		utill.setTextBoxValue(txtSSNNumber, ssnString, "SSN Number");
	}

	public void enterSIN_Number(String sin_Num) {
		utill.clear(txtSINNum);
		utill.setTextBoxValue(txtSINNum, sin_Num,"SIN Number");
	}

	public void selectGender(char select_M_Or_F) {
		
		switch (select_M_Or_F) {
		case 'M':
			utill.click(selMale,"Gender");
			break;
		case 'F':
			utill.click(selFemale," Gender");
		default:
			System.out.println("Please Enter M or F");
		}
	}

	public void enterDOB(String yyyy_mm_dd_selDOB) {
		utill.setTextBoxValue(txtDOB, yyyy_mm_dd_selDOB,"DOB");
	}

	public void enterNickName(String nickName) {
		utill.clear(txtNickName);
		utill.setTextBoxValue(txtNickName, nickName,"Nick Name");;
	}

	public void selChkBxSmoker(char sel_Y_or_N) {
		switch(sel_Y_or_N) {
		case 'Y':
			utill.click(chkbxSmoker,"Smoker");
			logger.info("Smoker Check Box is selected...");
			break;
		case 'N':
			logger.info("Smoker Check Box is unselected...");
			break;
		default:
			System.out.println("You have entered wrong char. Please select Y or N. otherwise smoker is unchecked by default........... ");
		}
	}

	public void clickOnSavebtn() {
		utill.click(btnEdit_Save, "Save");

		logger.info("Personal Details added successfully....");
	}



	public void bloodType(String bloodType) {
		utill.click(btEdit_CustomField,"Blood");
		utill.selectDropDownValue(bloodTypeDropDown, "value", bloodType);
		logger.info("Blood type addedd  "+ bloodType);

	}

	public void fileUpload() throws AWTException, Exception {

		//	utill.jsUtil.scrollUpPage(2000);
		utill.click(btnAddAttachment, "Add ");
		Thread.sleep(3000);
		utill.click(chooseFileBtn, "Choose");

		utill.uploadFile("C:\\Users\\288568\\Pictures\\Screenshots\\Screenshot.png");

		utill.click(uploadBtn, "Upload");

	}


}
