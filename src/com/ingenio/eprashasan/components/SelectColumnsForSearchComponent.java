package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;


import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SelectColumnsForSearchComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@id='htStud']")
	public QAFWebElement checkboxStudentBasicDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkBirDate']")
	public QAFWebElement checkboxBirthDate;
	
	@FindBy(locator = "xpath=//input[@id='checkBirPla']")
	public QAFWebElement checkboxBirthPlace;
	
	@FindBy(locator = "xpath=//input[@id='checkGen']")
	public QAFWebElement checkboxGender;
	
	@FindBy(locator = "xpath=//input[@id='checkReli']")
	public QAFWebElement checkboxReligion;
	
	@FindBy(locator = "xpath=//input[@id='thAdDe']")
	public QAFWebElement checkboxCurrentAcademicDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkAcade']")
	public QAFWebElement checkboxCurrentAcademyYear;
	
	@FindBy(locator = "xpath=//input[@id='checkAdmiDate']")
	public QAFWebElement checkboxCurrentAdmissionDate;
	
	@FindBy(locator = "xpath=//input[@id='checkMedi']")
	public QAFWebElement checkboxCurrentMedium;
	
	@FindBy(locator = "xpath=//input[@id='checkClass']")
	public QAFWebElement checkboxCurrentClass;
	
	@FindBy(locator = "xpath=//input[@id='thAdDetai']")
	public QAFWebElement checkboxAddressDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkLocAdd']")
	public QAFWebElement checkboxlAddress;
	
	@FindBy(locator = "xpath=//input[@id='checkLcity']")
	public QAFWebElement checkboxLCity;
	
	@FindBy(locator = "xpath=//input[@id='checkLpin']")
	public QAFWebElement checkboxLPinCode;
	
	@FindBy(locator = "xpath=//input[@id='checkLsat']")
	public QAFWebElement checkboxLState;
	
	@FindBy(locator = "xpath=//input[@id='checkLcoun']")
	public QAFWebElement checkboxLCountry;
	
	@FindBy(locator = "xpath=//input[@id='checkPadd']")
	public QAFWebElement checkboxPAddress;
	
	@FindBy(locator = "xpath=//input[@id='checkPcity']")
	public QAFWebElement checkboxPCity;
	
	@FindBy(locator = "xpath=//input[@id='checkPpin']")
	public QAFWebElement checkboxPPinCode;
	
	@FindBy(locator = "xpath=//input[@id='checkPsat']")
	public QAFWebElement checkboxPState;
	
	@FindBy(locator = "xpath=//input[@id='checkPcoun']")
	public QAFWebElement checkboxPCountry;
	
	@FindBy(locator = "xpath=//input[@id='thpaDe']")
	public QAFWebElement checkboxParentDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkFatName']")
	public QAFWebElement checkboxFatherName;
	
	@FindBy(locator = "xpath=//input[@id='checkFatEdu']")
	public QAFWebElement checkboxFatherEducation;
	
	@FindBy(locator = "xpath=//input[@id='checkFatOcc']")
	public QAFWebElement checkboxFatherOccupation;
	
	@FindBy(locator = "xpath=//input[@id='checkFatInco']")
	public QAFWebElement checkboxFatherIncome;
	
	@FindBy(locator = "xpath=//input[@id='checkFathAge']")
	public QAFWebElement checkboxFatherAge;
	
	@FindBy(locator = "xpath=//input[@id='checkFatEmail']")
	public QAFWebElement checkboxFatherEmail;
	
	@FindBy(locator = "xpath=//input[@id='checkMotName']")
	public QAFWebElement checkboxMotherName;
	
	@FindBy(locator = "xpath=//input[@id='thbaDe']")
	public QAFWebElement checkboxBankDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkBankNa']")
	public QAFWebElement checkboxBankName;
	
	@FindBy(locator = "xpath=//input[@id='checkBranName']")
	public QAFWebElement checkboxBranchName;
	
	@FindBy(locator = "xpath=//input[@id='checkAccNo']")
	public QAFWebElement checkboxAccountNo;
	
	@FindBy(locator = "xpath=//input[@id='checkIFSC']")
	public QAFWebElement checkboxBankIFCSCode;
	
	@FindBy(locator = "xpath=//input[@id='checkAdhar']")
	public QAFWebElement checkboxAadharCardNo;
	
	@FindBy(locator = "xpath=//input[@id='thcon']")
	public QAFWebElement checkboxStudentContactDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkMobi']")
	public QAFWebElement checkboxStudentMobile;
	
	@FindBy(locator = "xpath=//input[@id='checkstuEm']")
	public QAFWebElement checkboxEmailId;
	
	@FindBy(locator = "xpath=//input[@id='thPre']")
	public QAFWebElement checkboxPreviousSchoolandOtherDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkPriNam']")
	public QAFWebElement checkboxPreviousSchoolName;
	
	@FindBy(locator = "xpath=//input[@id='checkLang']")
	public QAFWebElement checkboxMothertongue;
	
	@FindBy(locator = "xpath=//input[@id='checkNoOfBonas']")
	public QAFWebElement checkboxEntranceFees;
	
	@FindBy(locator = "xpath=//input[@id='OtherDet']")
	public QAFWebElement checkboxAdditionStudentDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkNation']")
	public QAFWebElement checkboxNationality;
	
	@FindBy(locator = "xpath=//input[@id='checkcategory']")
	public QAFWebElement checkboxCategory;
	
	@FindBy(locator = "xpath=//input[@id='checkcaste']")
	public QAFWebElement checkboxCaste;
	
	@FindBy(locator = "xpath=//input[@id='checkMinority']")
	public QAFWebElement checkboxMinorityType;
	
	@FindBy(locator = "xpath=//input[@id='checkConcession']")
	public QAFWebElement checkboxConcession;
	
	@FindBy(locator = "xpath=//input[@id='checkEduOfficerNo']")
	public QAFWebElement checkboxEducationOfficerNo;
	
	@FindBy(locator = "xpath=//input[@id='CheckDynamic']")
	public QAFWebElement checkboxOtherDetails;
	
	@FindBy(locator = "xpath=//input[@id='checkBox1']")
	public QAFWebElement checkboxStudentID;
	
	@FindBy(locator = "xpath=//input[@id='save']")
	public QAFWebElement buttonSearch;
	
	@FindBy(locator = "xpath=//input[@id='reset']")
	public QAFWebElement buttonReset;
	
	
	
	public SelectColumnsForSearchComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public SelectColumnsForSearchComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

}
