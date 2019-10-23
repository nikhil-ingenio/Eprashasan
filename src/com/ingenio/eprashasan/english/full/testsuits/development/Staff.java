package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStaffBasicDetailsFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStaffDesignationFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStaffSchoolTypeFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;



public class Staff extends WebDriverTestCase{
	//Staff Settings : 1] Staff School Type
	
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality  without entering Staff School Type")
		public void TC_Staff_sett_01(Map<String, String>data) {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality  by entering Staff School Type field data")
		public void TC_Staff_sett_02(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data saved successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality by  entering all type of the data(Alphanumeric + special charectrs)School Type field data")
		public void TC_Staff_sett_03(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary...");
			fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data saved successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality by  entering duplicate data in the staff School Type field ")
		public void TC_Staff_sett_04(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information is already exist...!!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Update button functionality by without updating record")
		public void TC_Staff_sett_05(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			//fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			fullEPrashasanStaffSchoolTypeFormPage.tablerow1.click();
			fullEPrashasanStaffSchoolTypeFormPage.buttonUpdate.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data is updated successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Update button functionality by updating record with unique data ")
		public void TC_Staff_sett_06(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			//fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			fullEPrashasanStaffSchoolTypeFormPage.tablerow1.click();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.clear();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("PrePrimary");
			fullEPrashasanStaffSchoolTypeFormPage.buttonUpdate.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data is updated successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Update button functionality by  updating record with duplicate name")
		public void TC_Staff_sett_07(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			//fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			fullEPrashasanStaffSchoolTypeFormPage.tablerow1.click();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.clear();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			fullEPrashasanStaffSchoolTypeFormPage.buttonUpdate.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information is already exist...!!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Update button functionality by  updating record with blank School Type")
		public void TC_Staff_sett_08(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			//fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			fullEPrashasanStaffSchoolTypeFormPage.tablerow1.click();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.clear();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			fullEPrashasanStaffSchoolTypeFormPage.buttonUpdate.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data is updated successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Reset button functionality")
		public void TC_Staff_sett_09(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Higher");
			//fullEPrashasanStaffSchoolTypeFormPage.buttonSave.click();
			//fullEPrashasanStaffSchoolTypeFormPage.tablerow1.click();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.clear();
			//fullEPrashasanStaffSchoolTypeFormPage.textboxSchoolType.sendKeys("Primary");
			fullEPrashasanStaffSchoolTypeFormPage.buttonReset.click();
			
			EPUtils.sleep(3000);
			
			
			/*
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data is updated successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			*/
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Delete button functionalitly by without selecting any record")
		public void TC_Staff_sett_10(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
				
			fullEPrashasanStaffSchoolTypeFormPage.buttonDelete.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select row to delete..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Delete button functionalitly by deleting record which is in use")
		public void TC_Staff_sett_11(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			
			fullEPrashasanStaffSchoolTypeFormPage.tablerow1.click();
			fullEPrashasanStaffSchoolTypeFormPage.buttonDelete.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Are you sure..???"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			EPUtils.sleep(3000);
			
			Alert Windowalert1 = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert1.getText().contains("Sorry unable to delete record..!!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Delete button functionalitly by deleting record which is not in use")
		public void TC_Staff_sett_12(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSchoolType.click();
			
			FullEPrashasanStaffSchoolTypeFormPage fullEPrashasanStaffSchoolTypeFormPage = new FullEPrashasanStaffSchoolTypeFormPage();
			
			fullEPrashasanStaffSchoolTypeFormPage.tablerow3.click();
			fullEPrashasanStaffSchoolTypeFormPage.buttonDelete.click();
			
			EPUtils.sleep(3000);
			
			
			
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Are you sure..???"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
			EPUtils.sleep(3000);
			
			Alert Windowalert1 = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert1.getText().contains("Record deleted successfully..!!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
		}
		
		
		
		
		
		
		//Staff Settings : 1] Staff Designation	
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality  without entering Staff  Designation")
		public void TC_Staff_sett_27(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffDesignation.click();
		
			FullEPrashasanStaffDesignationFormPage fullEPrashasanStaffDesignationFormPage = new FullEPrashasanStaffDesignationFormPage();
			
			fullEPrashasanStaffDesignationFormPage.buttonSave.click();
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality  by entering Staff  Designation field data")
		public void TC_Staff_sett_28(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffDesignation.click();
		
			FullEPrashasanStaffDesignationFormPage fullEPrashasanStaffDesignationFormPage = new FullEPrashasanStaffDesignationFormPage();
			
			fullEPrashasanStaffDesignationFormPage.textboxStaffDesignation.sendKeys("Librarian");
			fullEPrashasanStaffDesignationFormPage.buttonSave.click();
			
			
			

			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data saved successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality by  entering all type of the data(Alphanumeric + special charectrs) Staff Designation field data")
		public void TC_Staff_sett_29(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffDesignation.click();
		
			FullEPrashasanStaffDesignationFormPage fullEPrashasanStaffDesignationFormPage = new FullEPrashasanStaffDesignationFormPage();
			
			fullEPrashasanStaffDesignationFormPage.textboxStaffDesignation.sendKeys("Staff...");
			fullEPrashasanStaffDesignationFormPage.buttonSave.click();
			
			
			

			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data saved successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Save button functionality by  entering all type of the data(Alphanumeric + special charectrs) Staff Designation field data")
		public void TC_Staff_sett_30(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffDesignation.click();
		
			FullEPrashasanStaffDesignationFormPage fullEPrashasanStaffDesignationFormPage = new FullEPrashasanStaffDesignationFormPage();
			
			fullEPrashasanStaffDesignationFormPage.textboxStaffDesignation.sendKeys("Staff...");
			fullEPrashasanStaffDesignationFormPage.buttonSave.click();
			
			
			

			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data saved successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Update button functionality by without updating record")
		public void TC_Staff_sett_31(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffDesignation.click();
		
			FullEPrashasanStaffDesignationFormPage fullEPrashasanStaffDesignationFormPage = new FullEPrashasanStaffDesignationFormPage();
			
			fullEPrashasanStaffDesignationFormPage.tablerow1.click();
			fullEPrashasanStaffDesignationFormPage.buttonUpdate.click();
			
			
			

			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data is updated successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
		
		
		
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Staff']}")
		@QAFTestStep(description = "Validate Update button functionality by updating record with unique data ")
		public void TC_Staff_sett_32(Map<String, String>data) throws InterruptedException {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//	fullEPrashasanWelcomePage.waitForPageToLoad();
			fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
			Reporter.log("User Navigated to Welcome page");

			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkStaff.click();
			Reporter.log("User Clicked on Staff Link");
			
			FullEPrashasanStaffBasicDetailsFormPage fullEPrashasanStaffBasicDetailsFormPage = new FullEPrashasanStaffBasicDetailsFormPage();
			
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffSettings.click();
			fullEPrashasanStaffBasicDetailsFormPage.topNavigationStaffBasicDetailsComponent.linkStaffDesignation.click();
		
			FullEPrashasanStaffDesignationFormPage fullEPrashasanStaffDesignationFormPage = new FullEPrashasanStaffDesignationFormPage();
			
			fullEPrashasanStaffDesignationFormPage.tablerow3.click();
			fullEPrashasanStaffDesignationFormPage.textboxStaffDesignation.clear();
			fullEPrashasanStaffDesignationFormPage.textboxStaffDesignation.sendKeys("Viceprincipal");
			fullEPrashasanStaffDesignationFormPage.buttonUpdate.click();
			
			
			

			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Data is updated successfully..!"), 
							" Alert message not displayed",
							" Alert message displayed");
			getDriver().switchTo().alert().accept();
			
			
		}
}