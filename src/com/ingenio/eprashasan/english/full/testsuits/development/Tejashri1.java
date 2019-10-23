	package com.ingenio.eprashasan.english.full.testsuits.development;
	
	import java.sql.Driver;
	import java.util.Map;
	
	
	import org.openqa.selenium.Alert;
	import org.testng.annotations.Test;
	
	import com.ingenio.eprashasan.core.EPUtils;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanDivisionManagementFormPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanEditStudentInformationPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanGeneralRegisterFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanGeneralRegisterSearchFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanQuickRegistrationFormPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanRenewAdmissionFormPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanSettingsPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanStudentAdmissionFormPage;
	import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
	import com.qmetry.qaf.automation.data.MetaData;
	import com.qmetry.qaf.automation.step.QAFTestStep;
	import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
	import com.qmetry.qaf.automation.ui.WebDriverTestCase;
	import com.qmetry.qaf.automation.util.Reporter;
	
	public class Tejashri1 extends WebDriverTestCase{
	//STUDENT ADMISSION
		
		//Admission
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by entering all mandatory fields")
		public void TC_Admis_StudAdm_01(Map<String, String> data) {
			
			FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
			fullEPrashasanLoginPage.invoke();
			fullEPrashasanLoginPage.waitForPageToLoad();
			
			EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
		
			FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
			Reporter.log("User Navigated to Welcome page");
			
			fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.waitForVisible();
			fullEPrashasanWelcomePage.leftNavigationComponent.linkAdmission.click();
			Reporter.log("User Clicked on Addmission Link");
			
			FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
			fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
			
			//fullEPrashasanGeneralRegisterFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			//fullEPrashasanGeneralRegisterFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("9965478");
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
		//	fullEPrashasanGeneralRegisterFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
					"Are You Sure? Alert message not displayed",
					"Are You Sure? Alert message displayed");
			
		
			getDriver().switchTo().alert().accept();
			
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Cancel\" buttun functionality by entering all mandatory fields")
		public void TC_Admis_StudAdm_02(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
					"Are You Sure? Alert message not displayed",
					"Are You Sure? Alert message displayed");
		
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Admission Month")
		public void TC_Admis_StudAdm_06(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Class")
		public void TC_Admis_StudAdm_09(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			//fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
			fullEPrashasanWelcomePage.waitForPageToLoad();
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
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please select an item in the list."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting MotherTongue")
		public void TC_Admis_StudAdm_21(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please select an item in the list."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Nationality")
		public void TC_Admis_StudAdm_22(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please select an item in the list."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by entering same registration number")
		public void TC_Admis_StudAdm_23(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("this reg no all ready used"), 
					"Are You Sure? Alert message not displayed",
					"Are You Sure? Alert message displayed");
			
		
			getDriver().switchTo().alert().dismiss();
			
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by entering same registration number")
		public void TC_Admis_StudAdm_24(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
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
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Father Name")
		public void TC_Admis_StudAdm_25(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please fill out this field."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Mother Name")
		public void TC_Admis_StudAdm_26(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please fill out this field."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Contact Number 1 For SMS")
		public void TC_Admis_StudAdm_27(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("Parner Public School");
			EPUtils.sleep(2000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please select an item in the list."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" buttun functionality by without selecting Previous School Name")
		public void TC_Admis_StudAdm_28(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName);
			Reporter.log(errorMessage);
			
			verifyTrue(errorMessage.equals("Please select an item in the list."), 
					"Fail : Message "+errorMessage+" not displayed",
					"Pass : Message "+errorMessage+" displayed");
			
		}
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate field validation after selecting  \"Permanent address same as Local address\" checkbox")
		public void TC_Admis_StudAdm_29(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
			
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textareaAddress.sendKeys("nevasa");
			fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			
			//Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
		
			//getDriver().switchTo().alert().accept();
		}
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Aadhaar Card No.\" field by entering  number less than 15 digit")
		public void TC_Admis_StudAdm_31(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("8888888888");
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("1234567");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
					//"Are You Sure? Alert message not displayed",
					//"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
	
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Aadhaar Card No.\" field by entering  number with 14 digit")
		public void TC_Admis_StudAdm_32(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("8888888888");
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Aadhaar Card No.\" field by entering  number morethan 15 digit")
		public void TC_Admis_StudAdm_33(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9865986574");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("8888888888");
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
	
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Contact Number 1 For SMS\" field by entering  number morethan 12 digit")
		public void TC_Admis_StudAdm_34(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9568746321547");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Contact Number 1 For SMS\" field by entering  12 digit number")
		public void TC_Admis_StudAdm_35(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("965874325315");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Validate validation of the \"Contact Number 1 For SMS\" field by entering  number lessthan 10 digit")
		public void TC_Admis_StudAdm_36(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("96587432");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Contact Number 1 For SMS\" field by entering 10 digit number")
		public void TC_Admis_StudAdm_37(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("9658743245");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate validation of the \"Contact Number 1 For SMS\" field by entering 11 digit number")
		public void TC_Admis_StudAdm_38(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("96587432451");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Email ID\" field by entering email id in wrong formate")
		public void TC_Admis_StudAdm_39(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("96587432451");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxEmailID.sendKeys("abc@gmail");
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonAdd.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Reset\"functionality")
		public void TC_Admis_StudAdm_40(Map<String, String> data) {
			
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
			
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.waitForVisible();
			fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkStudentAdmission.click();
			Reporter.log("User Clicked on Student Admission Link");
			
			fullEPrashasanStudentAdmissionFormPage.waitForPageToLoad();
		
			Reporter.log("User Started filling Details");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.waitForVisible();
			
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownCaste.selectByOptionValue("Kunbi");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1122334");
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownAdmissionYear.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxFirstName.sendKeys("Tushar");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxLastName.sendKeys("kakade");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(3);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(9);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(1);
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxMothertonge.sendKeys("Marathi");
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.clear();
			fullEPrashasanStudentAdmissionFormPage.basicDetailsComponent.textboxNationlity.sendKeys("Indian");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxFatherName.sendKeys("Sampat");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("96587432451");
			fullEPrashasanStudentAdmissionFormPage.parentDetailsComponent.textboxMotherName.sendKeys("Rekha");
			fullEPrashasanStudentAdmissionFormPage.studentContactDetailsComponent.textboxEmailID.sendKeys("abc@gmail");
			
			fullEPrashasanStudentAdmissionFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("12345678912345678");
			fullEPrashasanStudentAdmissionFormPage.previousSchoolDetailsComponent.textboxPreviousSchoolName.sendKeys("APS");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("Nashik");
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("411038");
			
			//fullEPrashasanStudentAdmissionFormPage.addressDetailsComponent.checkboxPermanentAddressSameAsLocalAddress.click();
			EPUtils.sleep(5000);
			fullEPrashasanStudentAdmissionFormPage.buttonReset.click();
			EPUtils.sleep(5000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
			//		"Are You Sure? Alert message not displayed",
			//		"Are You Sure? Alert message displayed");
		
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(5000);
		}
		
		
		
		
	//QUICK REGISTRATION
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(3);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(5);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12112");
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
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
		@QAFTestStep(description = "Validate \"Add\" functionality of the  \"Student Detail Form\" by selecting invalid date(31st for month july)")
		public void TC_Admis_Quick_60(Map<String, String> data) {
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(31);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(6);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
			fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
			Reporter.log("User Clicked on button Add");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
			
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(3000);
			//verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				//	"Record Inserted Successfully message not displayed",
					//"Record Inserted Successfully message displayed");
		}
		
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" functionality by without selecting date value of the \"Date\"")
		public void TC_Admis_Quick_61(Map<String, String> data) {
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(31);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(6);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
			fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
			Reporter.log("User Clicked on button Add");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
			
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(3000);
			//verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				//	"Record Inserted Successfully message not displayed",
					//"Record Inserted Successfully message displayed");
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" functionality by without selecting month value of the \"Date\"")
		public void TC_Admis_Quick_62(Map<String, String> data) {
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(31);
			//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(6);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
			fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
			Reporter.log("User Clicked on button Add");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
			
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(3000);
			//verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				//	"Record Inserted Successfully message not displayed",
					//"Record Inserted Successfully message displayed");
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Add\" functionality by without selecting year value of the \"Date\"")
		public void TC_Admis_Quick_63(Map<String, String> data) {
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(31);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(6);
			//fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
			fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
			Reporter.log("User Clicked on button Add");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
			
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(3000);
			//verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				//	"Record Inserted Successfully message not displayed",
					//"Record Inserted Successfully message displayed");
		}
	
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate Reset functionality")
		public void TC_Admis_Quick_64(Map<String, String> data) {
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(31);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(6);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
			fullEPrashasanQuickRegistrationFormPage.buttonReset.click();
			Reporter.log("User Clicked on button Reset");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
			
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(3000);
			//verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				//	"Record Inserted Successfully message not displayed",
					//"Record Inserted Successfully message displayed");
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"For Edit Click Here\" link functionality link functionality")
		public void TC_Admis_Quick_65(Map<String, String> data) {
			
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
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("12A#2");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxStudentFormNumber.sendKeys("200");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownInitialName.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxFirstName.sendKeys("Jay");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxMiddleName.sendKeys("Nitin");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.textboxLastName.sendKeys("Dixit");
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownClass.selectByIndex(2);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthDay.selectByIndex(31);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthMonth.selectByIndex(6);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownBirthYear.selectByIndex(12);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownGender.selectByIndex(1);
			fullEPrashasanQuickRegistrationFormPage.officeDetailsComponent.dropdownCaste.selectByOptionValue("Mali");
			
			fullEPrashasanQuickRegistrationFormPage.buttonAdd.click();
			Reporter.log("User Clicked on button Add");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			//verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				//	"Are You Sure? Alert message not displayed",
				//	"Are You Sure? Alert message displayed");
			
			getDriver().switchTo().alert().accept();
			EPUtils.sleep(3000);
			//verifyTrue(Windowalert.getText().contains("Record Inserted Successfully"), 
				//	"Record Inserted Successfully message not displayed",
					//"Record Inserted Successfully message displayed");
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Select Acedemic Year...!"), 
					"Alert message displayed",
					"Alert message not displayed");
			
			//getDriver().switchTo().alert().dismiss();
			getDriver().close();
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(5);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			EPUtils.sleep(3000);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByOptionValue("4 th");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(4);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownReligion.selectByIndex(9);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCaste.selectByIndex(138);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys(" Sonawane Aryan Ulhas");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4823");
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4824");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("1000000");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeFrom.sendKeys("500000");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("5000");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeFrom.sendKeys("10000");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			EPUtils.sleep(3000);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCategory.selectByIndex(10);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			EPUtils.sleep(3000);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.clear();
			EPUtils.sleep(3000);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.sendKeys("2000-12-05");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please Enter Valid Date."), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select class..!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
			
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select division..!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.waitForVisible();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxStudentId.sendKeys("4766");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!!!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			EPUtils.sleep(3000);
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAadharCardNo.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAccountNo.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankIFCSCode.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxBankName.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxGender.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			Reporter.log("User Clicked on Search Button");
			EPUtils.sleep(3000);
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("You can select maximum 15 columns"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(5);
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
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Class\" for which record exist")
		public void TC_Admis_Edit_61(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownDivision.selectByIndex(4);
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
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting \"Religion\" for which record exist")
		public void TC_Admis_Edit_65(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownReligion.selectByIndex(9);
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
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom searchby  selecting \"Caste\" for which record exist")
		public void TC_Admis_Edit_67(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCaste.selectByIndex(138);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxCaste.click();
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
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by selecting name from autocomplete list")
		public void TC_Admis_Edit_69(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("Randhe Riya Vilas");
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
		@QAFTestStep(description = "Validate \"Search\" button functionality of the \"Select Columns For Search\" popup for the custom search by  selecting left student name from autocomplete list")
		public void TC_Admis_Edit_71(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxName.sendKeys("Trivedi Vidhi Uttam");
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Reporter.log("User Clicked on Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821@");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Reporter.log("User Clicked on Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxRegistrationNumber.sendKeys("4821");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Reporter.log("User Clicked on Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxParentIncomeTo.sendKeys("10000");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Reporter.log("User Clicked on Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownCategory.selectByIndex(10);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Reporter.log("User Clicked on Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.textboxDateForAgeCalculation.sendKeys("1-1-2000");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			Reporter.log("User Clicked on Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Information Not Found...!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			
			Reporter.log("User Click On Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select class..!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			
			Reporter.log("User Click On Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select division..!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
			
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			
			Reporter.log("User Click On Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select division..!"), 
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
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxAdditionalStudentDetails.click();
			
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownClass.selectByIndex(1);
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxSortByRollNo.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			EPUtils.sleep(3000);
			
			Reporter.log("User Click On Search Button");
			Alert Windowalert = getDriver().switchTo().alert();
			
			verifyTrue(Windowalert.getText().contains("Please select division..!"), 
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownPage.selectByIndex(2);
			EPUtils.sleep(3000);
	
			getDriver().close();
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate the pagination functionality")
		public void TC_Admis_Edit_96(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
			EPUtils.sleep(3000);
	
			getDriver().close();
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Student Basic Detail\" checkbox by  disselcting one of the checkbox of the  \"Student Basic Detail\" form")
		public void TC_Admis_Edit_112(Map<String, String>data) {
			
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
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"First Name\" field blank")
		public void TC_Admis_Edit_146(Map<String, String>data) {
			
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Last Name\" field blank")
		public void TC_Admis_Edit_148(Map<String, String>data) {
			
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Birth Date\" field blank")
		public void TC_Admis_Edit_149(Map<String, String>data) {
			
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by entering \"Birth Date\" in invalid formate(i.e.formate other than dd-mm-yyyy)")
		public void TC_Admis_Edit_150(Map<String, String>data) {
			
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
		@QAFTestStep(description = "Validate ediatbility of the \"Current Academic Year\" column of the \"Current Academic Details\" form")
		public void TC_Admis_Edit_153(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality \"Father Name\" field blank")
		public void TC_Admis_Edit_161(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality \"Mother Name\" field blank")
		public void TC_Admis_Edit_162(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxParentDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Bank Details\" form")
		public void TC_Admis_Edit_163(Map<String, String>data) {
			
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Student Contact Details\" form")
		public void TC_Admis_Edit_166(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
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
		@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering 10 digits number")
		public void TC_Admis_Edit_169(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
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
		@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering 11 digits number")
		public void TC_Admis_Edit_170(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
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
		@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering 12 digits number")
		public void TC_Admis_Edit_171(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxMobileNo.sendKeys("986547123654");
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
		@QAFTestStep(description = "Validate \"Student Mobile\" field validation by entering number more than the 12 digits")
		public void TC_Admis_Edit_172(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentContactDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxEmailId.sendKeys("abc#ll");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
			EPUtils.sleep(5000);
			Reporter.log("User Clicked on Save Data Button");
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Please Check Email..!"), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().dismiss();
		}
		
		@Test
		@QAFDataProvider(key="login.data")
		@MetaData(value = "{'groups':['Admission']}")
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Previous School and Other Details\" form")
		public void TC_Admis_Edit_174(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Previous School Name\" field of the \"Previous School and Other Details\" form blank")
		public void TC_Admis_Edit_175(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Mothertongue\" field of the \"Previous School and Other Details\" form blank")
		public void TC_Admis_Edit_176(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxPreviousSchoolandOtherDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Additional Student Details\" form")
		public void TC_Admis_Edit_177(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality with \"Nationality\" field of the \"Additional Student Details\" form blank")
		public void TC_Admis_Edit_178(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Category\" value of the \"Additional Student Details\" as \"Select Category")
		public void TC_Admis_Edit_179(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Caste\" value of the \"Additional Student Details\" as \"Select Caste\"")
		public void TC_Admis_Edit_180(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(1);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"NT-3\" for the student")
		public void TC_Admis_Edit_182(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(2);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"SC\" for the student")
		public void TC_Admis_Edit_183(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(3);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"OBC\" for the student")
		public void TC_Admis_Edit_184(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(4);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"NT-1\" for the student")
		public void TC_Admis_Edit_185(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(5);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"NT-2\" for the student")
		public void TC_Admis_Edit_186(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(6);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"VJDT\" for the student")
		public void TC_Admis_Edit_187(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(7);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"TRIBAL\" for the student")
		public void TC_Admis_Edit_188(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(8);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"EBC\" for the student")
		public void TC_Admis_Edit_189(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(9);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Concession\" drop down value as \"Other\" for the student")
		public void TC_Admis_Edit_190(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownConcession.selectByIndex(10);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Muslim\" for the student")
		public void TC_Admis_Edit_191(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(1);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Punjabi\" for the student")
		public void TC_Admis_Edit_192(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(2);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Jain\" for the student")
		public void TC_Admis_Edit_193(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(3);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Sikh\" for the student")
		public void TC_Admis_Edit_194(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(4);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Parsi\" for the student")
		public void TC_Admis_Edit_195(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(5);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Catholic\" for the student")
		public void TC_Admis_Edit_196(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(6);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by selecting \"Minority Type\" drop down value as \"Other\" for the student")
		public void TC_Admis_Edit_197(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxAdditionStudentDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.dropdownMinority.selectByIndex(7);
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
		@QAFTestStep(description = "Validate \"Save Data\" button functionality by updating all column data of the \"Other Details\" form")
		public void TC_Admis_Edit_198(Map<String, String>data) {
			
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
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxOtherDetails.click();
			fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxStudentID.clear();
			fullEPrashasanEditStudentInformationPage.SearchStudentComponent.textboxStudentID.sendKeys("1234567989");
			fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.buttonSaveData.click();
			EPUtils.sleep(5000);
			Reporter.log("User Clicked on Save Data Button");
			Alert Windowalert = getDriver().switchTo().alert();
					
			verifyTrue(Windowalert.getText().contains("Your Data has been Succesfully Saved.."), 
							" Alert message displayed",
							" Alert message not displayed");
			getDriver().switchTo().alert().dismiss();
		}
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
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by entering only all mandatory fields")
	public void GR_GR_02(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Cancel\" button functionality of the confirmation message by entering all data")
	public void GR_GR_03(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting \"Academic Year\" drop down value")
	public void GR_GR_04(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Registration  Number\" field blank")
	public void GR_GR_05(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with duplicate \"Registration  Number")
	public void GR_GR_06(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting date value of the \"Admission Date")
	public void GR_GR_07(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting month value of the \"Admission Date\"")
	public void GR_GR_08(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting year value of the \"Admission Date")
	public void GR_GR_09(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by entering invalid date(ex.31st for he month JUNE) of the \"Admission Date")
	public void GR_GR_10(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(31);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(6);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting \"Class\" drop down value")
	public void GR_GR_11(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"First Name\" field blank")
	public void GR_GR_12(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Second Name\" field blank")
	public void GR_GR_13(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Last Name\" field blank")
	public void GR_GR_14(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting date value of the \"Birth Date")
	public void GR_GR_15(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting month value of the \"Birth Date")
	public void GR_GR_16(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting year value of the \"Birth Date")
	public void GR_GR_17(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by  selecting invalid date value(ex.31st for the JUNE month) of the \"Birth Date")
	public void GR_GR_18(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(31);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(6);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by  without selecting \"Gender\" drop down value")
	public void GR_GR_19(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by  without selecting \"Caste\" drop down value")
	public void GR_GR_20(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by  without selecting \"Category\" drop down value")
	public void GR_GR_21(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by  without selecting \"Religion\" drop down value")
	public void GR_GR_22(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Mothertongue\" blank")
	public void GR_GR_23(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMothertonge.clear();
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxPreviousSchoolName.sendKeys("Army Public School");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		
		EPUtils.sleep(5000);
		
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are You Sure?"), 
				"Are You Sure? Alert message not displayed",
				"Are You Sure? Alert message displayed");
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Nationality\" blank")
	public void GR_GR_24(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity.clear();
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Father  Name\"  field blank")
	public void GR_GR_25(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Mother  Name\"  field blank")
	public void GR_GR_26(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Contact Number 1\"  field blank")
	public void GR_GR_27(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Student Progress\"  field blank")
	public void GR_GR_29(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Conduct\"  field blank")
	public void GR_GR_30(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality with \"Remark\"  field blank")
	public void GR_GR_31(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting \"Student's Leaving Date\"  value")
	public void GR_GR_32(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting \"Concession\"  drop down value")
	public void GR_GR_33(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("2/01/2018");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting \"TC Given Date\"  value")
	public void GR_GR_34(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("2/01/2018");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Add\" button functionality by without selecting \"Left Class\"  drop down value")
	public void GR_GR_35(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("रोहिणी");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("2/01/2018");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("05/06/2018");
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate field validation after selecting  \"Permanent address same as Local address\" checkbox")
	public void GR_GR_36(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.addressDetailsComponent.checkboxLabelPermanentAddressSameAsLocalAddress.click();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Permanent address same as Local address\" checkbox functionality")
	public void GR_GR_37(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.addressDetailsComponent.checkboxLabelPermanentAddressSameAsLocalAddress.click();
		fullEPrashasanGeneralRegisterFormPage.addressDetailsComponent.localAddressDetailsComponent.textareaAddress.sendKeys("नेवासा");
		fullEPrashasanGeneralRegisterFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxDistrict.sendKeys("अहमदनगर");
		fullEPrashasanGeneralRegisterFormPage.addressDetailsComponent.localAddressDetailsComponent.textboxPincode.sendKeys("414526");
	
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate validation of the \"Aadhaar Card No.\" field by entering  number less than 15 digit")
	public void GR_GR_38(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("७४८८९६५४२१");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate validation of the \"Aadhaar Card No.\" field by entering  number less than 15 digit")
	public void GR_GR_39(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("७४८८९६५४२१");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate validation of the \"Aadhaar Card No.\" field by entering  number less than 15 digit")
	public void GR_GR_40(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३२१४७४");
		fullEPrashasanGeneralRegisterFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("७४८८९६५४२१");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxNationlity);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please fill out this field."), 
				"Fail : Message "+errorMessage+" not displayed",
				"Pass : Message "+errorMessage+" displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate validation of the \"Contact Number 1 For SMS\" field by entering  number lessthan 10 digit")
	public void GR_GR_43(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३५६४१");
		fullEPrashasanGeneralRegisterFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("७४८८९६५४२१");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		String errorMessage = EPUtils.getFieldLevelErrorValidationMessage(fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS);
		Reporter.log(errorMessage);
		
		verifyTrue(errorMessage.equals("Please lengthen this text to 10 characters or more (you are currently using 9 chracters)."), 
				"Fail : Message "+errorMessage+" displayed",
				"Pass : Message "+errorMessage+" not displayed");
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate validation of the \"Contact Number 1 For SMS\" field by entering 10 digit number")
	public void GR_GR_44(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३५६४१२");
		fullEPrashasanGeneralRegisterFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("७४८८९६५४२१");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonAdd.click();
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are you sure"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Reset\"functionality")
	public void GR_GR_47(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		Reporter.log("User Started filling Details");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.textboxRegistrationNumber.sendKeys("1000");
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionDay.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAdmissionMonth.selectByIndex(8);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownAcademicYear.selectByIndex(7);
		fullEPrashasanGeneralRegisterFormPage.officeDetailsComponent.dropdownClass.selectByIndex(1);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxFirstName.sendKeys("जयश्री");
		EPUtils.sleep(3000);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxMiddleName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.textboxLastName.sendKeys("शिर्के");
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthDay.selectByIndex(10);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthMonth.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownBirthYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownGender.selectByIndex(1);
		//fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCaste.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownCategory.selectByIndex(5);
		fullEPrashasanGeneralRegisterFormPage.basicDetailsComponent.dropdownReligion.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxFatherName.sendKeys("संपत");
		fullEPrashasanGeneralRegisterFormPage.parentDetailsComponent.textboxMotherName.sendKeys("निकिता");
		fullEPrashasanGeneralRegisterFormPage.studentContactDetailsComponent.textboxContactNumber1ForSMS.sendKeys("९८६५३५६४१२");
		fullEPrashasanGeneralRegisterFormPage.bankDetailsComponent.textboxAadhaarCardNo.sendKeys("७४८८९६५४२१");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentProgress.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxStudentsLeavingDate.sendKeys("12/05/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxTCGivenDate.sendKeys("24/06/2017");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxConduct.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.textboxRemark.sendKeys("चांगली");
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownConcession.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.tcInformationComponent.dropdownLeftClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterFormPage.buttonReset.click();
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Are you sure"), 
				" Alert message displayed",
				" Alert message not displayed");
		EPUtils.sleep(3000);
		
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"For Edit Click Here\" link functionality link functionality")
	public void GR_GR_48(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		//fullEPrashasanWelcomePage.waitForPageToLoad();
		//fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		//fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		Reporter.log("User Click on Here link");
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality without selecting any criteria")
	public void GR_GR_49(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Academic Year\" for which left student record exist")
	public void GR_GR_50(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.dropdownSelectYear.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Academic Year\" for which  left student record is not exist")
	public void GR_GR_51(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.dropdownSelectYear.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Class\" for which  left student  record exist")
	public void GR_GR_52(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Class\" for which left student  record is not exist")
	public void GR_GR_53(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.dropdownSelectClass.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.verifyPresent();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Category\" for which  left student  record exist")
	public void GR_GR_54(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		//fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.dropdownSelectCategory.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.verifyPresent();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting \"Category\" for which  left student record is not exist")
	public void GR_GR_55(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.dropdownSelectCategory.selectByIndex(2);
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.verifyPresent();
		
	}

	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate Autocomplete functionality by entering name in the \"Student Name\" field")
	public void GR_GR_56(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Swapnil Kale");
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.verifyPresent();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['जन-रजि']}")
	@QAFTestStep(description = "Validate \"Search\" functionality by selecting left student name from autocomplete list")
	public void GR_GR_57(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));
	
		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on जन-रजि Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterForm.click();
		Reporter.log("User Clicked on GeneralRegisterForm Link");
		
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		fullEPrashasanGeneralRegisterFormPage.linkHere.click();
		fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.textboxStudentName.sendKeys("Swapnil Kale");
		//fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.textboxStudentName.assertNotSelected(
		//fullEPrashasanGeneralRegisterFormPage.SearchStudentComponent.verifyPresent();
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Student Information\" checkbox functionality by disselecting defualt selection of checkbox")
	public void GR_GR_118(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.waitForVisible();
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.checkboxInformationOfStudent.click();
		EPUtils.sleep(3000);
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.checkboxInformationOfStudent.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Student Information\" checkbox functionality by selecting checkbox")
	public void GR_GR_119(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.waitForVisible();
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.checkboxInformationOfStudent.click();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by without selecting any criteria")
	public void GR_GR_120(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate the pagination functionality")
	public void GR_GR_121(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Next\" icon enability on the first grid")
	public void GR_GR_122(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Next\" icon enability on the first grid")
	public void GR_GR_123(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\"  by selecting \"Academic Year\" drop down value for which admitted students are present")
	public void GR_GR_135(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownAcademicYear.selectByIndex(2);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Academic Year\" drop down value for which admitted students are not present")
	public void GR_GR_136(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownAcademicYear.selectByIndex(4);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting single \"Class\"  value for which admitted students are present")
	public void GR_GR_137(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(2);;
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting single \"Class\" drop down value for which admitted students are not present")
	public void GR_GR_138(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(2);;
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting multiple \"Class\"  value for which admitted students are present")
	public void GR_GR_139(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(2);;
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Division\" drop down  list by selecting single drop down value of\"Class")
	public void GR_GR_140(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(3);;
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Division\" drop down  list by  selecting multiple drop down values of  \"Class")
	public void GR_GR_141(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(4);
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownDivision.selectByIndex(2);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Division\" drop down value for which admitted students are present")
	public void GR_GR_142(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownDivision.selectByIndex(2);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		getDriver().close();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Division\" drop down value for which admitted students are not present")
	public void GR_GR_143(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownClass.selectByIndex(3);
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownDivision.selectByIndex(2);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Information Not Available"), 
				" Alert message displayed",
				" Alert message not displayed");
	
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Religion\" drop down value for which admitted students are present")
	public void GR_GR_144(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownReligion.selectByIndex(1);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Religion\" drop down value for which admitted students are not present")
	public void GR_GR_145(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownReligion.selectByIndex(10);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		
        Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Information Not Available...!"), 
				" Alert message displayed",
				"Alert message not displayed");
	
		getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Category\" drop down value for which admitted students are present")
	public void GR_GR_146(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownCategory.selectByIndex(8);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		
	}
	
	@Test
	@QAFDataProvider(key="login.data")
	@MetaData(value = "{'groups':['Gen_reg']}")
	@QAFTestStep(description = "Validate \"Search\" button functionality with default value selection of the \"Search By\" drop down value as \"Admitted Student\" and default value selection of the \"Student Image\" as \"No\" by selecting \"Category\" drop down value for which admitted students are not present")
	public void GR_GR_147(Map<String, String> data) {
		
		FullEPrashasanLoginPage fullEPrashasanLoginPage = new FullEPrashasanLoginPage();
		fullEPrashasanLoginPage.invoke();
		fullEPrashasanLoginPage.waitForPageToLoad();
		
		EPUtils.loginToEPrashasan(data.get("username"), data.get("password"));

		FullEPrashasanWelcomePage fullEPrashasanWelcomePage = new FullEPrashasanWelcomePage();
		fullEPrashasanWelcomePage.waitForPageToLoad();
		fullEPrashasanWelcomePage.headerWelcometoEPRASHASAN.verifyText("Welcome To e-PRASHASAN");
		Reporter.log("User Navigated to Welcome page");
		
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.waitForVisible();
		fullEPrashasanWelcomePage.leftNavigationComponent.linkGenReg.click();
		Reporter.log("User Clicked on Gen-Reg Link");
		
		FullEPrashasanGeneralRegisterFormPage fullEPrashasanGeneralRegisterFormPage = new FullEPrashasanGeneralRegisterFormPage();
		fullEPrashasanGeneralRegisterFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.waitForVisible();
		fullEPrashasanGeneralRegisterFormPage.topNavigationComponent.linkGeneralRegisterSearch.click();
		Reporter.log("User Clicked on General Register Search Link");
		
		FullEPrashasanGeneralRegisterSearchFormPage fullEPrashasanGeneralRegisterSearchFormPage = new FullEPrashasanGeneralRegisterSearchFormPage();
		fullEPrashasanGeneralRegisterSearchFormPage.waitForPageToLoad();
		
		fullEPrashasanGeneralRegisterSearchFormPage.studentInformationComponent.dropdownCategory.selectByIndex(10);
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.buttonSearch.click();
		fullEPrashasanGeneralRegisterSearchFormPage.additionalStudentDetailsComponent.verifyPresent();
		EPUtils.sleep(3000);
		
        Alert Windowalert = getDriver().switchTo().alert();
		
		verifyTrue(Windowalert.getText().contains("Information Not Available...!"), 
				" Alert message displayed",
				"Alert message not displayed");
	
		getDriver().switchTo().alert().dismiss();
	}
}	
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
