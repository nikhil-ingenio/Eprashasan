package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanQuickRegistrationFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStudentAdmissionFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class ADMISSION extends WebDriverTestCase{

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
		fullEPrashasanWelcomePage.waitForPageToLoad();
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
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.selectByOptionValue("OBC");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.selectByOptionValue("Hindu");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("100");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
		
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
		fullEPrashasanWelcomePage.waitForPageToLoad();
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
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.selectByOptionValue("OBC");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.selectByOptionValue("Hindu");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear.selectByOptionValue("2017-2018");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("100");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Maratha");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
		Reporter.log("User Clicked on button Add");
		EPUtils.sleep(3000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().dismiss();
		EPUtils.sleep(2000);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.verifyValue("Jay");
		
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
		fullEPrashasanWelcomePage.waitForPageToLoad();
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
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCategory.selectByOptionValue("OBC");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownReligion.selectByOptionValue("Hindu");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("100");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
		
		fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
	
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownAcademicYear);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		verifyTrue(errorMessage.equals("Please select an item in the list."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
}
