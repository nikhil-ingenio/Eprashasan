package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class BasicDetailsComponent extends QAFWebComponent{
	
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

	@FindBy(locator = "xpath=//input[@name='birthPlace']")
    public QAFWebElement textboxBirthPlace;
	
	@FindBy(locator = "xpath=//select[@id='genId']")
    public DropdownListWebElement dropdownGender;
	
	@FindBy(locator = "xpath=//select[@id='castcombo'] | //input[@id='casteautotextbox']")
    public DropdownListWebElement dropdownCaste;
	
	@FindBy(locator = "xpath=//select[@id='categoryComboId']")
    public DropdownListWebElement dropdownCategory;
	
	@FindBy(locator = "xpath=//select[@id='religioncombo']")
    public DropdownListWebElement dropdownReligion;
	
	@FindBy(locator = "xpath=//input[@name='mothertonge']")
    public QAFWebElement textboxMothertonge;
	
	@FindBy(locator = "xpath=//input[@name='nationlity']")
    public QAFWebElement textboxNationlity;
	
	public BasicDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public BasicDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}

