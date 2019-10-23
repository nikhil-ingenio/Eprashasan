package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class OfficeDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//select[@id='yearcombo']")
    public DropdownListWebElement dropdownAcademicYear;
	
	@FindBy(locator = "xpath=//input[@id='registrationNo']")
    public QAFWebElement textboxRegistrationNumber;
	
	@FindBy(locator = "xpath=//select[@name='admissionday']")
    public DropdownListWebElement dropdownAdmissionDay;
	
	@FindBy(locator = "xpath=//select[@name='admissionmonth']")
    public DropdownListWebElement dropdownAdmissionMonth;
	
	@FindBy(locator = "xpath=//select[@name='admissionyear']")
    public DropdownListWebElement dropdownAdmissionYear;
	
	@FindBy(locator = "xpath=//input[@id='studentFormNumberId']")
    public QAFWebElement textboxStudentFormNumber;
	
	@FindBy(locator = "xpath=//select[@name='standardName']")
    public DropdownListWebElement dropdownClass;
	
	@FindBy(locator = "xpath=//select[@name='medium']")
    public DropdownListWebElement dropdownMedium;
	
	@FindBy(locator = "xpath=//select[@id='initialNameId1']")
    public DropdownListWebElement dropdownInitialName;
	
	@FindBy(locator = "xpath=//input[@id='firstNameId']")
    public QAFWebElement textboxFirstName;
	
	@FindBy(locator = "xpath=//input[@id='middleNameId']")
    public QAFWebElement textboxMiddleName;
	
	@FindBy(locator = "xpath=//input[@id='lastNameId']")
    public QAFWebElement textboxLastName;
	
	@FindBy(locator = "xpath=//select[@name='birthday']")
    public DropdownListWebElement dropdownBirthDay;
	
	@FindBy(locator = "xpath=//select[@name='birthmonth']")
    public DropdownListWebElement dropdownBirthMonth;
	
	@FindBy(locator = "xpath=//select[@name='birthyear']")
    public DropdownListWebElement dropdownBirthYear;
	
	@FindBy(locator = "xpath=//select[@id='genId']")
    public DropdownListWebElement dropdownGender;
	
	@FindBy(locator = "xpath=//select[@id='castcombo'] | //input[@name='casteName']")
    public DropdownListWebElement dropdownCaste;
	
	@FindBy(locator = "xpath=//select[@id='categoryComboId']")
    public DropdownListWebElement dropdownCategory;
	
	@FindBy(locator = "xpath=//select[@id='religioncombo']")
    public DropdownListWebElement dropdownReligion;
	
	
	public OfficeDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public OfficeDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}
