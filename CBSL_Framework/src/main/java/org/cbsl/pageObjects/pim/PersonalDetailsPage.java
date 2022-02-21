package org.cbsl.pageObjects.pim;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.cbsl.utility.BaseClass;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class PersonalDetailsPage {

	@FindBy(xpath = "//input[@id='btnSave']") private WebElement btnEdit_Save;
	@FindBy(xpath = "//input[@id='personal_txtLicenNo']") private WebElement txtDLNumber;
	@FindBy(xpath = "//input[@id='personal_txtLicExpDate']") private WebElement txtDLExpDate;
	@FindBy(xpath = "//input[@id='personal_txtNICNo']") private WebElement txtSSNNumber;
	@FindBy(xpath = "//input[@id='personal_txtSINNo']") private WebElement txtSINNum;
	@FindBy(xpath = "//input[@id='personal_optGender_1']") private WebElement selMale;
	@FindBy(xpath = "//input[@id='personal_optGender_2']") private WebElement selFemale;
	@FindBy(xpath = "//select[@id='personal_cmbMarital']") private WebElement selMaritalStatus;
	@FindBy(xpath = "//select[@id='personal_cmbNation']") private WebElement seleNationality;
	@FindBy(xpath = "//input[@id='personal_DOB']") private WebElement txtDOB;
	@FindBy(xpath = "//input[@id='personal_txtEmpNickName']") private WebElement txtNickName;
	@FindBy(xpath = "//input[@id='personal_chkSmokeFlag']") private WebElement chkbxSmoker;
	@FindBy(id="btnEditCustom") private WebElement btEdit_CustomField;
	@FindBy(name="custom1") private WebElement bloodTypeDropDown;
	@FindBy(id="btnAddAttachment") private WebElement btnAddAttachment;
	@FindBy(xpath= "//input[@id='ufile']") private WebElement chooseFileBtn;
	@FindBy(xpath = "//input[@id='btnSaveAttachment']") private WebElement uploadBtn; 

	private final static Logger logger=Logger.getLogger(PersonalDetailsPage.class);


	WebUtill utill;
	public PersonalDetailsPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);

	}

	public void clickEditbtn() {
		utill.click(btnEdit_Save);	
	}

	public void enterLicenNumber(String licenNumber) {
		utill.clear(txtDLNumber);
		utill.setTextBoxValue(txtDLNumber, licenNumber);
	}

	public void enterLicenExpDate(String yyyy_mm_dd_ExpDate) {
		utill.clear(txtDLExpDate);
		utill.setTextBoxValue(txtDLExpDate, yyyy_mm_dd_ExpDate);
	}

	public void enterSSN_Number(String ssnString ) {
		utill.clear(txtSSNNumber);
		utill.setTextBoxValue(txtSSNNumber, ssnString);
	}

	public void enterSIN_Number(String sin_Num) {
		utill.clear(txtSINNum);
		utill.setTextBoxValue(txtSINNum, sin_Num);
	}

	public void selectGender(char select_M_Or_F) {
		switch (select_M_Or_F) {
		case 'M':
			utill.click(selMale);
			break;
		case 'F':
			utill.click(selFemale);
		default:
			System.out.println("Please Enter M or F");
		}
	}


	public void enterDOB(String yyyy_mm_dd_selDOB) {
		utill.clear(txtDOB);
		utill.setTextBoxValue(txtDOB, yyyy_mm_dd_selDOB);
	}

	public void enterNickName(String nickName) {
		utill.clear(txtNickName);
		utill.setTextBoxValue(txtNickName, nickName);;
	}

	public void selChkBxSmoker(char sel_Y_or_N) {
		switch(sel_Y_or_N) {
		case 'Y':
			utill.click(chkbxSmoker);
			BaseClass.test.log(Status.PASS, "Smoker checkBox is checked");
			logger.info("Smoker Check Box is selected...");
			break;
		case 'N':
			BaseClass.test.log(Status.PASS, "Smoker checkBox is unchecked");
			logger.info("Smoker Check Box is unselected...");
			break;
		default:
			System.out.println("You have entered wrong char. Please select Y or N. otherwise smoker is unchecked by default........... ");
		}
	}

	public void clickOnSavebtn() {
		utill.click(btnEdit_Save);
	}



	public void bloodType(String bloodType) {
		utill.click(btEdit_CustomField);
		utill.selectDropDownValue(bloodTypeDropDown, "value", bloodType);

	}

	public void fileUpload() throws AWTException, Exception {
		
	//	utill.jsUtil.scrollUpPage(2000);
		utill.click(btnAddAttachment);
		Thread.sleep(3000);
		utill.click(chooseFileBtn);

		utill.uploadFile("C:\\Users\\288568\\Pictures\\Screenshots\\Screenshot.png");
		
		utill.click(uploadBtn);

	}


}
