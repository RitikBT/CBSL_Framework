package org.cbsl.pageObjects.pim;

import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImmigrationPage {
	
	@FindBy(xpath = "//a[text()='Immigration']") private WebElement nativeImmigration;
	@FindBy(xpath = "//input[@id='immigration_number']") private WebElement immNumberTxt;
	@FindBy(xpath = "//input[@id='immigration_passport_issue_date']") private WebElement immPassportIssueDate;
	@FindBy(xpath = "//input[@id='immigration_passport_expire_date']") private WebElement immPassportExpDate;
	@FindBy(xpath = "//input[@id='immigration_i9_status']") private WebElement immEligibleStatus;
	@FindBy(xpath = "//select[@id='immigration_country']") private WebElement immPassportCountryName;
	@FindBy(xpath = "//input[@id='immigration_i9_review_date']") private WebElement immReviewDate;
	@FindBy(xpath = "//textarea[@id='immigration_comments']") private WebElement immCommentsTxt;
	@FindBy(xpath = "//input[@id='btnSave']") private WebElement saveBtn;
	
	
	
	WebUtill utill;
	public ImmigrationPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
		
	}
	
	public void navigateToImmigration() {
		utill.click(null);
	}
	
	public void addImmigrationField() {
		utill.setTextBoxValue(immNumberTxt, "87665544");
		utill.setTextBoxValue(immPassportIssueDate, "2020-02-10");
		utill.setTextBoxValue(immPassportExpDate, "2030-02-10");
		utill.setTextBoxValue(immEligibleStatus, "Done");
		utill.selectDropDownValue(immPassportCountryName, "value", "India");
		utill.setTextBoxValue(immReviewDate, "2022-02-10");
		utill.setTextBoxValue(immCommentsTxt, "Welldone.....");
		utill.click(saveBtn);
		
	}
	

}
