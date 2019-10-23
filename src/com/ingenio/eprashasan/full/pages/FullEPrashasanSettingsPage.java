package com.ingenio.eprashasan.full.pages;

import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FullEPrashasanSettingsPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	//Main Menu Locators
	@FindBy(locator = "xpath=//input[@value='Admission & Provisional Admission'] | //input[@id='one1']")
    public QAFWebElement tabAdmissionAndProvisionalAdmission;
	
	@FindBy(locator = "xpath=//input[@value='SMS-E-Mail'] | //input[@value='à¤¸à¤‚à¤¦à¥‡à¤¶ à¤†à¤£à¤¿ à¤‡à¤®à¥‡à¤²']")
    public QAFWebElement tabSMSEMail;
	
	@FindBy(locator = "xpath=//input[@value='User Authentication'] | //input[@value='à¤µà¤¾à¤ªà¤°à¤•à¤°à¥�à¤¤à¥�à¤¯à¤¾à¤šà¥‡ à¤…à¤§à¤¿à¤•à¤¾à¤°']")
    public QAFWebElement tabUserAuthentication;
	
	@FindBy(locator = "xpath=//input[@value='Certificate(TC & Bonafide)'] | //input[@value='à¤ªà¥�à¤°à¤®à¤¾à¤£à¤ªà¤¤à¥�à¤° ( à¤¦à¤¾à¤–à¤²à¤¾ à¤µ à¤¬à¥‹à¤¨à¤¾à¤«à¤¾à¤ˆà¤¡)']")
    public QAFWebElement tabCertificateTCAndBonafide;
	
	@FindBy(locator = "xpath=//input[@value='Enquiry'] | //input[@value='à¤šà¥Œà¤•à¤¶à¥€']")
    public QAFWebElement tabEnquiry;
	
	@FindBy(locator = "xpath=//input[@value='Export/Import Data For Provisional Admission'] | //input[@value='à¤¤à¤¾à¤¤à¥�à¤ªà¥�à¤°à¤¤à¥�à¤¯à¤¾ à¤®à¤¾à¤¹à¤¿à¤¤à¥€à¤šà¥€ à¤†à¤¯à¤¾à¤¤ à¤¨à¤¿à¤°à¥�à¤¯à¤¾à¤¤']")
    public QAFWebElement tabExportImportDataForProvisionalAdmission;
	
	@FindBy(locator = "xpath=//input[@value='Extra Curricular Activity'] | //input[@value='à¤…à¤­à¥�à¤¯à¤¾à¤¸à¥‡à¤¤à¤° à¤‰à¤ªà¤•à¥�à¤°à¤®']")
    public QAFWebElement tabExtraCurricularActivity;
	
	@FindBy(locator = "xpath=//input[@value='Class Management'] | //input[@value='à¤µà¤°à¥�à¤— à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement tabClassManagement;

	@FindBy(locator = "xpath=//input[@value='Subject Section'] | //input[@value='à¤µà¤¿à¤·à¤¯  à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement tabSubjectSection;
	
	@FindBy(locator = "xpath=//input[@value='Transport Setting'] | ")
    public QAFWebElement tabTransportSetting;
	
	@FindBy(locator = "xpath=//input[@value='Challan Setting'] | //input[@id='one11']")
    public QAFWebElement tabChallanSetting;
	
	@FindBy(locator = "xpath=//input[@value='Student Documents'] | ")
    public QAFWebElement tabStudentDocuments;
	
	
	//1st Sub-Menu Admission & Provisional Admission Locators
	@FindBy(locator = "xpath=//input[@value='Academic Year'] | //input[@value='à¤µà¤°à¥�à¤·']")
    public QAFWebElement subTabAcademicYear;
	
	@FindBy(locator = "xpath=//input[@value='Standard'] | //input[@value='à¤µà¤°à¥�à¤—']")
    public QAFWebElement subTabStandard;
	
	@FindBy(locator = "xpath=//input[@value='Division'] | //input[@value='à¤¤à¥�à¤•à¤¡à¥€']")
    public QAFWebElement subTabDivision;
	
	@FindBy(locator = "xpath=//input[@value='Religion'] | //input[@value='à¤§à¤°à¥�à¤®']")
    public QAFWebElement subTabReligion;
	
	@FindBy(locator = "xpath=//input[@value='Caste Section'] | //input[@value='à¤œà¤¾à¤¤']")
    public QAFWebElement subTabCasteSection;
	
	@FindBy(locator = "xpath=//input[@value='Category'] | //input[@value='à¤µà¤°à¥�à¤—-à¤œà¤¾à¤¤']")
    public QAFWebElement subTabCategory;
	
	@FindBy(locator = "xpath=//input[@value='Concession'] | //input[@value='à¤¸à¤µà¤²à¤¤']")
    public QAFWebElement subTabConcession;
	
	@FindBy(locator = "xpath=//input[@value='Minority Setting'] | //input[@id='firstSubMenu8']")
    public QAFWebElement subTabMinoritySetting;
	
	@FindBy(locator = "xpath=//input[@value='Dynamic Fields'] | //input[@value='à¤‡à¤šà¥�à¤›à¤¿à¤¤ à¤®à¤¾à¤¹à¤¿à¤¤à¥€']")
    public QAFWebElement subTabDynamicFields;
	
	@FindBy(locator = "xpath=//input[@value='Entrance/Token Fees'] | //input[@value='à¤¶à¥�à¤²à¥�à¤• à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabEntranceTokenFees;

	@FindBy(locator = "xpath=//input[@value='Admission Form Setting'] | //input[@value='à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤¶à¥�à¤²à¥�à¤• à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabAdmissionFormSetting;
	
	@FindBy(locator = "xpath=//input[@value='Religion(Super Master 1)'] | //input[@value='à¤§à¤°à¥�à¤®(à¤¸à¥�à¤ªà¤° à¤®à¤¾à¤¸à¥�à¤Ÿà¤° à¥§)']")
    public QAFWebElement subTabReligionSuperMaster1;
	
	@FindBy(locator = "xpath=//input[@value='Religion(Super Master 2)'] | //input[@value='à¤§à¤°à¥�à¤®(à¤¸à¥�à¤ªà¤° à¤®à¤¾à¤¸à¥�à¤Ÿà¤° à¥¨)']")
    public QAFWebElement subTabReligionSuperMaster2;
	
	@FindBy(locator = "xpath=//input[@value='Religion(Super Master 3)'] | //input[@value='à¤§à¤°à¥�à¤®(à¤¸à¥�à¤ªà¤° à¤®à¤¾à¤¸à¥�à¤Ÿà¤° à¥©)']")
    public QAFWebElement subTabReligionSuperMaster3;

	
	//2nd Sub-Menu SMS-E-Mail Locators
	@FindBy(locator = "xpath=//input[@value='SMS Setting'] | //input[@value='à¤¸à¤‚à¤¦à¥‡à¤¶ à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabSMSSetting;
	
	@FindBy(locator = "xpath=//input[@value='Mail Setting'] | //input[@value='à¤®à¥‡à¤² à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabMailSetting;
	
	@FindBy(locator = "xpath=//input[@value='Back Up'] | //input[@value='à¤ªà¤¾à¤µà¤¤à¥€ à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabBackUp;
	
	@FindBy(locator = "xpath=//input[@value='SMS/EMAIL Permission'] | //input[@value='à¤¸à¤‚à¤¦à¥‡à¤¶ /à¤‡à¤®à¥‡à¤² à¤ªà¤°à¤µà¤¾à¤£à¤—à¥€Â€']")
    public QAFWebElement subTabSMSEMAILPermission;
	
	@FindBy(locator = "xpath=//input[@value='Birthday SMS'] | //input[@value='à¤µà¤¾à¤¢à¤¦à¤¿à¤µà¤¸ à¤¸à¤‚à¤¦à¥‡à¤¶']")
    public QAFWebElement subTabBirthdaySMS;
	
	@FindBy(locator = "xpath=//input[@value='Remaining Amount Show/hide'] | //input[@value='à¤¬à¥…à¤•-à¤…à¤ª à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement subTabRemainingAmountShowhide;
	
	@FindBy(locator = "xpath=//input[@value='Present Student Classwise SMS'] | //input[@value='à¤µà¤°à¥�à¤—à¤¾à¤¨à¥�à¤¸à¤¾à¤° à¤¹à¤œà¤° à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€à¤¸à¤¾à¤ à¥€ à¤¸à¤‚à¤¦à¥‡à¤¶']")
    public QAFWebElement subTabPresentStudentClasswiseSMS;
	
	@FindBy(locator = "xpath=//input[@value='Absent Student Classwise SMS'] | //input[@value='à¤µà¤°à¥�à¤—à¤¾à¤¨à¥�à¤¸à¤¾à¤° à¤—à¥ˆà¤°à¤¹à¤œà¤° à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€à¤¸à¤¾à¤ à¥€ à¤¸à¤‚à¤¦à¥‡à¤¶']")
    public QAFWebElement subTabAbsentStudentClasswiseSMS;
	
	@FindBy(locator = "xpath=//input[@value='Present Student Subjectwise SMS'] | //input[@value='à¤µà¤¿à¤·à¤¯à¤¾à¤¨à¥�à¤¸à¤¾à¤° à¤¹à¤œà¤° à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€à¤¸à¤¾à¤ à¥€ à¤¸à¤‚à¤¦à¥‡à¤¶']")
    public QAFWebElement subTabPresentStudentSubjectwiseSMS;
	
	@FindBy(locator = "xpath=//input[@value='Absent Student Subjectwise SMS'] | //input[@value='à¤µà¤¿à¤·à¤¯à¤¾à¤¨à¥�à¤¸à¤¾à¤° à¤—à¥ˆà¤°à¤¹à¤œà¤° à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€à¤¸à¤¾à¤ à¥€ à¤¸à¤‚à¤¦à¥‡à¤¶']")
    public QAFWebElement subTabAbsentStudentSubjectwiseSMS;
	
	@FindBy(locator = "xpath=//input[@value='Upload Birthday Greeting'] | //input[@value='à¤…à¤ªà¤²à¥‹à¤¡ à¤¬à¤°à¥�à¤¥à¤¡à¥‡ à¤—à¥�à¤°à¥€à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabUploadBirthdayGreeting;
	
	
	//3rd Sub-Menu User Authentication Locators
	@FindBy(locator = "xpath=//input[@value='No of User'] | //input[@value=' à¤�à¤•à¥‚à¤£ à¤µà¤¾à¤ªà¤°à¤•à¤°à¥�à¤¤à¤¾']")
    public QAFWebElement subTabNoOfUser;
	
	@FindBy(locator = "xpath=//input[@value='User'] | //input[@value='à¤µà¤¾à¤ªà¤°à¤•à¤°à¥�à¤¤à¤¾']")
    public QAFWebElement subTabUser;
	
	@FindBy(locator = "xpath=//input[@value='Exam-Class Users'] | //input[@value='à¤µà¤°à¥�à¤—-à¤ªà¤°à¥€à¤•à¥�à¤·à¤¾ à¤µà¤¾à¤ªà¤°à¤•à¤°à¥�à¤¤à¤¾ ']")
    public QAFWebElement subTabExamClassUsers;
	
	@FindBy(locator = "xpath=//input[@value='Welcome Note'] | //input[@value='à¤¸à¥�à¤µà¤¾à¤—à¤¤ à¤µà¤¾à¤•à¥�à¤¯']")
    public QAFWebElement subTabWelcomeNote;
	
	@FindBy(locator = "xpath=//input[@value='Upload Setting Image'] | //input[@value='à¤…à¤ªà¤²à¥‹à¤¡ à¤¸à¥‡à¤Ÿà¥€à¤‚à¤— à¤‡à¤®à¥‡à¤œ']")
    public QAFWebElement subTabUploadSettingImage;
	
	
	//4th Sub-Menu Certificate(TC & Bonafide) Locators
	@FindBy(locator = "xpath=//input[@value='TC Setting'] | //input[@value='à¤Ÿà¤¿à¤¸à¥€ à¤¸à¥‡à¤Ÿà¤¿à¤‚à¤—']")
    public QAFWebElement subTabTCSetting;
	
	@FindBy(locator = "xpath=//input[@value='Upload Image'] | //input[@value='à¤…à¤ªà¤²à¥‹à¤¡ à¤‡à¤®à¥‡à¤œ']")
    public QAFWebElement subTabUploadImage;
	
	@FindBy(locator = "xpath=//input[@value='Bonafide Linking With I\\O Lettering'] | //input[@value='à¤¬à¥‹à¤¨à¤¾à¤«à¤¾à¤ˆà¤¡ à¤†à¤£à¤¿ à¤ªà¤¤à¥�à¤° à¤µà¥�à¤¯à¤µà¤¹à¤° à¤²à¤¿à¤‚à¤• à¤•à¤°à¤¾']")
    public QAFWebElement subTabBonafideLinkingWithIOLettering;
	
	@FindBy(locator = "xpath=//input[@value='TC Linking With I\\O Lettering'] | //input[@value='à¤Ÿà¥€à¤¸à¥€ à¤†à¤£à¤¿ à¤ªà¤¤à¥�à¤° à¤µà¥�à¤¯à¤µà¤¹à¤¾à¤° à¤²à¤¿à¤‚à¤• à¤•à¤°à¤¾ ']")
    public QAFWebElement subTabTCLinkingWithIOLettering;
	
	@FindBy(locator = "xpath=//input[@value='Student Name Setting']")
    public QAFWebElement subTabStudentNameSetting;
	
	
	//5th Sub-Menu Enquiry Locators
	@FindBy(locator = "xpath=//input[@value='Advertisement Type'] | //input[@value='à¤œà¤¾à¤¹à¤¿à¤°à¤¾à¤¤à¥€à¤šà¤¾ à¤ªà¥�à¤°à¤•à¤¾à¤°']")
    public QAFWebElement subTabAdvertisementType;
	
	@FindBy(locator = "xpath=//input[@value='Class For Enquiry '] | //input[@value='à¤šà¥Œà¤•à¤¶à¥€ à¤µà¤°à¥�à¤—']")
    public QAFWebElement subTabClassForEnquiry;
	
	
	//6th Sub-Menu Export/Import Data For Provisional Admission Locators
	
	
	//7th Sub-Menu Extra Curricular Activity Locators
	
	
	//8th Sub-Menu Class Management Locators
	
	
	//9th Sub-Menu Subject Section Locators
	
	
	//10th Sub-Menu Transport Setting Locators
	
	
	//11th Sub-Menu Challan Setting Locators
	
	
	//12th Sub-Menu Student Documents Locators

	
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stubs
		
	}
	
	@Override
	public void waitForPageToLoad() {
		Reporter.log("On Page "+this.getClass().getSimpleName());
		super.waitForPageToLoad();
		super.waitForAjaxToComplete();
		try {
			tabAdmissionAndProvisionalAdmission.waitForVisible();
			tabAdmissionAndProvisionalAdmission.waitForPresent();
			
			tabUserAuthentication.waitForVisible();
			tabUserAuthentication.waitForPresent();

			tabStudentDocuments.waitForVisible();
			tabStudentDocuments.waitForPresent();

			Reporter.log(this.getClass().getSimpleName() + " Page loaded Sucessfully");
			
		} catch (Exception e) {
			Assert.fail(this.getClass().getSimpleName() + " Page Did not Load");
		}
	   
	}
	
}
