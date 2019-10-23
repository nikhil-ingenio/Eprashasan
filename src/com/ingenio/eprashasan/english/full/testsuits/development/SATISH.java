package com.ingenio.eprashasan.english.full.testsuits.development;

import java.util.Map;

import org.testng.annotations.Test;

import com.ingenio.eprashasan.core.EPUtils;
import com.ingenio.eprashasan.full.pages.FullEPrashasanEditStudentInformationPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanLoginPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanStudentAdmissionFormPage;
import com.ingenio.eprashasan.full.pages.FullEPrashasanWelcomePage;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class SATISH extends WebDriverTestCase {

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
		
		//fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.waitForVisible();
		fullEPrashasanStudentAdmissionFormPage.topNavigationAdmissionPageComponent.linkEditStudentInformation.click();
		Reporter.log("User Clicked on Edit Student Information Link");
		
		FullEPrashasanEditStudentInformationPage fullEPrashasanEditStudentInformationPage = new FullEPrashasanEditStudentInformationPage();
		fullEPrashasanEditStudentInformationPage.waitForPageToLoad();
		
		Reporter.log("User started filling Details");
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.dropdownAcademicYear.selectByIndex(1);
		fullEPrashasanEditStudentInformationPage.informationOfStudentComponent.checkboxCustomSearch.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.checkboxStudentBasicDetails.click();
		fullEPrashasanEditStudentInformationPage.selectColumnsForSearchComponent.buttonSearch.click();
		EPUtils.sleep(10000);
		
		Reporter.log(fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textStudentRegNoList.get(1).getText());
		Reporter.log(fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxFirstName.get(1).getAttribute("value"));
		Reporter.log(fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxLastName.get(1).getAttribute("value"));
		
		fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxFirstName.get(1).clear();
		fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxFirstName.get(1).sendKeys("AABBCCC");
		
		fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxLastName.get(1).clear();
		fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxLastName.get(1).sendKeys("ZZWWWWWWW");
		
		Reporter.log(fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxFirstName.get(1).getAttribute("value"));
		Reporter.log(fullEPrashasanEditStudentInformationPage.studentInformationTableComponent.textboxLastName.get(1).getAttribute("value"));
		
		EPUtils.sleep(3000);

		
		
		}
}
