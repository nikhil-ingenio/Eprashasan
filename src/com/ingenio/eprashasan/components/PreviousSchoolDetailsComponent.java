package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class PreviousSchoolDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@id='isprevdataid']")
    public QAFWebElement checkboxPreviousSchoolDetail;
	
	@FindBy(locator = "xpath=//input[@name='previousSchool']")
    public QAFWebElement textboxPreviousSchoolName;
	
	@FindBy(locator = "xpath=//input[@name='previousStandard']")
    public QAFWebElement textboxPreviousClass;
	
	@FindBy(locator = "xpath=//input[@name='previousYear']")
    public QAFWebElement textboxPreviousYear;
	
	@FindBy(locator = "xpath=//input[@name='previousReason']")
    public QAFWebElement textboxReasonForLeavingPreviousSchool;
	
	public PreviousSchoolDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public PreviousSchoolDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}

