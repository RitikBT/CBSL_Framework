package org.cbsl.pageObjects.pim;

import org.apache.log4j.Logger;
import org.cbsl.utility.WebUtill;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DependentPage {


	@FindBy(xpath = "//a[text()='Dependents']") private WebElement dependenetsPage;
	@FindBy(xpath = "//input[@id='btnAddDependent']") private WebElement addBtn;
	@FindBy(xpath = "//input[@id='dependent_name']") private WebElement dependentNameTxt;
	@FindBy(xpath = "//select[@id='dependent_relationshipType']") private WebElement dependentRelationshipTypeTxt;
	@FindBy(xpath = "//input[@id='dependent_dateOfBirth']") private WebElement dependentDOBtxt;
	@FindBy(xpath = "//input[@id='dependent_relationship']") private WebElement dependentRelationshionTxt;
	@FindBy(xpath = "//input[@id='btnSaveDependent']") private WebElement saveBtn;

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
		utill.setTextBoxValue(addBtn, "Salini Verma");
		utill.selectDropDownValue(dependentRelationshipTypeTxt, "value", "other");
		utill.setTextBoxValue(dependentDOBtxt, "2000-02-03");
		utill.setTextBoxValue(dependentRelationshionTxt, "Welcome Dear");
		utill.click(saveBtn);
		logger.info("Save dependent field.....");

	}


}
