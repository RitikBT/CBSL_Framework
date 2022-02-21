package org.cbsl.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class JavaScriptUtil extends WebUtill {
	
	
	public   JavascriptExecutor getJSExecutor(){
		return ((JavascriptExecutor) getDriver());
		
	}

	

	/**
	 * This method is for scrolling the page up
	 */
	public void scrollUpPage() {
		getJSExecutor().executeScript("window.scrollTo(2000,0)");
	}
	
	/**
	 * This method is for scrolling the page down
	 */
	public void scrollDownPage(Integer numberOfPixels) {
		getJSExecutor().executeScript("window.scrollTo(0,\""+numberOfPixels+"\")");

	}
	
	/**
	 * This method is used to scroll the page till the exact web element provided.
	 * @param we Web element name 
	 */
//	public void scrollingToElementOfAPage(WebElement we) {
//
//		getJSExecutor().executeScript(JS_SCROLL_CODE, we);
//	}

	

	/**
	 * This method is used to click on the particular element.
	 * @param element Web Element
	 */
	public void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click()", element);

	}

	/**
	 * This method is used to set the particular value in the text box by using the Java Script.
	 * @param locatorName Name of the locator for which you want to set the value.
	 * @param value A string value which needs to be passed to the locator.
	 */
	public void jsSetTextBoxValue(WebElement element, String value) {
		getJSExecutor().executeScript("arguments[0].value = '"+value+"';", element);

	}
}
