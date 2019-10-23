package com.ingenio.eprashasan.components;

import com.ingenio.eprashasan.core.DropdownListWebElement;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;

public class ActivitySearchEngineComponent extends QAFWebComponent {
	
	
	@FindBy(locator = "xpath=//select[@id='categorycombo']")
	public DropdownListWebElement dropdownActivityCategory;
	
	@FindBy(locator = "xpath=//select[@id='subcategorycombo']")
	public DropdownListWebElement dropdownActivitySubCategory;
	
	@FindBy(locator = "xpath=//select[@id='levelcombo']")
	public DropdownListWebElement dropdownActivityLevel;
	
	@FindBy(locator = "xpath=//select[@id='rankcombo']")
	public DropdownListWebElement dropdownActivityRank;
	
	
	
		
	
	
	
	
	
	
	
	public ActivitySearchEngineComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public ActivitySearchEngineComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

}
