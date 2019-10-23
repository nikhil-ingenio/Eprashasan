package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AdditionalStudentDetailsComponent extends QAFWebComponent {

	@FindBy(locator = "xpath=//input[@id='isprevdataid']")
    public QAFWebElement checkboxAdditionalStudentDetails;
	
	@FindBy(locator = "xpath=//input[@id='textbox1']")
    public QAFWebElement textboxStudentID;
	
	@FindBy(locator = "xpath=//input[@id='searchbtn']")
    public QAFWebElement buttonSearch;
	
	public AdditionalStudentDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public AdditionalStudentDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
}