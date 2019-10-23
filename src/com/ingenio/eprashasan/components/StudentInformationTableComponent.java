package com.ingenio.eprashasan.components;

import java.util.List;


import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class StudentInformationTableComponent  extends QAFWebComponent{

	
	@FindBy(locator = "xpath=//td[@aria-describedby='grid_studentRegNo']")
    public List<QAFWebElement> textStudentRegNoList;
	
	@FindBy(locator = "xpath=//select[@name='initial']")
    public List<DropdownListWebElement> dropdownInitial;
	
	@FindBy(locator = "xpath=//input[@name='studname1']")
    public List<QAFWebElement> textboxFirstName;
	
	@FindBy(locator = "xpath=//input[@name='studname2']")
    public List<QAFWebElement> textboxMiddleName;
	
	@FindBy(locator = "xpath=//input[@name='studname3']")
    public List<QAFWebElement> textboxLastName;
	
	@FindBy(locator = "xpath=//input[@name='birthDate']")
    public List<QAFWebElement> textboxBirthDate;
	
	@FindBy(locator = "xpath=//input[@name='birthPlace']")
    public List<QAFWebElement> textboxBirthPlace;
	
	@FindBy(locator = "xpath=//select[@name='studGender']")
    public List<DropdownListWebElement> dropdownGender;
	
	@FindBy(locator = "xpath=//select[@name='religionName']")
    public List<DropdownListWebElement> dropdownReligionName;
	
	@FindBy(locator = "xpath=//input[@name='mmobile']")
    public List<QAFWebElement> textboxMobileNumber;
	
	@FindBy(locator = "xpath=//input[@name='memail']")
    public List<QAFWebElement> textboxEmail;
	
	
	public StudentInformationTableComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public StudentInformationTableComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
}
