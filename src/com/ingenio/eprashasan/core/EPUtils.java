package com.ingenio.eprashasan.core;

import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class EPUtils {

	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public static void loginToEPrashasan(String username, String password) {
		
		try {
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		
		fullEPrashasanLoginPage.dropdownDBName.waitForVisible(30000);
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		
		fullEPrashasanLoginPage.textboxUsername.waitForVisible(30000);
		fullEPrashasanLoginPage.textboxUsername.sendKeys(username);
		Reporter.log("User Entered Username");
		
		fullEPrashasanLoginPage.textboxPassword.waitForVisible(30000);
		fullEPrashasanLoginPage.textboxPassword.sendKeys(password);
		Reporter.log("User Entered Password");
		
		fullEPrashasanLoginPage.buttonLogin.waitForVisible(30000);
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method returns Field Level Error Validation Message for QAFWebElement type element
	 * @author SATISH
	 */
	public static String getFieldLevelErrorValidationMessage(QAFWebElement element) {
		
		String errorMessage = element.getAttribute("validationMessage");
		return errorMessage;
		
	}
	
	/**
	 * This Method returns Field Level Error Validation Message for DropdownListWebElement type element
	 * @author SATISH
	 */
	
	public static String getFieldLevelErrorValidationMessage(DropdownListWebElement element) {
		
		String errorMessage = element.getAttribute("validationMessage");
		return errorMessage;
		
	}
	
	
}
