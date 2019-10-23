package com.ingenio.eprashasan.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class OtherDetailsComponent extends QAFWebComponent{
	
	@FindBy(locator = "xpath=//input[@id='textbox1']")
    public QAFWebElement textboxStudentID;
	
	public OtherDetailsComponent(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
		// TODO Auto-generated constructor stub
	}
	public OtherDetailsComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
}
