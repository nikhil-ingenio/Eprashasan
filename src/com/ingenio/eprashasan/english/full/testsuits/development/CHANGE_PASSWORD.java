package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class CHANGE_PASSWORD extends WebDriverTestCase {

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
	
}
