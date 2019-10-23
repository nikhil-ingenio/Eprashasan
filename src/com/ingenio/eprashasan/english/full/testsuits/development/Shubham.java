package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanDivisionAndRollNoMgtFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanDivisionManagementFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanEducationOfficerNoAndConcessionPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanExtraCurricularActivityFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanExtraCurricularActivitySearchEngineFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanFillExtraActivityFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanOtherDetailsFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanRenewAdmissionFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStudentAdmissionFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStudentHealthInfoFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanUpdateStudDivisionFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanUpdateStudRegNoFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class Shubham extends WebDriverTestCase{
	//Renew & Re-Admission Module
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Year\" and \"Standard\" for which record exist")
		public void TC_Admis_Ren_01(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(2);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("1234");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("shubham");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
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
		@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Year\" and \"Standard\" for which record is not exist")
		public void TC_Admis_Ren_02(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2016-2017");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(3);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("1234");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("shubham");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
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
		@QAFTestStep(description = "Validate \"Search\" functionality by without selecting any criteria")
		public void TC_Admis_Ren_03(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2016-2017");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(3);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("1234");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("shubham");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
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
		@QAFTestStep(description = "Verify \"Student Information\" form by selecting \"Year\",\"Standard\",\"Division\" for which record exist ")
		public void TC_Admis_Ren_04(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(4);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("1234");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("shubham");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
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
		@QAFTestStep(description = "Validate \"Search\" functionality by entering registration No. for which record is exist")
		public void TC_Admis_Ren_05(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(4);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("5700");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("shubham");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
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
		@QAFTestStep(description = "Validate \"Search\" functionality by entering registration No. for which record is not exist")
		public void TC_Admis_Ren_06(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(4);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("shubham");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
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
		@QAFTestStep(description = "Validate Autocomplete functionality for \"Student Name\" by entering name in the \"Student Name\" field")
		public void TC_Admis_Ren_07(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(4);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.OptionSelectName.click();
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
			Reporter.log("User started filling Details");
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			getDriver().switchTo().alert().dismiss();
			
			
			*/
			}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by without selecting name from autocomplete list")
		public void TC_Admis_Ren_09(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(4);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			
			fullEPrashasanRenewAdmissionFormPage.renewStudentComponent.waitForPopupToLoad();
			
			Reporter.log("User started filling Details");
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by selecting checkbox")
		public void TC_Admis_Ren_10(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by disselecting checked checkbox")
		public void TC_Admis_Ren_11(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			EPUtils.sleep(2000);
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			EPUtils.sleep(2000);
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by selecting it")
		public void TC_Admis_Ren_12(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(0).click();
			EPUtils.sleep(2000);
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			//EPUtils.sleep(2000);
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting it")
		public void TC_Admis_Ren_13(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(0).click();
			EPUtils.sleep(2000);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(0).click();
			EPUtils.sleep(2000);
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			//EPUtils.sleep(2000);
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting single or multiple record in a grid")
		public void TC_Admis_Ren_14(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(0).click();
			EPUtils.sleep(2000);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			EPUtils.sleep(2000);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(2).click();
			EPUtils.sleep(2000);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			//EPUtils.sleep(2000);
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Renew Student\" button functionality by selecting record")
		public void TC_Admis_Ren_30(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			EPUtils.sleep(2000);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonRenewStudent.click();
			EPUtils.sleep(2000);
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Renew Student\" button functionality by without selecting record")
		public void TC_Admis_Ren_31(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkRenewAndReAdmission.click();
			
			Reporter.log("User Clicked on Renew & Readmission Link");
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentRenew.click();
			
			FullEPrashasanRenewAdmissionFormPage fullEPrashasanRenewAdmissionFormPage = new FullEPrashasanRenewAdmissionFormPage();
			fullEPrashasanRenewAdmissionFormPage.waitForPageToLoad();
			
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxRegistrationNo.sendKeys("570");
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Sonali");
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			//fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.CheckBox.get(1).click();
			//EPUtils.sleep(2000);
			fullEPrashasanRenewAdmissionFormPage.SearchStudentComponent.buttonRenewStudent.click();
			EPUtils.sleep(2000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Student"), 
							" Alert message not displayed",
							" Alert message displayed");
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
			
			fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownSelectYear.selectByOptionValue("2012-2013");
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
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Class\" for which record is exist")
		public void TC_Admis_OthDet_03(Map<String, String>data) {
			
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
			fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("5006");
			
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
		@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number which include all type data for which record exist")
		public void TC_Admis_OthDet_14(Map<String, String>data) {
			
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
			fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4842");
			
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
		@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number for which record is not exist")
		public void TC_Admis_OthDet_15(Map<String, String>data) {
			
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
			fullEPrashasanOtherDetailsFormPage.searchStudentComponent.textboxRRegistrationNo.sendKeys("4151");
			
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
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Male\" from \"Gender\" drop down list")
		public void TC_Admis_OthDet_16(Map<String, String>data) {
			
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
			fullEPrashasanOtherDetailsFormPage.searchStudentComponent.dropdownGender.selectByIndex(1);
			
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
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting any criteria")
		public void TC_Admis_OthDet_56(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Division\" drop down  list by  selecting \"Class\" ")
		public void TC_Admis_OthDet_57(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Year\" drop down value")
		public void TC_Admis_OthDet_58(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Standard\" drop down value")
		public void TC_Admis_OthDet_59(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			//fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Division\" drop down value")
		public void TC_Admis_OthDet_60(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Division"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Semester\" drop down value")
		public void TC_Admis_OthDet_61(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting criteria for which record is exist")
		public void TC_Admis_OthDet_62(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Year\" for which record is not exist")
		public void TC_Admis_OthDet_63(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2012-2013");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Record Found..!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
		
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Standard\" for which record is not exist")
		public void TC_Admis_OthDet_64(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(2);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2016-2017");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Record Found..!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
		
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by  selecting \"Division\" for which record is not exist")
		public void TC_Admis_OthDet_65(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2016-2017");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(2);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Record Found..!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
		
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by selecting checkbox")
		public void TC_Admis_OthDet_66(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by disselecting checkbox")
		public void TC_Admis_OthDet_67(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by selecting it")
		public void TC_Admis_OthDet_68(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkboxSelectAll.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting it")
		public void TC_Admis_OthDet_69(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkboxSelectAll.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.checkboxSelectAll.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting single or multiple record in a grid")
		public void TC_Admis_OthDet_70(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkboxSelectAll.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();            			
           	//Reporter.log("User started filling Details");
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Select Year,Standard and Division and Semester"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Fill Details\" button functionality by without selecting any record")
		public void TC_Admis_OthDet_86(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			//fullEPrashasanStudentHealthInfoFormPage.checkboxSelectAll.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("please select student"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Fill Details\" button functionality by  selecting  record")
		public void TC_Admis_OthDet_87(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();            			
           	//Reporter.log("User started filling Details");
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("please select student"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup by enetering all criteria for \"Semester 1\" drop down value of the \"Semester\"")
		public void TC_Admis_OthDet_88(Map<String, String>data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(1);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34");
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad(); 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("error"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup by enetering all criteria for \"Semester 2\" drop down value of the \"Semester\"")
		public void TC_Admis_OthDet_89(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			
			getDriver().switchTo().alert().accept();
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			
			getDriver().switchTo().alert().accept();
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			
			getDriver().switchTo().alert().accept();
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34");
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad(); 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup by without entering \"Student Weight\" for a student")
		public void TC_Admis_OthDet_90(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			//fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34");
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup  by without entering \"Student Height \" for a student")
		public void TC_Admis_OthDet_91(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			//fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34");
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup by without selecting \"Student Blood Group\"")
		public void TC_Admis_OthDet_92(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			//fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34");
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup by without entering \"Chest \" for a student")
		public void TC_Admis_OthDet_93(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			//fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34");
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Student Information\" popup by without entering \"Waist\" for a student")
		public void TC_Admis_OthDet_94(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			//fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			//getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			//fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34"); 
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSave.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Close\" button functionality")
		public void TC_Admis_OthDet_97(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentHealthInfo.click();
			Thread.sleep(2500);
			
			FullEPrashasanStudentHealthInfoFormPage fullEPrashasanStudentHealthInfoFormPage = new FullEPrashasanStudentHealthInfoFormPage();
			
			
			
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.dropdownSelectSemester.selectByIndex(2);
			
			
			fullEPrashasanStudentHealthInfoFormPage.buttonSearch.click();
			
			fullEPrashasanStudentHealthInfoFormPage.checkbox1.click();
			
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			
			fullEPrashasanStudentHealthInfoFormPage.buttonFillDetails.click();
			
			           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			getDriver().switchTo().alert().accept();
			
			//fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			//getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			//fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34"); 
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonClose.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting any criteria")
		public void TC_Admis_OthDet_140(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			//Thread.sleep(2500);
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			/*           			
           	//Reporter.log("User started filling Details");
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.clear();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Enter Only Digits...!!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.clear();
			getDriver().switchTo().alert().accept();
			
			//fullEPrashasanStudentHealthInfoFormPage.textboxWaist.clear();
			//getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.clear();
			getDriver().switchTo().alert().accept();
			
			fullEPrashasanStudentHealthInfoFormPage.textboxWeight.sendKeys("60");
			fullEPrashasanStudentHealthInfoFormPage.textboxHeight.sendKeys("5.7");
			fullEPrashasanStudentHealthInfoFormPage.dropdownBloodGroup.selectByIndex(1);
			fullEPrashasanStudentHealthInfoFormPage.textboxChest.sendKeys("34");
			//fullEPrashasanStudentHealthInfoFormPage.textboxWaist.sendKeys("34"); 
			
			 
			
			fullEPrashasanStudentHealthInfoFormPage.buttonClose.click();
			fullEPrashasanStudentHealthInfoFormPage.renewStudentComponent.waitForPopupToLoad();
			*/
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Year"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Year\"")
		public void TC_Admis_OthDet_141(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Year"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Division\" drop down  list by  selecting \"Class\" ")
		public void TC_Admis_OthDet_142(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Year"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Standard\"")
		public void TC_Admis_OthDet_143(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.renewStudentComponent.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Class"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting \"Division\"")
		public void TC_Admis_OthDet_144(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Division"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting criteria for which record is exist")
		public void TC_Admis_OthDet_145(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			//Alert Windowalert = getDriver().switchTo().alert();
					
			//verifyTrue(Windowalert.getText().contains("Please Select Division"), 
			//				" Alert message displayed",
			//				" Alert message not displayed");
			//getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Year\" for which record is not  exist")
		public void TC_Admis_OthDet_146(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2015-2016");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Standard\" for which record is not  exist")
		public void TC_Admis_OthDet_147(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2016-2017");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(2);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Division\" for which record is not  exist")
		public void TC_Admis_OthDet_148(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2016-2017");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(2);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Reset\" button functionality")
		public void TC_Admis_OthDet_149(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2016-2017");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);		
			fullEPrashasanExtraCurricularActivityFormPage.buttonReset.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by selecting checkbox")
		public void TC_Admis_OthDet_150(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(1).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(1).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(1).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(1).getText());
			
			
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by disselecting checked checkbox")
		public void TC_Admis_OthDet_151(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(1).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(1).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(1).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(1).getText());
			
			
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by selecting it")
		public void TC_Admis_OthDet_152(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.checkboxSelectAll.click();
			Thread.sleep(2000);
			
			/*
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(59).getText());
			
			*/
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting it")
		public void TC_Admis_OthDet_153(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.checkboxSelectAll.click();
			Thread.sleep(2000);
			fullEPrashasanExtraCurricularActivityFormPage.checkboxSelectAll.click();
			Thread.sleep(2000);
			
			/*
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(59).getText());
			
			*/
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Students Found"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Fill Student Activity\" button functionality by without selecting record")
		public void TC_Admis_OthDet_170(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			/*
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(59).getText());
			Reporter.log(fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(59).getText());
			
			*/
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Students...!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Fill Student Activity\" button functionality by  selecting more than single record")
		public void TC_Admis_OthDet_171(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
			
			
			
			
			
			
			
			/*
			fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(2);
			fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(2);
			fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(2);
			fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(2);
			*/
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Only one Students...!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Fill Student Activity\" button functionality by  selecting  single record")
		public void TC_Admis_OthDet_172(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
			
			
			
			
			
			
			
			/*
			fullEPrashasanExtraCurricularActivityFormPage.textStudentRollNoList.get(2);
			fullEPrashasanExtraCurricularActivityFormPage.textStudentRegNoList.get(2);
			fullEPrashasanExtraCurricularActivityFormPage.textboxStudentName.get(2);
			fullEPrashasanExtraCurricularActivityFormPage.textboxGender.get(2);
			*/
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			//fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Only one Students...!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add New Activity\" button functionality of the \"Extra Activity Details\" popup ")
		public void TC_Admis_OthDet_173(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Only one Students...!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Sub Category\" list available by selecting \"Category\"")
		public void TC_Admis_OthDet_174(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Only one Students...!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by entering all criteria")
		public void TC_Admis_OthDet_175(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			//fullEPrashasanFillExtraActivityFormPage.waitForPageToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Data Save successfully"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by without selecting \"Type Of Category")
		public void TC_Admis_OthDet_176(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			//fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			//EPUtils.sleep(2000);
			//fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			//EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			//fullEPrashasanFillExtraActivityFormPage.waitForPageToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Category..!!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by without selecting \"SubCategory\"")
		public void TC_Admis_OthDet_177(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			//fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			//EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Sub-Category..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by without selecting \"Play Level\"")
		public void TC_Admis_OthDet_178(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			//fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			//EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Play Level..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by without selecting \"Rank\"")
		public void TC_Admis_OthDet_179(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			//fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			//EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Rank..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup with \"Enter Details Of Activity\" field blank")
		public void TC_Admis_OthDet_180(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			//fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill The Deatils Of Activity"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by selecting  date value of the \"Competition Date\" as \"DD\"")
		public void TC_Admis_OthDet_181(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(0);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Proper Date..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by selecting  date value of the \"Competition Date\" as \"MM\"")
		public void TC_Admis_OthDet_182(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(0);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Proper Date..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by selecting  date value of the \"Competition Date\" as \"YYYY\"")
		public void TC_Admis_OthDet_183(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(19);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(0);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Proper Date..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality of the \"Fill Extra Activity\" popup by selecting invalid date(31st for the JUNE month)")
		public void TC_Admis_OthDet_184(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(31);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonSave.click();
			
			fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Proper Date..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Cancel\" button functionality of the \"Fill Extra Activity\" popup")
		public void TC_Admis_OthDet_185(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			Thread.sleep(2500);
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectYear.selectByOptionValue("2017-2018");
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectClass.selectByIndex(1);
			Thread.sleep(2500);
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelectDivision.selectByIndex(1);
			
			
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonSearch.click();
			Thread.sleep(2000);
			
			
			fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect1.click();
			//fullEPrashasanExtraCurricularActivityFormPage.dropdownSelect2.click();
			
											
			fullEPrashasanExtraCurricularActivityFormPage.buttonFillStudentActivity.click();
			Thread.sleep(2000);
			
			fullEPrashasanExtraCurricularActivityFormPage.buttonAddExtraActivity.click();
			
			fullEPrashasanExtraCurricularActivityFormPage.waitForPopupToLoad();
			
			
			FullEPrashasanFillExtraActivityFormPage fullEPrashasanFillExtraActivityFormPage = new FullEPrashasanFillExtraActivityFormPage();
			
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectSubCategory.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectPlayLevel.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectRank.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.textboxActivityDetails.sendKeys("Inter School Football Tournament");
			EPUtils.sleep(2000);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectDate.selectByIndex(31);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectMonth.selectByIndex(6);
			fullEPrashasanFillExtraActivityFormPage.dropdownSelectYear.selectByIndex(1);
			
			
			fullEPrashasanFillExtraActivityFormPage.buttonCancel.click();
			
			//fullEPrashasanFillExtraActivityFormPage.waitForPopupToLoad();
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Proper Date..!!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by without selecting any criteria")
		public void TC_Admis_OthDet_186(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Academic Year...!"), 
							"Alert message displayed",
							"Alert message not displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting only \"Academic Year\"")
		public void TC_Admis_OthDet_187(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Any One Field From Category / Sub-Category / Level / Rank...!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting only any one of the field of the \"Activity Search Engine\" form")
		public void TC_Admis_OthDet_188(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Academic Year...!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting criteria for which record is exist")
		public void TC_Admis_OthDet_189(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Academic Year...!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Academic Year\" for which record is not exist")
		public void TC_Admis_OthDet_190(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Activity Category\" for which record is exist")
		public void TC_Admis_OthDet_191(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			/*
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Activity Category\" for which record is not exist")
		public void TC_Admis_OthDet_192(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Sub Category\" for which record is exist")
		public void TC_Admis_OthDet_193(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			/*
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			*/
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Sub Category\" for which record is not exist")
		public void TC_Admis_OthDet_194(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Level\" for which record is exist")
		public void TC_Admis_OthDet_195(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			*/
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Level\" for which record is not exist")
		public void TC_Admis_OthDet_196(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Rank\" for which record is exist")
		public void TC_Admis_OthDet_197(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			*/
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Rank\" for which record is not exist")
		public void TC_Admis_OthDet_198(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Class\" for which record is exist")
		public void TC_Admis_OthDet_199(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			*/
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Class\" for which record is not exist")
		public void TC_Admis_OthDet_200(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Division\" drop down  list by  selecting \"Class\" ")
		public void TC_Admis_OthDet_201(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.click();
			EPUtils.sleep(3000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Division\" for which record is exist")
		public void TC_Admis_OthDet_202(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Division\" for which record is not exist")
		public void TC_Admis_OthDet_203(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Caste\" for which record is exist")
		public void TC_Admis_OthDet_204(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Caste\" for which record is not exist")
		public void TC_Admis_OthDet_205(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Category\" for which record is exist")
		public void TC_Admis_OthDet_206(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			/*
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Category\" for which record is not exist")
		public void TC_Admis_OthDet_207(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Religion\" for which record is exist")
		public void TC_Admis_OthDet_208(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Extra Curricular Activity Search Engine\" form by  selecting \"Religion\" for which record is not exist")
		public void TC_Admis_OthDet_209(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Male\" from \"Gender\" drop down list")
		public void TC_Admis_OthDet_213(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting gender as \"Female\" from \"Gender\" drop down list")
		public void TC_Admis_OthDet_214(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownGender.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by selecting \"Academic Year\" for which gender is not assigned for the student")
		public void TC_Admis_OthDet_215(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownGender.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Reset\" button functionality")
		public void TC_Admis_OthDet_216(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownGender.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonReset.click();
			EPUtils.sleep(2000);
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Print Activity Report\" button functionality")
		public void TC_Admis_OthDet_231(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkExtraCurricularActivity.click();
			
			Reporter.log("User Clicked on Extra Curricular Activity Link");
			
			FullEPrashasanExtraCurricularActivityFormPage fullEPrashasanExtraCurricularActivityFormPage = new FullEPrashasanExtraCurricularActivityFormPage();
			
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.waitForVisible();
			fullEPrashasanExtraCurricularActivityFormPage.linkExtraCurricularActivitySearchEngine.click();
			EPUtils.sleep(2000);
			
			Reporter.log("User Clicked on Extra Curricular Activity Search Engine Link");
			
			FullEPrashasanExtraCurricularActivitySearchEngineFormPage fullEPrashasanExtraCurricularActivitySearchEngineFormPage = new FullEPrashasanExtraCurricularActivitySearchEngineFormPage();
			
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectYear.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectClass.selectByIndex(1);
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectDivision.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCaste.selectByIndex(16);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectCategory.selectByIndex(1);
			//fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownSelectReligion.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.generalSearchEngineComponent.dropdownGender.selectByIndex(2);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivitySubCategory.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityLevel.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.activitySearchEngineComponent.dropdownActivityRank.selectByIndex(1);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			fullEPrashasanExtraCurricularActivitySearchEngineFormPage.buttonPrintActivityReport.click();
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		//Division & Roll No. Mgt.
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Get Fields\" button functionality by without selecting \"Year\"")
		public void TC_Admis_OthDet_232(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			
			
			
			
			
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select Year"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Get Fields\" button functionality by without selecting \"Standard\"")
		public void TC_Admis_OthDet_233(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			
								
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select standard"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Get Fields\" button functionality with \"No Of Students\" field blank")
		public void TC_Admis_OthDet_234(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			
								
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Number Of Students"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Get Fields\" button functionality by without selecting \"Renew Date\"")
		public void TC_Admis_OthDet_235(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("10");
			//fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			
			
			
			
			
								
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Renew Date"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Get Fields\" button functionality by  selecting \"Renew Date\" in invalid(DD-MM-YYYY) formate")
		public void TC_Admis_OthDet_236(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("10");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Renew Date"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Get Fields\" button functionality by  selecting \"Renew Date\" not within select \"Year\"")
		public void TC_Admis_OthDet_237(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("10");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Renew Date"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Verify the number of rows displaying against the number entered in the \"No Of Students\"")
		public void TC_Admis_OthDet_238(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("10");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Renew Date"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Verify the default values for the \"Roll No.\" column")
		public void TC_Admis_OthDet_239(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Renew Date"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality with  \"Register No.\" field blank")
		public void TC_Admis_OthDet_240(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("");
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonSAVE.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Fill Registration No....!!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by entering non existance  \"Register No.\" ")
		public void TC_Admis_OthDet_241(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("23564");
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonSAVE.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Division Assigned successfully"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			EPUtils.sleep(2000);
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality with  \"Roll No.\" field blank ")
		public void TC_Admis_OthDet_242(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("123");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).clear();
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonSAVE.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Must Fill RollNo...!!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			EPUtils.sleep(2000);
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality with duplicate \"Roll No.\"")
		public void TC_Admis_OthDet_243(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("123");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).clear();
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).sendKeys("2");
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonSAVE.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Roll Number Already Exists. Please Check The Roll Numbers"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			EPUtils.sleep(2000);
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by without selecting \"Division\" drop down value")
		public void TC_Admis_OthDet_244(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("123");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).clear();
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).sendKeys("1");
			//fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonSAVE.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Select division"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			EPUtils.sleep(2000);
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by entering all valid criteria")
		public void TC_Admis_OthDet_245(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("123");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).clear();
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).sendKeys("157");
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonSAVE.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Division Assigned successfully"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			EPUtils.sleep(2000);
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Cancel\" button functionality")
		public void TC_Admis_OthDet_246(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivisionRollNoMgmt.click();
			
			Reporter.log("User Clicked on Division & Roll No Mgt Link");
			
			
			FullEPrashasanDivisionAndRollNoMgtFormPage fullEPrashasanDivisionAndRollNoMgtFormPage = new FullEPrashasanDivisionAndRollNoMgtFormPage();
			fullEPrashasanDivisionAndRollNoMgtFormPage.waitForPageToLoad();
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(2000);
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectStandard.selectByIndex(1);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxSelectNoOfStudents.sendKeys("15");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRenewDate.click();
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectMonth.selectByIndex(5);
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectYear.selectByValue("2018");
			fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.selectDay("16").click();
			EPUtils.sleep(2000);
			//fullEPrashasanDivisionAndRollNoMgtFormPage.datePickerComponent.buttonDONE.click();
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonGetFields.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0);
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRegistrationNo.get(0).sendKeys("123");
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).clear();
			fullEPrashasanDivisionAndRollNoMgtFormPage.textboxRollNo.get(0).sendKeys("157");
			fullEPrashasanDivisionAndRollNoMgtFormPage.dropdownSelectDivision.selectByIndex(1);
			
			fullEPrashasanDivisionAndRollNoMgtFormPage.buttonCANCEL.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Division Assigned successfully"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			EPUtils.sleep(2000);
			
			*/
			
		    }
		
		
		
		/*        ***Test Case No. TC_Admit_OthDet_247 to 304 remaining...***         */
		
		
		
		
		//Update Student Registration No. Module
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting any criteria")
		public void TC_Admis_OthDet_347(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("123");
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shete Shubham Sunil");
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
		    }
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number(including Left student) for which record is exist")
		public void TC_Admis_OthDet_348(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("123");
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shete Shubham Sunil");
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			*/
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number for which record is not exist")
		public void TC_Admis_OthDet_349(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("121");
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shete Shubham Sunil");
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
			
		    }
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate Autocomplete functionality by entering name(including left student) in the \"Student Name\" field")
		public void TC_Admis_OthDet_350(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("121");
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			//fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by selecting name from autocomplete list")
		public void TC_Admis_OthDet_351(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("121");
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			EPUtils.sleep(2000);
			
			//fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by without selecting name from autocomplete list")
		public void TC_Admis_OthDet_352(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("121");
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			fullEPrashasanUpdateStudRegNoFormPage.headerUpdateStudentRegistrationNo.click();
			
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by without entering \"Student New Regi. No.\" value")
		public void TC_Admis_OthDet_353(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("123");
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			
			
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudRegNoFormPage.buttonSave.click();
			EPUtils.sleep(2000);
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Enter Student New Regi. No."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by  entering unique \"Student New Regi. No.\" value")
		public void TC_Admis_OthDet_354(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("0081");
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			
			
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxNewRegNo.sendKeys("8001");
			fullEPrashasanUpdateStudRegNoFormPage.buttonSave.click();
			EPUtils.sleep(2000);
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Student Regi. No. Updated Successfully."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
			
		    }
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by  entering duplicate \"Student New Regi. No.\" value")
		public void TC_Admis_OthDet_355(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("121");
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			
			
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxNewRegNo.sendKeys("5520");
			fullEPrashasanUpdateStudRegNoFormPage.buttonSave.click();
			EPUtils.sleep(2000);
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("this no. is allready exists.."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
			
		    }
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by  entering all type of data(alphanumeric+special charecters) in the \"Student New Regi. No.\" field")
		public void TC_Admis_OthDet_356(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudRegiNo.click();
			
			Reporter.log("User Clicked on Update Student Reg. No. link");
			
			
			FullEPrashasanUpdateStudRegNoFormPage fullEPrashasanUpdateStudRegNoFormPage =  new FullEPrashasanUpdateStudRegNoFormPage();
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxStudentRegNo.sendKeys("4849");
			//fullEPrashasanUpdateStudRegNoFormPage.textboxStudentName.sendKeys("Shet");
			
			
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudRegNoFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanUpdateStudRegNoFormPage.textboxNewRegNo1.sendKeys("48$$");
			fullEPrashasanUpdateStudRegNoFormPage.buttonSave.click();
			EPUtils.sleep(2000);
			
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Student Regi. No. Updated Successfully."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
			
			
			
		    }
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by without selecting any criteria")
		public void TC_Admis_OthDet_357(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
		
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
		
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number(including Left student) for which record is exist")
		public void TC_Admis_OthDet_358(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudRegNo.sendKeys("5520");
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
		
		}
		
		
		
		
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" button functionality by entering registration number for which record is not exist")
		public void TC_Admis_OthDet_359(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudRegNo.sendKeys("8181");
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
		
		}
		
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate Autocomplete functionality by entering name(including left student) in the \"Student Name\" field")
		public void TC_Admis_OthDet_360(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudentName.sendKeys("shub");
			//fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by without selecting name from autocomplete list")
		public void TC_Admis_OthDet_362(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudentName.sendKeys("shub");
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Regi. No./Student Name."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by without selecting \"Date\"")
		public void TC_Admis_OthDet_363(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudRegNo.sendKeys("107");
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudentName.sendKeys("Shaikh Arshad");
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanUpdateStudDivisionFormPage.buttonSave.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("please select date"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by without selecting \"Division\"")
		public void TC_Admis_OthDet_364(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudRegNo.sendKeys("107");
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudentName.sendKeys("Shaikh Arshad");
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxDate.click();
			//fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.selectMonth.selectByIndex(6);
			fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.selectYear.selectByOptionValue("2018");
			fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.selectDay("21").click();
			//fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.buttonDONE.click();
			fullEPrashasanUpdateStudDivisionFormPage.buttonSave.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("please select division"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by entering all mandatory data")
		public void TC_Admis_OthDet_365(Map<String, String>data) throws InterruptedException {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkUpdateStudentDivision.click();
			
			Reporter.log("User Clicked on Update Student Division Link");
			
			
			FullEPrashasanUpdateStudDivisionFormPage fullEPrashasanUpdateStudDivisionFormPage = new FullEPrashasanUpdateStudDivisionFormPage();
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudRegNo.sendKeys("107");
			fullEPrashasanUpdateStudDivisionFormPage.textboxStudentName.sendKeys("Shaikh Arshad");
			fullEPrashasanUpdateStudDivisionFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			
			fullEPrashasanUpdateStudDivisionFormPage.textboxDate.click();
			//fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.selectMonth.selectByIndex(6);
			fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.selectYear.selectByOptionValue("2018");
			fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.selectDay("21").click();
			//fullEPrashasanUpdateStudDivisionFormPage.datePickerComponent.buttonDONE.click();
			fullEPrashasanUpdateStudDivisionFormPage.dropdownSelectNewDivision.selectByIndex(2);
			fullEPrashasanUpdateStudDivisionFormPage.buttonSave.click();
			EPUtils.sleep(2000);
		
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains(" Division Updated sucessfully "), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		
		
	
		
	/*	*************      DIVISION MODULE     *************   */
		
		
		
		
		

		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by entering all mandatory data")
		public void TC_Admis_Div_01(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(3000);
			
			
			
			
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save\" button functionality by entering all mandatory data")
		public void TC_Admis_Div_02(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(1);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(3000);
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("No Data Found..."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by without selecting \"Year\"")
		public void TC_Admis_Div_03(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(1);
			//EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(3000);
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Select Year And Class..!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Search\" functionality by without selecting \"Standard\"")
		public void TC_Admis_Div_04(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			//fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(3000);
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Select Year And Class..!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Verify \"Search Student\" form with default value selection as \"Manually Enter Reg.No\" in \"Select Division allocation type\" drop down list")
		public void TC_Admis_Div_05(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(0);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(3000);
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Select Year And Class..!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Verify \"Search Student\" form by selecting  \"Select Division allocation type\" drop down value as \"Multiselect Students\"")
		public void TC_Admis_Div_06(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			
			
			
			
			
			/*
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Select Year And Class..!"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for defualt selection of \"Select Division allocation type\" drop down with all mandatory fields selection")
		public void TC_Admis_Div_07(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5471,5472");
			fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Division Allocated Successfully for Selected Student.. Please Check Roll Numbers For Selected Students."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for defualt selection of \"Select Division allocation type\" drop down with blank \"Enter Student Registration Numbers\" ")
		public void TC_Admis_Div_08(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5471,5472");
			fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Registration Numbers and Select Divion"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for defualt selection of \"Select Division allocation type\" drop down by without selecting division from \"Set Division\" drop down")
		public void TC_Admis_Div_09(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5471,5472");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Student Registration Numbers and Select Divion"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for defualt selection of \"Select Division allocation type\" drop down by entering reistration which is not available in the grid")
		public void TC_Admis_Div_10(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("8181");
			fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for defualt selection of \"Select Division allocation type\" drop down by entering duplicate registration number")
		public void TC_Admis_Div_11(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate reseting of form  for defualt selection of \"Select Division allocation type\" drop down by performing delete functionality after displaying grid")
		public void TC_Admis_Div_12(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by selecting checkbox")
		public void TC_Admis_Div_13(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(1);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(1).click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by disselecting checked checkbox")
		public void TC_Admis_Div_14(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(1);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(1).click();
			EPUtils.sleep(3000);
			
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(1);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(1).click();
			EPUtils.sleep(3000);
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate checkbox functionality by selecting checkbox")
		public void TC_Admis_Div_15(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0).click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting it")
		public void TC_Admis_Div_16(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0).click();
			EPUtils.sleep(3000);
			
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0).click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate select all checkbox functionality by disselecting single or multiple record in a grid")
		public void TC_Admis_Div_17(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(0).click();
			EPUtils.sleep(3000);
			
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(2);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(2).click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Registration Numbers Not Matched With Selected criteria"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for  selection of \"Multiselect Student\" drop down by entering all mandatory fields")
		public void TC_Admis_Div_19(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			
			
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(2);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(2).click();
			EPUtils.sleep(3000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSetDivision.click();
			EPUtils.sleep(13000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Division Allocated Successfully for Selected Student.. Please Check Roll Numbers For Selected Students."), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for  selection of \"Multiselect Student\" drop down by without selecting record")
		public void TC_Admis_Div_20(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.Checkbox.get(2);
			//fullEPrashasanDivisionManagementFormPage.Checkbox.get(2).click();
			//EPUtils.sleep(3000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSetDivision.click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Select Student"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Set Division\" functionality for  selection of \"Multiselect Student\" drop down by without selecting \"Set Division\" drop down value")
		public void TC_Admis_Div_21(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			EPUtils.sleep(2000);
			
			fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSearch.click();
			EPUtils.sleep(3000);
			
			
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(2);
			fullEPrashasanDivisionManagementFormPage.Checkbox.get(2).click();
			EPUtils.sleep(3000);
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			fullEPrashasanDivisionManagementFormPage.buttonMultiSetDivision.click();
			EPUtils.sleep(3000);
			
			
			//fullEPrashasanDivisionManagementFormPage.textareaStudRegNo.sendKeys("5254");
			//fullEPrashasanDivisionManagementFormPage.dropdownSetDivision.selectByIndex(2);
			//fullEPrashasanDivisionManagementFormPage.buttonSetDivision.click();
			//EPUtils.sleep(4000);
			
			
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Select Division"), 
							"Alert message not displayed",
							"Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Next\" icon enability on the first grid")
		public void TC_Admis_Div_23(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(3000);
			
			
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Previous\" icon enability on the first page")
		public void TC_Admis_Div_24(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(3000);
			
			
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Previous\" icon enability on the pages other than first page")
		public void TC_Admis_Div_25(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(3000);
			
			
		
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Next\" icon enability on the Last page")
		public void TC_Admis_Div_26(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(3000);
			
			
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Previous\" icon enability on the Last page")
		public void TC_Admis_Div_27(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(3000);
			
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Next\" icon functionality for all pages till last page")
		public void TC_Admis_Div_28(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(2000);
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(2000);
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Previous\" icon functionality for all pages next to the  first page")
		public void TC_Admis_Div_29(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(2000);
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(2000);
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(2000);
		
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"End\" icon enability on the Last page")
		public void TC_Admis_Div_30(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(2000);
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(2000);
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"First\" icon enability on the Last page")
		public void TC_Admis_Div_31(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(2000);
			fullEPrashasanDivisionManagementFormPage.IconFirst.click();
			EPUtils.sleep(2000);
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"End\" icon enability on the first page on so on till last page page")
		public void TC_Admis_Div_32(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(3000);
			
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"First\" icon enability on the first page on so on till last page page")
		public void TC_Admis_Div_33(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconPrevious.click();
			EPUtils.sleep(3000);
		
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"End\" icon functionality on the first page and so on till last page")
		public void TC_Admis_Div_34(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconLast.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			
		
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"First\" icon functionality from the second page and so on till last page")
		public void TC_Admis_Div_35(Map<String, String>data) throws InterruptedException {
			
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
		
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkDivision.click();
			EPUtils.sleep(1200);
			
			Reporter.log("User Clicked on Division link");                   
		
			
			FullEPrashasanDivisionManagementFormPage fullEPrashasanDivisionManagementFormPage = new FullEPrashasanDivisionManagementFormPage();
			
			//fullEPrashasanDivisionManagementFormPage.dropdownSelectDivisionAllocationtype.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.dropdownSelectYear.selectByIndex(2);
			EPUtils.sleep(1500);
			fullEPrashasanDivisionManagementFormPage.dropdownClass.selectByIndex(1);
			fullEPrashasanDivisionManagementFormPage.buttonSearch.click();
			
			
			fullEPrashasanDivisionManagementFormPage.IconNext.click();
			EPUtils.sleep(3000);
			fullEPrashasanDivisionManagementFormPage.IconFirst.click();
			EPUtils.sleep(3000);
		
		}
}
	
















