package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ParentDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@name='fatherName']")
    public QAFWebElement textboxFatherName;
	
	@FindBy(locator = "xpath=//input[@name='motherName']")
    public QAFWebElement textboxMotherName;
	
	@FindBy(locator = "xpath=//input[@name='feducation']")
    public QAFWebElement textboxEducation;
	
	@FindBy(locator = "xpath=//input[@name='foccupation']")
    public QAFWebElement textboxOccupation;
	
	@FindBy(locator = "xpath=//input[@name='fincome']")
    public QAFWebElement textboxIncome;
	
	@FindBy(locator = "xpath=//input[@name='fage']")
    public QAFWebElement textboxAge;
	
	@FindBy(locator = "xpath=//input[@name='femail']")
    public QAFWebElement textboxEmailID;
	
	public ParentDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public ParentDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}
