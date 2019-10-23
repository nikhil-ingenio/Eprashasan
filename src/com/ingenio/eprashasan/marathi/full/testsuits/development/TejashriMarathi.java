package com.ingenio.eprashasan.marathi.full.testsuits.development;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanEditStudentInformationPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanEducationOfficerNoAndConcessionPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanOtherDetailsFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanQuickRegistrationFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStudentAdmissionFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

//FORGOT PASSWORD
public class TejashriMarathi extends WebDriverTestCase{
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Forgot Password?']}")
	@QAFTestStep(description = "Validate the functionality of \"Forgot Password?\" link")
	public void TC_ForPass_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		verifyTrue(Windowalert.getText().contains("चुकीचे वापरकर्ता नाव"), "Wrong UserName message not displayed",
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		verifyTrue(Windowalert.getText().contains("प्रश्नांची उत्तरे तपासून पहा"), 
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		verifyTrue(Windowalert.getText().contains("प्रश्नांची उत्तरे तपासून पहा"), 
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		verifyTrue(Windowalert.getText().contains("प्रश्नांची उत्तरे तपासून पहा"), 
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		verifyTrue(Windowalert.getText().contains("पासवर्ड / गुप्तमाहितीत बदल यशस्वीपणे झाला."), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		FullEPrashasanLoginPage fullEPrashasanLoginPage2 = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage2.waitForPageToLoad();
		
		fullEPrashasanLoginPage2.dropdownDBName.selectByValue("dbm5");
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
		
		fullEPrashasanLoginPage3.dropdownDBName.selectByValue("dbm5");
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
		verifyTrue(Windowalert.getText().contains("पासवर्ड / गुप्तमाहितीत बदल यशस्वीपणे झाला."), 
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
		
		fullEPrashasanLoginPage.dropdownDBName.selectByValue("dbm5");
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
		
		verifyTrue(Windowalert.getText().contains("पासवर्ड / गुप्तमाहितीत बदल यशस्वीपणे झाला."), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage2 = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage2.waitForPageToLoad();
		
		fullEPrashasanLoginPage2.dropdownDBName.selectByValue("dbm5");
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
		
		fullEPrashasanLoginPage3.dropdownDBName.selectByValue("dbm5");
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
		verifyTrue(Windowalert.getText().contains("पासवर्ड / गुप्तमाहितीत बदल यशस्वीपणे झाला."), 
				"Password Updated Successfully message not displayed",
				"Password Updated Successfully message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();
		
	}
	//Change Password
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Change Password']}")
	@QAFTestStep(description = "Validate the functionality of \"Submit\" button with blank fields")
	public void TC_ChPas_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		Actions builder = new Actions(getDriver());
		builder.moveToElement(fullEPrashasanWelcomePage.dropdownToggleOnUsername).perform();
		EPUtils.sleep(4000);
		fullEPrashasanWelcomePage.linkChangePassword.waitForVisible();
		fullEPrashasanWelcomePage.linkChangePassword.click();
		
		fullEPrashasanWelcomePage.popupChangePassword.waitForPopupToLoad();
		fullEPrashasanWelcomePage.popupChangePassword.verifyVisible();
		
		fullEPrashasanWelcomePage.popupChangePassword.buttonSubmit.waitForVisible();
		fullEPrashasanWelcomePage.popupChangePassword.buttonSubmit.click();
		
		EPUtils.sleep(4000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Please Enter Correct old Password"), 
				"Please Enter Correct old Password message not displayed",
				"Please Enter Correct old Password message displayed");
		
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().defaultContent();	
	}
	
//Quick Registration
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by entering all mandatory fields")
	public void TC_Admis_Quick_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		Reporter.log("User Clicked on button Add");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("पडताळुन पहा."), 
				"पडताळुन पहा. Alert message not displayed",
				"पडताळुन पहा. Alert message displayed");
		
		getDriver().switchTo().alert().accept();
		EPUtils.sleep(3000);
		verifyTrue(Windowalert.getText().contains("माहिती जतन झाली आहे"), 
				"माहिती जतन झाली आहे message not displayed",
				"माहिती जतन झाली आहे message displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Cancel\" buttun functionality by entering all mandatory fields")
	public void TC_Admis_Quick_02(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonReset.click();
		Reporter.log("User Clicked on button Reset");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("पडताळुन पहा."), 
				"पडताळुन पहा. Alert message not displayed",
				"पडताळुन पहा. Alert message displayed");
		
		getDriver().switchTo().alert().accept();
		EPUtils.sleep(3000);
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Academic year")
	public void TC_Admis_Quick_03(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
	
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality with \"Registration Number\" mandatory field blank")
	public void TC_Admis_Quick_04(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality \"First Name\" field blank")
	public void TC_Admis_Quick_05(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality \"Middle Name\" field blank")
	public void TC_Admis_Quick_06(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality \"Last Name\" field blank")
	public void TC_Admis_Quick_07(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  Class value in \"Class\" drop down list")
	public void TC_Admis_Quick_12(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  \"Date\" in \"Birth Date\" drop down list")
	public void TC_Admis_Quick_13(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  month value of \"Birth Date\" drop down list")
	public void TC_Admis_Quick_15(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  Year value of \"Birth Date\" drop down list")
	public void TC_Admis_Quick_16(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by selecting invalid date for a month")
	public void TC_Admis_Quick_18(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(31);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(6);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
	
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select valid month."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  Caste")
	public void TC_Admis_Quick_19(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  category")
	public void TC_Admis_Quick_20(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
	
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  Religion")
	public void TC_Admis_Quick_21(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by entering duplicate Registration Number")
	public void TC_Admis_Quick_22(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		
		Reporter.log("User Clicked on button Add");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message displayed",
				"Are You Sure? Alert message not displayed");
		
		getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by entering all type(Alphanumeric,Special Charecters) data in \"Registration Number\" field")
	public void TC_Admis_Quick_23(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkQuickRegistration.click();
		Reporter.log("User Clicked on Quick Registration Link");
		
		FullEPrashasanQuickRegistrationFormPage fullEPrashasanQuickRegistrationFormPage = new FullEPrashasanQuickRegistrationFormPage();
		fullEPrashasanQuickRegistrationFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling details");
		
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("१००#");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("माळी");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.executeScript("value='ओबीसी'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.executeScript("value='काळे'");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(7);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.executeScript("value='हिंदु'");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		Reporter.log("User Clicked on button Add");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
		EPUtils.sleep(3000);
		verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				"Record Inserted Successfully message not displayed",
				"Record Inserted Successfully message displayed");
	}
	
//Student Admission
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" functionality by entering all data")
	public void TC_Admis_StudAdm_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		Reporter.log("User started filling details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownMedium.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownInitialName.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxBirthPlace.executeScript("value='श्रीगोंदा'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		Reporter.log("User Clicked on button Add");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("पडताळुन पहा."), 
				"पडताळुन पहा. Alert message not displayed",
				"पडताळुन पहा. Alert message displayed");
		
		getDriver().switchTo().alert().accept();
		EPUtils.sleep(3000);
		verifyTrue(Windowalert.getText().contains("माहिती जतन झाली आहे"), 
				"माहिती जतन झाली आहे message not displayed",
				"माहिती जतन झाली आहे message displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Cancel\" button functionality of confirmation message popup")
	public void TC_Admis_StudAdm_02(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonReset.click();
		Reporter.log("User Clicked on button Reset");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("पडताळुन पहा."), 
				"पडताळुन पहा. Alert message not displayed",
				"पडताळुन पहा. Alert message displayed");
		
		getDriver().switchTo().alert().dismiss();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Academic year")
	public void TC_Admis_StudAdm_03(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Registration Number")
	public void TC_Admis_StudAdm_04(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Admission Date")
	public void TC_Admis_StudAdm_05(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Admission Month")
	public void TC_Admis_StudAdm_06(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
	  	//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Admission Year")
	public void TC_Admis_StudAdm_07(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Admission Month")
	public void TC_Admis_StudAdm_08(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Class")
	public void TC_Admis_StudAdm_09(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		//fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.sendKeys("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting First Name")
	public void TC_Admis_StudAdm_10(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Middle Name")
	public void TC_Admis_StudAdm_11(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Last Name")
	public void TC_Admis_StudAdm_12(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  \"Date\" in \"Birth Date\" drop down list")
	public void TC_Admis_StudAdm_13(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  month value of \"Birth Date\" drop down list")
	public void TC_Admis_StudAdm_14(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting  Year value of \"Birth Date\" drop down list")
	public void TC_Admis_StudAdm_15(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Caste")
	public void TC_Admis_StudAdm_17(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Category")
	public void TC_Admis_StudAdm_18(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Religion")
	public void TC_Admis_StudAdm_19(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Gender")
	public void TC_Admis_StudAdm_20(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
		Reporter.log("User Clicked on Student Admission Link");
		
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("११२२३३४");
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.executeScript("value='तुषार'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.executeScript("value='संपत'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.executeScript("value='काकडे'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
		//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByVisibleText("कुणबी");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.executeScript("value='मराठी'");
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.executeScript("value='भारतीय'");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रेखा");
		fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५४७१२३४");
		
		fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
		
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	//Edit Student Information
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Information of Student\" checkbox functionality by disselcting the checkbox")
	public void TC_Admis_Edit_01(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxInformationOfStudent.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Information of Student\" checkbox functionality by selcting the cheked checkbox")
	public void TC_Admis_Edit_02(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxInformationOfStudent.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxInformationOfStudent.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting any criteria")
	public void TC_Admis_Edit_03(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				"Alert message displayed",
				"Alert message not displayed");
		
		getDriver().switchTo().alert().dismiss();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Academic Year\" for which record exist")
	public void TC_Admis_Edit_04(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		
		getDriver().switchTo();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Academic Year\" for which record is not exist")
	public void TC_Admis_Edit_05(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(16);
		//fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		
		getDriver().switchTo().alert().dismiss();
	}

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Class\" for which record exist")
	public void TC_Admis_Edit_06(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting\"Class\" for which record is not exist")
	public void TC_Admis_Edit_07(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
	   	//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(7);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Division\" drop down  list by without selecting \"Class\" ")
	public void TC_Admis_Edit_08(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.click();

		EPUtils.sleep(3000);
		getDriver().switchTo();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Division\" drop down  list by  selecting \"Class ")
	public void TC_Admis_Edit_09(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Division\" for which record exist ")
	public void TC_Admis_Edit_10(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Division\" for which record is not exist")
	public void TC_Admis_Edit_11(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Religion\" for which record exist")
	public void TC_Admis_Edit_12(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Religion\" for which record is not exist")
	public void TC_Admis_Edit_13(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownReligion.selectByIndex(9);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Caste\" for which record exist")
	public void TC_Admis_Edit_14(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCaste.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
				
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Religion\" for which record is not exist")
	public void TC_Admis_Edit_15(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate Autocomplete functionality by entering name in the \"Student Name\" field")
	public void TC_Admis_Edit_16(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("Riya");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting name from autocomplete list")
	public void TC_Admis_Edit_17(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("Randhe Riya Vilas");
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by without selecting name from autocomplete list")
	public void TC_Admis_Edit_18(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("Randhe Riya Vilas");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by  selecting left student name from autocomplete list")
	public void TC_Admis_Edit_19(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.executeScript("value='सोनवणे आर्यन उल्हास'");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by entering present student(Not left) registration number in \"Registration Number\" field")
	public void TC_Admis_Edit_20(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("१६५५");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by entering left student registration number in \"Reg.No.\"field")
	public void TC_Admis_Edit_21(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.executeScript("value='१६१४'");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number which include all type data for which record exist")
	public void TC_Admis_Edit_22(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821$1");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number for which record is not exist")
	public void TC_Admis_Edit_23(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4824");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by without entering \"From\" value of the \"Parent Income\"")
	public void TC_Admis_Edit_24(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("1000000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("enter the \"From\" value of the \"Parent Income"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  entering \"From\" and \"To\" value of the \"Parent Income\" for which record exist")
	public void TC_Admis_Edit_25(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("100000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeFrom.sendKeys("500000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("enter the \"From\" value of the \"Parent Income"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  entering \"From\" and \"To\" value of the \"Parent Income\" for which record exist")
	public void TC_Admis_Edit_26(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("10000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeFrom.sendKeys("5000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by   entering \"From\" and \"To\" value of the \"Parent Income\" for which record is not exist")
	public void TC_Admis_Edit_27(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("1000000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeFrom.sendKeys("500000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by   entering \"To\"  value less than \"From\" value of the \"Parent Income")
	public void TC_Admis_Edit_28(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("5000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeFrom.sendKeys("10000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Male\" from \"Gender\" drop down list")
	public void TC_Admis_Edit_29(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownGender.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Female\" from \"Gender\" drop down list")
	public void TC_Admis_Edit_30(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownGender.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Academic Year\" for which gender is not assigned for the student")
	public void TC_Admis_Edit_31(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownGender.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Category\" for which record exist")
	public void TC_Admis_Edit_32(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCategory.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Category\" for which record is not exist")
	public void TC_Admis_Edit_33(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCategory.selectByIndex(10);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by changing default value of the \"Date For Age Calculation")
	public void TC_Admis_Edit_34(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.sendKeys("15-06-2000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by changing date in invalid  formate(formate other than dd-mm-yyyy")
	public void TC_Admis_Edit_35(Map<String, String> data) {
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.clear();
		EPUtils.sleep(3000);
		//fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.click();
		fullEPrashasanEditStudentInformationPage.datePickerComponent.selectYear.selectByIndex(2018);
		fullEPrashasanEditStudentInformationPage.datePickerComponent.selectDay("11");
		fullEPrashasanEditStudentInformationPage.datePickerComponent.selectMonth.selectByIndex(05);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया योग्य तारीख भरा."), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Sort By Roll No.\" checkbox functionality by selecting Class and Division")
	public void TC_Admis_Edit_36(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Sort By Roll No.\" checkbox functionality by disselecting the checkbox with Class and Division selection")
	public void TC_Admis_Edit_37(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Sort By Roll No.\" checkbox functionality by selecting the checkbox without selection of \"Class")
	public void TC_Admis_Edit_38(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया वर्ग निवडा...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Sort By Roll No.\" checkbox functionality by selecting the checkbox without selection of \"Division")
	public void TC_Admis_Edit_39(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया तुकडी निवडा...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering \"Additional Student Details\" data for which record is exist")
	public void TC_Admis_Edit_40(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().switchTo();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering \"Additional Student Details\" data for which record is not exist")
	public void TC_Admis_Edit_41(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxStudentId.sendKeys("4766");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate the pagination functionality")
	public void TC_Admis_Edit_42(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownPage.selectByIndex(2);
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Verify default column selected on the \"Select Columns For Search\" popup of the custom search")
	public void TC_Admis_Edit_56(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting 15 columns(Including default selection) on the \"Select Columns For Search\" popup of the \"Custom Search\"")
	public void TC_Admis_Edit_57(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankIFCSCode.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAadharCardNo.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAccountNo.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAddressDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownCaste.verifyPresent();
	
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting more than 15 columns(Including default selection) on the \"Select Columns For Search\" popup of the \"Custom Search")
	public void TC_Admis_Edit_58(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		EPUtils.sleep(3000);
		
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAddressDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("जास्तीत जास्त 25 पर्याय निवडू शकता"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Academic Year\" for which record exist")
	public void TC_Admis_Edit_59(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Academic Year\" for which record is not exist")
	public void TC_Admis_Edit_60(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(16);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Class\" for which record exist")
	public void TC_Admis_Edit_61(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom searchby  selecting\"Class\" for which record is not exist")
	public void TC_Admis_Edit_62(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Division\" for which record exist")
	public void TC_Admis_Edit_63(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom searchby  selecting \"Division\" for which record is not exist")
	public void TC_Admis_Edit_64(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Religion\" for which record exist")
	public void TC_Admis_Edit_65(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Religion\" for which record is not exist")
	public void TC_Admis_Edit_66(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownReligion.selectByIndex(9);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom searchby  selecting \"Caste\" for which record exist")
	public void TC_Admis_Edit_67(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCaste.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom searchby  selecting \"Caste\" for which record is not exist")
	public void TC_Admis_Edit_68(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCaste.selectByIndex(138);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCaste.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting name from autocomplete list")
	public void TC_Admis_Edit_69(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("");
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCaste.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by without selecting name from autocomplete list")
	public void TC_Admis_Edit_70(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("रांधे रिया विलास");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("माहिती उपलब्ध नाही...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting left student name from autocomplete list")
	public void TC_Admis_Edit_71(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		Reporter.log("User Clicked on Search Button");
		
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
				" Alert message displayed",
				" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by entering present student(Not left) registration number in \"Registration Number\" field")
	public void TC_Admis_Edit_72(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4823");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by entering left student registration number in \"Reg.No.\"field")
	public void TC_Admis_Edit_73(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("1513");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
		}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by entering registration number which include all type data for which record exist")
	public void TC_Admis_Edit_74(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821@");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by entering registration number for which record is not exist")
	public void TC_Admis_Edit_75(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by without entering \"From\" value of the \"Parent Income")
	public void TC_Admis_Edit_76(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		//fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("10000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting gender as \"Male\" from \"Gender\" drop down list")
	public void TC_Admis_Edit_81(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting gender as \"Female\" from \"Gender\" drop down list")
	public void TC_Admis_Edit_82(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownGender.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
   }
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting \"Academic Year\" for which gender is not assigned for the student")
	public void TC_Admis_Edit_83(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownGender.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
   }
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Category\" for which record exist")
	public void TC_Admis_Edit_84(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		//fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCategory.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Category\" for which record is not exist")
	public void TC_Admis_Edit_85(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCategory.selectByIndex(10);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by changing default value of the \"Date For Age Calculation")
	public void TC_Admis_Edit_86(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.sendKeys("1-1-2000");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by changing default value of the \"Date For Age Calculation")
	public void TC_Admis_Edit_87(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.sendKeys("2000-15-05");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Please Enter Valid Date."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting Class and Division")
	public void TC_Admis_Edit_88(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by disselecting the checkbox with Class and Division selection")
	public void TC_Admis_Edit_89(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User Clicked on Search Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting the checkbox without selection of \"Class")
	public void TC_Admis_Edit_90(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		
		Reporter.log("User Click On Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया वर्ग निवडा...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting the checkbox without selection of \"Division")
	public void TC_Admis_Edit_91(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		
		Reporter.log("User Click On Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया तुकडी निवडा...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by entering \"Additional Student Details\" data for which record is exist")
	public void TC_Admis_Edit_92(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		
		Reporter.log("User Click On Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया वर्ग निवडा...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering \"Additional Student Details\" data for which record is not exist")
	public void TC_Admis_Edit_93(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		
		Reporter.log("User Click On Search Button");
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("कृपया तुकडी निवडा...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Reset\" button functionality")
	public void TC_Admis_Edit_94(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAccountNo.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonReset.click();
		EPUtils.sleep(3000);
		
		Reporter.log("User Click On Reset Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate the pagination functionality")
	public void TC_Admis_Edit_95(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownPage.selectByIndex(2);
		EPUtils.sleep(3000);

		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Basic Detail\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_109(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		EPUtils.sleep(3000);

		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Basic Detail\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_110(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		EPUtils.sleep(3000);

		getDriver().close();
	}
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Basic Detail\" checkbox by manualy selcting all checkbox of the \"Student Basic Detail\" form")
	public void TC_Admis_Edit_111(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		EPUtils.sleep(3000);

		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Current Academic Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_113(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		EPUtils.sleep(3000);

		//getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Current Academic Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_114(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		EPUtils.sleep(3000);

		//getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Address Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_117(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAddressDetails.click();
		EPUtils.sleep(5000);

		//getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Address Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_118(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAddressDetails.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAddressDetails.click();
		EPUtils.sleep(5000);

		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Parent Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_121(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
		EPUtils.sleep(5000);

		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Parent Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_122(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Bank Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_125(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Bank Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_126(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Contact Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_129(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Contact Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_130(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Previous School and Other Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_133(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Previous School and Other Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_134(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Additional Student Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_137(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		EPUtils.sleep(5000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Additional Student Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_138(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Other Details\" checkbox by selecting checkbox")
	public void TC_Admis_Edit_141(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxOtherDetails.click();
		EPUtils.sleep(5000);
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Other Details\" checkbox by disselecting checkbox")
	public void TC_Admis_Edit_142(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxOtherDetails.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxOtherDetails.click();
		EPUtils.sleep(5000);
	}
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Other Details\" checkbox by  disselcting one of the checkbox of the  \"Other Details\" form")
	public void TC_Admis_Edit_144(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		EPUtils.sleep(5000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxOtherDetails.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentID.click();
		EPUtils.sleep(5000);
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Student Basic Details\" form")
	public void TC_Admis_Edit_145(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		
		EPUtils.sleep(5000);
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"First Name\" field blank")
	public void TC_Admis_Edit_146(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
	//	fullEPrashasanEditStudentInformationPage.
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		
		EPUtils.sleep(5000);
	}
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Middle Name\" field blank")
	public void TC_Admis_Edit_147(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Last Name\" field blank")
	public void TC_Admis_Edit_148(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Birth Date\" field blank")
	public void TC_Admis_Edit_149(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by entering \"Birth Date\" in invalid formate(i.e.formate other than dd-mm-yyyy)")
	public void TC_Admis_Edit_150(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Gender\" drop down value as \"Select Gender")
	public void TC_Admis_Edit_151(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Religion\" drop down value as \"Select Religion")
	public void TC_Admis_Edit_152(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate ediatbility of the \"Current Academic Year\" column of the \"Current Academic Details\" form")
	public void TC_Admis_Edit_153(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Current Academic Details\" form")
	public void TC_Admis_Edit_154(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Address Details\" form")
	public void TC_Admis_Edit_159(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCurrentAcademicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Parent Details\" form")
	public void TC_Admis_Edit_160(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality \"Father Name\" field blank")
	public void TC_Admis_Edit_161(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxFatherName.clear();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("रिक्त जागा वापरण्यास परवानगी नाही."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality \"Mother Name\" field blank")
	public void TC_Admis_Edit_162(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxMotherName.clear();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("रिक्त जागा वापरण्यास परवानगी नाही."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Bank Details\" form")
	public void TC_Admis_Edit_163(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Aadhar Card No.\" field validation by entering number less than 12 digits")
	public void TC_Admis_Edit_164(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Addhar Card Number Must be 12 digits..!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Aadhar Card No.\" field validation by entering number more than 12 digits")
	public void TC_Admis_Edit_165(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Student Mobile\" field of the \"Student Contact Details\" form blank")
	public void TC_Admis_Edit_167(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Mobile Nummber must be in 12 or 10 Digit..!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering number less than 10 digits")
	public void TC_Admis_Edit_168(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxMobileNo.sendKeys("९८५६४७५८");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("कृपया मोबाईल क्र.तपासा, १० ते १२ अंकीच असावा...!!! "), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering 10 digits number")
	public void TC_Admis_Edit_169(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxMobileNo.sendKeys("८८५६३२१४५२");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering 11 digits number")
	public void TC_Admis_Edit_170(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxMobileNo.sendKeys("९८५६३२१४५२१");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering 12 digits number")
	public void TC_Admis_Edit_171(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxMobileNo.sendKeys("986547123654");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering number more than the 12 digits")
	public void TC_Admis_Edit_172(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Mobile Nummber must be in 12 or 10 Digit..!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Email Id\" field validation by entering email id in wrong formate(i.e formate other than a@l.k)")
	public void TC_Admis_Edit_173(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxEmailId.executeScript("value='abc#ll.com'");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("कृपया ई-मैल तपासा..!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Previous School and Other Details\" form")
	public void TC_Admis_Edit_174(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Previous School Name\" field of the \"Previous School and Other Details\" form blank")
	public void TC_Admis_Edit_175(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Mothertongue\" field of the \"Previous School and Other Details\" form blank")
	public void TC_Admis_Edit_176(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Additional Student Details\" form")
	public void TC_Admis_Edit_177(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Nationality\" field of the \"Additional Student Details\" form blank")
	public void TC_Admis_Edit_178(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Category\" value of the \"Additional Student Details\" as \"Select Category")
	public void TC_Admis_Edit_179(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Caste\" value of the \"Additional Student Details\" as \"Select Caste\"")
	public void TC_Admis_Edit_180(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownCaste.selectByIndex(0);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownCaste.verifyPresent();
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"SBC\" for the student")
	public void TC_Admis_Edit_181(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"NT-3\" for the student")
	public void TC_Admis_Edit_182(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(3);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"SC\" for the student")
	public void TC_Admis_Edit_183(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(8);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"OBC\" for the student")
	public void TC_Admis_Edit_184(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(10);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"NT-1\" for the student")
	public void TC_Admis_Edit_185(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(3);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"NT-2\" for the student")
	public void TC_Admis_Edit_186(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(6);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"VJDT\" for the student")
	public void TC_Admis_Edit_187(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"TRIBAL\" for the student")
	public void TC_Admis_Edit_188(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(6);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"EBC\" for the student")
	public void TC_Admis_Edit_189(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"Other\" for the student")
	public void TC_Admis_Edit_190(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(11);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Muslim\" for the student")
	public void TC_Admis_Edit_191(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(3);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Punjabi\" for the student")
	public void TC_Admis_Edit_192(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Jain\" for the student")
	public void TC_Admis_Edit_193(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(4);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Sikh\" for the student")
	public void TC_Admis_Edit_194(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(4);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Parsi\" for the student")
	public void TC_Admis_Edit_195(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(2);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Catholic\" for the student")
	public void TC_Admis_Edit_196(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(6);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Other\" for the student")
	public void TC_Admis_Edit_197(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(7);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Other Details\" form")
	public void TC_Admis_Edit_198(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxOtherDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(3000);
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxStudentID.clear();
		fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxStudentID.sendKeys("1234567989");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
		EPUtils.sleep(5000);
		Reporter.log("User Clicked on Save Data Button");
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("यशस्वीपणे जतन करण्यात आले.."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
	}
	
//Other Details Module
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Academic Year\" for which record is exist")
	public void TC_Admis_OthDet_01(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByOptionValue("2016-2017");
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().dismiss();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Academic Year\" for which record is not exist")
	public void TC_Admis_OthDet_02(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByOptionValue("२००३-२००४");
		EPUtils.sleep(3000);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
					" Alert message displayed",
					" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
    }
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Class\" for which record is exist")
	public void TC_Admis_OthDet_03(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByOptionValue("2012-2013");
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(2);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
	}

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Class\" for which record is not exist")
	public void TC_Admis_OthDet_04(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByOptionValue("2016-2017");
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(2);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
    }
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Division\" drop down  list by  selecting \"Class\"")
	public void TC_Admis_OthDet_05(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanEducationOfficerNoAndConcessionPage fullEPrashasanEducationOfficerNoAndConcessionPage = new FullEPrashasanEducationOfficerNoAndConcessionPage();
		fullEPrashasanEducationOfficerNoAndConcessionPage.waitForPageToLoad();
		
		fullEPrashasanEducationOfficerNoAndConcessionPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		fullEPrashasanEducationOfficerNoAndConcessionPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		fullEPrashasanEducationOfficerNoAndConcessionPage.searchStudentComponent.dropdownSelectDDivision.selectByIndex(1);
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanEducationOfficerNoAndConcessionPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
	    }
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Division\" for which record exist")
	public void TC_Admis_OthDet_06(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDDivision.selectByIndex(1);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Division\" for which record is not exist")
	public void TC_Admis_OthDet_07(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDDivision.selectByIndex(4);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by entering present student(Not left) registration number in \"Registration Number\" field")
	public void TC_Admis_OthDet_12(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4828");
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by entering left student registration number in \"Reg.No.\"field")
	public void TC_Admis_OthDet_13(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("१");
		EPUtils.sleep(3000);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		EPUtils.sleep(3000);
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number which include all type data for which record exist")
	public void TC_Admis_OthDet_14(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("७a!");
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
	
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number for which record is not exist")
	public void TC_Admis_OthDet_15(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("४५६३");
		EPUtils.sleep(3000);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("विद्यार्थ्याची माहिती उपलब्ध नाही...!"), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Male\" from \"Gender\" drop down list")
	public void TC_Admis_OthDet_16(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		//fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownGender.selectByIndex(1);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Female\" from \"Gender\" drop down list")
	public void TC_Admis_OthDet_17(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownGender.selectByIndex(2);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Category\" for which record exist")
	public void TC_Admis_OthDet_19(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(2);
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	


	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Category\" for which record is not exist")
	public void TC_Admis_OthDet_25(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4151");
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by entering all type(Alphanumeric Value, special charecters) of the data in \"Education Officer No.\" column")
	public void TC_Admis_OthDet_38(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxEduOffNo.sendKeys("$123");
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"SBC\" for the student")
	public void TC_Admis_OthDet_39(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByOptionValue("SBC");
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"NT-3\" for the student")
	public void TC_Admis_OthDet_40(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(2);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"SC\" for the student")
	public void TC_Admis_OthDet_41(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(3);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"OBC\" for the student")
	public void TC_Admis_OthDet_42(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(4);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"NT-1\" for the student")
	public void TC_Admis_OthDet_43(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(5);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"NT-2\" for the student")
	public void TC_Admis_OthDet_44(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(6);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"VJDT\" for the student")
	public void TC_Admis_OthDet_45(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(7);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"TRIBAL\" for the student")
	public void TC_Admis_OthDet_46(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(8);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"EBC\" for the student")
	public void TC_Admis_OthDet_47(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(9);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		//Alert Windowalert = getDriver().switchTo().alert();
				
		//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
		//				" Alert message displayed",
		//				" Alert message not displayed");
		//getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Concession\" drop down value as \"Other\" for the student")
	public void TC_Admis_OthDet_48(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCConcession.selectByIndex(10);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Muslim\" for the student")
	public void TC_Admis_OthDet_49(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(1);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Punjabi\" for the student")
	public void TC_Admis_OthDet_50(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(2);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Jain\" for the student")
	public void TC_Admis_OthDet_51(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(3);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Sikh\" for the student")
	public void TC_Admis_OthDet_52(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(4);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Parsi\" for the student")
	public void TC_Admis_OthDet_53(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(5);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Catholic\" for the student")
	public void TC_Admis_OthDet_54(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(6);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Admission']}")
	@QAFTestStep(description = "Validate \"Save\" button functionality by selecting \"Minority Type\" drop down value as \"Other\" for the student")
	public void TC_Admis_OthDet_55(Map<String, String>data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
		Reporter.log("User Clicked on Addmission Link");
		
		FullEPrashasanStudentAdmissionFormPage fullEPrashasanStudentAdmissionFormPage = new FullEPrashasanStudentAdmissionFormPage();
		fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
	
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkOtherDetails.click();
		
		Reporter.log("User Clicked on Other Details link");
		
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEduOfficerNoConcession.click();
		
		FullEPrashasanOtherDetailsFormPage fullEPrashasanOtherDetailsFormPage = new FullEPrashasanOtherDetailsFormPage();
		fullEPrashasanOtherDetailsFormPage.waitForPageToLoad();
		
		
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectClass.selectByIndex(1);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectDivisions.selectByIndex(4);
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownCategory.selectByIndex(4);
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4840");
		//fullEPrashasanOtherDetailsFormPage.searchStudentComponent.iconNext.click();
		
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSSearch.click();
		
		fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		
		fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownMMinority.selectByIndex(7);
	
        
        fullEPrashasanOtherDetailsFormPage.searchStudentComponent.buttonSave.click();
		
        fullEPrashasanOtherDetailsFormPage.renewStudentComponent.waitForPopupToLoad();
		Reporter.log("User started filling Details");
		
		Alert Windowalert = getDriver().switchTo().alert();
				
		verifyTrue(Windowalert.getText().contains("Information Saved Successfully..."), 
						" Alert message displayed",
						" Alert message not displayed");
		getDriver().switchTo().alert().accept();
		
		
		
	    }
	
	
}
