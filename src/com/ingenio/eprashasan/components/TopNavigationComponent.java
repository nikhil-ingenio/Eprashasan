package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TopNavigationComponent extends QAFWebComponent {

	@FindBy(locator = "xpath=//a[text()='Quick Registration'] | //a[normalize-space(.)='à¤œà¤²à¤¦ à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ']")
    public QAFWebElement linkQuickRegistration;

	@FindBy(locator = "xpath=//a[text()='Student Admission'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥‡ à¤ªà¥�à¤°à¤µà¥‡à¤¶']")
    public QAFWebElement linkStudentAdmission;

	@FindBy(locator = "xpath=//a[text()='Division'] | //a[normalize-space(.)='à¤¤à¥�à¤•à¤¡à¥€ à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement linkDivision;

	@FindBy(locator = "xpath=//a[text()='Renew & Re-Admission'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥‡ à¤¨à¥�à¤¤à¤¨à¥€à¤•à¤°à¤£']  |  //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥‡ à¤ªà¥�à¤¨:à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ']")
    public QAFWebElement linkRenewAndReAdmission;

	@FindBy(locator = "xpath=//a[text()='Edit Student Information'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥�à¤¯à¤¾ à¤®à¤¾à¤¹à¤¿à¤¤à¥€à¤¤ à¤¬à¤¦à¤²']")
    public QAFWebElement linkEditStudentInformation;

	@FindBy(locator = "xpath=//a[text()='Other Details'] | //a[normalize-space(.)='à¤‡à¤¤à¤° à¤®à¤¾à¤¹à¤¿à¤¤à¥€']")
    public QAFWebElement linkOtherDetails;

	@FindBy(locator = "xpath=//a[text()='Dynamic Field Excel Import']")
    public QAFWebElement linkDynamicFieldExcelImport;

	@FindBy(locator = "xpath=//a[contains(.,'General Register Form')] | //a[normalize-space(.)='à¤¦à¤¾à¤–à¤² à¤–à¤¾à¤°à¥€à¤œà¤šà¤¾ à¤…à¤°à¥�à¤œ']")
    public QAFWebElement linkGeneralRegisterForm;
	
	@FindBy(locator = "xpath=//a[text()='General Register Search'] | //a[normalize-space(.)='à¤¦à¤¾à¤–à¤² à¤–à¤¾à¤°à¥€à¤œà¤šà¤¾ à¤¶à¥‹à¤§']")
    public QAFWebElement linkGeneralRegisterSearch;
	
	@FindBy(locator = "xpath=//a[text()='Excel Import'] | //a[normalize-space(.)='excelà¤®à¤§à¥€à¤² à¤®à¤¾à¤¹à¤¿à¤¤à¥€ à¤­à¤°à¤¾']")
    public QAFWebElement linkExcelImport;
	
	@FindBy(locator = "xpath=//a[text()='Irrelevant Students'] | //a[normalize-space(.)='à¤µà¤¯à¥‹à¤®à¤°à¥�à¤¯à¤¾à¤¦à¥‡à¤¸ à¤…à¤ªà¤¾à¤¤à¥�à¤° à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€']")
    public QAFWebElement linkIrrelevantStudents;
	
	@FindBy(locator = "xpath=//a[text()='Help']")
    public QAFWebElement linkHelp;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Student Renew'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥‡ à¤¨à¥�à¤¤à¤¨à¥€à¤•à¤°à¤£']")
    public QAFWebElement linkStudentRenew;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Re-Admission'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤šà¥‡ à¤ªà¥�à¤¨:à¤ªà¥�à¤°à¤µà¥‡à¤¶ à¤…à¤°à¥�à¤œ']")
    public QAFWebElement linkReAdmission;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Auto Student Renew']")
    public QAFWebElement linkAutoStudentRenew;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Edu.Officer No.&Concession'] | //a[normalize-space(.)='à¤†à¤¦à¥‡à¤¶ à¤•à¥�à¤°. à¤µ à¤¸à¤µà¤²à¤¤']")
    public QAFWebElement linkEduOfficerNoConcession;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Student Health Info.'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥�à¤¯à¤¾à¤‚à¤šà¥€ à¤†à¤°à¥‹à¤—à¥�à¤¯à¤¾à¤µà¤¿à¤·à¤¯à¥€ à¤®à¤¾à¤¹à¤¿à¤¤à¥€']")
    public QAFWebElement linkStudentHealthInfo;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Add / Remove From Catalog'] | //a[normalize-space(.)='à¤•à¥…à¤Ÿà¤²à¥‰à¤— à¤µà¤°à¥�à¤¨ à¤•à¤®à¥€ / à¤¦à¤¾à¤–à¤² à¤•à¤°à¤£à¥‡']")
    public QAFWebElement linkAddRemoveFromCatalog;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Extra Curricular Activity'] | //a[normalize-space(.)='à¤…à¤­à¥�à¤¯à¤¾à¤¸à¥‡à¤¤à¤° à¤‰à¤ªà¤•à¥�à¤°à¤®']")
    public QAFWebElement linkExtraCurricularActivity;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Division & RollNo Mgmt'] | //a[normalize-space(.)='à¤¤à¥�à¤•à¤¡à¥€ à¤µ à¤°à¥‹à¤² à¤¨à¤‚. à¤µà¥�à¤¯à¤µà¤¸à¥�à¤¥à¤¾à¤ªà¤¨']")
    public QAFWebElement linkDivisionRollNoMgmt;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Fee Challan'] | //a[normalize-space(.)='à¤«à¥€ à¤šà¤¾à¤²à¤¾à¤¨']")
    public QAFWebElement linkFeeChallan;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Update Stud. Regi. No.'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤¨à¥‹à¤‚à¤¦à¤£à¥€à¤•à¥ƒà¤¤ à¤¨à¤‚à¤¬à¤° à¤¬à¤¦à¤²']")
    public QAFWebElement linkUpdateStudRegiNo;
	
	@FindBy(locator = "xpath=//ul[@class='dropdown-menu']//a[text()='Update Student Division'] | //a[normalize-space(.)='à¤µà¤¿à¤¦à¥�à¤¯à¤¾à¤°à¥�à¤¥à¥€ à¤¤à¥�à¤•à¤¡à¥€ à¤¬à¤¦à¤²']")
    public QAFWebElement linkUpdateStudentDivision;
	
	@FindBy(locator = "xpath=//a[text()='Extra Curricular Activity Search Engine']")
    public QAFWebElement linkExtraCurricularActivitySearchEngine;
	
	
	// Staff Module Links
	
	@FindBy(locator = "xpath=//a[text()='Setting']")
    public QAFWebElement linkStaffSettings;
	
	
	@FindBy(locator = "xpath=//a[text()='Staff School Type']")
    public QAFWebElement linkStaffSchoolType;
	
	@FindBy(locator = "xpath=//a[text()='Staff Designation']")
    public QAFWebElement linkStaffDesignation;
	
	@FindBy(locator = "xpath=//a[text()='Staff Type']")
    public QAFWebElement linkStaffType;
	
	@FindBy(locator = "xpath=//a[text()='Staff Department']")
    public QAFWebElement linkStaffDepartment;
	
	@FindBy(locator = "xpath=//a[text()='Staff Relation']")
    public QAFWebElement linkStaffRelation;
	
	@FindBy(locator = "xpath=//a[text()='Staff Relative occupation']")
    public QAFWebElement linkStaffRelativeOccupation;
	
	@FindBy(locator = "xpath=//a[text()='Staff Service Type']")
    public QAFWebElement linkStaffServiveType;
	
	@FindBy(locator = "xpath=//a[text()='Staff Handicap Type']")
    public QAFWebElement linkStaffHandicapType;
	
	@FindBy(locator = "xpath=//a[text()='Staff Form Excel Export Import']")
    public QAFWebElement linkStaffFormExcelExportImport;
	
	@FindBy(locator = "xpath=//a[text()='Staff Attachment']")
    public QAFWebElement linkStaffAttachment;
	
	@FindBy(locator = "xpath=//a[text()='Staff Basic Details']")
    public QAFWebElement linkStaffBasicDetails;
	
	@FindBy(locator = "xpath=//a[text()='Staff General Details']")
    public QAFWebElement linkStaffGeneralDetails;
	
	@FindBy(locator = "xpath=//a[text()='Staff Report']")
    public QAFWebElement linkStaffReports;
	
	@FindBy(locator = "xpath=//a[text()='Staff Basic Report']")
    public QAFWebElement linkStaffBasicReports;
	
	@FindBy(locator = "xpath=//a[text()='Staff Quick Admission']")
    public QAFWebElement linkStaffQuickAdmission;
	
	@FindBy(locator = "xpath=//a[text()='Assign Subject To Staff']")
    public QAFWebElement linkAssignSubjectToStaff;
	
	
	
	
	
	public TopNavigationComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public TopNavigationComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}
