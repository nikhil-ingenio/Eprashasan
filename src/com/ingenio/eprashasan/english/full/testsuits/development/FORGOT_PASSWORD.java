package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;


public class FORGOT_PASSWORD extends WebDriverTestCase{

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate the functionality of \"Forgot Password?\" link")
	public void TC_ForPass_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate the functionality of \"Forgot Password?\" link without adding DB")
	public void TC_ForPass_02(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyNotPresent();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate the functionality of \"Next\" button on \"Forgot Password?\" popup  by entering wrong username in \"Enter Username\" field")
	public void TC_ForPass_03(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("invalid_username"));
		Reporter.log("User Entered invalid Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Login Button");
		EPUtils.sleep(4000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Wrong UserName"), "Wrong UserName message not displayed",
				"Wrong UserName message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate the functionality of \"Next\" button on \"Forgot Password?\" popup  by entering correct username in \"Enter Username\" field")
	public void TC_ForPass_04(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate the functionality of \"Next\" button by entering wrong answere for one of the question")
	public void TC_ForPass_05(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("wrong_answser"));
		Reporter.log("User Entered wrong Answser for Question 1");
		
		fullEPrashasanLoginPage.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		EPUtils.sleep(4000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Enter Correct Answer For Security Questions"), 
				"Enter Correct Answer For Security Questions message not displayed",
				"Enter Correct Answer For Security Questions message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();	
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validating functionality of \"Next\" button by entering both answere correct")
	public void TC_ForPass_06(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("question_2_answser"));
		Reporter.log("User Entered Correct Answser for Question 2");
		
		fullEPrashasanLoginPage.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		fullEPrashasanLoginPage.popupEnterNewPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupEnterNewPassword.headerForgotPassword.verifyVisible();
			
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validating the functionality of \"Next\" buttonby entering answere of different user")
	public void TC_ForPass_07(Map<String, String> data) {
		Assert.fail();	
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate functionality of \"Next\" button with blank field")
	public void TC_ForPass_08(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		
		fullEPrashasanLoginPage.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		EPUtils.sleep(4000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Enter Correct Answer For Security Questions"), 
				"Enter Correct Answer For Security Questions message not displayed",
				"Enter Correct Answer For Security Questions message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate functionality of \"Next\" button with blank field")
	public void TC_ForPass_09(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("question_2_answser"));
		Reporter.log("User Entered Correct Answser for Question 2");
		
		fullEPrashasanLoginPage.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		EPUtils.sleep(4000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Enter Correct Answer For Security Questions"), 
				"Enter Correct Answer For Security Questions message not displayed",
				"Enter Correct Answer For Security Questions message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
	}
	
	//TC_ForPass_10 and TC_ForPass_11 can be merged
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "After performing \"Forgot Password?\" functionality validate the login functionality with new password")
	public void TC_ForPass_10(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("question_2_answser"));
		Reporter.log("User Entered Correct Answser for Question 2");
		
		fullEPrashasanLoginPage.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		fullEPrashasanLoginPage.popupEnterNewPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupEnterNewPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupEnterNewPassword.textboxEnterNewPassword.waitForVisible();
		fullEPrashasanLoginPage.popupEnterNewPassword.textboxEnterNewPassword.sendKeys(data.get("new_password"));
		Reporter.log("User Entered new password");
		fullEPrashasanLoginPage.popupEnterNewPassword.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		EPUtils.sleep(4000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Password Updated Successfully"), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		FullEPrashasanLoginPage fullEPrashasanLoginPage2 = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage2.waitForPageToLoad();
		
		fullEPrashasanLoginPage2.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage2.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered Username");
		fullEPrashasanLoginPage2.textboxPassword.sendKeys(data.get("new_password"));
		Reporter.log("User Entered new Password");
		fullEPrashasanLoginPage2.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");
		
		EPUtils.sleep(4000);
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
			
		//The Following code is not part of test case. It is written for reset original password
		Reporter.log("*****The Following code is not part of test case. It is written for reset original password*****");
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage3 = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage3.invoke();
		
		fullEPrashasanLoginPage3.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage3.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage3.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage3.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage3.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage3.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage3.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage3.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage3.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		fullEPrashasanLoginPage3.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("question_2_answser"));
		Reporter.log("User Entered Correct Answser for Question 2");
		
		fullEPrashasanLoginPage3.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		fullEPrashasanLoginPage3.popupEnterNewPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage3.popupEnterNewPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage3.popupEnterNewPassword.textboxEnterNewPassword.waitForVisible();
		fullEPrashasanLoginPage3.popupEnterNewPassword.textboxEnterNewPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered new password");
		fullEPrashasanLoginPage3.popupEnterNewPassword.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		EPUtils.sleep(4000);
		verifyTrue(Windowalert.getText().contains("Password Updated Successfully"), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "After performing \"Forgot Password?\" functionality validate the login functionality with old password")
	public void TC_ForPass_12(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		fullEPrashasanLoginPage.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("question_2_answser"));
		Reporter.log("User Entered Correct Answser for Question 2");
		
		fullEPrashasanLoginPage.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		fullEPrashasanLoginPage.popupEnterNewPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage.popupEnterNewPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage.popupEnterNewPassword.textboxEnterNewPassword.waitForVisible();
		fullEPrashasanLoginPage.popupEnterNewPassword.textboxEnterNewPassword.sendKeys(data.get("new_password"));
		Reporter.log("User Entered new password");
		fullEPrashasanLoginPage.popupEnterNewPassword.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		EPUtils.sleep(4000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Password Updated Successfully"), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage2 = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage2.waitForPageToLoad();
		
		fullEPrashasanLoginPage2.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage2.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered Username");
		fullEPrashasanLoginPage2.textboxPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered new Password");
		fullEPrashasanLoginPage2.buttonLogin.click();
		Reporter.log("User Clicked on Login Button");
		
		EPUtils.sleep(4000);
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		verifyFalse(fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.isPresent(),
				"User navigated to Welcome Page", "User not navigated to Welcome Page");
			
		//The Following code is not part of test case. It is written for reset original password
		Reporter.log("*****The Following code is not part of test case. It is written for reset original password*****");
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage3 = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage3.invoke();
		
		fullEPrashasanLoginPage3.dropdownDBName.selectByValue("dbe1");
		Reporter.log("User Selected DB from Dropdown List");
		fullEPrashasanLoginPage3.linkForgotPassword.click();
		Reporter.log("User Clicked on Forgot Password Link");
		fullEPrashasanLoginPage3.popupForgotPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage3.popupForgotPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage3.popupForgotPassword.textboxUsername.sendKeys(data.get("username"));
		Reporter.log("User Entered the Username");
		fullEPrashasanLoginPage3.popupForgotPassword.buttonNext.click();
		Reporter.log("User Clicked on Next Button");
		fullEPrashasanLoginPage3.popupQuestionAnswer.waitForPopupToLoad();
		fullEPrashasanLoginPage3.popupQuestionAnswer.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage3.popupQuestionAnswer.textboxAnswer1.sendKeys(data.get("question_1_answser"));
		Reporter.log("User Entered Correct Answser for Question 1");
		fullEPrashasanLoginPage3.popupQuestionAnswer.textboxAnswer2.sendKeys(data.get("question_2_answser"));
		Reporter.log("User Entered Correct Answser for Question 2");
		
		fullEPrashasanLoginPage3.popupQuestionAnswer.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		fullEPrashasanLoginPage3.popupEnterNewPassword.waitForPopupToLoad();
		fullEPrashasanLoginPage3.popupEnterNewPassword.headerForgotPassword.verifyVisible();
		
		fullEPrashasanLoginPage3.popupEnterNewPassword.textboxEnterNewPassword.waitForVisible();
		fullEPrashasanLoginPage3.popupEnterNewPassword.textboxEnterNewPassword.sendKeys(data.get("password"));
		Reporter.log("User Entered new password");
		fullEPrashasanLoginPage3.popupEnterNewPassword.buttonSubmit.click();
		Reporter.log("User Clicked on Submit Button");
		
		EPUtils.sleep(4000);
		verifyTrue(Windowalert.getText().contains("Password Updated Successfully"), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		
	}
}
