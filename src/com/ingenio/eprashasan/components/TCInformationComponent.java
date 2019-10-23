package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TCInformationComponent  extends QAFWebComponent{

	@FindBy(locator = "xpath=//input[@name='previousSchool']")
    public QAFWebElement textboxPreviousSchoolName;
	
	@FindBy(locator = "xpath=//select[@id='statusId']")
    public DropdownListWebElement dropdownMinorityTypes;
	
	@FindBy(locator = "xpath=//input[@name='progress']")
    public QAFWebElement textboxStudentProgress;
	
	@FindBy(locator = "xpath=//input[@name='reason']")
    public QAFWebElement textboxReasonForLeavingSchool;
	
	@FindBy(locator = "xpath=//input[@name='collegeLeavingdate']")
    public QAFWebElement textboxStudentsLeavingDate;
	
	@FindBy(locator = "xpath=//input[@name='date']")
    public QAFWebElement textboxTCGivenDate;
	
	@FindBy(locator = "xpath=//input[@name='eduOfficerNo']")
    public QAFWebElement textboxEducationOfficerNo;
	
	@FindBy(locator = "xpath=//input[@name='conduct']")
    public QAFWebElement textboxConduct;
	
	@FindBy(locator = "xpath=//input[@name='renewRemark']")
    public QAFWebElement textboxRemark;
	
	@FindBy(locator = "xpath=//select[@id='studConcessionId']")
    public DropdownListWebElement dropdownConcession;
	
	@FindBy(locator = "xpath=//select[@id='standardcombo2']")
    public DropdownListWebElement dropdownLeftClass;
	
	
	
	public TCInformationComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public TCInformationComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
}
