package org.cbsl.testcases;

import org.cbsl.pageObjects.login.LoginPage;
import org.cbsl.pageObjects.pim.PIMPage;
import org.cbsl.pageObjects.pim.PersonalDetailsPage;
import org.cbsl.utility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddEmployee extends BaseClass {
	
	
	
	@Test
	public void loginTest() {
		loginPg =new LoginPage(utill);
		loginPg.setPwd("admin123");
		loginPg.setUserID("Admin");
		loginPg.clickLogin();
		pimPage= new PIMPage(utill);
		pimPage.navigateToPIM();
		pimPage.clickAddbtn();
		pimPage.setFirstName("Vikas");
		pimPage.setLastName("Singh");
		pimPage.clickSavebtn();
		personalDetails =new  PersonalDetailsPage(utill);
		personalDetails.clickEditbtn();
		personalDetails.enterLicenNumber("DL03 20180045666");
		personalDetails.enterLicenExpDate("2028-12-09");
		personalDetails.enterSSN_Number("000000012398");
		personalDetails.enterSIN_Number("09876580000");
		personalDetails.enterDOB("1995-03-26");
		personalDetails.selectGender('M');
		personalDetails.selChkBxSmoker('N');
		personalDetails.clickOnSavebtn();
		Assert.assertEquals(true, false);
	}

}
