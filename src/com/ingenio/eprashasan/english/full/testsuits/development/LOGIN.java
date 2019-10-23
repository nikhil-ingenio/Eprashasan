package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;

import org.testng.annotations.Test;

import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class LOGIN extends WebDriverTestCase{

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Login Functionaltiy']}")
	@QAFTestStep(description = "Validate the login functionality with invalid credintial")
	public void TC_Login_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered Username");
		fullEPrashasanLoginPage.textboxPassword.sendKeys(data.get("invalid_password"));
		Reporter.log("User Entered invalid Password");
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		verifyFalse(fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.isPresent(),
				"User navigated to Welcome Page", "User not navigated to Welcome Page");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Login Functionaltiy']}")
	@QAFTestStep(description = "Validate the login functionality with invalid credintial")
	public void TC_Login_02(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.textboxUsername.sendKeys(data.get("invalid_username"));
		Reporter.log("User Entered invalid Username");
		fullEPrashasanLoginPage.textboxPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered Password");
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		verifyFalse(fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.isPresent(),
				"User navigated to Welcome Page", "User not navigated to Welcome Page");
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Login Functionaltiy']}")
	@QAFTestStep(description = "Validate the login functionality with blank username")
	public void TC_Login_03(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.textboxUsername.sendKeys("");
		fullEPrashasanLoginPage.textboxPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered Password");
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanLoginPage.textboxUsername);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Login Functionaltiy']}")
	@QAFTestStep(description = "Validate the login functionality with blank password")
	public void TC_Login_04(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered Username");
		fullEPrashasanLoginPage.textboxPassword.sendKeys("");
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanLoginPage.textboxPassword);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Login Functionaltiy']}")
	@QAFTestStep(description = "Validate the login functionality without selecting DB")
	public void TC_Login_05(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered Username");
		fullEPrashasanLoginPage.textboxPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered Password");
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanLoginPage.dropdownDBName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Login Functionaltiy']}")
	@QAFTestStep(description = "Validate the login functionality with valid credintial")
	public void TC_Login_06(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered Username");
		fullEPrashasanLoginPage.textboxPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered Password");
		fullEPrashasanLoginPage.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
	}
}
