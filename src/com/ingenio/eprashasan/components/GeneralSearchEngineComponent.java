package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class GeneralSearchEngineComponent extends QAFWebComponent {
	
	@FindBy(locator = "xpath=//select[@id='yearcombo']")
	public DropdownListWebElement dropdownSelectYear;
	
	@FindBy(locator = "xpath=//select[@id='standardcombo']")
	public DropdownListWebElement dropdownSelectClass;
	
	@FindBy(locator = "xpath=//select[@id='divisioncombo']")
	public DropdownListWebElement dropdownSelectDivision;
	
	@FindBy(locator = "xpath=//select[@id='castcombo']")
	public DropdownListWebElement dropdownSelectCaste;
	
	@FindBy(locator = "xpath=//select[@id='castecategorycombo']")
	public DropdownListWebElement dropdownSelectCategory;
	
	@FindBy(locator = "xpath=//select[@id='religioncombo']")
	public DropdownListWebElement dropdownSelectReligion;
	
	@FindBy(locator = "xpath=//input[@id='nameSearchId']")
	public QAFWebElement textboxStudentName;
	
	@FindBy(locator = "xpath=//select[@id='gendercombo']")
	public DropdownListWebElement dropdownGender;
	
	
	
	
	
	
	
	
	public GeneralSearchEngineComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public GeneralSearchEngineComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

}
