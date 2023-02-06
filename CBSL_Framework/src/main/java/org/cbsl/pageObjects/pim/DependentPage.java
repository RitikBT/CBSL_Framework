package org.cbsl.pageObjects.pim;

import org.apache.log4j.Logger;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentPage {


	@FindBy(xpath = "//a[text()='Dependents']") private WebElement dependenetsPage;
	@FindBy(xpath = "//div[@class='orangehrm-action-header']//button[1]") private WebElement addBtn;
	@FindBy(xpath = "//label[contains(text(),'Name')]/following::input[1]") private WebElement dependentNameTxt;
	@FindBy(xpath = "//select[@id='dependent_relationshipType']") private WebElement dependentRelationshipTypeTxt;
	@FindBy(xpath = "//label[contains(text(),'Birth')]/following::input[1]") private WebElement dependentDOBtxt;
	@FindBy(xpath = "//div[@class='oxd-form-actions']/p/following-sibling::button[2]") private WebElement saveBtn;

	private final Logger logger=Logger.getLogger(getClass());
	
	WebUtill utill;
	public DependentPage(WebUtill utill) {
		this.utill=utill;
		PageFactory.initElements(utill.getDriver(), this);
	}


	public void naviagteToDependent() {
		utill.click(dependenetsPage);
		logger.info("Navigate to dependent page.....");
	}


	public void addDependentField() {
		utill.click(addBtn);
		utill.setTextBoxValue(dependentNameTxt, "Salini Verma");
	//	utill.selectDropDownValue(dependentRelationshipTypeTxt, "value", "other");
		utill.setTextBoxValue(dependentDOBtxt, "2000-02-03");
		utill.click(saveBtn);
		logger.info("Save dependent field.....");

	}


}
