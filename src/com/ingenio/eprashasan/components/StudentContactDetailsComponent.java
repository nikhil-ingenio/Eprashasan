package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class StudentContactDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@name='mmobile']")
    public QAFWebElement textboxContactNumber1ForSMS;
	
	@FindBy(locator = "xpath=//input[@name='fmobile']")
    public QAFWebElement textboxContactNumber2;
	
	@FindBy(locator = "xpath=//input[@name='memail']")
    public QAFWebElement textboxEmailID;
	
	@FindBy(locator = "xpath=//input[@name='gievnNoBonafide']")
    public QAFWebElement textboxEntranceTokenFees;
	
	public StudentContactDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public StudentContactDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}
